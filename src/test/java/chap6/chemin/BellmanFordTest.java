package chap6.chemin;

import org.jibe77.algo.chap6.chemin.bellmanford.BellmanFord;
import org.jibe77.algo.chap6.chemin.dijkstra.Result;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashMap;
import java.util.Map;

public class BellmanFordTest {

    @Test
    public void testBellmanFord() {
        // Définition du graphe
        Map<String, Map<String, Double>> E = new HashMap<>();
        E.put("s", Map.of("t", 6.0, "y", 7.0));
        E.put("t", Map.of("x", 5.0, "y", 8.0, "z", -4.0));
        E.put("x", Map.of("t", -2.0));
        E.put("y", Map.of("x", -3.0, "z", 9.0));
        E.put("z", Map.of("s", 2.0, "x", 7.0));

        // Résultats attendus
        Map<String, Double> expectedShortest = new HashMap<>();
        expectedShortest.put("s", 0.0);
        expectedShortest.put("t", 2.0);
        expectedShortest.put("x", 4.0);
        expectedShortest.put("y", 7.0);
        expectedShortest.put("z", -2.0);

        Map<String, String> expectedPred = new HashMap<>();
        expectedPred.put("s", null);
        expectedPred.put("t", "x");
        expectedPred.put("x", "y");
        expectedPred.put("y", "s");
        expectedPred.put("z", "t");

        // Exécution de l'algorithme
        Result result = BellmanFord.bellmanFord(E, "s");

        // Assertions sur les distances les plus courtes
        assertEquals(expectedShortest, result.plusCourt, "Les distances les plus courtes ne sont pas correctes.");

        // Assertions sur les prédécesseurs
        assertEquals(expectedPred, result.pred, "Les prédécesseurs ne sont pas corrects.");
    }
}
