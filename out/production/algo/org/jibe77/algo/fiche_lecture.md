## Chapitres 2 et 3 : algorithmes de recherche et de tri

La recherche linéaire est la plus simple et efficace sur n'importe quel tableau, 
par contre la recherche dichotomique a un temps d'exécution plus intéressant, O(lg n) contre O(n), à condition d'avoir un tableau déjà trié.

Concernant les fonctions de tri, le tri par fusion donne des résultats intéressants sur des larges ensembles de données,
par exemple sur des tableaux de plusieurs milliers d'entrées car son temps d'exécution est de 0(lg n), comparé aux
autres qui sont O(n) voire O(n²).

D'un point de vu général, il faut retenir que les différentes implémentations ont des performances qui varient dans le temps.
Ces performances peuvent se représenter de façon O(lg n), O(n) ou O(n2). Donc une implémentation peut se retrouver lente 
sur des petits ensemble, mais rapide sur de grands ensembles car elle a une complexité dite logarithmique.

Lu et implémenté du 15 au 22 décembre 2024.

## Chapitre 4 : minorant pour le tri à battre

Ce chapitre traite du tri par dénombrement (ou Counting Sort en anglais). C'est un algorithme de tri basé sur le 
comptage des occurrences des éléments dans une collection. Il est particulièrement efficace pour trier des entiers dans 
un intervalle limité et fonctionne en temps linéaire O(n+k)), où n est la taille des données et k est la plage de 
valeurs (maximum - minimum).

## Chapitre 5 : graphes orientés acycliques

Un DAG (pour Directed Acyclic Graph, ou graphe orienté acyclique en français) est une structure mathématique utilisée en
informatique et en théorie des graphes. Le graphe est dirigé (chaque arête a une direction, allant d'un sommet source 
vers un sommet cible) et acyclique (il n'existe pas de chemin partant d'un sommet et revenant à ce même sommet). Le tri
d'un DAG est traité dans la classe TriTopologique.

Dansn un deuxième temps on y étudie le diagramme de PERT (Program Evaluation and Review Technique). C'est un outil de 
gestion de projet utilisé pour planifier et organiser les tâches nécessaires à l'achèvement d'un projet. 
C'est une représentation graphique d'un projet sous forme de graphe orienté.

Un diagramme de PERT est un type particulier de DAG. Il est dirigé et acyclique (aucun cycle n'est permis, car les 
tâches ne peuvent pas dépendre d'elles-mêmes). Cependant, il inclut des informations spécifiques à la gestion de projet, 
comme les durées des tâches et les chemins critiques.


## Chapitre 6 : plus court chemin

TODO

## Chapitre 7 : algo sur chaines de caractères

TODO

## Chapitre 8 : base de la cryptographie

TODO

## Chapitre 9 : compression de données

TODO

## Chapitre 10 : complexité

TODO
