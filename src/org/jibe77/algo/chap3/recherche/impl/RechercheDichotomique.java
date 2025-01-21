package org.jibe77.algo.chap3.recherche.impl;

import org.jibe77.algo.chap2.recherche.Recherche;

public class RechercheDichotomique implements Recherche {

    public static final int NON_TROUVé = -1;

    /**
     * Effectue la recherche dans le tableau de la valeur x, sur les n premiers indices du tableau.
     * Cette méthode ne fonctionne qu'avec un tableau trié !
     *
     * @param tableau tableau sur lequel effectuer les recherches
     * @param n nombre d'éléments de tableau à examiner
     * @param elementRecherché la valeur à rechercher
     * @return soit i pour lequel tableau[i] = x, soit la valeur spécial -1 correspond au cas "non trouvé"
     */
    @Override
    public int rechercheDansTableau(String[] tableau, int n, String elementRecherché) {
        // 1. initialiser les variables
        int p = 0;
        int r = n;

        // 2. tant que p<=r, faire la chose suivante :
        while (p<=r) {
            // A. initialiser q
            int q =  (p + r) / 2;

            // B. Si tableau[q]  = elementRecherché, alors retourner q
            if (tableau[q].equals(elementRecherché)) {
                return q;
            } // C. Sinon si tableau[q] se situe après l'élément recherché alors fixer r à q - 1
            else if (tableau[q].compareTo(elementRecherché) > 0) {
                r = q - 1;
            } // D. Sinon fixer p à q + 1
            else {
                p = q + 1;
            }
        }

        return NON_TROUVé;
    }
}
