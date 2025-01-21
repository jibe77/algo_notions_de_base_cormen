package org.jibe77.algo.chap6.chemin.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    Map<String, Map<String, Double>> arcs;

    public Graph() {
        arcs = new HashMap<>();
    }

    public void ajoutArc(String src, String dest, Double poids) {
        arcs.putIfAbsent(src, new HashMap<>());
        arcs.get(src).put(dest, poids);
    }
}
