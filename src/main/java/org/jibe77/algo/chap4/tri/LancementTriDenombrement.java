package org.jibe77.algo.chap4.tri;

import org.jibe77.algo.chap4.tri.impl.TriParDénombrement;

import java.util.Arrays;

public class LancementTriDenombrement {

    public static void main(String[] args) {
        int plage = 7;
        int[] tableauÀTrier = new int[] {4,1,5,0,1,6,5,1,5,3};
        int[] égal = TriParDénombrement.denombrerClésÉgales(tableauÀTrier, plage);
        int[] inférieur = TriParDénombrement.denombrerClésInférieures(égal, plage);
        /*
          renvoie les tableaux suivants :
            égal = [1, 3, 0, 1, 1, 3, 1]
            inférieur = [0, 1, 4, 4, 5, 6, 9]
         */
        System.out.println(Arrays.toString(égal));
        System.out.println(Arrays.toString(inférieur));

        int[] result = TriParDénombrement.réorganiser(tableauÀTrier, inférieur,plage);
        /*
          renvoie le tableau suivant qui est le tableau trié :
          [0, 1, 1, 1, 3, 4, 5, 5, 5, 6]
         */
        System.out.println(Arrays.toString(result));
        // les trois opérations sont compilées dans la même méthodes "dénombrement" :
        System.out.println(Arrays.toString(TriParDénombrement.denombrement(tableauÀTrier, plage)));
    }
}
