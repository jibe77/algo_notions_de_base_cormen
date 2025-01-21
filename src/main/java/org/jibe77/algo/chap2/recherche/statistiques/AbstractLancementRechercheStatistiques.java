package org.jibe77.algo.chap2.recherche.statistiques;

import org.jibe77.algo.chap2.recherche.Recherche;

public abstract class AbstractLancementRechercheStatistiques {

    static final String[] presidents = {
            "Charles de Gaulle",
            "Georges Pompidou",
            "Valéry Giscard d'Estaing",
            "François Mitterrand",
            "Jacques Chirac"
    };

    public void lancerRecherche() {
        // Début de la mesure
        long startTime = System.nanoTime();

        // Code à mesurer
        for (int i = 0; i <= 10000000; i++) {
            lancerRechercheAvecImplémentation(lancerRechercheImplementation());
        }

        // Fin de la mesure
        long endTime = System.nanoTime();

        // Calcul du temps écoulé
        long duration = endTime - startTime;
        System.out.println("Temps d'exécution : " + duration + " nanosecondes");
        System.out.println("Temps d'exécution : " + (duration / 1_000_000) + " millisecondes");
    }

    public abstract Recherche lancerRechercheImplementation();

    private void lancerRechercheAvecImplémentation(Recherche implementationDeLaRecherche) {
        implementationDeLaRecherche.rechercheDansTableau(
                presidents, presidents.length, "François Mitterrand");
    }
}
