package ca.udem.ift2255.planif.ui;

import ca.udem.ift2255.planif.modele.Activite;
import ca.udem.ift2255.planif.modele.ExigencesProgramme;
import ca.udem.ift2255.planif.service.Constat;
import ca.udem.ift2255.planif.service.ResultatVerification;
import ca.udem.ift2255.planif.service.ServicePlanification;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Client de bureau JavaFX (conteneur « client de bureau » du C4 niveau 2).
 * Démontre trois décisions de conception :
 *  1. vérifier AVANT d'envoyer une demande (UC07, flux A2-1) ;
 *  2. alerter tout de suite sur le temps plein, y compris avant un retrait (UC10, flux A2-4) ;
 *  3. exigences du programme en lecture seule (UC20).
 */
public class ApplicationPlanification extends Application {

    private ServicePlanification service = ServicePlanification.demo();
    private final TableView<Activite> tableOffre = new TableView<>();
    private final ListView<Activite> listePlan = new ListView<>();
    private final Label bandeau = new Label();
    private final Label resume = new Label();
    private final Label libelleSemaine = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        BorderPane racine = new BorderPane();
        racine.setPadding(new Insets(12));
        racine.setTop(construireHaut());
        racine.setLeft(construireProfil());
        racine.setCenter(construireOffre());
        racine.setRight(construirePlan());

