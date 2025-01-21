package org.jibe77.algo.chap3.recherche.impl;

import org.jibe77.algo.chap2.recherche.Recherche;

public class RechercheDichotomiqueRecursive implements Recherche {

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
        return rechercheDansTableauRecursivement(tableau, 0, n, elementRecherché);
    }

    /**
     * Effectue la recherche dans le tableau de la valeur x, sur les n premiers indices du tableau.
     * Cette méthode ne fonctionne qu'avec un tableau trié !
     *
     * @param tableau tableau sur lequel effectuer les recherches
     * @param p balise le début du sous-tableau examiné
     * @param r balise la fin du sous-tableau examiné
     * @param elementRecherché la valeur à rechercher
     * @return soit i pour lequel tableau[i] = x, soit la valeur spécial -1 correspond au cas "non trouvé"
     */
    public int rechercheDansTableauRecursivement(String[] tableau, int p, int r, String elementRecherché) {
        // 1. Si p > r alors retourner NON TROUVé
        if (p > r) {
            return NON_TROUVé;
        } // 2. Sinon faire les choses suivantes
        else {
            // A. Fixer q à (p+r) / 2
            int q = (p+r)/2;

            // B. Si tableau[q] = elementRecherché alors retourner q
            if (tableau[q].equals(elementRecherché)) {
                return q;
            } // C. Sinon si tableau[q] se situe après l'élément recherché alors faire appel recursif
            else if (tableau[q].compareTo(elementRecherché) > 0){
                return rechercheDansTableauRecursivement(tableau, p, q - 1, elementRecherché);
            } // D. Sinon faire l'appel recursif avec q + 1
            else {
                return rechercheDansTableauRecursivement(tableau, q + 1, r, elementRecherché);
            }
        }
    }
}
