package org.jibe77.algo.chap3.tri.statistiques;

import org.jibe77.algo.chap3.tri.Tri;
import org.jibe77.algo.chap3.tri.impl.TriInsertion;

public class LancementTriInsertionStatistiques {

    public static void main(String[] args) {
        new AbstractLancementTriStatistiques() {
            @Override
            public Tri lancerTriAvecImplementation() {
                return new TriInsertion();
            }
        }.lancerRecherche();
    }
}
