package org.jibe77.algo.chap7.transform;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ComputeTransformTablesTest {

    @Test
    public void testComputeTransformTables() {
        // Données d'entrée
        String X = "ACAAGC";
        String Y = "CCGT";
        int costCopy = -1;       // Coût de la copie
        int costReplace = 1;     // Coût du remplacement
        int costDelete = 2;      // Coût de la suppression
        int costInsert = 2;      // Coût de l'insertion

        // Tables de transformation attendues
        int[][] expectedCost = {
                {0, 2, 4, 6, 8},
                {2, 1, 3, 5, 7},
                {4, 1, 0, 2, 4},
                {6, 3, 2, 1, 3},
                {8, 5, 4, 3, 2},
                {10, 7, 6, 3, 4},
                {12, 9, 6, 5, 4}
        };

        String[][] expectedOp = {
                {"", "insert C", "insert C", "insert G", "insert T"},
                {"delete A", "replace A by C", "replace A by C", "replace A by G", "replace A by T"},
                {"delete C", "copy C", "copy C", "insert G", "insert T"},
                {"delete A", "delete A", "replace A by C", "replace A by G", "replace A by T"},
                {"delete A", "delete A", "replace A by C", "replace A by G", "replace A by T"},
                {"delete G", "delete G", "replace G by C", "copy G", "replace G by T"},
                {"delete C", "copy C", "copy C", "delete C", "replace C by T"}
        };

        // Calculer les tables de transformation
        ComputeTransformTables.TransformResult result = ComputeTransformTables.computeTransformTables(
                X, Y, costCopy, costReplace, costDelete, costInsert
        );

        // Vérifier les tables de coûts
        assertArrayEquals(expectedCost, result.getCost(), "La table des coûts est incorrecte !");

        // Vérifier les tables d'opérations
        assertArrayEquals(expectedOp, result.getOp(), "La table des opérations est incorrecte !");
    }
}
