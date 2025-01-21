package org.jibe77.algo.chap2.recherche.impl;

import org.jibe77.algo.chap2.recherche.Recherche;

public class RechercheLinéaireAméliorée implements Recherche {

    /**
     * Similaire à la précédente fonction, mais retourne la réponse dès qu'elle est
     * trouvée plutôt que de continuer à vérifier les indices restants.
     *
     * @param tableau tableau sur lequel effectuer les recherches
     * @param n nombre d'éléments de tableau à examiner
     * @param elementRecherché la valeur à rechercher
     * @return soit i pour lequel tableau[i] = x, soit la valeur spécial -1 correspond au cas "non trouvé"
     */
    @Override
    public int rechercheDansTableau(String[] tableau, int n, String elementRecherché) {
        for (int i = 0; i < n; i++) {
            if (tableau[i].equals(elementRecherché)) {
                return i;
            }
        }
        return -1;
    }
}
