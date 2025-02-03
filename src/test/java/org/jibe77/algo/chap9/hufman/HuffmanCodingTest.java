package org.jibe77.algo.chap9.hufman;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class HuffmanCodingTest {

    /**
     * Vérifie que pour une table de fréquence ne contenant qu'un seul caractère,
     * l'algorithme assigne le code "0".
     */
    @Test
    public void testSingleCharacterHuffman() {
        // Table de fréquence avec un seul caractère
        Map<Character, Integer> freqMap = new HashMap<>();
        freqMap.put('a', 5);

        // Construction de l'arbre et génération des codes
        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(freqMap);
        Map<Character, String> codes = new HashMap<>();
        HuffmanCoding.generateHuffmanCodes(root, "", codes);

        // On doit obtenir un unique code pour 'a' égal à "0"
        assertEquals(1, codes.size(), "Il ne doit y avoir qu'un seul code");
        assertTrue(codes.containsKey('a'), "Le code pour 'a' doit être présent");
        assertEquals("0", codes.get('a'), "Pour un seul caractère, le code doit être '0'");
    }

    /**
     * Vérifie que la fréquence stockée dans la racine de l'arbre est égale à la somme
     * de toutes les fréquences.
     */
    @Test
    public void testHuffmanTreeFrequencySum() {
        Map<Character, Integer> freqMap = new HashMap<>();
        freqMap.put('a', 5);
        freqMap.put('b', 9);
        freqMap.put('c', 12);
        freqMap.put('d', 13);
        freqMap.put('e', 16);
        freqMap.put('f', 45);

        int totalFreq = 5 + 9 + 12 + 13 + 16 + 45;

        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(freqMap);
        assertEquals(totalFreq, root.frequency, "La fréquence à la racine doit être la somme des fréquences");
    }

    /**
     * Vérifie que pour une table de fréquence donnée :
     * - Chaque caractère obtient un code non vide.
     * - L'ensemble des codes générés est préfixe-libre (aucun code n'est préfixe d'un autre).
     */
    @Test
    public void testHuffmanCodesNonEmptyAndPrefixFree() {
        Map<Character, Integer> freqMap = new HashMap<>();
        freqMap.put('a', 5);
        freqMap.put('b', 9);
        freqMap.put('c', 12);
        freqMap.put('d', 13);
        freqMap.put('e', 16);
        freqMap.put('f', 45);

        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(freqMap);
        Map<Character, String> codes = new HashMap<>();
        HuffmanCoding.generateHuffmanCodes(root, "", codes);

        // Vérification que chaque caractère possède bien un code non vide
        for (char c : freqMap.keySet()) {
            assertTrue(codes.containsKey(c), "Le code pour le caractère '" + c + "' est manquant.");
            String code = codes.get(c);
            assertFalse(code.isEmpty(), "Le code pour le caractère '" + c + "' ne doit pas être vide.");
        }

        // Vérification de la propriété préfixe-libre
        Set<Character> characters = freqMap.keySet();
        for (char c1 : characters) {
            for (char c2 : characters) {
                if (c1 != c2) {
                    String code1 = codes.get(c1);
                    String code2 = codes.get(c2);
                    // On s'assure que ni code1 n'est préfixe de code2 ni l'inverse
                    assertFalse(isPrefix(code1, code2),
                            "Le code pour '" + c1 + "' (" + code1 + ") ne doit pas être préfixe du code pour '" + c2 + "' (" + code2 + ").");
                    assertFalse(isPrefix(code2, code1),
                            "Le code pour '" + c2 + "' (" + code2 + ") ne doit pas être préfixe du code pour '" + c1 + "' (" + code1 + ").");
                }
            }
        }
    }

    /**
     * Vérifie que l'encodage d'un texte donné à l'aide des codes de Huffman ne renvoie pas une chaîne vide.
     */
    @Test
    public void testEncodeText() {
        String text = "huffman";

        // Construction de la table de fréquence pour le texte
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        HuffmanCoding.Node root = HuffmanCoding.buildHuffmanTree(freqMap);
        Map<Character, String> codes = new HashMap<>();
        HuffmanCoding.generateHuffmanCodes(root, "", codes);

        // Encodage du texte
        StringBuilder encoded = new StringBuilder();
        for (char c : text.toCharArray()) {
            String code = codes.get(c);
            assertNotNull(code, "Aucun code trouvé pour le caractère '" + c + "'");
            encoded.append(code);
        }

        assertFalse(encoded.toString().isEmpty(), "Le texte encodé ne doit pas être vide.");
    }

    /**
     * Méthode utilitaire pour vérifier si une chaîne est préfixe d'une autre.
     *
     * @param prefix la chaîne potentiellement préfixe
     * @param s la chaîne à tester
     * @return true si 'prefix' est préfixe de 's', false sinon
     */
    private boolean isPrefix(String prefix, String s) {
        return s.startsWith(prefix);
    }
}

