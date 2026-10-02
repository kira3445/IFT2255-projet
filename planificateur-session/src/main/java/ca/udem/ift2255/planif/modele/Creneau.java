package ca.udem.ift2255.planif.modele;

import java.time.DayOfWeek;
import java.time.LocalTime;

/** Plage horaire hebdomadaire d'une activité. Absente du prototype de référence (simplification S2). */
public record Creneau(DayOfWeek jour, LocalTime debut, LocalTime fin) {

    public boolean chevauche(Creneau autre) {
        if (autre == null || jour != autre.jour) return false;
        return debut.isBefore(autre.fin) && autre.debut.isBefore(fin);
    }

    @Override
    public String toString() {
        String[] jours = {"Lun", "Mar", "Mer", "Jeu", "Ven", "Sam", "Dim"};
        return jours[jour.getValue() - 1] + " " + debut + "-" + fin;
    }
}
