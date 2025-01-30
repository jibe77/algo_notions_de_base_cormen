Algorithmes - Notions de base / Algorithms Unlocked
Thomas H. Cormen

Notes

## Chapitres 2 et 3 : algorithmes de recherche et de tri

La recherche linéaire est la plus simple et efficace sur n'importe quel tableau, 
par contre la recherche dichotomique a un temps d'exécution plus intéressant, O(lg n) contre O(n), à condition d'avoir un tableau déjà trié.

Concernant les fonctions de tri, le tri par fusion donne des résultats intéressants sur des larges ensembles de données,
par exemple sur des tableaux de plusieurs milliers d'entrées car son temps d'exécution est de 0(lg n), comparé aux
autres qui sont O(n) voire O(n²).

D'un point de vu général, il faut retenir que les différentes implémentations ont des performances qui varient dans le temps.
Ces performances peuvent se représenter de façon O(lg n), O(n) ou O(n2). Donc une implémentation peut se retrouver lente 
sur des petits ensemble, mais rapide sur de grands ensembles car elle a une complexité dite logarithmique.

## Chapitre 4 : minorant pour le tri à battre

Ce chapitre traite du tri par dénombrement (ou Counting Sort en anglais). C'est un algorithme de tri basé sur le 
comptage des occurrences des éléments dans une collection. Il est particulièrement efficace pour trier des entiers dans 
un intervalle limité et fonctionne en temps linéaire O(n+k)), où n est la taille des données et k est la plage de 
valeurs (maximum - minimum).

## Chapitre 5 : graphes orientés acycliques

Un DAG (pour Directed Acyclic Graph, ou graphe orienté acyclique en français) est une structure mathématique utilisée en
informatique et en théorie des graphes. Le graphe est dirigé (chaque arête a une direction, allant d'un sommet source 
vers un sommet cible) et acyclique (il n'existe pas de org.jibe77.algo.chap6.chemin partant d'un sommet et revenant à ce même sommet). Le tri
d'un DAG est traité dans la classe TriTopologique.

Dansn un deuxième temps on y étudie le diagramme de PERT (Program Evaluation and Review Technique). C'est un outil de 
gestion de projet utilisé pour planifier et organiser les tâches nécessaires à l'achèvement d'un projet. 
C'est une représentation graphique d'un projet sous forme de graphe orienté.

Un diagramme de PERT est un type particulier de DAG. Il est dirigé et acyclique (aucun cycle n'est permis, car les 
tâches ne peuvent pas dépendre d'elles-mêmes). Cependant, il inclut des informations spécifiques à la gestion de projet, 
comme les durées des tâches et les chemins critiques.

## Chapitre 6 : plus court org.jibe77.algo.chap6.chemin

Ces algorithmes sont essentiels pour déterminer le chemin le plus court entre deux nœuds dans un réseau, une tâche 
courante en informatique et en mathématiques appliquées.

Le chapitre présente trois algorithmes principaux :

* L'algorithme de Dijkstra : Cet algorithme est utilisé pour trouver le chemin le plus court depuis un nœud source vers 
tous les autres nœuds d'un graphe avec des arêtes de poids non négatifs. Il fonctionne en explorant de manière itérative
les nœuds les plus proches non encore visités, en mettant à jour les distances les plus courtes connues.

* L'algorithme de Bellman-Ford : Contrairement à l'algorithme de Dijkstra, Bellman-Ford peut gérer des graphes avec des
arêtes de poids négatifs. Il calcule les distances les plus courtes en relaxant de manière itérative les arêtes du 
graphe, permettant de détecter également les cycles de poids négatif.

* L'algorithme de Floyd-Warshall : Cet algorithme est utilisé pour trouver les chemins les plus courts entre tous les
couples de nœuds dans un graphe. Il utilise une approche dynamique pour construire progressivement les solutions des
sous-problèmes, en considérant chaque nœud comme un intermédiaire potentiel sur le chemin entre deux autres nœuds.

## Chapitre 7 : algo sur chaines de caractères

Ce chapitre aborde plusieurs problèmes fondamentaux liés aux chaînes de caractères :

Sous-séquence commune la plus longue (Longest Common Subsequence - LCS) : L'objectif est de trouver la plus longue
séquence qui apparaît dans le même ordre (mais pas nécessairement de manière contiguë) dans deux chaînes données. 
Par exemple, pour les chaînes "ABCBDAB" et "BDCAB", la LCS est "BCAB". Ce problème est résolu à l'aide de techniques de
programmation dynamique, permettant de déterminer efficacement la LCS et sa longueur.

Transformation d'une chaîne en une autre (problème de l'édition) : Il s'agit de déterminer le nombre minimal
d'opérations nécessaires pour transformer une chaîne de caractères en une autre. Les opérations typiques incluent
l'insertion, la suppression et la substitution de caractères. Ce concept est essentiel dans des applications telles que
la correction orthographique et la comparaison de séquences génétiques.

