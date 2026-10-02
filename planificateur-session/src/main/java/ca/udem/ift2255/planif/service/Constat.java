package ca.udem.ift2255.planif.service;

/** Un résultat de vérification : un motif, sa gravité et une alternative proposée. */
public record Constat(Gravite gravite, String motif, String alternative) {

    @Override
    public String toString() {
        String prefixe = gravite == Gravite.BLOQUANT ? "[Bloquant] " : "[Avertissement] ";
        return prefixe + motif + (alternative == null ? "" : "\n   Alternative : " + alternative);
    }
}
