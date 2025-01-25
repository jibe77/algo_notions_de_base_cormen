package org.jibe77.algo.chap7.lcs.assemble;

public class AssembleLCS {

    // Méthode récursive pour assembler la LCS
    public static String assembleLCS(String X, String Y, int[][] l, int i, int j) {
        if (l[i][j] == 0) {
            return ""; // Si la valeur dans la table est 0, retourner une chaîne vide
        }
        if (X.charAt(i - 1) == Y.charAt(j - 1)) {
            // Si les caractères correspondent, inclure ce caractère et descendre en diagonale
            return assembleLCS(X, Y, l, i - 1, j - 1) + X.charAt(i - 1);
        } else if (l[i][j - 1] > l[i - 1][j]) {
            // Si la cellule à gauche a une valeur supérieure, avancer vers la gauche
            return assembleLCS(X, Y, l, i, j - 1);
        } else {
            // Sinon, avancer vers le haut
            return assembleLCS(X, Y, l, i - 1, j);
        }
    }

    // Exemple d'utilisation
    public static void main(String[] args) {
        String X = "CATCGA";
        String Y = "GTACCGTCA";

        // Table LCS calculée (exemple)
        int[][] lcsTable = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 2},
                {0, 0, 1, 1, 1, 1, 1, 2, 2, 2},
                {0, 0, 1, 1, 2, 2, 2, 2, 3, 3},
                {0, 1, 1, 1, 2, 2, 3, 3, 3, 3},
                {0, 1, 1, 2, 2, 2, 3, 3, 3, 4}
        };

        // Indices correspondant aux longueurs des chaînes X et Y
        int i = X.length();
        int j = Y.length();

        // Assembler la LCS
        String lcs = assembleLCS(X, Y, lcsTable, i, j);

        // Afficher la LCS
        System.out.println("La plus longue sous-séquence commune est : " + lcs);
    }
}
