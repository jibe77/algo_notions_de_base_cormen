package org.jibe77.algo.chap8.mod_exp;

public class ModularExponentiation {

    /**
     * Calcule x^d mod n en utilisant l'exponentiation rapide.
     *
     * @param x la base (positif)
     * @param d l'exposant (positif)
     * @param n le modulo (strictement positif)
     * @return le résultat de x^d mod n
     */
    public static long modExp(long x, long d, long n) {
        long result = 1;
        // On réduit x modulo n pour simplifier le calcul
        x = x % n;

        // Tant que l'exposant est positif
        while (d > 0) {
            // Si d est impair, multiplier le résultat par x modulo n
            if (d % 2 == 1) {
                result = (result * x) % n;
            }
            // Diviser d par 2 (division entière)
            d = d / 2;
            // Mettre x au carré modulo n
            x = (x * x) % n;
        }
        return result;
    }

    public static void main(String[] args) {
        // Quelques exemples de tests

        // Exemple 1 : 2^10 mod 1000
        // 2^10 = 1024 et 1024 mod 1000 = 24
        long x1 = 2, d1 = 10, n1 = 1000;
        System.out.println(x1 + "^" + d1 + " mod " + n1 + " = " + modExp(x1, d1, n1));

        // Exemple 2 : 3^20 mod 50
        long x2 = 3, d2 = 20, n2 = 50;
        System.out.println(x2 + "^" + d2 + " mod " + n2 + " = " + modExp(x2, d2, n2));

        // Exemple 3 : 5^13 mod 19
        long x3 = 5, d3 = 13, n3 = 19;
        System.out.println(x3 + "^" + d3 + " mod " + n3 + " = " + modExp(x3, d3, n3));
    }
}
