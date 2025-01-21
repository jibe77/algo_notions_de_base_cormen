package org.jibe77.algo.chap2.recherche.impl;

import org.jibe77.algo.chap2.recherche.Recherche;

public class RechercheLinéaire implements Recherche {

    /**
     * Effectue la recherche dans le tableau de la valeur x, sur les n premiers indices du tableau.
     *
     * @param tableau tableau sur lequel effectuer les recherches
     * @param n nombre d'éléments de tableau à examiner
     * @param elementRecherché la valeur à rechercher
     * @return soit i pour lequel tableau[i] = x, soit la valeur spécial -1 correspond au cas "non trouvé"
     */
    @Override
    public int rechercheDansTableau(String[] tableau, int n, String elementRecherché) {
        int réponse = -1;
        for (int i = 0; i < n; i++) {
            if (tableau[i].equals(elementRecherché)) {
                réponse = i;
            }
        }
        return réponse;
    }
}
