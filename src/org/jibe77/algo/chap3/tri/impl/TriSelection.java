package org.jibe77.algo.chap3.tri.impl;

import org.jibe77.algo.chap3.tri.Tri;

import java.util.Arrays;

public class TriSelection implements Tri {

    @Override
    public void tri(String[] tableau) {
        TriSelection.triEtSelection(tableau, tableau.length);
    }

    /**
     * Réorganise les éléments du tableau afin que les éléments soient triés dans l'ordre alphabétique.
     * @param a un tableau
     * @param n nombre d'éléments du tableau A à trier
     * @return les éléments du tableau A triés par ordre croissant.
     */
    public static String[] triEtSelection(String[] a, int n) {
        // 1. pour i = 0 à n - 1
        for (int i = 0 ; i < n-1  ; i++) {
            // A. fixer la variable 'minimum' à l'indice du plus petit élément du sous-tableau A[i...n]
            int minimum = plusPetitElementTableau(Arrays.copyOfRange(a, i, n)) + i;
            // B. échanger a[i] et A[minimum]
            String temp = a[i];
            a[i] = a[minimum];
            a[minimum] = temp;
        }
        return a;
    }

    private static int plusPetitElementTableau(String[] sousTableau) {
        int plusPetit = 0;
        for (int i = 1; i < sousTableau.length; i++) {
            if (sousTableau[plusPetit].compareTo(sousTableau[i]) > 0) {
                plusPetit = i;
            }
        }
        return plusPetit;
    }
}
