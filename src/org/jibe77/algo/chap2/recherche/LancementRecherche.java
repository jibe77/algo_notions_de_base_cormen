package org.jibe77.algo.chap2.recherche;

import org.jibe77.algo.chap2.recherche.impl.RechercheLinéaire;
import org.jibe77.algo.chap2.recherche.impl.RechercheLinéaireAméliorée;
import org.jibe77.algo.chap2.recherche.impl.RechercheRecursive;
import org.jibe77.algo.chap2.recherche.impl.RechercheSentinelle;

public class LancementRecherche {

    static String[] presidents = {
            "Charles de Gaulle",
            "Georges Pompidou",
            "Valéry Giscard d'Estaing",
            "François Mitterrand",
            "Jacques Chirac"
    };

    public static void main(String... args) {
        lancerRechercheAvecImplémentation(new RechercheLinéaire());
        lancerRechercheAvecImplémentation(new RechercheLinéaireAméliorée());
        lancerRechercheAvecImplémentation(new RechercheSentinelle());
        lancerRechercheAvecImplémentation(new RechercheRecursive());
    }

    private static void lancerRechercheAvecImplémentation(Recherche implementationDeLaRecherche) {
        int resultat = implementationDeLaRecherche.rechercheDansTableau(
                presidents, presidents.length, "François Mitterrand");
        System.out.println("Indice du résultat avec implémentation " + implementationDeLaRecherche.getClass() +
                " est " + resultat);
    }
}
