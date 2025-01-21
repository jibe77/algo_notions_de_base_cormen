package org.jibe77.algo.chap2.recherche.impl;

import org.jibe77.algo.chap2.recherche.Recherche;

public class RechercheRecursive implements Recherche {

    public static final int NON_TROUVé = -1;

    /**
     * Similaire à la précédente fonction, mais retourne la réponse dès qu'elle est
     * trouvée plutôt que de continuer à vérifier les indices restants.
     *
     * @param tableau tableau sur lequel effectuer les recherches
     * @param n nombre d'éléments de tableau à examiner
     * @param elementRecherché la valeur à rechercher
     * @param i indice du tableau à vérifier
     * @return soit i pour lequel tableau[i] = x, soit la valeur spécial -1 correspond au cas "non trouvé"
     */
    public int rechercheDansTableauRecursive(String[] tableau, int n, String elementRecherché, int i) {
        if (i > n) {
            return NON_TROUVé;
        } else if (tableau[i].equals(elementRecherché)) {
            return i;
        } else {
            return rechercheDansTableauRecursive(tableau, n, elementRecherché, i+1);
        }
    }

    @Override
    public int rechercheDansTableau(String[] tableau, int n, String elementRecherché) {
        return rechercheDansTableauRecursive(tableau, n, elementRecherché, 0);
    }
}
