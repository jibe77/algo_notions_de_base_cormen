package org.jibe77.algo.chap4.tri.impl;

import org.jibe77.algo.chap3.tri.Tri;

public class TriTrèsSimple implements Tri {

    /**
     * Tri les éléments de tableau par ordre croissant.
     * On effectue ici un tri sans aucune comparaison, ce qui permet d'avoir un temps d'exécution de O(n).
     * @param tableau un tableau dont chaque élément vaut 1 ou 2
     */
    @Override
    public void tri(String[] tableau) {
        // 1. fixer k à 0
        int k = 0;
        // 2. pour i = 0 à n-1:
        for (int i = 0; i < (tableau.length - 1) ; i++) {
            // A. Si A[i] = 1 alors incrémenter k
            if (tableau[i].equals("1")) {
                k++;
            }
        }
        // 3. Pour i = 1 à k:
        for (int i = 0 ; i < k;i++) {
            // A. Fixer A[i] à 1
            tableau[i] = "1";
        }
        // 4. Pour i = k + 1 à n :
        for (int i = k + 1; i < tableau.length ; i++) {
            // A. Fixer A[i] à 2
            tableau[i] = "2";
        }
    }
}
