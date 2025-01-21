package org.jibe77.algo.chap5.chemin.dag;

import java.util.*;

public class TriTopologique {
    public static List<String> topologicalSort(Map<String, List<String>> graph) {
        // Initialiser l'indégré de chaque sommet
        Map<String, Integer> inDegree = new HashMap<>();
        for (String vertex : graph.keySet()) {
            inDegree.put(vertex, 0);
        }
        for (String u : graph.keySet()) {
            for (String v : graph.get(u)) {
                try {
                    inDegree.put(v, inDegree.get(v) + 1);
                } catch (NullPointerException e) {
                    System.err.println("u=" + u + ",v="+v);
                }
            }
        }

        // Initialiser la liste des sommets avec un indégré de 0
        Queue<String> next = new LinkedList<>();
        for (String vertex : inDegree.keySet()) {
            if (inDegree.get(vertex) == 0) {
                next.add(vertex);
            }
        }

        // Liste pour stocker l'ordre linéaire
        List<String> linearOrder = new ArrayList<>();
        while (!next.isEmpty()) {
            String u = next.poll();
            linearOrder.add(u);

            // Réduire l'indégré des voisins et ajouter à la queue si indégré devient 0
            for (String v : graph.getOrDefault(u, new ArrayList<>())) {
                inDegree.put(v, inDegree.get(v) - 1);
                if (inDegree.get(v) == 0) {
                    next.add(v);
                }
            }
        }

        // Vérifier s'il y a un cycle (le graphe n'est pas un DAG si ordre incomplet)
        if (linearOrder.size() != graph.size()) {
            throw new IllegalStateException("Cycle détecté : le graphe n'est pas un DAG !");
        }

        return linearOrder;
    }

    // Exemple d'utilisation
    public static void main(String[] args) {
        // Définir un graphe comme une liste d'adjacence
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D"));
        graph.put("C", Arrays.asList("D", "E"));
        graph.put("D", Arrays.asList("E"));
        graph.put("E", Collections.emptyList());

        // Effectuer le tri topologique
        List<String> order = topologicalSort(graph);

        // Afficher l'ordre topologique
        System.out.println("Ordre topologique : " + order);
    }
}
