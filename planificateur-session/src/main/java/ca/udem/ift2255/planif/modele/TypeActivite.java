package ca.udem.ift2255.planif.modele;

/** Types d'activités de l'offre consolidée (UC02). */
public enum TypeActivite {
    COURS("Cours"), PROJET_SUPERVISE("Projet supervisé"), SEMINAIRE("Séminaire");

    private final String libelle;
    TypeActivite(String libelle) { this.libelle = libelle; }
    public String libelle() { return libelle; }
}
