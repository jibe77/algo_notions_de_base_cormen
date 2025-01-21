package org.jibe77.algo.chap2.recherche.impl;

import org.jibe77.algo.chap2.recherche.Recherche;

public class RechercheSentinelle implements Recherche {

    /**
     * Optimisation de la recherche linéaire qui permet de réduire le nombre de comparaisons dans certaines situations.
     * Ajoute une "sentinelle" (un marqueur) à la fin du tableau pour garantir que l'élément recherché est toujours
     * trouvé dans le tableau, soit comme valeur réelle, soit comme sentinelle
     *
     * @param tableau tableau sur lequel effectuer les recherches
     * @param n nombre d'éléments de tableau à examiner
     * @param elementRecherché la valeur à rechercher
     * @return soit i pour lequel tableau[i] = x, soit la valeur spécial -1 correspond au cas "non trouvé"
     */
    @Override
    public int rechercheDansTableau(String[] tableau, int n, String elementRecherché) {
        String dernier = tableau[n-1];
        tableau[n-1] = elementRecherché;

        int i = 0;

        while (tableau[i].equals(elementRecherché) == false) {
            i++;
        }

        tableau[n-1] = dernier;

        if ((i < n-1) || (tableau[n].equals(elementRecherché))){
            return i;
        } else {
            return -1;
        }
    }
}
