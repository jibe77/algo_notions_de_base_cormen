package org.jibe77.algo.chap6.chemin.bellmanford;

import org.jibe77.algo.chap5.chemin.dag.Relachement;
import org.jibe77.algo.chap6.chemin.dijkstra.Result;

import java.util.HashMap;
import java.util.Map;

public class BellmanFord {

    public static Result bellmanFord(Map<String, Map<String, Double>> graph, String source) {
        Map<String, Double> plusCourt = new HashMap<>();
        Map<String, String> pred = new HashMap<>();

        // Initialisation des distances
        for (String sommet : graph.keySet()) {
            plusCourt.put(sommet, sommet.equals(source) ? 0.0 : Double.POSITIVE_INFINITY);
            pred.put(sommet, null);
        }

        // Nombre de sommets dans le graphe
        int n = graph.size();

        // Étapes de relaxation
        for (int i = 0; i < n - 1; i++) {
            for (String sommetDeDepartArc : graph.keySet()) {
                for (String sommetDeDestinationArc : graph.get(sommetDeDepartArc).keySet()) {
                    Relachement.relachement(sommetDeDepartArc, sommetDeDestinationArc, plusCourt, pred, graph);
                }
            }
        }

        // Retourner les résultats
        return new Result(plusCourt, pred);
    }

    public static void main(String[] args) {
        // Exemple de graphe représenté par une Map
        Map<String, Map<String, Double>> graphe = new HashMap<>();

        // Ajout des sommets et des arêtes avec leurs poids
        graphe.put("A", Map.of("B", 4.0, "C", 2.0));
        graphe.put("B", Map.of("C", 5.0, "D", 10.0));
        graphe.put("C", Map.of("E", 3.0));
        graphe.put("D", Map.of("E", 4.0));
        graphe.put("E", Map.of());

        // Exécution de l'algorithme de Bellman-Ford
        String source = "A";
        Result result = bellmanFord(graphe, source);

        System.out.println("Distance la plus courte : " + result.plusCourt);
        System.out.println("Prédecesseurs : " + result.pred);
    }
}
