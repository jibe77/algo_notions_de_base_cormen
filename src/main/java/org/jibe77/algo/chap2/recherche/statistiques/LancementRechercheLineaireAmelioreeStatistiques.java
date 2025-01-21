package org.jibe77.algo.chap2.recherche.statistiques;

import org.jibe77.algo.chap2.recherche.Recherche;
import org.jibe77.algo.chap2.recherche.impl.RechercheLinéaireAméliorée;

public class LancementRechercheLineaireAmelioreeStatistiques {

    public static void main(String[] args) {
        new AbstractLancementRechercheStatistiques() {
            @Override
            public Recherche lancerRechercheImplementation() {
                return new RechercheLinéaireAméliorée();
            }
        }.lancerRecherche();
    }
}
