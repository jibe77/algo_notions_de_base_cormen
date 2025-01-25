package org.jibe77.algo.chap7.transform;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssembleTransformation {

    // Méthode pour assembler les transformations à partir de la table des opérations
    public static List<String> assembleTransformation(String[][] op, int i, int j) {
        return assembleTransformation(op, i, j, new ArrayList<>());
    }

    private static List<String> assembleTransformation(String[][] op, int i, int j, List<String> result) {
        if (i == 0 && j == 0) {
            result.add("initial strings");
            Collections.reverse(result); // Inverser l'ordre des opérations
            return result;
        }

        result.add(op[i][j]); // Ajouter l'opération actuelle

        // Déterminer le type d'opération et appeler récursivement
        switch (getOperation(op[i][j])) {
            case "copy":
            case "replace":
                return assembleTransformation(op, i - 1, j - 1, result);
            case "delete":
                return assembleTransformation(op, i - 1, j, result);
            case "insert":
                return assembleTransformation(op, i, j - 1, result);
            default:
                throw new IllegalArgumentException("Opération inconnue : " + op[i][j]);
        }
    }

    // Méthode pour extraire le type d'opération (copy, replace, delete, insert)
    private static String getOperation(String operation) {
        return operation.split(" ")[0]; // Récupérer le premier mot
    }

    // Méthode principale pour tester
    public static void main(String[] args) {
        // Exemple de table des opérations
        String[][] op = {
                {"", "insert A", "insert C", "insert B"},
                {"delete A", "copy A", "insert C", "insert B"},
                {"delete B", "delete B", "replace B by C", "copy B"},
                {"delete C", "copy C", "delete C", "copy B"}
        };

        int i = op.length - 1; // Indice de la dernière ligne
        int j = op[0].length - 1; // Indice de la dernière colonne

        // Assembler les transformations
        List<String> transformations = assembleTransformation(op, i, j);

        // Afficher les transformations
        System.out.println("Transformations :");
        for (String transformation : transformations) {
            System.out.println(transformation);
        }
    }
}
