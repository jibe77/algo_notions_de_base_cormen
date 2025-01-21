package org.jibe77.algo.chap5.chemin.dag;

import java.util.*;

public class LancementTriTopologique {
    // Méthode principale pour tester
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();

        // Ajouter des arêtes au graphe
        graph.put("1", Arrays.asList("3"));
        graph.put("2", Arrays.asList("4"));
        graph.put("3", Arrays.asList("4", "5"));
        graph.put("4", Arrays.asList("6"));
        graph.put("5", Arrays.asList("6"));
        graph.put("6", Arrays.asList("7", "11"));
        graph.put("7", Arrays.asList("8"));
        graph.put("8", Arrays.asList("13"));
        graph.put("9", Arrays.asList("10"));
        graph.put("10", Arrays.asList("11"));
        graph.put("11", Arrays.asList("12"));
        graph.put("12", Arrays.asList("13"));
        graph.put("13", Arrays.asList("14"));
        graph.put("14", Collections.emptyList());

        // Effectuer le tri topologique
        List<String> order = TriTopologique.topologicalSort(graph);

        // Afficher l'ordre topologique
        System.out.println("Ordre topologique : " + order);
    }
}
