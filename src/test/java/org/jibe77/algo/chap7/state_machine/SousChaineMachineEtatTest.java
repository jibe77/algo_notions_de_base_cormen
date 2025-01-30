package org.jibe77.algo.chap7.state_machine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SousChaineMachineEtatTest {

    @Test
    void testSousChaineTrouvee() {
        String texte = "abracadabra";
        String motif = "cad";
        int resultat = SousChaineMachineEtat.rechercheSousChaine(texte, motif);
        assertEquals(4, resultat, "La sous-chaîne 'cad' devrait être trouvée à l'index 4.");
    }

    @Test
    void testSousChaineNonTrouvee() {
        String texte = "abracadabra";
        String motif = "xyz";
        int resultat = SousChaineMachineEtat.rechercheSousChaine(texte, motif);
        assertEquals(-1, resultat, "La sous-chaîne 'xyz' ne devrait pas être trouvée.");
    }

    @Test
    void testMotifVide() {
        String texte = "abracadabra";
        String motif = "";
        int resultat = SousChaineMachineEtat.rechercheSousChaine(texte, motif);
        assertEquals(0, resultat, "Un motif vide devrait toujours être trouvé à l'index 0.");
    }

    @Test
    void testTexteVide() {
        String texte = "";
        String motif = "abc";
        int resultat = SousChaineMachineEtat.rechercheSousChaine(texte, motif);
        assertEquals(-1, resultat, "Si le texte est vide, aucun motif ne peut être trouvé.");
    }

    @Test
    void testMotifPlusLongQueTexte() {
        String texte = "short";
        String motif = "longer";
        int resultat = SousChaineMachineEtat.rechercheSousChaine(texte, motif);
        assertEquals(-1, resultat, "Un motif plus long que le texte ne peut pas être trouvé.");
    }

    @Test
    void testSousChaineEnDebut() {
        String texte = "abracadabra";
        String motif = "abra";
        int resultat = SousChaineMachineEtat.rechercheSousChaine(texte, motif);
        assertEquals(0, resultat, "La sous-chaîne 'abra' devrait être trouvée à l'index 0.");
    }

    @Test
    void testSousChaineEnFin() {
        String texte = "abracadabra";
        String motif = "bra";
        int resultat = SousChaineMachineEtat.rechercheSousChaine(texte, motif);
        assertEquals(1, resultat, "La sous-chaîne 'bra' devrait être trouvée à l'index 1.");
    }
}
