package org.jibe77.algo.chap2.recherche.statistiques;

import org.jibe77.algo.chap2.recherche.Recherche;
import org.jibe77.algo.chap2.recherche.impl.RechercheRecursive;

/**
 * On remarque que cette implémentation est la plus lente lorsqu'on l'exécute 10 millions de fois.
 * Cela met environ 130 ms à s'exécuter par rapports aux autres.
 * Les autres implémentations mette 2 à 3 fois moins de temps.
 */
public class LancementRechercheRecursiveStatistiques {

    public static void main(String[] args) {
        new AbstractLancementRechercheStatistiques() {
            @Override
            public Recherche lancerRechercheImplementation() {
                return new RechercheRecursive();
            }
        }.lancerRecherche();
    }
}
