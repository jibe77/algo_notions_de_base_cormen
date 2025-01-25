package org.jibe77.algo.chap7.transform;

import java.util.Arrays;

/**
 * Cette classe est basée sur les principes de programmation dynamique et
 * appliquée au problème de transformation de chaînes.
 *
 * Transformer un mot en un autre, c'est un peu comme suivre un itinéraire avec des étapes précises.
 * Imagine que tu veux changer le mot "ACAAGC" en "CCGT".
 * À chaque étape, tu as des choix : copier une lettre si elle est la même, remplacer une lettre si
 * elle est différente, supprimer une lettre si elle est en trop, ou en ajouter une si elle manque.
 * Chaque action a un "coût" : copier est facile et coûte peu, mais remplacer ou ajouter demande
 * plus d'effort, donc ça coûte plus cher. Pour savoir comment faire de la manière la plus efficace,
 * on remplit un tableau : il te dit, étape par étape, la solution qui coûte le moins cher. À la fin,
 * tu obtiens non seulement le mot transformé, mais aussi toutes les étapes que tu as suivies pour y
 * arriver, comme une recette de cuisine pour changer un mot en un autre.
 *
 */
public class ComputeTransformTables {

    // Méthode pour calculer les tables de transformation
    public static TransformResult computeTransformTables(String X, String Y, int cC, int cR, int cD, int cI) {
        int m = X.length() + 1; // Nombre de lignes (longueur de X + 1)
        int n = Y.length() + 1; // Nombre de colonnes (longueur de Y + 1)

        int[][] cost = new int[m][n]; // Table des coûts
        String[][] op = new String[m][n]; // Table des opérations

        // Initialisation de la première cellule
        cost[0][0] = 0;
        op[0][0] = "";

        // Initialisation de la première colonne
        for (int i = 1; i < m; i++) {
            cost[i][0] = i * cD;
            op[i][0] = "delete " + X.charAt(i - 1);
        }

        // Initialisation de la première ligne
        for (int j = 1; j < n; j++) {
            cost[0][j] = j * cI;
            op[0][j] = "insert " + Y.charAt(j - 1);
        }

        // Remplissage des tables de transformation
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    cost[i][j] = cost[i - 1][j - 1] + cC;
                    op[i][j] = "copy " + X.charAt(i - 1);
                } else {
                    cost[i][j] = cost[i - 1][j - 1] + cR;
                    op[i][j] = "replace " + X.charAt(i - 1) + " by " + Y.charAt(j - 1);
                }
                if (cost[i - 1][j] + cD < cost[i][j]) {
                    cost[i][j] = cost[i - 1][j] + cD;
                    op[i][j] = "delete " + X.charAt(i - 1);
                }
                if (cost[i][j - 1] + cI < cost[i][j]) {
                    cost[i][j] = cost[i][j - 1] + cI;
                    op[i][j] = "insert " + Y.charAt(j - 1);
                }
            }
        }

        return new TransformResult(cost, op);
    }

    // Classe pour encapsuler les résultats des tables
    public static class TransformResult {
        private final int[][] cost;
        private final String[][] op;

        public TransformResult(int[][] cost, String[][] op) {
            this.cost = cost;
            this.op = op;
        }

        public int[][] getCost() {
            return cost;
        }

        public String[][] getOp() {
            return op;
        }
    }

    // Méthode principale pour tester
    public static void main(String[] args) {
        String X = "ABC";
        String Y = "ACB";
        int cC = 0; // Coût de la copie
        int cR = 2; // Coût du remplacement
        int cD = 1; // Coût de la suppression
        int cI = 1; // Coût de l'insertion

        TransformResult result = computeTransformTables(X, Y, cC, cR, cD, cI);

        // Afficher la table des coûts
        System.out.println("Table des coûts :");
        printTable(result.getCost());

        // Afficher la table des opérations
        System.out.println("\nTable des opérations :");
        printTable(result.getOp());
    }

    // Méthode utilitaire pour afficher une table d'entiers
    public static void printTable(int[][] table) {
        for (int[] row : table) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Méthode utilitaire pour afficher une table de chaînes
    public static void printTable(String[][] table) {
        for (String[] row : table) {
            System.out.println(Arrays.toString(row));
        }
    }
}
