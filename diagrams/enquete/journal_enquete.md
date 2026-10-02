# Journal d'enquête : prototype Mon cheminement (IFT2255, phase 1)

Traces d'enquête (section 6 du rapport).

## 1. Sessions jouées et exportées

| Session | Profil | Résultat | Fichier |
|---|---|---|---|
| Coéquipier 1 | Logiciel, Données et IA, Design · 3 cours / 1 projet / 1 activité · 30 h | 3 demandes, 0 confirmée, 3 encore en attente à la clôture | mon-cheminement-s15-2026-09-21.json |
| Coéquipier 2 | même profil | 8 demandes, 3 expirées, 5 confirmées, 16 crédits | …__1_.json |
| Coéquipier 3 | même profil | 7 demandes, 2 expirées, 5 confirmées, 16 crédits | …__2_.json |
| Profil A (Michel) | Logiciel, Données et IA · 4 cours · 30 h · concentré, pratique | 7 demandes, 4 expirées, 2 confirmées, **6 crédits : temps plein raté** | mon-cheminement-s15-2026-09-28.json |
| Profil C (Michel) | Psychologie, Technologie et société, Design · 5 cours / 1 projet / 2 séminaires · 10 h · explorer, théorique | 8 demandes, 2 expirées, 6 confirmées ; **19 crédits pour un plafond de 15, 36 h pour 10 h disponibles** ; 0 cours de psychologie, 6 activités hors concentration ; intention PSY1075 à Hiver 2027 | mon-cheminement-s15-2026-09-28__2_.json |
| Profil B (Michel) | Robotique, Logiciel · 2 cours / 1 projet / 1 séminaire · 20 h · expérience prioritaire | 3 demandes : projet (Prof. Boucher) et ELE8200 confirmés en sem. 3, MEC1310 expiré sans avis ; **9 crédits : temps plein raté**, signalé en rouge seulement à la clôture | mon-cheminement-s15-2026-09-28__1_.json |

## 2. Simplifications relevées (brouillon pour la section 3)

