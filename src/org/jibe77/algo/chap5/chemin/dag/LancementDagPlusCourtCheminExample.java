package org.jibe77.algo.chap5.chemin.dag;

import java.util.*;

public class LancementDagPlusCourtCheminExample {

    // Exemple d'utilisation
    public static void main(String[] args) {
        // Définir les sommets
        Set<String> vertices = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E"));

        // Définir la liste des arcs
        Map<String, List<String>> adjacencyList = new HashMap<>();
        adjacencyList.put("A", Arrays.asList("B", "C"));
        adjacencyList.put("B", Arrays.asList("D"));
        adjacencyList.put("C", Arrays.asList("D", "E"));
        adjacencyList.put("D", Arrays.asList("E"));
        adjacencyList.put("E", Collections.emptyList());

        // Définir les poids des arcs
        Map<String, Map<String, Double>> weights = new HashMap<>();
        weights.put("A", Map.of("B", 1.0, "C", 2.0));
        weights.put("B", Map.of("D", 3.0));
        weights.put("C", Map.of("D", 1.0, "E", 5.0));
        weights.put("D", Map.of("E", 1.0));
        weights.put("E", new HashMap<>());

        // Créer le graphe
        Graph G = new Graph(vertices, adjacencyList, weights);

        // Calculer les plus courts chemins depuis le sommet "A"
        Map<String, Object> result = DagPlusCourtChemin.dagPlusCourtChemin(G, "A");

        // Afficher les résultats
        System.out.println("Distances les plus courtes : " + result.get("plusCourt"));
        System.out.println("Prédécesseurs : " + result.get("pred"));
    }
}
