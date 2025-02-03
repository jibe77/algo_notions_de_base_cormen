package org.jibe77.algo.chap9.hufman;

import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;

public class HuffmanCoding {

    /**
     * Classe représentant un nœud dans l'arbre de Huffman.
     * Un nœud peut être une feuille (contenant un caractère) ou un nœud interne.
     */
    static class Node implements Comparable<Node> {
        char character;      // Caractère associé (uniquement pour les feuilles)
        int frequency;       // Fréquence d'apparition du caractère ou somme des fréquences pour les nœuds internes
        Node left, right;    // Fils gauche et droit

        // Constructeur pour une feuille
        Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        // Constructeur pour un nœud interne
        Node(int frequency, Node left, Node right) {
            this.character = '\0'; // caractère nul pour les nœuds internes
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        // Vérifie si le nœud est une feuille (aucun enfant)
        boolean isLeaf() {
            return (left == null) && (right == null);
        }

        // Pour ordonner les nœuds par fréquence dans la file de priorité
        @Override
        public int compareTo(Node other) {
            return this.frequency - other.frequency;
        }
    }

    /**
     * Construit l'arbre de Huffman à partir d'une table de fréquence.
     *
     * @param frequencyMap une Map associant chaque caractère à sa fréquence
     * @return la racine de l'arbre de Huffman
     */
    public static Node buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        // Utilisation d'une file de priorité qui trie les nœuds par fréquence croissante
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Créer un nœud feuille pour chaque caractère et l'ajouter à la file
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        // Combiner les nœuds jusqu'à ce qu'il ne reste qu'un seul nœud (la racine)
        while (pq.size() > 1) {
            Node left = pq.poll();   // Nœud de plus petite fréquence
            Node right = pq.poll();  // Deuxième nœud de plus petite fréquence
            Node parent = new Node(left.frequency + right.frequency, left, right);
            pq.add(parent);
        }

        // Le dernier nœud est la racine de l'arbre de Huffman
        return pq.poll();
    }

    /**
     * Génère les codes de Huffman pour chaque caractère en parcourant l'arbre.
     *
     * @param node         le nœud courant de l'arbre
     * @param code         le code accumulé jusqu'à présent
     * @param huffmanCodes la Map qui associera chaque caractère à son code
     */
    public static void generateHuffmanCodes(Node node, String code, Map<Character, String> huffmanCodes) {
        if (node == null) {
            return;
        }

        // Si le nœud est une feuille, on a trouvé le code pour ce caractère
        if (node.isLeaf()) {
            // Dans le cas particulier où l'arbre ne contient qu'un seul caractère,
            // on lui attribue le code "0"
            if (code.length() == 0) {
                code = "0";
            }
            huffmanCodes.put(node.character, code);
        }

        // Parcours récursif de l'arbre en ajoutant "0" pour le branchement gauche et "1" pour le droit
        generateHuffmanCodes(node.left, code + "0", huffmanCodes);
        generateHuffmanCodes(node.right, code + "1", huffmanCodes);
    }

    /**
     * Exemple d'utilisation : lecture d'un texte, construction de l'arbre de Huffman,
     * génération et affichage des codes, et encodage du texte.
     */
    public static void main(String[] args) {
        // Exemple de texte à encoder
        String texte = "exemple de texte pour l'arbre de Huffman";
        System.out.println("Texte original : " + texte);

        // Calculer la fréquence d'apparition de chaque caractère dans le texte
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : texte.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Afficher la table des fréquences
        System.out.println("Fréquences :");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }

        // Construire l'arbre de Huffman à partir de la table de fréquence
        Node root = buildHuffmanTree(frequencyMap);

        // Générer les codes de Huffman pour chaque caractère
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodes);

        // Afficher les codes de Huffman obtenus
        System.out.println("\nCodes de Huffman :");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println("'" + entry.getKey() + "' : " + entry.getValue());
        }

        // Encoder le texte original en utilisant les codes de Huffman
        StringBuilder encodedText = new StringBuilder();
        for (char c : texte.toCharArray()) {
            encodedText.append(huffmanCodes.get(c));
        }
        System.out.println("\nTexte encodé : " + encodedText.toString());
    }
}
