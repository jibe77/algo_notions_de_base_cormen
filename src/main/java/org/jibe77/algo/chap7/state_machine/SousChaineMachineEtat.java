package org.jibe77.algo.chap7.state_machine;

/**
 * Voici un algorithme en Java qui implémente la recherche d’une sous-chaîne dans une chaîne
 * en utilisant une machine à états finis. Cet exemple utilise l’approche de
 * l’algorithme Knuth-Morris-Pratt (KMP), qui construit un tableau des “longueurs des préfixes”
 * pour gérer efficacement les transitions d’état.
 */
public class SousChaineMachineEtat {

    // Méthode principale
    public static void main(String[] args) {
        String texte = "abracadabra";
        String motif = "cad";

        int index = rechercheSousChaine(texte, motif);

        if (index != -1) {
            System.out.println("Sous-chaîne trouvée à l'index : " + index);
        } else {
            System.out.println("Sous-chaîne non trouvée.");
        }
    }

    // Recherche d'une sous-chaîne en utilisant une machine à états
    public static int rechercheSousChaine(String texte, String motif) {
        int n = texte.length();
        int m = motif.length();

        if (m == 0) {
            return 0; // Sous-chaîne vide trouvée à l'index 0
        }

        // Construire le tableau des "longueurs des préfixes"
        int[] prefixTable = construireTablePrefixe(motif);

        int i = 0; // Index pour le texte
        int j = 0; // Index pour le motif

        while (i < n) {
            if (texte.charAt(i) == motif.charAt(j)) {
                i++;
                j++;

                // Si le motif complet est trouvé
                if (j == m) {
                    return i - m; // Retourne l'index de début du motif
                }
            } else {
                if (j > 0) {
                    j = prefixTable[j - 1]; // Revenir à l'état précédent
                } else {
                    i++; // Passer au caractère suivant dans le texte
                }
            }
        }

        return -1; // Motif non trouvé
    }

    // Construire le tableau des "longueurs des préfixes"
    public static int[] construireTablePrefixe(String motif) {
        int m = motif.length();
        int[] prefixTable = new int[m];
        int longueur = 0; // Longueur du préfixe le plus long
        int i = 1;

        prefixTable[0] = 0; // Le premier caractère a un préfixe de longueur 0

        while (i < m) {
            if (motif.charAt(i) == motif.charAt(longueur)) {
                longueur++;
                prefixTable[i] = longueur;
                i++;
            } else {
                if (longueur > 0) {
                    longueur = prefixTable[longueur - 1];
                } else {
                    prefixTable[i] = 0;
                    i++;
                }
            }
        }

        return prefixTable;
    }
}