| # | Observation dans le prototype | Réalité | Coût pour l'étudiant | Verdict proposé | Obj. |
|---|---|---|---|---|---|
| S1 | Aucun préalable modélisé : IFT1015 et IFT1025 demandés ensemble ; IFT3395 (niveau 3000) confirmé en semaine 1 sans relevé | Les cours ont des préalables (répertoire) | Inscription à un cours impossible à réussir, découverte tardive | À corriger | O3 |
| S2 | Aucun horaire, donc aucun conflit possible | Les cours ont des horaires, les conflits sont fréquents (parcours de MHD) | Plan irréalisable | À corriger | O3 |
| S3 | Dates limites affichées (16 sept., 6 nov.) mais non appliquées : cours confirmés en semaines 11 à 14 | Après la date limite, modification impossible ou abandon avec frais | Fausse impression de marge, frais | À corriger | O3, O4 |
| S4 | Ajouter une case change l'exigence du programme (4 → 6 cours) | Les exigences sont fixées par le programme | L'étudiant peut « réécrire » ses règles | À corriger | O2, O3 |
| S5 | Plafond de crédits lié à la disponibilité (18 à 30 h, 15 à 20 h, 15 à 10 h) | Plafond fixé par le règlement | Confusion entre conseil personnel et règle officielle | À corriger (garder comme avertissement distinct) | O3 |
| S6 | Charge de 6 h/sem pour 3 crédits | 1 crédit ≈ 45 h, soit ~9 h/sem (à vérifier) | Surcharge sous-estimée | À corriger | O3 |
| S7 | Cours en inscription libre soumis à une demande qui attend et peut expirer | Inscription immédiate dans Synchro | Perte de cours sans raison | À corriger | O4 |
| S8 | Une demande en attente bloque une case | | Impossible de prévoir un plan B pendant l'attente | À discuter | O4 |
| S9 | Demandes en attente non comptées dans les crédits | | Aucune alerte avant confirmation | À corriger | O3 |
| S10 | Appréciation possible avant d'avoir suivi l'activité | Un avis suppose d'avoir suivi | Suggestions faussées | À corriger | O2, O6 |
| S11 | Monde régénéré à chaque partie (places, rattachements) | Offre stable, publiée | Aucun (outil de simulation) | Acceptable | |
| S12 | % disponible / % répond des superviseurs affichés | Information tacite, non publiée | Utile à l'étudiant, mais sensible pour les professeurs | Acceptable avec réserves (conflit de parties prenantes) | O6 |
| S13 | Conditions affichées non vérifiables (« dès la 2e année », « rencontre préalable ») | Conditions réelles d'accès | Demandes vouées à l'échec | À corriger | O3 |
| S14 | Activités qui ouvrent en cours de session ; séminaire exigé mais aucun offert en semaine 1, sans explication ; 3 séminaires ouvrent en sem. 3-4, hors des intérêts du profil, et le prototype ne signale pas qu'ils pourraient remplir la case vide (profil B terminé sans séminaire) | Certaines activités ouvrent tard | Incertitude, pas de date annoncée ; exigence manquée | À corriger (afficher la date d'ouverture) | O4 |
| S16 | Projet supervisé confirmé automatiquement, sans étape « offert » ni acceptation par l'étudiant | L'étudiant accepte ou refuse une offre | Engagement sans consentement explicite | À corriger | O4 |
| S17 | Expiration silencieuse (MEC1310 disparu sans notification) | | L'étudiant découvre trop tard qu'il a perdu sa place en attente | À corriger | O4 |
| S18 | Règle du temps plein neutre toute la session, rouge seulement à la clôture (sem. 15) | Statut vérifié à la date limite de modification | Perte du temps plein (prêts et bourses) découverte trop tard | À corriger | O3 |
| S19 | Après la date limite d'abandon : simple avertissement « entraînerait des frais », retrait permis ; contredit le calendrier | Après le 6 nov., abandon impossible | Fausse information sur ce qui reste possible | À corriger | O3, O4 |
| S20 | Avertissement « dépasserait votre disponibilité » affiché avant la demande, non bloquant | | Bonne pratique (contrainte visible avant la décision) | Point fort à conserver | O3 |
| S21 | Vue multi-sessions : intention clairement distinguée d'une place (« rien n'est réservé ici ») | | Aucun, bonne pratique pour O5 | Point fort à conserver | O5 |
| S22 | Intention acceptée sans indiquer si l'activité est offerte à la session visée ; exigences des sessions futures réglées par l'étudiant (+/−) | Offre et exigences fixées par l'université et le programme | Projection irréaliste | À corriger | O5 |
| S23 | Profil C : règles incompatibles acceptées sans alerte (5 cours = 30 h, temps plein = 24 h, maximum 10 h) ; cours limités à 6 cases (18 crédits) alors que le plafond est de 15 | | Plan irréalisable dès la configuration | À corriger (vérifier la cohérence du profil) | O3 |
| S24 | Plafonds dépassés sans blocage : 19 crédits / 15, 36 h / 10 h ; règles rouges et avertissements « dépasserait le maximum », mais demandes acceptées et confirmées | Au-delà du maximum, autorisation requise | Surcharge réelle, échec probable | À corriger | O3 |
| S25 | Asymétrie des alertes : les plafonds passent au rouge dès le dépassement, les minimums (temps plein) seulement à la clôture | | Le risque le plus coûteux (perte du temps plein) est signalé le plus tard | À corriger | O3 |
| S26 | Profil centré sur la psychologie terminé avec 0 cours de psychologie et 6 activités hors concentration (règle « au plus 1 » en rouge, sans blocage) | Exigences de bloc imposées par le programme | Session inutile pour le programme | À corriger | O2 |
| S27 | Cumul du programme = crédits en cours + intentions planifiées (22 = 19 + 3) | Seuls les crédits réussis comptent | Avancement surestimé | Acceptable si bien étiqueté | O5 |
| S28 | Message de fin : « 2 demandes antérieures ont expiré sans réponse » (bilan, pas d'alerte au moment de l'expiration) | | Information tardive | À corriger (alerter à l'expiration) | O4 |
| S15 | Cumul du programme compte les crédits en cours | Seuls les crédits réussis sont acquis | Surestimation de l'avancement | Acceptable si bien étiqueté | O5 |

## 3. Reste à vérifier (profil B / C)
- Préciser comment une « offre reçue, non confirmée » devient « confirmée » (clic de l'étudiant ou automatique ?)
