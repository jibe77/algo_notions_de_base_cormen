package org.jibe77.algo.chap2.recursion;

public class RecursionErronée {

    public static void main(String... args) {
        System.out.println(factoriel(5));
    }

    /**
     * Cette fonction résursive produit une erreur de dépassement de pile.
     * @param n valeur dont on doit calculer le produit factoriel, n >= 0.
     * @return retourne le résultat du calcul.
     */
    private static int factoriel(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factoriel(n+1)/(n+1);
    }
}
