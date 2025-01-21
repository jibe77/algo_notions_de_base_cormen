package org.jibe77.algo.chap5.chemin.topologique;

import java.util.*;

// Classe pour représenter un graphe
public class TriTopologique {

    private int sommets; // Nombre de sommets
    private LinkedList<Integer>[] listeAdjacence; // Liste d'adjacence

    // Constructeur
    public TriTopologique(int sommets) {
        this.sommets = sommets;
        listeAdjacence = new LinkedList[sommets];
        for (int i = 0; i < sommets; i++) {
            listeAdjacence[i] = new LinkedList<>();
        }
    }

    // Ajouter une arête au graphe
    public void ajouterArete(int source, int cible) {
        listeAdjacence[source].add(cible);
    }

    // Méthode pour effectuer un tri topologique
    public List<Integer> effectuerTriTopologique() {
        boolean[] visites = new boolean[sommets];
        Stack<Integer> pile = new Stack<>();

        // Parcourir tous les sommets
        for (int i = 1; i < sommets; i++) {
            if (!visites[i]) {
                triTopologiqueRecursif(i, visites, pile);
            }
        }

        // Récupérer l'ordre du tri topologique
        List<Integer> resultat = new ArrayList<>();
        while (!pile.isEmpty()) {
            resultat.add(pile.pop());
        }
        return resultat;
    }

    // Méthode utilitaire pour le tri topologique (DFS)
    private void triTopologiqueRecursif(int sommet, boolean[] visites, Stack<Integer> pile) {
        visites[sommet] = true;

        // Parcourir les voisins
        for (int voisin : listeAdjacence[sommet]) {
            if (!visites[voisin]) {
                triTopologiqueRecursif(voisin, visites, pile);
            }
        }

        // Ajouter le sommet à la pile une fois ses voisins traités
        pile.push(sommet);
    }
}
