package ca.udem.ift2255.planif.service;

import ca.udem.ift2255.planif.modele.*;

/**
 * UC19 Vérifier l'admissibilité (préalables et horaire), avec les places et la date limite.
 * Exécuté AVANT l'envoi d'une demande (flux A2-1), contrairement au prototype de référence.
 */
public class VerificateurAdmissibilite {

    public ResultatVerification verifier(Etudiant etudiant, Plan plan, Activite activite,
                                         ExigencesProgramme exigences, int semaine) {
        ResultatVerification r = new ResultatVerification();

        if (semaine > exigences.semaineLimiteModification()) {
            r.ajouter(new Constat(Gravite.BLOQUANT,
                    "La date limite de modification de l'inscription (semaine "
                            + exigences.semaineLimiteModification() + ") est passée.",
                    "Planifier cette activité pour une session future (UC12)."));
        }
        if (plan.contient(activite.code())) {
            r.ajouter(new Constat(Gravite.BLOQUANT, activite.code() + " est déjà dans votre plan.", null));
        }
        for (String prealable : activite.prealables()) {
            if (!etudiant.aReussi(prealable)) {
                r.ajouter(new Constat(Gravite.BLOQUANT,
                        "Préalable manquant : " + prealable + " ne figure pas dans votre relevé.",
                        "Suivre " + prealable + " d'abord, ou planifier " + activite.code()
                                + " pour une session future (UC12)."));
            }
        }
        for (Activite autre : plan.activites()) {
            if (activite.creneau() != null && activite.creneau().chevauche(autre.creneau())) {
                r.ajouter(new Constat(Gravite.BLOQUANT,
                        "Conflit d'horaire avec " + autre.code() + " (" + autre.creneau() + ").",
                        "Choisir une autre activité, ou demander une exception au département (UC11)."));
            }
        }
        if (activite.estComplete()) {
            r.ajouter(new Constat(Gravite.BLOQUANT,
                    activite.code() + " est complet (" + activite.places() + " places).",
                    "Demander une exception au département (UC11)."));
        }
        return r;
    }
}
