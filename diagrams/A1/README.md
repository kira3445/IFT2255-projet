# A1 — Diagramme de cas d'utilisation

| Fichier | Contenu |
|---|---|
| `A1-Diagramme.puml` | Source PlantUML, (Moncef Ahmed Guellala) |
| `A1-Diagramme.png` | Export PNG 300 DPI, pour le rapport |

Acteurs : personne étudiante (principal) ; encadrant ou partenaire (principal pour UC14 et UC15, secondaire pour UC08) ; administration (secondaire) ; systèmes externes : répertoire des cours, calendrier universitaire, service de notifications, système d'inscription officiel.

Relations : UC05, UC07, UC08 et UC10 incluent « Vérifier les règles du programme » (UC20) ; UC07 inclut « Vérifier l'admissibilité » (UC19) ; UC03 inclut « Consulter la disponibilité des places » (UC18) ; UC16 étend UC01, UC17 é,tend UC03, UC11 étend UC07.

Export : `java -DPLANTUML_LIMIT_SIZE=8192 -jar plantuml.jar -SDPI=300 A1-cas-utilisation.puml`
