package ca.udem.ift2255.planif.service;

import ca.udem.ift2255.planif.modele.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

/**
 * Données simulées. Remplace le Répertoire des cours et le Système d'inscription officiel
 * (systèmes externes du C4) ainsi que la base PostgreSQL : tout est en mémoire.
 * Les préalables et horaires sont illustratifs, pas une copie du répertoire officiel.
 */
public final class DonneesSimulees {

    private DonneesSimulees() { }

    public static ExigencesProgramme exigences() {
        return new ExigencesProgramme("Baccalauréat en informatique", 12, 18, 3, 10);
    }

    public static Etudiant etudiantDemo() {
        return new Etudiant("Personne étudiante (démo)", Set.of("IFT1015", "MAT1400"), 30);
    }

    public static List<Activite> catalogue() {
        return List.of(
            cours("IFT1025", "Programmation 2", List.of("IFT1015"), DayOfWeek.MONDAY, 9, 11, 40, 22),
            cours("IFT1227", "Architecture des ordinateurs 1", List.of(), DayOfWeek.TUESDAY, 13, 15, 35, 30),
            cours("IFT2015", "Structures de données", List.of("IFT1025"), DayOfWeek.WEDNESDAY, 9, 11, 40, 18),
            cours("IFT2255", "Génie logiciel", List.of("IFT1025"), DayOfWeek.THURSDAY, 13, 15, 35, 35),
            cours("IFT3395", "Fondements de l'apprentissage machine", List.of("IFT2015"), DayOfWeek.FRIDAY, 9, 11, 30, 12),
            cours("MAT1978", "Probabilités et statistique", List.of("MAT1400"), DayOfWeek.MONDAY, 9, 11, 50, 31),
            cours("MAT1600", "Algèbre linéaire", List.of(), DayOfWeek.TUESDAY, 9, 11, 60, 40),
            cours("IFT1065", "Mathématiques discrètes", List.of(), DayOfWeek.WEDNESDAY, 13, 15, 45, 20),
            cours("PSY1075", "Psychologie sociale", List.of(), DayOfWeek.THURSDAY, 16, 18, 37, 10),
            new Activite("PROJ-LOG", "Projet supervisé en logiciel (Prof. Lavoie)", TypeActivite.PROJET_SUPERVISE,
                    6, List.of("IFT1025"), null, 3, 1),
            new Activite("SEM-SOC", "Séminaire de lecture : technologie et société", TypeActivite.SEMINAIRE,
                    1, List.of(), new Creneau(DayOfWeek.FRIDAY, LocalTime.of(14, 0), LocalTime.of(15, 0)), 13, 5)
        );
    }

    private static Activite cours(String code, String titre, List<String> prealables,
                                  DayOfWeek jour, int debut, int fin, int places, int inscrits) {
        return new Activite(code, titre, TypeActivite.COURS, 3, prealables,
                new Creneau(jour, LocalTime.of(debut, 30), LocalTime.of(fin, 30)), places, inscrits);
    }
}
