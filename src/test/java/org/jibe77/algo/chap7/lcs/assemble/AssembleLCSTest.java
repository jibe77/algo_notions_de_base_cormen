package org.jibe77.algo.chap7.lcs.assemble;

import org.jibe77.algo.chap7.lcs.table.LCS;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssembleLCSTest {

    // Test avec JUnit
    @Test
    public void testAssembleLCS() {
        // Données d'entrée
        String X = "CATCGA";
        String Y = "GTACCGTCA";
        int m = X.length();
        int n = Y.length();

        // Table LCS calculée
        int[][] l = LCS.computeLCSTable(X, Y);

        // Résultat attendu
        String expectedLCS = "CTCA";

        // Vérifier si assembleLCS produit le résultat attendu
        assertEquals(expectedLCS, AssembleLCS.assembleLCS(X, Y, l, m, n), "La LCS calculée est incorrecte !");
    }
}
