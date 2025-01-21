package org.jibe77.algo.chap2.recherche.statistiques;

import org.jibe77.algo.chap2.recherche.Recherche;
import org.jibe77.algo.chap2.recherche.impl.RechercheLinéaire;

public class LancementRechercheLineaireStatistiques {

    public static void main(String[] args) {
        new AbstractLancementRechercheStatistiques() {
            @Override
            public Recherche lancerRechercheImplementation() {
                return new RechercheLinéaire();
            }
        }.lancerRecherche();
    }
}
