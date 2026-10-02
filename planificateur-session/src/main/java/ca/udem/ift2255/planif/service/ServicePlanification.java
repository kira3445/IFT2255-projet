package ca.udem.ift2255.planif.service;

import ca.udem.ift2255.planif.modele.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Point d'entrée de la logique (joue le rôle de l'API Spring Boot du C4, simulée ici en mémoire).
 * UC07 soumettre une demande d'inscription : vérification complète AVANT l'envoi.
 * UC10 retirer une activité : simulation et alerte AVANT le retrait.
 */
public class ServicePlanification {

    private final Etudiant etudiant;
    private final ExigencesProgramme exigences;
    private final Plan plan = new Plan();
    private final List<Activite> offre;
    private final VerificateurAdmissibilite admissibilite = new VerificateurAdmissibilite();
    private final VerificateurRegles regles = new VerificateurRegles();
    private int semaine = 1;

    public ServicePlanification(Etudiant etudiant, ExigencesProgramme exigences, List<Activite> offre) {
        this.etudiant = etudiant;
        this.exigences = exigences;
        this.offre = new ArrayList<>(offre);
    }

    public static ServicePlanification demo() {
        return new ServicePlanification(DonneesSimulees.etudiantDemo(), DonneesSimulees.exigences(),
                DonneesSimulees.catalogue());
    }

    /** Étape 1 de UC07 : vérifier sans rien envoyer. */
    public ResultatVerification verifierDemande(Activite a) {
        ResultatVerification r = admissibilite.verifier(etudiant, plan, a, exigences, semaine);
        r.fusionner(regles.verifierAjout(etudiant, plan, a, exigences));
        return r;
    }

    /** Étape 2 de UC07 : envoi au Système d'inscription officiel (simulé), seulement si rien ne bloque. */
    public boolean soumettreDemande(Activite a) {
        if (verifierDemande(a).estBloque()) return false;
        plan.ajouter(a);
        remplacer(a, new Activite(a.code(), a.titre(), a.type(), a.credits(), a.prealables(), a.creneau(),
                a.places(), a.inscrits() + 1));
        return true;
    }

    public ResultatVerification verifierRetrait(Activite a) {
        return regles.verifierRetrait(plan, a, exigences, semaine);
    }

    public boolean retirer(Activite a) {
        if (verifierRetrait(a).estBloque()) return false;
        plan.retirer(a);
        return true;
    }

    private void remplacer(Activite ancienne, Activite nouvelle) {
        for (int i = 0; i < offre.size(); i++) {
            if (offre.get(i).code().equals(ancienne.code())) offre.set(i, nouvelle);
        }
    }

    public String etatTempsPlein() { return regles.etatTempsPlein(plan, exigences, semaine); }

    public boolean estTempsPlein() { return regles.estTempsPlein(plan, exigences); }

    public List<Activite> offre() { return List.copyOf(offre); }

    public Plan plan() { return plan; }

    public Etudiant etudiant() { return etudiant; }

    public ExigencesProgramme exigences() { return exigences; }

    public int semaine() { return semaine; }

    public void setSemaine(int semaine) { this.semaine = Math.max(1, Math.min(15, semaine)); }
}
