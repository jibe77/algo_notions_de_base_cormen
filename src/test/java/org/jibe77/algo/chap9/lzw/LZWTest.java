package org.jibe77.algo.chap9.lzw;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LZWTest {

    /**
     * Teste que la compression puis la décompression d'une chaîne
     * retourne bien la chaîne d'origine.
     */
    @Test
    public void testCompressDecompress() {
        String input = "TOBEORNOTTOBEORTOBEORNOT";
        List<Integer> compressed = LZW.compress(input);
        String decompressed = LZW.decompress(compressed);
        assertEquals(input, decompressed, "La chaîne décompressée doit être identique à l'originale.");
    }

    /**
     * Teste la compression et décompression d'une chaîne vide.
     * On s'attend à obtenir une liste vide lors de la compression
     * et une chaîne vide lors de la décompression.
     */
    @Test
    public void testEmptyString() {
        String input = "";
        List<Integer> compressed = LZW.compress(input);
        // On attend une liste vide pour une chaîne vide
        assertTrue(compressed.isEmpty(), "La compression d'une chaîne vide doit renvoyer une liste vide.");

        // Pour que ce test réussisse, la méthode decompress doit gérer l'entrée vide.
        String decompressed = LZW.decompress(compressed);
        assertEquals(input, decompressed, "La décompression d'une liste vide doit renvoyer une chaîne vide.");
    }

    /**
     * Teste la compression et décompression d'une chaîne composée d'un seul caractère répété.
     */
    @Test
    public void testSingleCharacterString() {
        String input = "AAAAAAA";
        List<Integer> compressed = LZW.compress(input);
        String decompressed = LZW.decompress(compressed);
        assertEquals(input, decompressed, "La chaîne décompressée doit être identique à l'originale pour une chaîne répétitive.");
    }

    /**
     * Teste la compression et décompression d'une chaîne contenant plusieurs motifs.
     */
    @Test
    public void testRepeatedPattern() {
        String input = "ABABABAABAB";
        List<Integer> compressed = LZW.compress(input);
        String decompressed = LZW.decompress(compressed);
        assertEquals(input, decompressed, "La décompression doit retrouver la chaîne d'origine.");
    }

    /**
     * Teste la compression et décompression d'une chaîne avec des caractères non-ASCII.
     */
    @Test
    public void testNonAsciiCharacters() {
        String input = "ééééééééé";
        List<Integer> compressed = LZW.compress(input);
        String decompressed = LZW.decompress(compressed);
        assertEquals(input, decompressed, "La décompression doit gérer correctement les caractères non-ASCII.");
    }

    /**
     * Teste que la décompression lève une exception en cas de code compressé invalide.
     * On crée une liste contenant un code qui n'appartient pas au dictionnaire initial.
     */
    @Test
    public void testDecompressInvalidInput() {
        List<Integer> invalidCompressed = new ArrayList<>();
        // On ajoute un code qui dépasse la plage des codes ASCII initiaux (0-255)
        invalidCompressed.add(9999);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LZW.decompress(invalidCompressed);
        });
        assertTrue(exception.getMessage().contains("Code compressé invalide"),
                "Une IllegalArgumentException avec le message approprié doit être levée pour un code invalide.");
    }
}
