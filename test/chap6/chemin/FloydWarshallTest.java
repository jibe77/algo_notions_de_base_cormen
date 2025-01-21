package chap6.chemin;

import org.jibe77.algo.chap6.chemin.floydwarshall.FloydWarshall;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class FloydWarshallTest {

    @Test
    public void testFloydWarshall() {
        // Graphe d'entrée
        Map<String, Map<String, Double>> G = new HashMap<>();
        G.put("1", Map.of("1", 0.0, "2", 3.0, "3", 8.0, "4", Double.POSITIVE_INFINITY));
        G.put("2", Map.of("1", Double.POSITIVE_INFINITY, "2", 0.0, "3", Double.POSITIVE_INFINITY, "4", 1.0));
        G.put("3", Map.of("1", Double.POSITIVE_INFINITY, "2", 4.0, "3", 0.0, "4", Double.POSITIVE_INFINITY));
        G.put("4", Map.of("1", 2.0, "2", Double.POSITIVE_INFINITY, "3", -5.0, "4", 0.0));

        // Matrice des plus courts chemins attendue
        Map<String, Map<String, Double>> expectedShortestPathLastMatrix = new HashMap<>();
        expectedShortestPathLastMatrix.put("1", Map.of("1", 0.0, "2", 3.0, "3", -1.0, "4", 4.0));
        expectedShortestPathLastMatrix.put("2", Map.of("1", 3.0, "2", 0.0, "3", -4.0, "4", 1.0));
        expectedShortestPathLastMatrix.put("3", Map.of("1", 7.0, "2", 4.0, "3", 0.0, "4", 5.0));
        expectedShortestPathLastMatrix.put("4", Map.of("1", 2.0, "2", -1.0, "3", -5.0, "4", 0.0));

        // Matrice des prédécesseurs attendue
        Map<String, Map<String, String>> expectedPredLastMatrix = new HashMap<>();
        expectedPredLastMatrix.put("1", Map.of("1", "0", "2", "1", "3", "4", "4", "2"));
        expectedPredLastMatrix.put("2", Map.of("1", "4", "2", "0", "3", "4", "4", "2"));
        expectedPredLastMatrix.put("3", Map.of("1", "4", "2", "3", "3", "0", "4", "2"));
        expectedPredLastMatrix.put("4", Map.of("1", "4", "2", "3", "3", "4", "4", "0"));

        // Exécution de l'algorithme
        Map<String, Map<String, Map<String, Object>>> result = FloydWarshall.floydWarshall(G);

        // Vérification des résultats
        Map<String, Map<String, Object>> actualShortest = result.get("shortest");
        Map<String, Map<String, Object>> actualPred = result.get("pred");

        assertEquals(expectedShortestPathLastMatrix, actualShortest, "Les matrices des plus courts chemins ne correspondent pas.");
        assertEquals(expectedPredLastMatrix, actualPred, "Les matrices des prédécesseurs ne correspondent pas.");
    }
}
