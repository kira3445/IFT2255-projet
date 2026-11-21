#  Plateforme de planification des études — projet de session IFT2255 (Automne 2026), Phase 2

- **Rapport :** `docs/phase2/[À COMPLÉTER : nom du PDF]`
- **Release :** https://github.com/kira3445/IFT2255-projet/releases/tag/phase-2

## 1. Changements depuis la phase 1

- [À COMPLÉTER : changement 1 — raison (rétroaction reçue, réponse du conseiller, contrainte découverte)]
- [À COMPLÉTER : changement 2 — raison]
- [À COMPLÉTER : changement 3 — raison]

## 2. Contenu de la remise

| Artefact | Contenu | Emplacement |
|---|---|---|
| B1 | Modèle C4 niveau 3 (composants) | Rapport, section 3 · `diagrammes/` |
| B2 | Diagramme de classes | Rapport, section 4 · `diagrammes/` |
| B3 | Spécification des tests (critères d'acceptation, jeu de données, oracle) | Rapport, section 5 |
| B4 | Modèle de données | Rapport, section 4.4 · `diagrammes/` |
| — | Traçabilité (flux A2 → composants → classes → tests) | Rapport, sections 3.4 et 6 |

## 3. État d'avancement
### Ce qui est conçu

- C4 niveau 3 du conteneur API/Backend : 4 contrôleurs, 5 services, dépôts de données et 4 clients d'intégration
- Diagramme de classes, modèle de données et spécification des tests
- Spécification des tests (B3) : 25 critères d'acceptation et 25 tests unitaires couvrant les 14 exigences retenues, avec jeu de données commun et bouchons pour les dépendances externes (API Planifium, notifications, horloge).

### Ce qui est implémenté

[À COMPLÉTER]

### Ce qui reste à faire

- Implémenter les 25 tests unitaires de B3 (JUnit) une fois les classes codées.
- Ajouter au diagramme de classes (B2) les éléments marqués « à ajouter » dans l'oracle : VerificateurDateLimite, résultat de préalables à trois valeurs, copie datée du catalogue, GenerateurPlan, GestionnaireDemandes.verifierExpirations.

## 4. Installation et lancement

[À COMPLÉTER : inchangé depuis la phase 1, ou nouvelles instructions]

## 5. Composition de l'équipe et répartition du travail
| Membre | Matricule |  Rôle / contribution |
|---|---|---|
| Cheikh Ahmed Khalifa | 20228606 | B1, conception de diagramme C4 niveau 3 |
| Michel Kpomaho | 20229387 | B3 – Spécification des tests : 25 critères d'acceptation (E1 à E14), jeu de données (DS-1 à DS-8), hypothèses de test (H1 à H7), oracle de 25 tests unitaires (T01 à T25) et traçabilité exigences → critères → tests → classes (section 6) |
| Samy Naak | 20343103 | [À COMPLÉTER : B1 / B2 / B3 / B4 …] |
| Moncef Ahmed Guellala | 20346073 | [À COMPLÉTER : B1 / B2 / B3 / B4 …] |

## 6. Outils d'assistance logicielle utilisés
| Outil | Utilise par | Utilisé pour | Parties concernées |

| Claude (Anthropic) | Michel Kpomaho | [Relecture de la cohérence de B3 avec le gabarit, aide pour la release GitHub] | B3 (section 5 et 6) |

⚠️ Non délégué à l'IA : [À COMPLÉTER]

## Structure du dossier

```
docs/phase2/
├── README.md        → ce fichier
├── <rapport>.pdf    → rapport de conception (phase 2)
├── diagrammes/
│   ├── sources/     → fichiers sources des diagrammes (B1, B2, B4)
│   └── images/      → exports PNG inclus dans le rapport
├── tests/           → (voir rapport, section 5)
└── tracabilite/     → (voir rapport, sections 3.4 et 6)
```
