package org.jibe77.algo.chap5.chemin.dag;

import java.util.*;

public class DagPlusCourtChemin {

    // Méthode principale pour calculer les plus courts chemins dans un DAG
    public static Map<String, Object> dagPlusCourtChemin(Graph graphiqueDAG, String s) {
        // on lance un tri topologique pour mettre les arcs dans l'ordre d'exécution.
        List<String> triTopologique = TriTopologique.topologicalSort(graphiqueDAG.getListeArcs());
        Map<String, Double> plusCourt = new HashMap<>();
        Map<String, String> pred = new HashMap<>();

        // Initialiser les distances et prédécesseurs
        for (String sommet : graphiqueDAG.getSommets()) {
            plusCourt.put(sommet, sommet.equals(s) ? 0.0 : Double.POSITIVE_INFINITY);
            pred.put(sommet, null);
        }

        // Parcourir les sommets dans l'ordre topologique
        for (String sommetSourceDeArc : triTopologique) {
            for (String sommetDestinationDeArc : graphiqueDAG.getListeArcs().getOrDefault(sommetSourceDeArc, Collections.emptyList())) {
                Relachement.relachement(sommetSourceDeArc, sommetDestinationDeArc, plusCourt, pred, graphiqueDAG.getPoids());
            }
        }

        // Retourner les résultats
        Map<String, Object> result = new HashMap<>();
        result.put("plusCourt", plusCourt);
        result.put("pred", pred);
        return result;
    }


}
