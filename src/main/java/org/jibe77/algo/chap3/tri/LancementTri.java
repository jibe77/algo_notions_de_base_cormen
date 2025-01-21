package org.jibe77.algo.chap3.tri;

import org.jibe77.algo.chap3.tri.impl.TriFusion;
import org.jibe77.algo.chap3.tri.impl.TriInsertion;
import org.jibe77.algo.chap3.tri.impl.TriRapide;
import org.jibe77.algo.chap3.tri.impl.TriSelection;

import java.util.Arrays;

public class LancementTri {

    public static String[] presidents = {
            "De Gaulle",
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
        lancerTri(new TriFusion());
        lancerTri(new TriSelection());
        lancerTri(new TriRapide());
        lancerTri(new TriInsertion());
    }

    private static void lancerTri(Tri tri) {
        tri.tri(Arrays.copyOf(presidents, presidents.length));
        System.out.println(Arrays.toString(presidents));
    }
}
