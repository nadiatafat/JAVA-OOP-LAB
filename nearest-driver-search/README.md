# Nearest Driver Search (Spatial Grid)

## Contexte

Ce projet illustre un problème classique de backend temps réel.

Exemple :

* Une application type Uber
* Un utilisateur fait une demande
* Il y a jusqu’à **1 million de chauffeurs connectés**
* Il faut trouver **le chauffeur le plus proche**

---

## Problème

Chaque chauffeur a :

* une latitude
* une longitude

La distance réelle entre deux points GPS est calculée avec la **formule de Haversine**.

Problème :

* Calculer cette distance pour **1 million de chauffeurs** à chaque requête est trop lent
* La solution naïve est en **O(N)** et ne scale pas

---

## Idée clé

On n’a pas besoin de comparer l’utilisateur avec tous les chauffeurs.

Un chauffeur très loin :

* ne sera jamais le plus proche

On peut donc :

* **réduire fortement le nombre de comparaisons**
* ne calculer la distance exacte que sur un petit groupe

---

## Solution : Grille spatiale

### Principe

On découpe la carte en **cellules géographiques fixes** (grille).

* Chaque chauffeur est stocké dans une cellule
* Une cellule contient une liste de chauffeurs

Exemple :

```
(latitude, longitude) → cellule (x, y)
```

---

## Recherche du chauffeur le plus proche

1. Calculer la cellule de l’utilisateur
2. Récupérer :

   * la cellule courante
   * les cellules voisines
3. Obtenir un petit nombre de chauffeurs (au lieu de 1 million)
4. Calculer la distance exacte (Haversine) uniquement pour eux
5. Retourner le plus proche

---

## Avantages

* Beaucoup moins de calculs
* Latence faible
* Solution simple à implémenter
* Fonctionne très bien en temps réel

---

## Compromis architectural

* On utilise un peu plus de mémoire (la grille)
* En échange, on économise énormément de CPU

C’est un compromis classique dans les systèmes backend performants.

---

## Complexité

| Approche    | Coût                    |
| ----------- | ----------------------- |
| Naïve       | O(N)                    |
| Avec grille | O(k), avec k très petit |

---

## Cas d’usage

* Applications de transport
* Livraison
* Jeux multijoueurs
* Matchmaking géographique
* Services basés sur la localisation

---

## Conclusion

Le but n’est pas d’optimiser la formule mathématique.

Le vrai gain vient du fait de :

* **réduire le nombre de fois où on l’exécute**

