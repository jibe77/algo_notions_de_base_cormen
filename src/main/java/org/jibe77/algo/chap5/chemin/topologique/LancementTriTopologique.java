package org.jibe77.algo.chap5.chemin.topologique;

public class LancementTriTopologique {
    // Méthode principale pour tester
    public static void main(String[] args) {
        TriTopologique graphe = new TriTopologique(15);

        // Ajouter des arêtes au graphe
        graphe.ajouterArete(1, 3);
        graphe.ajouterArete(2, 4);
        graphe.ajouterArete(3, 4);
        graphe.ajouterArete(3, 5);
        graphe.ajouterArete(4, 6);
        graphe.ajouterArete(5, 6);
        graphe.ajouterArete(6, 7);
        graphe.ajouterArete(6, 11);
        graphe.ajouterArete(7, 8);
        graphe.ajouterArete(8, 13);
        graphe.ajouterArete(9, 10);
        graphe.ajouterArete(10, 11);
        graphe.ajouterArete(11, 12);
        graphe.ajouterArete(12, 13);
        graphe.ajouterArete(13, 14);

        System.out.println("Résultat du tri topologique : " + graphe.effectuerTriTopologique());
    }
}
