package org.jibe77.algo.chap5.chemin.dag;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Set<String> sommets;
    private Map<String, List<String>> listeArcs;
    private Map<String, Map<String, Double>> poids;

    public Graph(Set<String> sommets, Map<String, List<String>> listeArcs, Map<String, Map<String, Double>> poids) {
        this.sommets = sommets;
        this.listeArcs = listeArcs;
        this.poids = poids;
    }

    public Set<String> getSommets() {
        return sommets;
    }

    public Map<String, List<String>> getListeArcs() {
        return listeArcs;
    }

    public Map<String, Map<String, Double>> getPoids() {
        return poids;
    }
}
