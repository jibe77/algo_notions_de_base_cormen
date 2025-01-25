package org.jibe77.algo.chap7.lcs.table;

/**
 * L'explication du fonctionnement de la table LCS est dans cette vidéo :
 *
 * https://youtu.be/P-mMvhfJhu8?si=Un6vvh1_rISh_26d
 */
public class LCS {

    // Méthode pour calculer la table LCS
    public static int[][] computeLCSTable(String X, String Y) {
        int m = X.length() + 1; // Nombre de lignes
        int n = Y.length() + 1; // Nombre de colonnes

        // Initialisation de la table LCS
        int[][] l = new int[m][n];

        // Remplir la première ligne et la première colonne avec des 0
        for (int i = 0; i < m; i++) {
            l[i][0] = 0;
        }
        for (int j = 0; j < n; j++) {
            l[0][j] = 0;
        }

        // Remplir le reste de la table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                } else {
                    l[i][j] = Math.max(l[i][j - 1], l[i - 1][j]);
                }
            }
        }

        return l;
    }

    // Méthode principale pour tester
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";

        // Calculer la table LCS
        int[][] lcsTable = computeLCSTable(X, Y);

        // Afficher la table LCS
        System.out.println("Table LCS :");
        for (int i = 0; i < lcsTable.length; i++) {
            for (int j = 0; j < lcsTable[i].length; j++) {
                System.out.print(lcsTable[i][j] + " ");
            }
            System.out.println();
        }
    }
}
