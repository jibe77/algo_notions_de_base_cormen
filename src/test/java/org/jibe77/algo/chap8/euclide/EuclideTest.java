package org.jibe77.algo.chap8.euclide;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EuclideTest {

    @Test
    public void testCasGeneral() {
        // Exemple avec a = 252 et b = 198
        int a = 252;
        int b = 198;
        int[] result = Euclide.euclide(a, b);
        int g = result[0];
        int i = result[1];
        int j = result[2];

        // Vérifie que g = a * i + b * j
        assertEquals(a * i + b * j, g, "L'égalité g = a*i + b*j n'est pas respectée.");
        // Vérifie que le PGCD est bien 18
        assertEquals(18, g, "Le PGCD attendu est 18.");
    }

    @Test
    public void testCasSimple() {
        // Exemple avec a = 12 et b = 18, pour lequel le PGCD attendu est 6
        int a = 12;
        int b = 18;
        int[] result = Euclide.euclide(a, b);
        int g = result[0];
        int i = result[1];
        int j = result[2];

        assertEquals(a * i + b * j, g, "L'égalité g = a*i + b*j n'est pas respectée.");
        assertEquals(6, g, "Le PGCD attendu est 6.");
    }

    @Test
    public void testCasBaseBZero() {
        // Test du cas de base : b == 0
        int a = 17;
        int b = 0;
        int[] result = Euclide.euclide(a, b);
        int g = result[0];
        int i = result[1];
        int j = result[2];

        // Dans ce cas, g doit être égal à a, i doit être 1 et j 0
        assertEquals(a, g, "Pour b=0, le PGCD doit être égal à a.");
        assertEquals(1, i, "Pour b=0, i doit être 1.");
        assertEquals(0, j, "Pour b=0, j doit être 0.");
        assertEquals(a * i + b * j, g, "L'égalité g = a*i + b*j n'est pas respectée.");
    }

    @Test
    public void testCasAZero() {
        // Test lorsque a = 0 et b != 0
        int a = 0;
        int b = 5;
        int[] result = Euclide.euclide(a, b);
        int g = result[0];
        int i = result[1];
        int j = result[2];

        // Dans ce cas, le PGCD doit être égal à b et l'égalité 0*i + b*j = g doit être vérifiée.
        assertEquals(b, g, "Le PGCD de (0, b) doit être égal à b.");
        assertEquals(0 * i + b * j, g, "L'égalité g = a*i + b*j n'est pas respectée.");
        // Selon l'implémentation attendue, on devrait obtenir j = 1.
        assertEquals(1, j, "Pour a=0, j devrait être 1.");
    }

    @Test
    public void testCasLivre() {
        // Exemple avec a = 252 et b = 198
        int a = 30;
        int b = 18;
        int[] result = Euclide.euclide(a, b);
        int g = result[0];
        int i = result[1];
        int j = result[2];

        // Vérifie que g = a * i + b * j
        assertEquals(a * i + b * j, g, "L'égalité g = a*i + b*j n'est pas respectée.");
        // Vérifie que le PGCD est bien 6
        assertEquals(6, g, "Le PGCD attendu est 18.");
    }
}
