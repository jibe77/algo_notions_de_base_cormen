package org.jibe77.algo.chap3.recherche;

import org.jibe77.algo.chap2.recherche.Recherche;
import org.jibe77.algo.chap3.recherche.impl.RechercheDichotomique;
import org.jibe77.algo.chap3.recherche.impl.RechercheDichotomiqueRecursive;

import java.util.Arrays;

public class LancementRecherche {

    static String[] presidents = {
            "de Gaulle",
            "Pompidou",
            "Giscard d'Estaing",
            "Mitterrand",
            "Chirac",
            "Thiers",
            "Mac Mahon",
            "Carnot",
            "Grévy",
            "Perier",
            "Faure",
            "Loubet",
            "Fallières",
            "Pointcaré",
            "Deschanel",
            "Doumergue",
            "Doumer",
            "Lebrun",
            "Auriol",
            "Coty",
            "Sarkozy",
            "Hollande",
            "Macron"
    };

    public static void main(String... args) {
        lancerRechercheAvecImplémentation(new RechercheDichotomique());
        lancerRechercheAvecImplémentation(new RechercheDichotomiqueRecursive());
    }

    private static void lancerRechercheAvecImplémentation(Recherche implementationDeLaRecherche) {
        // cette recherche doit impérativement être lancée sur un tableau trié.
        Arrays.sort(presidents);
        // lancement de la recherche
        int resultat = implementationDeLaRecherche.rechercheDansTableau(
                presidents, presidents.length, "Mitterrand");
        System.out.println("Indice du résultat avec implémentation " + implementationDeLaRecherche.getClass() +
                " est " + resultat);
    }
}
