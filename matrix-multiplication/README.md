Voici une **explication claire + un README** parfaitement adapté à la consigne de ton prof, dans un style **étudiant 42 sérieux + ingénieur en devenir**.

---

# 🔥 **Explication pour toi (avant le README)**

Ton prof veut que tu comprennes **pourquoi l’approche mathématique “idéale” ne suffit pas** et pourquoi **le hardware impose sa propre réalité**.

### 🎯 Le problème mathématique

La multiplication matricielle est simple :
Pour chaque entrée `C[i][j]` :
[
C[i][j] = \sum_{k=0}^{N-1} A[i][k] \times B[k][j]
]

Trois boucles. Évident.
**Mais math ≠ hardware.**

---

# 🧠 **Pourquoi l’implémentation naïve est catastrophique ? (les cache misses)**

En Java (et dans la plupart des langages), `double[][]` = **tableau de tableaux**.
Donc :

* chaque ligne est stockée **dans un bloc mémoire à part**
* les lignes ne sont **pas contiguës**
* le CPU lit la mémoire par blocs (cache lines)
# MATRIX-MULTIPLICATION — Java OOP & Cache Locality

Ce module a pour objectif d’implémenter et d’optimiser la multiplication de deux matrices carrées `A` et `B` de taille `N × N` (ex : 2048).
Le but est de comprendre la différence entre **la théorie mathématique** et **la réalité du hardware**.

---

## 🎯 Objectifs du module

* Implémenter la multiplication matricielle classique.
* Observer les limites de l’implémentation naïve (trois boucles `for`).
* Découvrir l’impact réel de la **localité mémoire** et des **cache misses**.
* Optimiser l’algorithme en modifiant l’ordre des boucles.
* Accélérer encore plus en **transposant la matrice B** pour accéder à la mémoire de manière contiguë.
* Comparer les temps d’exécution entre les différentes versions.

---

## 🧠 Pourquoi l’implémentation naïve est lente

En Java, un tableau `double[][]` est un **tableau de tableaux**, ce qui signifie :

* la mémoire n’est pas contiguë,
* chaque ligne se trouve à un emplacement différent,
* parcourir la matrice par colonnes provoque des **cache misses**,
* le CPU passe plus de temps à attendre la mémoire qu’à calculer.

Pour une matrice de taille 2048, la différence de performance devient massive.

---

## 🚀 Optimisations explorées

### ✔️ 1. Changement de l’ordre des boucles

Réorganiser les boucles pour améliorer la localité et réduire les sauts mémoire.

### ✔️ 2. Transposition de B

Transposer `B` en `B_T` permet d’accéder aux données ligne par ligne (contigu), ce qui :

* réduit drastiquement les cache misses,
* augmente très fortement les performances.

### ✔️ 3. Représentation en tableau plat `double[]`

Au lieu de faire :

```java
double[][] m;
```

on utilise :

```java
double[] m; // taille N*N
int index = i * N + j;
```

Avantages :

* mémoire contiguë,
* accès prévisible pour le CPU,
* beaucoup moins de fragmentation,
* performances largement meilleures.

---

## 📊 Benchmark

Les tests comparent :

1. Version naïve (`double[][]`)
2. Version optimisée par ordre des boucles
3. Version avec transposition de B
4. Version optimale : matrices plates `double[]` + transposition


