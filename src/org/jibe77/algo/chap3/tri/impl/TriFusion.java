package org.jibe77.algo.chap3.tri.impl;

import org.jibe77.algo.chap3.tri.Tri;

import java.util.Arrays;

/**
 * Le tri fusion est idéal pour :
 *  - Les données volumineuses nécessitant un tri stable.
 *  - Les systèmes où la complexité prévisible et les performances robustes sont primordiales.
 *  - Les environnements où la parallélisation est une option.
 *
 * Cependant, il est moins adapté si :
 *  - La mémoire est une contrainte.
 *  - Les données à trier sont petites ou déjà partiellement triées.
 *  - L'utilisation d'un algorithme en place (qui ne nécessite pas de mémoire supplémentaire) est critique.
 *
 * Dans ces cas, d'autres algorithmes comme le tri rapide ou le tri par insertion pourraient être préférés.
 */
public class TriFusion implements Tri {

    /**
     * Décompose le problème de tri en plusieurs sous-problèmes, puis les résoud de façon résursive, et enfin
     * combine les solutions trouvée afin de construire la solution du problème initial.
     * @param a un tableau à trier
     */
    @Override
    public void tri(String[] a) {
        if (a.length <= 1) {
            return;
        }

        // Diviser le tableau en deux parties
        int mid = a.length / 2;
        String[] left = Arrays.copyOfRange(a, 0, mid);
        String[] right = Arrays.copyOfRange(a, mid, a.length);

        // Tri récursif des deux parties
        tri(left);
        tri(right);

        // Fusionner les parties triées
        fusion(a, left, right);
    }

    /**
     * consolide les éléments du tableau
     * @param a tableau à trier
     * @param left 1er sous-tableau
     * @param right 2ème sous-tableau
     */
    private void fusion(String[] a, String[] left, String[] right) {
        int i = 0; // Indice pour le tableau gauche
        int j = 0; // Indice pour le tableau droit
        int k = 0; // Indice pour le tableau final

        // Fusionner les éléments dans le bon ordre
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        // Ajouter les éléments restants de gauche
        while (i < left.length) {
            a[k++] = left[i++];
        }

        // Ajouter les éléments restants de droite
        while (j < right.length) {
            a[k++] = right[j++];
        }
    }
}
