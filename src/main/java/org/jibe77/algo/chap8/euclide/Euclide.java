package org.jibe77.algo.chap8.euclide;

public class Euclide {

    /**
     * Calcule le Plus Grand Diviseur Commun (PGCD) de a et b ainsi que les coefficients i et j vérifiant
     * g = a * i + b * j, où g est le PGCD de a et b.
     *
     * @param a le premier entier
     * @param b le deuxième entier
     * @return un tableau d'entiers {g, i, j}
     */
    public static int[] euclide(int a, int b) {
        // Cas de base : si b est nul, le PGCD est a et on a i = 1, j = 0.
        if (b == 0) {
            return new int[]{a, 1, 0};
        }
        // Appel récursif
        int[] result = euclide(b, a % b);
        int g = result[0];   // PGCD
        int x = result[1];   // coefficient pour b
        int y = result[2];   // coefficient pour (a % b)

        // Mise à jour des coefficients
        int i = y;
        int j = x - (a / b) * y;

        return new int[]{g, i, j};
    }

    public static void main(String[] args) {
        int a = 252;
        int b = 198;

        int[] result = euclide(a, b);
        int g = result[0];
        int i = result[1];
        int j = result[2];

        System.out.println("Pour a = " + a + " et b = " + b + " :");
        System.out.println("PGCD (g) = " + g);
        System.out.println("Coefficients : i = " + i + ", j = " + j);
        System.out.println("Vérification : " + a + " * " + i + " + " + b + " * " + j + " = " + (a * i + b * j));
    }
}

