package org.jibe77.algo.chap6.chemin.dijkstra;

import org.jibe77.algo.chap5.chemin.dag.Relachement;

import java.util.*;

public class Dijkstra {

    public static Result dijkstra(Graph graph, String s) {
        Map<String, Double> plusCourt = new HashMap<>();
        Map<String, String> pred = new HashMap<>();
        PriorityQueue<String> Q = new PriorityQueue<>(Comparator.comparingDouble(plusCourt::get));

        for (String sommet : getSommetsSet(graph)) {
            plusCourt.put(sommet, sommet.equals(s) ? 0.0 : Double.MAX_VALUE);
            pred.put(sommet, null);
            Q.add(sommet);
        }

        while (!Q.isEmpty()) {
            String u = Q.poll();
            Map<String, Double> voisins = graph.arcs.get(u);
            if (voisins != null) {
                for (String v : voisins.keySet()) {
                    Relachement.relachement(u, v, plusCourt, pred, graph.arcs);
                }
            }
        }

        return new Result(plusCourt, pred);
    }

    private static Set<String> getSommetsSet(Graph graph) {
        Set<String> sommets = new HashSet<>();
        for(String sommetSource : graph.arcs.keySet()) {
            sommets.add(sommetSource);

            for (String sommetDest : graph.arcs.get(sommetSource).keySet()) {
                sommets.add(sommetDest);
            }
        }
        return sommets;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.ajoutArc("A", "B", 1.0);
        graph.ajoutArc("A", "C", 4.0);
        graph.ajoutArc("B", "C", 2.0);
        graph.ajoutArc("B", "D", 6.0);
        graph.ajoutArc("C", "D", 3.0);


        Result result = dijkstra(graph, "A");

        System.out.println("Distance la plus courte : " + result.plusCourt);
        System.out.println("Prédecesseurs : " + result.pred);
    }
}
