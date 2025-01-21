package org.jibe77.algo.chap3.tri.impl;

import org.jibe77.algo.chap3.tri.Tri;

/**
 * Le tri rapide (Quick Sort) est un algorithme de tri basé sur le paradigme "diviser pour régner".
 *
 * Le tri rapide est souvent préféré pour ses performances pratiques et sa simplicité d'implémentation en place.
 */
public class TriRapide implements Tri {

    @Override
    public void tri(String[] tableau) {
        triRapide(tableau, 0, tableau.length - 1);
    }

    /**
     * Étapes principales :
     * Choix d'un pivot : Sélectionner un élément du tableau comme pivot (souvent le dernier, le premier ou un élément aléatoire).
     * Partitionnement :  Réorganiser les éléments du tableau :
     *   - Les éléments inférieurs ou égaux au pivot sont placés à gauche.
     *   - Les éléments supérieurs au pivot sont placés à droite.
     *   Le pivot est alors à sa position finale.
     * Récursivité : Appliquer récursivement l'algorithme sur les sous-tableaux à gauche et à droite du pivot.
     * Terminaison : Lorsque la taille des sous-tableaux atteint 1 ou 0, ils sont déjà triés.
     * @param a tableau à trier
     * @param p index à gauche
     * @param r index à droite
     */
    public void triRapide(String[] a, int p, int r) {
        if (p < r) {
            // Trouve l'index de partition
            int pivotIndex = partitionnement(a, p, r);

            // Trie récursivement les deux parties
            triRapide(a, p, pivotIndex - 1);  // Partie gauche
            triRapide(a, pivotIndex + 1, r); // Partie droite
        }
    }

    private static int partitionnement(String[] a, int low, int high) {
        // Choisir le dernier élément comme pivot
        String pivot = a[high];
        int i = low - 1; // Index du plus petit élément

        for (int j = low; j < high; j++) {
            // Si l'élément courant est plus petit ou égal au pivot
            if (a[j].compareTo(pivot) < 0) {
                i++;
                // Échange array[i] et array[j]
                swap(a, i, j);
            }
        }

        // Place le pivot à sa position correcte
        swap(a, i + 1, high);
        return i + 1;

    }

    // Méthode pour échanger deux éléments dans le tableau
    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
