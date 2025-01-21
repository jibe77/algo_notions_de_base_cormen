package org.jibe77.algo.chap4.tri.impl;

import java.util.Arrays;

public class TriParDénombrement {

    /**
     * @param tableauÀTrier tableau d'entiers
     * @param plage définit la plage de valeurs dans a
     * @return retourne un tableau contenant le nombre d'éléments de a égaux à j, pour j = 0,1,2,...,m-1
     */
    public static int[] denombrerClésÉgales(int[] tableauÀTrier, int plage) {
        // 1. créer un tableau egal de taille 'plage'
        int[] egal = new int[plage];
        // 2. fixer toutes les valeurs de egal à 0
        for (int i = 0; i < egal.length; i++) {
            egal[i] = 0;
        }
        // 3. pour i = 0 à a.length :
        for (int i = 0; i < tableauÀTrier.length;i++) {
            // a. fixer clé à a[i]
            int clé = tableauÀTrier[i];
            // b. incrémenter egal[clé]
            egal[clé]++;

        }
        // 4. retourner le tableau égal
        return egal;
    }

    /**
     *
     * @param egal tableau retourné par la méthode denombrerClésÉgales
     * @param plage définit la plage de valeurs dans le tableau egal tel que egal[0...m-1]
     * @return un tableau inférieur tel que inférieur[0..m-1] et inférieur[j] contient la somme de egal[0]+egal[1]+...+egal[j-1]
     */
    public static int[] denombrerClésInférieures(int[] egal, int plage) {
        // 1. créer un tableau inférieur
        int[] inférieur = new int[plage];
        // 2. fixer inférieur[0] à 0
        inférieur[0] = 0;
        // 3. pour j = 1 à j = plage-1
        for (int j = 1 ; j < plage; j++) {
            // a. fixer inférieur[j] à inférieur[j-1]+egal[j-1]
            inférieur[j] = inférieur[j-1]+egal[j-1];
        }
        return inférieur;
    }

    /**
     * effectue une tri sur le tableau passé en paramètre afin de le réorganiser
     * @param tableauÀTrier tableau d'entiers dans la plage 0 à plage -1
     * @param inférieur tableau retourné par la méthode 'denombrerClésInférieures'
     * @param plage définit la plage des valeurs dans tableauÀTrier
     * @return un tableau qui contient les éléments de tableauÀTrier triés.
     */
    public static int[] réorganiser(int[] tableauÀTrier, int[] inférieur, int plage) {
        // 1. créer les tableaux tableauARetourner et 'suivant'
        int[] tableauARetourner = new int[tableauÀTrier.length];
        int[] suivant = new int[plage];
        // 2. pour j = 0 à plage-1
        for (int j = 0 ; j < plage ; j++) {
            // A. fixer suivant[j] à inférieur[j]+1
            suivant[j] = inférieur[j] + 1;
        }
        // 3. pour i=1 à n:
        for (int i = 0; i < tableauÀTrier.length  ; i++) {
            // A. fixer clé à tableauÀTrier[i]
            int clé = tableauÀTrier[i];
            // B. fixer indice à suivant[clé]
            int indice = suivant[clé];
            // C. fixer tableauARetourner[indice] à tableauÀTrier[i]
            tableauARetourner[indice - 1] = tableauÀTrier[i];
            // D. incrémenter suivant[clé]
            suivant[clé]++;
        }

        // 4. Retourner le tableau
        return tableauARetourner;
    }

    /**
     * Réuni les trois méthodes précédentes pour créer le tri par dénombrement
     * @param tableauÀTrier tableau d'entiers dans la plage définie par le paramètre 'plage'
     * @param plage définit la plage des valeurs dans tableauÀTrier
     * @return un tableau qui contient les éléments de tableauÀTrier triés
     */
    public static int[] denombrement(int[] tableauÀTrier, int plage) {
        // 1. appeler "dénombrerClésÉgales"
        int[] egal = denombrerClésÉgales(tableauÀTrier, plage);
        // 2. appeler "dénombrerClésInférieures"
        int[] inférieur = denombrerClésInférieures(egal, plage);
        // 3. appeler "régorganiser"
        return réorganiser(tableauÀTrier, inférieur, plage);

    }
}
