# Phase 2 — Conception

Ce dossier regroupe les livrables de la phase 2 (conception) du projet IFT2255.

- **Rapport :** `[À COMPLÉTER : nom du PDF]`
- **Release :** https://github.com/kira3445/IFT2255-projet/releases/tag/phase-2

## Où trouver chaque section du rapport

| Section du rapport | Fichier(s) dans ce dossier |
|---|---|
| 1. Changements depuis la phase 1 | Rapport, section 1 |
| 2. Hypothèses (optionnel) | Rapport, section 2 |
| 3.1 C4 niveau 1 : contexte | `diagrammes/sources/c4-n1-contexte`, `diagrammes/images/c4-n1-contexte.png` |
| 3.2 C4 niveau 2 : conteneurs | `diagrammes/sources/c4-n2-conteneurs`, `diagrammes/images/c4-n2-conteneurs.png` |
| 3.3 C4 niveau 3 : composants | `diagrammes/sources/c4-n3-composants`, `diagrammes/images/c4-n3-composants.png` |
| 3.4 Cas d'utilisation → composants | `tracabilite/README.md` |
| 4.1 Diagramme de classes | `diagrammes/sources/classes-principal`, `diagrammes/images/classes-principal.png` |
| 4.2 et 4.3 Classes, responsabilités, choix de conception | Rapport, section 4 |
| 4.4 Modèle de données | `diagrammes/*/donnees-*` et rapport, section 4.4 |
| 5. Spécification des tests | `tests/README.md` |
| 6. Traçabilité | `tracabilite/README.md` |
| Annexe A. Diagrammes en pleine page | `diagrammes/images/` |
| Annexe B. Utilisation de l'IA | Rapport, annexe B, et README principal du dépôt |

## Organisation

```
docs/phase2/
├── README.md          ← ce fichier
├── <rapport>.pdf
├── diagrammes/
│   ├── README.md      ← liste des diagrammes et convention de nommage
│   ├── sources/       ← fichiers sources (.puml, .vpp, …)
│   └── images/        ← exports PNG inclus dans le rapport
├── tests/
│   └── README.md      ← critères d'acceptation, jeu de données, oracle
└── tracabilite/
    └── README.md      ← CU / flux → composants → classes → tests
```
