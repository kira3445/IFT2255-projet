# Prototype : plateforme de planification de session

Partie « prototype » du README, à intégrer au README principal du dépôt.

## À quoi sert le prototype

Ce prototype montre trois décisions de conception tirées de notre enquête sur *Mon cheminement* :

1. **Vérifier avant d'envoyer** (UC07, UC19, UC20, flux A2-1). Avant toute demande d'inscription, le système vérifie les préalables, les conflits d'horaire, les places, le plafond de crédits et la date limite de modification. Une règle officielle non respectée bloque l'envoi et une alternative est proposée. Dans *Mon cheminement*, ces vérifications n'existent pas ou n'arrivent qu'après coup.
2. **Alerter tout de suite sur le temps plein** (UC10, UC13, flux A2-4). Un bandeau indique en permanence l'état du temps plein et le délai restant pour le corriger. Avant un retrait, les conséquences (temps plein, frais, date limite d'abandon) sont affichées et doivent être confirmées. Dans *Mon cheminement*, le temps plein manqué n'est signalé qu'à la semaine 15.
3. **Exigences du programme en lecture seule** (UC20). Les règles proviennent du programme et ne sont pas modifiables par la personne étudiante. Dans *Mon cheminement*, ajouter une case modifie l'exigence elle-même.

Le prototype distingue aussi la **règle officielle** (bloquante, par exemple le plafond de crédits) du **conseil personnel** lié à la disponibilité déclarée (simple avertissement), et compte 9 h de travail par semaine pour un cours de 3 crédits.

## Ce qui fonctionne, ce qui est simulé, ce qui reste à faire

| Fonctionne | Simulé | Reste à faire |
|---|---|---|
| Consultation de l'offre, vérification avant demande, ajout et retrait d'activités, bandeau de temps plein, dates limites appliquées | L'API Spring Boot et la base PostgreSQL du C4 (remplacées par un service en mémoire) ; le Répertoire des cours et le Système d'inscription officiel (données fictives) ; l'avancement des semaines (boutons de démonstration) | Demandes d'encadrement (UC08) et d'exception (UC11), avis (UC04), sessions futures (UC12), notifications (UC13), persistance des données |

## Installer et lancer

Prérequis : Java 17 ou plus récent, et Maven (inclus dans IntelliJ IDEA).

**Avec IntelliJ IDEA** : ouvrir le dossier `planificateur-session` (IntelliJ reconnaît le projet Maven), puis dans le panneau Maven : `Plugins > javafx > javafx:run`.

**En ligne de commande** :
```
mvn javafx:run
```

Démonstration sans interface graphique (scénarios commentés dans la console) :
```
mvn compile exec:java
```

## Scénario de démonstration suggéré

Le bouton « Recommencer la démo » vide le plan et revient à la semaine 1.

1. Sélectionner **IFT2015** puis « Vérifier et demander » : refus pour préalable manquant (IFT1025).
2. Demander **IFT1025**, puis **MAT1978** : refus pour conflit d'horaire (lundi).
3. Demander **IFT2255** : refus, cours complet, avec la proposition de demander une exception (UC11).
4. Ajouter des cours jusqu'à 12 crédits : le bandeau passe du rouge au vert.
5. Retirer un cours : avertissement de perte du temps plein avant le retrait.
6. Avancer à la semaine 4 : plus aucune demande possible (date limite de modification) ; semaine 11 : retrait refusé (date limite d'abandon).

## Outils d'assistance

Code du prototype généré avec l'assistance de Claude (Anthropic), à partir de nos diagrammes A1, A2 et A3, puis relu, testé et ajusté par l'équipe.