        rafraichir();
        stage.setTitle("Plateforme de planification de session (prototype phase 1)");
        stage.setScene(new Scene(racine, 1400, 700));
        stage.show();
    }

    private VBox construireHaut() {
        Label titre = new Label("Plateforme de planification de session");
        titre.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Button precedente = new Button("Semaine précédente");
        precedente.setOnAction(e -> { service.setSemaine(service.semaine() - 1); rafraichir(); });
        Button suivante = new Button("Semaine suivante");
        suivante.setOnAction(e -> { service.setSemaine(service.semaine() + 1); rafraichir(); });
        Label note = new Label("(contrôle de démonstration : simule l'avancement de la session)");
        note.setStyle("-fx-text-fill: #666;");
        Button recommencer = new Button("Recommencer la démo");
        recommencer.setOnAction(e -> recommencer());
        HBox temps = new HBox(8, libelleSemaine, precedente, suivante, recommencer, note);

        bandeau.setMaxWidth(Double.MAX_VALUE);
        bandeau.setPadding(new Insets(8));
        bandeau.setWrapText(true);

        VBox haut = new VBox(8, titre, temps, bandeau);
        haut.setPadding(new Insets(0, 0, 10, 0));
        return haut;
    }

    private VBox construireProfil() {
        ExigencesProgramme ex = service.exigences();
        Label titre = new Label("Exigences du programme");
        titre.setStyle("-fx-font-weight: bold;");
        Label source = new Label("Source : Répertoire des cours.\nLecture seule : fixées par le programme,\nnon modifiables par l'étudiant.");
        source.setStyle("-fx-text-fill: #666;");
        Label regles = new Label(
                ex.programme() + "\n"
                + "Temps plein : " + ex.seuilTempsPlein() + " crédits minimum\n"
                + "Plafond : " + ex.plafondCredits() + " crédits par session\n"
                + "Date limite de modification : semaine " + ex.semaineLimiteModification() + "\n"
                + "Date limite d'abandon : semaine " + ex.semaineLimiteAbandon());

        Label titreReleve = new Label("Mon relevé (importé)");
        titreReleve.setStyle("-fx-font-weight: bold;");
        Label releve = new Label(String.join(", ", service.etudiant().releve().stream().sorted().toList()));
        Label dispo = new Label("Disponibilité déclarée : " + service.etudiant().disponibiliteHeures() + " h/sem");

        VBox profil = new VBox(8, titre, source, regles, new Separator(), titreReleve, releve, dispo);
        profil.setPadding(new Insets(0, 12, 0, 0));
        profil.setPrefWidth(240);
        return profil;
    }

    private VBox construireOffre() {
        tableOffre.getColumns().add(colonne("Code", 75, Activite::code));
        tableOffre.getColumns().add(colonne("Activité", 200, Activite::titre));
        tableOffre.getColumns().add(colonne("Type", 100, a -> a.type().libelle()));
        tableOffre.getColumns().add(colonne("Crédits", 60, a -> String.valueOf(a.credits())));
        tableOffre.getColumns().add(colonne("Charge", 70, a -> a.heuresParSemaine() + " h/sem"));
        tableOffre.getColumns().add(colonne("Préalables", 90, Activite::prealablesTexte));
        tableOffre.getColumns().add(colonne("Horaire", 120, a -> a.creneau() == null ? "À convenir" : a.creneau().toString()));
        tableOffre.getColumns().add(colonne("Places", 80, a -> a.estComplete() ? "Complet" : a.placesRestantes() + " / " + a.places()));

        tableOffre.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        Button demander = new Button("Vérifier et demander l'inscription");
        demander.setOnAction(e -> demander());

        Label titre = new Label("Offre consolidée (session en cours)");
        titre.setStyle("-fx-font-weight: bold;");
        VBox centre = new VBox(8, titre, tableOffre, demander);
        VBox.setVgrow(tableOffre, Priority.ALWAYS);
        return centre;
    }

    private VBox construirePlan() {
        listePlan.setCellFactory(l -> new ListCell<>() {
            @Override
            protected void updateItem(Activite a, boolean vide) {
                super.updateItem(a, vide);
                setText(vide || a == null ? null : a.code() + "  " + a.titre() + " (" + a.credits() + " cr.)");
            }
        });
        Button retirer = new Button("Retirer l'activité sélectionnée");
        retirer.setOnAction(e -> retirer());

        Label titre = new Label("Mon plan de session (confirmé)");
        titre.setStyle("-fx-font-weight: bold;");
        VBox droite = new VBox(8, titre, listePlan, resume, retirer);
        droite.setPadding(new Insets(0, 0, 0, 12));
        droite.setPrefWidth(270);
        VBox.setVgrow(listePlan, Priority.ALWAYS);
        return droite;
    }

    private TableColumn<Activite, String> colonne(String titre, double largeur, Function<Activite, String> valeur) {
        TableColumn<Activite, String> c = new TableColumn<>(titre);
        c.setPrefWidth(largeur);
        c.setCellValueFactory(d -> new SimpleStringProperty(valeur.apply(d.getValue())));
        return c;
    }

    /** Décision 1 : la vérification précède l'envoi. Un constat bloquant empêche l'envoi. */
    private void demander() {
        Activite a = tableOffre.getSelectionModel().getSelectedItem();
        if (a == null) { info("Sélectionnez d'abord une activité dans l'offre."); return; }

        ResultatVerification r = service.verifierDemande(a);
        if (r.estBloque()) {
            afficher(Alert.AlertType.ERROR, "Demande non envoyée",
                    "La demande pour " + a.code() + " n'a pas été envoyée :", r);
            return;
        }
        if (r.aAvertissements() && !confirmer("Avertissement avant l'envoi",
                "Vérifiez ces points avant d'envoyer la demande pour " + a.code() + " :", r)) {
            return;
        }
        service.soumettreDemande(a);
        info(a.code() + " a été transmis au système d'inscription officiel (simulé) et ajouté à votre plan.");
        rafraichir();
    }

    /** Décision 2 : les conséquences d'un retrait sont montrées avant qu'il soit effectué. */
    private void retirer() {
        Activite a = listePlan.getSelectionModel().getSelectedItem();
        if (a == null) { info("Sélectionnez d'abord une activité de votre plan."); return; }

        ResultatVerification r = service.verifierRetrait(a);
        if (r.estBloque()) {
            afficher(Alert.AlertType.ERROR, "Retrait impossible", "Le retrait de " + a.code() + " est refusé :", r);
            return;
        }
        if (r.aAvertissements() && !confirmer("Conséquences du retrait",
                "Avant de retirer " + a.code() + " :", r)) {
            return;
        }
        service.retirer(a);
        rafraichir();
    }

    /** Remet la session à zéro (semaine 1, plan vide, places d'origine). */
    private void recommencer() {
        Alert alerte = new Alert(Alert.AlertType.CONFIRMATION,
                "Vider le plan et revenir à la semaine 1 ?");
        alerte.setHeaderText("Recommencer la démo");
        Optional<ButtonType> choix = alerte.showAndWait();
        if (choix.isPresent() && choix.get() == ButtonType.OK) {
            service = ServicePlanification.demo();
            tableOffre.getSelectionModel().clearSelection();
            rafraichir();
        }
    }

    private void rafraichir() {
        tableOffre.setItems(FXCollections.observableArrayList(service.offre()));
        listePlan.setItems(FXCollections.observableArrayList(service.plan().activites()));
        libelleSemaine.setText("Semaine " + service.semaine() + " / 15");
        resume.setText("Total : " + service.plan().credits() + " crédits, " + service.plan().charge() + " h/sem");

        bandeau.setText(service.etatTempsPlein());
        String couleur = service.estTempsPlein() ? "#d7f0dc; -fx-text-fill: #1b5e20" : "#fbe3e3; -fx-text-fill: #b71c1c";
        bandeau.setStyle("-fx-background-color: " + couleur + "; -fx-font-weight: bold;");
    }

    private void afficher(Alert.AlertType type, String titre, String entete, ResultatVerification r) {
        Alert alerte = new Alert(type);
        alerte.setTitle(titre);
        alerte.setHeaderText(entete);
        alerte.setContentText(texte(r));
        alerte.getDialogPane().setMinWidth(560);
        alerte.showAndWait();
    }

    private boolean confirmer(String titre, String entete, ResultatVerification r) {
        Alert alerte = new Alert(Alert.AlertType.CONFIRMATION);
        alerte.setTitle(titre);
        alerte.setHeaderText(entete);
        alerte.setContentText(texte(r) + "\n\nContinuer quand même ?");
        alerte.getDialogPane().setMinWidth(560);
        Optional<ButtonType> choix = alerte.showAndWait();
        return choix.isPresent() && choix.get() == ButtonType.OK;
    }

    private String texte(ResultatVerification r) {
        return r.constats().stream().map(Constat::toString).collect(Collectors.joining("\n\n"));
    }

    private void info(String message) {
        Alert alerte = new Alert(Alert.AlertType.INFORMATION, message);
        alerte.setHeaderText(null);
        alerte.showAndWait();
    }
}
