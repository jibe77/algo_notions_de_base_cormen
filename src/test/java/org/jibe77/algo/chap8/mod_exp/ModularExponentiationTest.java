package org.jibe77.algo.chap8.mod_exp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ModularExponentiationTest {

    @Test
    public void test2Puissance10Modulo1000() {
        // 2^10 = 1024, et 1024 mod 1000 = 24
        long x = 2;
        long d = 10;
        long n = 1000;
        long attendu = 24;
        long resultat = ModularExponentiation.modExp(x, d, n);
        assertEquals(attendu, resultat, "2^10 mod 1000 doit être égal à 24");
    }

    @Test
    public void test3Puissance20Modulo50() {
        // 3^20 mod 50
        // On peut vérifier que 3^20 mod 50 = 1
        long x = 3;
        long d = 20;
        long n = 50;
        long attendu = 1;
        long resultat = ModularExponentiation.modExp(x, d, n);
        assertEquals(attendu, resultat, "3^20 mod 50 doit être égal à 1");
    }

    @Test
    public void test5Puissance13Modulo19() {
        // 5^13 mod 19 doit être égal à 17 (calculé ou vérifié à l'avance)
        long x = 5;
        long d = 13;
        long n = 19;
        long attendu = 17;
        long resultat = ModularExponentiation.modExp(x, d, n);
        assertEquals(attendu, resultat, "5^13 mod 19 doit être égal à 17");
    }

    @Test
    public void testBasePlusGrandeQueModulo() {
        // Exemple : 7^5 mod 5
        // 7 mod 5 = 2 et 2^5 = 32, 32 mod 5 = 2
        long x = 7;
        long d = 5;
        long n = 5;
        long attendu = 2;
        long resultat = ModularExponentiation.modExp(x, d, n);
        assertEquals(attendu, resultat, "7^5 mod 5 doit être égal à 2");
    }

    @Test
    public void testGrandExposant() {
        // Exemple : 2^100 mod 13
        // En utilisant le petit théorème de Fermat (ou φ(13)=12), 2^100 mod 13 = 2^(100 mod 12) = 2^4 = 16 mod 13 = 3
        long x = 2;
        long d = 100;
        long n = 13;
        long attendu = 3;
        long resultat = ModularExponentiation.modExp(x, d, n);
        assertEquals(attendu, resultat, "2^100 mod 13 doit être égal à 3");
    }

    @Test
    public void test1() {
        // Exemple : 2^100 mod 13
        // En utilisant le petit théorème de Fermat (ou φ(13)=12), 2^100 mod 13 = 2^(100 mod 12) = 2^4 = 16 mod 13 = 3
        long x = 2;
        long d = 0;
        long n = 13;
        long attendu = 1;
        long resultat = ModularExponentiation.modExp(x, d, n);
        assertEquals(attendu, resultat, "2^0 mod 13 doit être égal à 1");
    }
}