Recherche de motifs dans une chaîne (String Matching) : Ce problème consiste à trouver toutes les occurrences d'une
chaîne modèle (pattern) au sein d'une chaîne texte. Des algorithmes efficaces, tels que l'algorithme de
Knuth-Morris-Pratt (KMP) et l'algorithme de Boyer-Moore, sont présentés pour accomplir cette tâche.


## Chapitre 8 : base de la cryptographie

Le chapitre aborde la cryptographie à clé symétrique, où l'expéditeur et le destinataire utilisent la même clé secrète 
pour chiffrer et déchiffrer les messages. Cette méthode nécessite un échange sécurisé de la clé entre les parties 
concernées.

La cryptographie à clé publique est également explorée. Dans ce système, chaque utilisateur possède une paire de clés : 
une clé publique, accessible à tous, et une clé privée, gardée secrète. Les messages chiffrés avec la clé publique ne 
peuvent être déchiffrés qu'avec la clé privée correspondante, et vice versa.

Le chapitre présente en détail le système de cryptographie RSA, un algorithme de cryptographie à clé publique largement
utilisé. Il explique les principes mathématiques sous-jacents, notamment l'utilisation des nombres premiers et de
l'exponentiation modulaire, pour assurer la sécurité du chiffrement.

Enfin, le chapitre aborde les systèmes cryptographiques hybrides, qui combinent les avantages des cryptographies à clé 
symétrique et à clé publique, ainsi que les méthodes de génération de nombres aléatoires, essentielles pour créer des 
clés sécurisées.

## Chapitre 9 : compression de données

Dans ce chapitre, l'auteur explore plusieurs méthodes de compression, en mettant l'accent sur deux 
algorithmes principaux :

Les codes de Huffman : Cette méthode de compression sans perte attribue des codes binaires de longueur variable aux
symboles d'un fichier, en fonction de leur fréquence d'apparition. Les symboles les plus fréquents reçoivent des 
codes plus courts, ce qui permet de réduire la taille globale du fichier.

La compression LZW (Lempel-Ziv-Welch) : Il s'agit d'une technique de compression sans perte qui remplace les séquences 
de caractères répétitives par des codes plus courts, en construisant dynamiquement un dictionnaire des séquences
rencontrées au fur et à mesure de la lecture des données. Cette méthode est notamment utilisée dans des formats de
fichiers tels que GIF et dans des utilitaires de compression comme UNIX compress.

## Chapitre 10 : complexité

Ce chapitre aborde les problèmes dits "difficiles" en informatique. Il explore notamment les concepts de P et NP, ainsi
que la NP-complétude. Ces notions sont essentielles pour comprendre la complexité de certains problèmes algorithmiques
et déterminer s'ils peuvent être résolus efficacement.
            
Le chapitre commence par une introduction aux classes de complexité P (problèmes résolubles en temps polynomial) et NP 
(problèmes dont les solutions peuvent être vérifiées en temps polynomial). Il explique ensuite la notion de 
NP-complétude, qui caractérise les problèmes les plus difficiles au sein de la classe NP.
            
L'auteur présente également des exemples de problèmes NP-complets, tels que le problème du voyageur de commerce et le 
problème de la clique, et discute des stratégies générales pour aborder ces problèmes, y compris les approches 
heuristiques et les algorithmes d'approximation.
            
Enfin, le chapitre aborde la question des problèmes indécidables, c'est-à-dire des problèmes pour lesquels il n'existe 
pas d'algorithme capable de fournir une solution pour toutes les instances possibles.
