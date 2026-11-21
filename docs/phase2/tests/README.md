# Spécification des tests — Phase 2 (section 5 du rapport)

Tous les cas sont des **tests unitaires** : chacun vérifie **une seule règle** et s'attaque à **une seule classe**.
Les noms de classes et de méthodes doivent correspondre au diagramme de classes (`../diagrammes/`, section 4.1).

## 5.1 Exigences retenues et critères d'acceptation

Chaque exigence retenue reçoit au moins un critère d'acceptation vérifiable.

| Critère | Exigence | Étant donné | Quand | Alors |
|---|---|---|---|---|
| CA-1.1 | [À COMPLÉTER] | [À COMPLÉTER] | [À COMPLÉTER] | [À COMPLÉTER] |
| CA-1.2 | | | | |
| CA-2.1 | | | | |

## 5.2 Jeu de données

Données d'essai communes à tous les cas de l'oracle (personnes étudiantes, programme, activités, sessions, dates limites, …).

| Identifiant | Description | Valeurs |
|---|---|---|
| [À COMPLÉTER] | | |

## 5.3 Oracle (15 à 25 cas)

Pour chaque cas, l'oracle donne l'entrée et la sortie attendue.

Types de tests :

- **Succès** : l'entrée est valide et le résultat attendu est obtenu.
- **Échec** : l'entrée viole la règle et le système le signale.
- **Limite** : l'entrée se trouve exactement à un seuil.
- **Sanitaire** : une propriété reste la même avant et après l'exécution de la méthode.

| # | Exigence ou CU | Objectif | Classe et méthode | Type | Préconditions (optionnel) | Données d'entrée | Sortie attendue | Précisions |
|---|---|---|---|---|---|---|---|---|
| T01 | [À COMPLÉTER] | | `Classe.methode` | Succès | | | | |
| T02 | | | | Échec | | | | |
| T03 | | | | Limite | | | | |
| T04 | | | | Sanitaire | | | | |

## Vérifications

- [ ] Entre 15 et 25 cas dans l'oracle.
- [ ] Les quatre types (Succès, Échec, Limite, Sanitaire) sont représentés.
- [ ] Chaque exigence retenue a au moins un critère CA et au moins un cas dans l'oracle.
- [ ] Chaque cas est reporté dans `../tracabilite/README.md`.
