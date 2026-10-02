package ca.udem.ift2255.planif.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Plan de session (UC05) : activités confirmées pour la session en cours. */
public class Plan {
    private final List<Activite> activites = new ArrayList<>();

    public List<Activite> activites() { return Collections.unmodifiableList(activites); }

    public int credits() { return activites.stream().mapToInt(Activite::credits).sum(); }

    public int charge() { return activites.stream().mapToInt(Activite::heuresParSemaine).sum(); }

    public boolean contient(String code) { return activites.stream().anyMatch(a -> a.code().equals(code)); }

    public void ajouter(Activite a) { activites.add(a); }

    public void retirer(Activite a) { activites.removeIf(x -> x.code().equals(a.code())); }
}
