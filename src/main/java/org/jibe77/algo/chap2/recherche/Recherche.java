package org.jibe77.algo.chap2.recherche;

public interface Recherche {

    /**
     * Interface spécifiant la recherche dans un tableau de taille n de l'élément spécifié
     * @param tableau tableau contenant l'élément à rechercher
     * @param n taille du tableau
     * @param elementRecherché élément à recherche dans le tableau
     * @return indice de l'élément recherché dans le tableau, si non trouvé alors retourne une valeur négative
     */
    int rechercheDansTableau(String[] tableau, int n, String elementRecherché);
}
