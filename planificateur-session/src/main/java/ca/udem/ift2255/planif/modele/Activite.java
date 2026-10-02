package ca.udem.ift2255.planif.modele;

import java.util.List;

/**
 * Une activité de l'offre (cours, projet supervisé, séminaire).
 * Les données proviennent du Répertoire des cours, simulé dans ce prototype.
 * La charge suit la règle de 45 h de travail par crédit (3 crédits = 9 h/sem sur 15 semaines).
 */
public record Activite(String code, String titre, TypeActivite type, int credits,
                       List<String> prealables, Creneau creneau, int places, int inscrits) {

    public int heuresParSemaine() { return credits * 3; }

    public int placesRestantes() { return Math.max(0, places - inscrits); }

    public boolean estComplete() { return placesRestantes() == 0; }

    public String prealablesTexte() { return prealables.isEmpty() ? "Aucun" : String.join(", ", prealables); }
}
