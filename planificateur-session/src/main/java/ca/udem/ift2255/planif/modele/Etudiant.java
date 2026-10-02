package ca.udem.ift2255.planif.modele;

import java.util.Set;

/** Profil d'études (UC01) : relevé importé (UC16) et disponibilité déclarée. */
public record Etudiant(String nom, Set<String> releve, int disponibiliteHeures) {

    public boolean aReussi(String code) { return releve.contains(code); }
}
