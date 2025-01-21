package org.jibe77.algo.chap2.recursion;

public class Recursion {

    public static void main(String... args) {
        System.out.println(factoriel(5));
    }

    /**
     * Cette fonction effectue le calcul du produit factoriel de n
     * @param n valeur dont on doit calculer le produit factoriel, n >= 0.
     * @return retourne le résultat du calcul.
     */
    private static int factoriel(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factoriel(n-1);
    }
}
