package org.jibe77.algo.chap5.chemin.dag;

import java.util.Map;

public class Relachement {

    // Méthode de relachement pour mettre à jour les distances
    public static void relachement(String sommetSourceDeArc, String sommetDestinationDeArc, Map<String, Double> plusCourt,
                                    Map<String, String> pred, Map<String, Map<String, Double>> poids) {
        try {
            if (plusCourt.get(sommetSourceDeArc) + poids.get(sommetSourceDeArc).get(sommetDestinationDeArc) < plusCourt.get(sommetDestinationDeArc)) {
                plusCourt.put(sommetDestinationDeArc, plusCourt.get(sommetSourceDeArc) + poids.get(sommetSourceDeArc).get(sommetDestinationDeArc));
                pred.put(sommetDestinationDeArc, sommetSourceDeArc);
            }
        } catch (NullPointerException ex) {
            System.err.println("Erreur sur la récupération de l'arc ayant pour source " + sommetSourceDeArc +
                    " et de destination " + sommetDestinationDeArc);
        }
    }
}
