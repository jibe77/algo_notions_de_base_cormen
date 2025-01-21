package org.jibe77.algo.chap6.chemin.floydwarshall;

import java.util.HashMap;
import java.util.Map;

public class FloydWarshall {

    public static Map<String, Map<String, Map<String, Object>>> floydWarshall(Map<String, Map<String, Double>> G) {
        int n = G.size();
        Map<Integer, Map<String, Map<String, Double>>> shortest = new HashMap<>();
        Map<Integer, Map<String, Map<String, String>>> pred = new HashMap<>();

        // Initialisation de shortest[0] avec G
        shortest.put(0, new HashMap<>(G));
        pred.put(0, new HashMap<>());

        // Initialisation des prédécesseurs
        for (String u : G.keySet()) {
            pred.get(0).put(u, new HashMap<>());
            for (String v : G.keySet()) {
                String weight = (u.equals(v) || G.get(u).getOrDefault(v, Double.POSITIVE_INFINITY).equals(Double.POSITIVE_INFINITY))
                        ? "0" : u;
                pred.get(0).get(u).put(v, weight);
            }
        }

        // Calcul des plus courts chemins
        for (int x = 1; x <= n; x++) {
            String xKey = (String) G.keySet().toArray()[x - 1];
            shortest.put(x, new HashMap<>());
            pred.put(x, new HashMap<>());

            for (String u : G.keySet()) {
                shortest.get(x).put(u, new HashMap<>());
                pred.get(x).put(u, new HashMap<>());

                for (String v : G.keySet()) {
                    Double directPath = shortest.get(x - 1).get(u).getOrDefault(v, Double.POSITIVE_INFINITY);
                    Double throughX = shortest.get(x - 1).get(u).getOrDefault(xKey, Double.POSITIVE_INFINITY)
                            + shortest.get(x - 1).get(xKey).getOrDefault(v, Double.POSITIVE_INFINITY);

                    if (directPath > throughX) {
                        shortest.get(x).get(u).put(v, throughX);
                        pred.get(x).get(u).put(v, pred.get(x - 1).get(xKey).get(v));
                    } else {
                        shortest.get(x).get(u).put(v, directPath);
                        pred.get(x).get(u).put(v, pred.get(x - 1).get(u).get(v));
                    }
                }
            }
        }

        // Résultat
        Map<String, Map<String, Map<String, Object>>> result = new HashMap<>();
        result.put("shortest", (Map) shortest.get(n));
        result.put("pred", (Map) pred.get(n));

        return result;
    }

    public static void main(String[] args) {
        // Exemple de graphe pondéré
        Map<String, Map<String, Double>> graph = new HashMap<>();
        graph.put("A", Map.of("A", 0.0, "B", 3.0, "C", Double.POSITIVE_INFINITY, "D", 7.0));
        graph.put("B", Map.of("A", 8.0, "B", 0.0, "C", 2.0, "D", Double.POSITIVE_INFINITY));
        graph.put("C", Map.of("A", 5.0, "B", Double.POSITIVE_INFINITY, "C", 0.0, "D", 1.0));
        graph.put("D", Map.of("A", 2.0, "B", Double.POSITIVE_INFINITY, "C", Double.POSITIVE_INFINITY, "D", 0.0));

        Map<String, Map<String, Map<String, Object>>> result = floydWarshall(graph);

        System.out.println("Plus courts chemins : " + result.get("shortest"));
        System.out.println("Prédécesseurs : " + result.get("pred"));
    }
}
