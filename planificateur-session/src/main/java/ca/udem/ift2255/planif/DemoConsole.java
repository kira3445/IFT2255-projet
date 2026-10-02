package ca.udem.ift2255.planif;

import ca.udem.ift2255.planif.modele.Activite;
import ca.udem.ift2255.planif.service.ResultatVerification;
import ca.udem.ift2255.planif.service.ServicePlanification;

/** Démonstration en console des décisions de conception, sans interface graphique. */
public class DemoConsole {

    public static void main(String[] args) {
        ServicePlanification s = ServicePlanification.demo();
        System.out.println("=== Exigences (lecture seule) : " + s.exigences());
        System.out.println("=== Relevé : " + s.etudiant().releve());
        System.out.println(s.etatTempsPlein());

        essayer(s, "IFT2015"); // préalable IFT1025 manquant
        essayer(s, "IFT2255"); // complet + préalable
        essayer(s, "IFT1025"); // accepté
        essayer(s, "MAT1978"); // conflit d'horaire avec IFT1025 (lundi)
        essayer(s, "IFT1227");
        essayer(s, "MAT1600");
        System.out.println(s.etatTempsPlein());
        essayer(s, "IFT1065");
        essayer(s, "PSY1075");
        essayer(s, "PROJ-LOG"); // préalable IFT1025 pas encore réussi
        essayer(s, "SEM-SOC");
        System.out.println(s.etatTempsPlein());

        System.out.println("\n--- Retrait de IFT1065 en semaine 2");
        s.setSemaine(2);
        retirer(s, "IFT1065");
        retirer(s, "PSY1075");
        System.out.println(s.etatTempsPlein());

        System.out.println("\n--- Semaine 4 : après la date limite de modification");
        s.setSemaine(4);
        essayer(s, "IFT1065");
        System.out.println(s.etatTempsPlein());

        System.out.println("\n--- Semaine 11 : après la date limite d'abandon");
        s.setSemaine(11);
        retirer(s, "IFT1227");
    }

    private static Activite trouver(ServicePlanification s, String code) {
        return s.offre().stream().filter(a -> a.code().equals(code)).findFirst().orElseThrow();
    }

    private static void essayer(ServicePlanification s, String code) {
        Activite a = trouver(s, code);
        ResultatVerification r = s.verifierDemande(a);
        boolean ok = s.soumettreDemande(a);
        System.out.println("\nDemande " + code + " -> " + (ok ? "ENVOYÉE" : "NON ENVOYÉE")
                + " | plan : " + s.plan().credits() + " crédits, " + s.plan().charge() + " h/sem");
        r.constats().forEach(c -> System.out.println("  " + c));
    }

    private static void retirer(ServicePlanification s, String code) {
        Activite a = s.plan().activites().stream().filter(x -> x.code().equals(code)).findFirst().orElseThrow();
        ResultatVerification r = s.verifierRetrait(a);
        boolean ok = s.retirer(a);
        System.out.println("\nRetrait " + code + " -> " + (ok ? "EFFECTUÉ" : "REFUSÉ")
                + " | plan : " + s.plan().credits() + " crédits");
        r.constats().forEach(c -> System.out.println("  " + c));
    }
}
