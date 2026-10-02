package ca.udem.ift2255.planif.service;

import java.util.ArrayList;
import java.util.List;

/** Ensemble des constats produits avant une décision (demande ou retrait). */
public class ResultatVerification {
    private final List<Constat> constats = new ArrayList<>();

    public void ajouter(Constat c) { constats.add(c); }

    public void fusionner(ResultatVerification autre) { constats.addAll(autre.constats); }

    public List<Constat> constats() { return List.copyOf(constats); }

    public boolean estBloque() { return constats.stream().anyMatch(c -> c.gravite() == Gravite.BLOQUANT); }

    public boolean aAvertissements() { return constats.stream().anyMatch(c -> c.gravite() == Gravite.AVERTISSEMENT); }

    public boolean estVide() { return constats.isEmpty(); }
}
