package org.jibe77.algo.chap3.tri.statistiques;

import org.jibe77.algo.chap2.recherche.Recherche;
import org.jibe77.algo.chap3.tri.LancementTri;
import org.jibe77.algo.chap3.tri.Tri;

import java.util.Arrays;

public abstract class AbstractLancementTriStatistiques {

    public void lancerRecherche() {
        // Début de la mesure
        long startTime = System.nanoTime();

        // Code à mesurer
        for (int i = 0; i <= 10000000; i++) {
            lancerTriAvecImplémentation(lancerTriAvecImplementation());
        }

        // Fin de la mesure
        long endTime = System.nanoTime();

        // Calcul du temps écoulé
        long duration = endTime - startTime;
        System.out.println("Temps d'exécution : " + duration + " nanosecondes");
        System.out.println("Temps d'exécution : " + (duration / 1_000_000) + " millisecondes");
    }

    public abstract Tri lancerTriAvecImplementation();

    private void lancerTriAvecImplémentation(Tri implementationDuTri) {
        implementationDuTri.tri(
                Arrays.copyOf(LancementTri.presidents, LancementTri.presidents.length));
    }
}
