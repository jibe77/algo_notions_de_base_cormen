package org.jibe77.algo.chap2;

public class InvariantDeBoucle {

    /**
     * Un invariant de boucle est une propriété constante qui permet de démontrer la validité d'une boucle
     * @param args
     */
    public static void main(String ... args) {
        lancementBoucle();
    }

    /**
     * La variable "somme" est un invariant de boucle car elle contient la somme des entiers de 1 à i-1.
     *
     * Avant l'entrée dans la boucle : i=1, donc la somme des entiers jusqu'à i−1 est 0, ce qui est vrai.
     * Pendant chaque itération : on ajoute i à la somme, puis on incrémente i, ce qui maintient l'invariant.
     * À la sortie de la boucle : Lorsque i>n, la valeur de somme contient bien la somme des entiers de 1 à n.
     * @return
     */
    private static int lancementBoucle() {
        int somme = 0;
        int i = 1;
        while (i <= 500) {
            somme = somme + i;
            i = i + 1;
        }
        return somme;
    }
}
