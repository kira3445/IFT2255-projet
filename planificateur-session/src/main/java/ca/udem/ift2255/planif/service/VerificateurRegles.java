package ca.udem.ift2255.planif.service;

import ca.udem.ift2255.planif.modele.*;

/**
 * UC20 Vérifier les règles du programme : plafond de crédits, temps plein, charge.
 * Distingue la règle officielle (bloquante) du conseil personnel lié à la disponibilité
 * (avertissement), que le prototype de référence confondait (simplification S5).
 */
public class VerificateurRegles {

    public ResultatVerification verifierAjout(Etudiant etudiant, Plan plan, Activite activite,
                                              ExigencesProgramme exigences) {
        ResultatVerification r = new ResultatVerification();
        int creditsApres = plan.credits() + activite.credits();
        int chargeApres = plan.charge() + activite.heuresParSemaine();

        if (creditsApres > exigences.plafondCredits()) {
            r.ajouter(new Constat(Gravite.BLOQUANT,
                    "Plafond du programme dépassé : " + creditsApres + " crédits pour un maximum de "
                            + exigences.plafondCredits() + ".",
                    "Retirer une activité du plan avant d'ajouter celle-ci (UC10)."));
        }
        if (chargeApres > etudiant.disponibiliteHeures()) {
            r.ajouter(new Constat(Gravite.AVERTISSEMENT,
                    "Charge estimée de " + chargeApres + " h/sem pour une disponibilité déclarée de "
                            + etudiant.disponibiliteHeures() + " h/sem (conseil personnel, pas une règle du programme).",
                    "Vérifier votre disponibilité réelle avant de confirmer."));
        }
        return r;
    }

    public ResultatVerification verifierRetrait(Plan plan, Activite activite,
                                                ExigencesProgramme exigences, int semaine) {
        ResultatVerification r = new ResultatVerification();
        if (semaine > exigences.semaineLimiteAbandon()) {
            r.ajouter(new Constat(Gravite.BLOQUANT,
                    "La date limite d'abandon (semaine " + exigences.semaineLimiteAbandon()
                            + ") est passée : le retrait n'est plus possible.",
                    "Contacter l'administration de votre département."));
        }
        boolean apresModification = semaine > exigences.semaineLimiteModification();
        if (apresModification && semaine <= exigences.semaineLimiteAbandon()) {
            r.ajouter(new Constat(Gravite.AVERTISSEMENT,
                    "La date limite de modification est passée : ce retrait est un abandon avec frais.",
                    null));
        }
        int creditsApres = plan.credits() - activite.credits();
        if (creditsApres < exigences.seuilTempsPlein()) {
            r.ajouter(new Constat(Gravite.AVERTISSEMENT,
                    "Après ce retrait, vous auriez " + creditsApres + " crédits, sous le seuil de temps plein ("
                            + exigences.seuilTempsPlein() + "). Conséquences possibles sur les prêts et bourses.",
                    apresModification ? "Garder l'activité : aucune activité ne peut plus être ajoutée cette session."
                                      : "Garder l'activité, ou la remplacer avant la date limite de modification."));
        }
        return r;
    }

    /** Message d'état du temps plein, affiché en permanence (et non à la clôture, simplification S18). */
    public String etatTempsPlein(Plan plan, ExigencesProgramme exigences, int semaine) {
        int manque = exigences.seuilTempsPlein() - plan.credits();
        if (manque <= 0) {
            return "Temps plein atteint : " + plan.credits() + " crédits (seuil " + exigences.seuilTempsPlein() + ").";
        }
        if (semaine > exigences.semaineLimiteModification()) {
            return "Temps plein impossible cette session : " + plan.credits() + " crédits sur "
                    + exigences.seuilTempsPlein() + ", et la date limite de modification est passée.";
        }
        int semainesRestantes = exigences.semaineLimiteModification() - semaine;
        return "Sous le temps plein : " + plan.credits() + " crédits sur " + exigences.seuilTempsPlein()
                + ". Ajoutez " + manque + " crédits d'ici la semaine " + exigences.semaineLimiteModification()
                + " (encore " + semainesRestantes + " semaine(s)).";
    }

    public boolean estTempsPlein(Plan plan, ExigencesProgramme exigences) {
        return plan.credits() >= exigences.seuilTempsPlein();
    }
}
