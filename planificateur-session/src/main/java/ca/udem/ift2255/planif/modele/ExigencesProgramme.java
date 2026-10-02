package ca.udem.ift2255.planif.modele;

/**
 * Exigences officielles d'un programme (UC20).
 * Objet immuable : elles sont importées du Répertoire des cours et ne sont jamais
 * modifiables par la personne étudiante (corrige la simplification S4 du prototype de référence).
 */
public record ExigencesProgramme(String programme, int seuilTempsPlein, int plafondCredits,
                                 int semaineLimiteModification, int semaineLimiteAbandon) {
}
