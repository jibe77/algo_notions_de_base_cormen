package org.jibe77.algo.chap7.lcs.table;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LCSTableTest {

    // Méthode pour calculer la table LCS
    public static int[][] computeLCSTable(String X, String Y) {
        int m = X.length() + 1;
        int n = Y.length() + 1;

        int[][] l = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    l[i][j] = l[i - 1][j - 1] + 1;
                } else {
                    l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
                }
            }
        }

        return l;
    }

    // Test unitaire avec JUnit
    @Test
    public void testComputeLCSTable() {
        // Données d'entrée
        String X = "CATCGA";
        String Y = "GTACCGTCA";

        // Table LCS attendue
        int[][] expectedLCSTable = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 1, 1, 1, 2},
                {0, 0, 1, 1, 1, 1, 1, 2, 2, 2},
                {0, 0, 1, 1, 2, 2, 2, 2, 3, 3},
                {0, 1, 1, 1, 2, 2, 3, 3, 3, 3},
                {0, 1, 1, 2, 2, 2, 3, 3, 3, 4}
        };

        // Appeler la méthode computeLCSTable
        int[][] actualLCSTable = computeLCSTable(X, Y);

        // Vérifier si la table calculée est correcte
        assertArrayEquals(expectedLCSTable, actualLCSTable, "La table LCS calculée est incorrecte !");
    }
}
