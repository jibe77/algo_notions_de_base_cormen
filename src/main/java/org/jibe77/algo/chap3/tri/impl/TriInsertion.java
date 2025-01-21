package org.jibe77.algo.chap3.tri.impl;

import org.jibe77.algo.chap3.tri.Tri;

/**
 * Le tri par insertion est particulièrement utile dans les cas suivants :
 *
 * - Les petits ensembles de données, où sa simplicité et ses performances surpassent celles d'autres algorithmes.
 * - Les données déjà triées, où il offre des performances très rapides grâce à son faible nombre de comparaisons.
 * - Lorsque l'utilisation de mémoire supplémentaire doit être évitée.
 */
public class TriInsertion implements Tri {

    /**
     * Réorganise les éléments du tableau afin que les éléments soient triés dans l'ordre alphabétique.
     * @param a un tableau
     * @return les éléments du tableau A triés par ordre croissant.
     */
    @Override
    public void tri(String[] a) {
        // 1. pour i = 1 à n
        for (int i = 1 ; i < a.length ; i++) {
            // A. fixer clé à a[i] et j à i - 1.
            String clé = a[i];
            int j = i-1;
            // B. tant que j > 0 et a[j] > clé faire la chose suivante :
            while(j >= 0 && a[j].compareTo(clé) > 0) {
                // i. fixer a[j+1] à a[j]
                a[j+1] = a[j];
                // ii. décrémenter j
                j--;
            }
            // C. fixer a[j + 1] à clé
            a[j+1] = clé;
        }
        return;

    }
}
