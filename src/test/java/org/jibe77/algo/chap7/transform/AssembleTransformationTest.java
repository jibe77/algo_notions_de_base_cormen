package org.jibe77.algo.chap7.transform;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssembleTransformationTest {

    @Test
    public void testAssembleTransformation() {
        // Données d'entrée
        String X = "ACAAGC";
        String Y = "CCGT";
        int costCopy = -1;       // Coût de la copie
        int costReplace = 1;     // Coût du remplacement
        int costDelete = 2;      // Coût de la suppression
        int costInsert = 2;      // Coût de l'insertion

        // Tables de transformation (exemple donné dans les données initiales)
        String[][] op = {
                {"", "insert C", "insert C", "insert G", "insert T"},
                {"delete A", "replace A by C", "replace A by C", "replace A by G", "replace A by T"},
                {"delete C", "copy C", "copy C", "insert G", "insert T"},
                {"delete A", "delete A", "replace A by C", "replace A by G", "replace A by T"},
                {"delete A", "delete A", "replace A by C", "replace A by G", "replace A by T"},
                {"delete G", "delete G", "replace G by C", "copy G", "replace G by T"},
                {"delete C", "copy C", "copy C", "delete C", "replace C by T"}
        };

        int m = X.length(); // Longueur de X
        int n = Y.length(); // Longueur de Y

        // Séquence d'opérations attendue
        List<String> expectedOperations = List.of(
                "initial strings",
                "delete A",
                "copy C",
                "delete A",
                "replace A by C",
                "copy G",
                "replace C by T"
        );

        // Appeler assembleTransformation pour calculer les opérations
        List<String> actualOperations = AssembleTransformation.assembleTransformation(op, m, n);

        // Vérifier que les opérations calculées correspondent à celles attendues
        assertEquals(expectedOperations, actualOperations, "La séquence d'opérations est incorrecte !");
    }
}
