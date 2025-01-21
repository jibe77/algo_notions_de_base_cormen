package org.jibe77.algo.chap3.recherche.statistiques;

import org.jibe77.algo.chap2.recherche.Recherche;
import org.jibe77.algo.chap2.recherche.statistiques.AbstractLancementRechercheStatistiques;
import org.jibe77.algo.chap3.recherche.impl.RechercheDichotomique;

public class LancementRechercheDichotomiqueStatistiques {

    public static void main(String[] args) {
        new AbstractLancementRechercheStatistiques() {
            @Override
            public Recherche lancerRechercheImplementation() {
                return new RechercheDichotomique();
            }
        }.lancerRecherche();
    }
}
