# Diagrammes — Phase 2

- `sources/` : fichiers sources éditables (PlantUML `.puml`, Visual Paradigm `.vpp`, …)
- `images/` : exports PNG inclus dans le rapport et en annexe A (pleine page)

Une source et son image portent **le même nom**, seule l'extension change.

## Diagrammes attendus

| Section du rapport | Diagramme | Nom de fichier | Source | Image | Auteur·e |
|---|---|---|---|---|---|
| 3.1 | C4 niveau 1 : contexte (révisé) | `c4-n1-contexte` | ☐ | ☐ | [À COMPLÉTER] |
| 3.2 | C4 niveau 2 : conteneurs (révisé) | `c4-n2-conteneurs` | ☐ | ☐ | [À COMPLÉTER] |
| 3.3 | C4 niveau 3 : composants du conteneur qui applique les règles | `c4-n3-composants` | ☐ | ☐ | [À COMPLÉTER] |
| 4.1 | Diagramme de classes, vue principale (15 à 20 classes, multiplicités sur chaque association) | `classes-principal` | ☐ | ☐ | [À COMPLÉTER] |
| 4.1 | Vue(s) secondaire(s), si le diagramme est trop dense | `classes-vue-<nom>` | ☐ | ☐ | [À COMPLÉTER] |
| 4.4.2 | Classes conservées d'une visite à l'autre, et où | `donnees-persistance` | ☐ | ☐ | [À COMPLÉTER] |
| 4.4.3 | Parcours d'une information, de la source à l'affichage (1) | `donnees-parcours-1` | ☐ | ☐ | [À COMPLÉTER] |
| 4.4.3 | Parcours d'une information, de la source à l'affichage (2) | `donnees-parcours-2` | ☐ | ☐ | [À COMPLÉTER] |

## Vérifications avant la remise

- [ ] Chaque diagramme est lisible et inclus dans le rapport.
- [ ] Chaque image dans `images/` a sa source dans `sources/`.
- [ ] Les noms des composants (3.3) et des classes (4.1) sont les mêmes que dans `../tracabilite/README.md` et `../tests/README.md`.

## Export PlantUML (même commande qu'à la phase 1)

```
java -DPLANTUML_LIMIT_SIZE=8192 -jar plantuml.jar -SDPI=300 sources/<nom>.puml -o ../images
```
