package org.jibe77.algo.chap9.lzw;

import java.util.*;

public class LZW {

    /**
     * Compresse une chaîne de caractères en utilisant l'algorithme LZW.
     *
     * @param uncompressed La chaîne à compresser.
     * @return Une liste d'entiers représentant la version compressée.
     */
    public static List<Integer> compress(String uncompressed) {
        // Initialisation du dictionnaire avec l'ensemble des caractères (ASCII 0-255)
        int dictSize = 256;
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < dictSize; i++) {
            dictionary.put("" + (char) i, i);
        }

        String w = "";
        List<Integer> result = new ArrayList<>();

        // Parcours de la chaîne d'entrée
        for (char c : uncompressed.toCharArray()) {
            String wc = w + c;
            if (dictionary.containsKey(wc)) {
                w = wc;
            } else {
                // Ajoute le code correspondant à w dans le résultat
                result.add(dictionary.get(w));
                // Ajoute la nouvelle séquence wc au dictionnaire
                dictionary.put(wc, dictSize++);
                w = "" + c;
            }
        }

        // Si w n'est pas vide, ajoute son code dans le résultat
        if (!w.isEmpty()) {
            result.add(dictionary.get(w));
        }
        return result;
    }

    /**
     * Décompresse une liste d'entiers obtenue par la compression LZW.
     *
     * @param compressed La liste des codes compressés.
     * @return La chaîne de caractères d'origine.
     */
    public static String decompress(List<Integer> compressed) {
        // Initialisation du dictionnaire avec l'ensemble des caractères (ASCII 0-255)
        int dictSize = 256;
        Map<Integer, String> dictionary = new HashMap<>();
        for (int i = 0; i < dictSize; i++) {
            dictionary.put(i, "" + (char) i);
        }

        // Gestion du cas d'une liste vide (optionnel selon le comportement souhaité)
        if (compressed == null || compressed.isEmpty()) {
            return "";
        }

        int index = 0;
        int firstCode = compressed.get(index++);

        // Vérification du premier code
        if (!dictionary.containsKey(firstCode)) {
            throw new IllegalArgumentException("Code compressé invalide : " + firstCode);
        }

        String w = dictionary.get(firstCode);
        StringBuilder result = new StringBuilder(w);

        while (index < compressed.size()) {
            int k = compressed.get(index++);
            String entry;
            if (dictionary.containsKey(k)) {
                entry = dictionary.get(k);
            } else if (k == dictSize) {
                // Cas particulier : la séquence est égale à w + le premier caractère de w
                entry = w + w.charAt(0);
            } else {
                throw new IllegalArgumentException("Code compressé invalide : " + k);
            }
            result.append(entry);
            // Ajoute la nouvelle séquence au dictionnaire
            dictionary.put(dictSize++, w + entry.charAt(0));
            w = entry;
        }
        return result.toString();
    }


    /**
     * Exemple d'utilisation de la compression et décompression LZW.
     */
    public static void main(String[] args) {
        String input = "TOBEORNOTTOBEORTOBEORNOT";
        System.out.println("Texte original : " + input);

        // Compression
        List<Integer> compressed = compress(input);
        System.out.println("Texte compressé : " + compressed);

        // Décompression
        String decompressed = decompress(compressed);
        System.out.println("Texte décompressé : " + decompressed);

        // Vérification
        if (input.equals(decompressed)) {
            System.out.println("La décompression a réussi !");
        } else {
            System.out.println("Erreur dans la décompression !");
        }
    }
}
