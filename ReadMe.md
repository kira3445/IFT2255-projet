#  Plateforme de planification des études — projet de session IFT2255 (Automne 2026), Phase 1



## 1. À quoi sert le projet

1. (UC07, UC19, UC20, flux A2-1). Avant toute demande d'inscription, le système vérifie les préalables, les conflits d'horaire, les places, le plafond de crédits et la date limite de modification. Une règle officielle non respectée bloque l'envoi et une alternative est proposée. Dans *Mon cheminement*, ces vérifications n'existent pas ou n'arrivent qu'après coup.
   
2. (UC10, UC13, flux A2-4). Un bandeau indique en permanence l'état du temps plein et le délai restant pour le corriger. Avant un retrait, les conséquences (temps plein, frais, date limite d'abandon) sont affichées et doivent être confirmées. Dans *Mon cheminement*, le temps plein manqué n'est signalé qu'à la semaine 15.
   
3. (UC20). Les règles proviennent du programme et ne sont pas modifiables par la personne étudiante. Dans *Mon cheminement*, ajouter une case modifie l'exigence elle-même.

Le prototype distingue aussi la **règle officielle** (bloquante, par exemple le plafond de crédits) du **conseil personnel** lié à la disponibilité déclarée (simple avertissement), et compte 9 h de travail par semaine pour un cours de 3 crédits.

## 2. État d'avancement

### Ce qui fonctionne réellement

Consulter l'offre consolidée d'activités (UC02)
Soumettre une demande d'inscription à un cours, avec vérification des préalables, des conflits d'horaire, du plafond de crédits, des places et des dates limites avant l'envoi (UC07, UC19, UC20)
Afficher en permanence l'état du temps plein et alerter avant qu'il ne soit atteint (UC13)
Modifier ou retirer une activité du plan, avec les conséquences affichées avant le retrait (UC10)
Consulter les exigences du programme, fixées par le programme et non modifiables par la personne étudiante (UC01, UC20)


### Ce qui est simulé / mocké

Le Répertoire des cours et le Système d'inscription officiel (systèmes externes du C4) : données d'une dizaine d'activités fictives codées en dur, pas de vraie base de données ni d'API externe
L'API Spring Boot et la base PostgreSQL prévues au C4 niveau 2 : remplacées par un service en mémoire dans le client de bureau
L'avancement des semaines : contrôlé par des boutons de démonstration plutôt que par le temps réel


### Ce qui reste à faire

Demande d'encadrement (projet supervisé, laboratoire, stage) et suivi de son état (UC08, UC09)
Demande d'exception au département (UC11)
Publication d'avis sur une activité (UC04)
Planification sur les sessions futures (UC12)
Offres et réponses des encadrants (UC14, UC15)
Notifications (UC13)
Persistance réelle des données (base de données, API)


## 3. Installation et lancement

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


## 4. Composition de l'équipe et répartition du travail

| Membre | Matricule |  Rôle / contribution |
|---|---|---|
| Cheikh Ahmed Khalifa | 20228606  | Modele C4 (A3), niveaux 1 et 2, parcourt documentee
| Michel | 20229387 | Enquête sur le prototype (3 profils contrastés, sessions exportées), diagrammes d'activités (A2),prototype codé (client JavaFX, logique et données simulées) |
| Samy Naak | 20343103 |Analyse du prototype, A1, Redaction et coordination du rapport, ReadMe|
| Moncef | 20346073 | Révison du prototype, Fiches A1, Redaction rapport, Réalisation du diagramme A1, Debug|

## 5. Outils d'assistance logicielle utilisés

| Outil | Utilise par | Utilisé pour | Parties concernées |
|---|---|---|---|
| Claude | Cheikh Ahmed Khalifa, Moncef Ahmed Guellala | Aide à la conception (diagrammes C4, structuration du projet), Planification, Relecture et suggestions | A3, mise en place du dépôt, README |
| Gemini |  Moncef Ahmed Guellala | Orthographe et Grammaire | Rapport |


Code du prototype généré avec l'assistance de Claude (Anthropic), à partir de nos diagrammes A1, A2 et A3, puis relu, testé et ajusté par l'équipe.

> ⚠️ Non délégué à l'IA : l'enquête (observations du prototype de référence, 
> questions au conseiller, entretiens) — travail entièrement issu de l'équipe.

## Structure du dépôt

\`\`\`
/src              → code du prototype
/docs/diagrams    → fichiers sources des diagrammes (A1, A2, A3)
/docs/rapport.pdf → rapport d'analyse et de conception
\`\`\`

