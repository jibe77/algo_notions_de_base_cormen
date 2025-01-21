package chap6.chemin;

import org.jibe77.algo.chap6.chemin.dijkstra.Dijkstra;
import org.jibe77.algo.chap6.chemin.dijkstra.Graph;
import org.jibe77.algo.chap6.chemin.dijkstra.Result;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DijstraTest {

    @Test
    public void testDijkstra() {
        Graph graph = new Graph();

        // définit les arcs avec leurs poids
        graph.ajoutArc("s", "t", 6.0);
        graph.ajoutArc("s", "y", 4.0);
        graph.ajoutArc("t", "x", 3.0);
        graph.ajoutArc("t", "y", 2.0);
        graph.ajoutArc("x", "z", 4.0);
        graph.ajoutArc("y", "t", 1.0);
        graph.ajoutArc("y", "x", 9.0);
        graph.ajoutArc("y", "z", 3.0);
        graph.ajoutArc("z", "s", 7.0);
        graph.ajoutArc("z", "x", 5.0);

        // resultat attendu
        Map<String, Double> shortestExpected = new HashMap<>();
        shortestExpected.put("s", 0.0);
        shortestExpected.put("t", 5.0);
        shortestExpected.put("x", 8.0);
        shortestExpected.put("y", 4.0);
        shortestExpected.put("z", 7.0);

        Map<String, String> predExpected = new HashMap<>();
        predExpected.put("s", null);
        predExpected.put("t", "y");
        predExpected.put("x", "t");
        predExpected.put("y", "s");
        predExpected.put("z", "y");

        Result expected = new Result(shortestExpected, predExpected);

        // Run Dijkstra
        assertEquals(expected, Dijkstra.dijkstra(graph, "s"));
    }
}
