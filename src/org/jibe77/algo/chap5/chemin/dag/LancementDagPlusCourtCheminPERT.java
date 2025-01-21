package org.jibe77.algo.chap5.chemin.dag;

import java.util.*;

public class LancementDagPlusCourtCheminPERT {

    public static final String AJOUTER_L_AIL_ET_LE_GINGEMBRE = "Ajouter l'ail et le gingembre";
    public static final String DÉPART = "Départ";
    public static final String PRÉPARER_LA_MARINADE = "Préparer la marinade";
    public static final String DÉCOUPER_LE_POULET = "Découper le poulet";
    public static final String FAIRE_MARINER_LE_POULET = "Faire mariner le poulet";
    public static final String HACHER_L_AIL = "Hacher l'ail";
    public static final String HACHER_LE_GINGEMBRE = "Hacher le gingembre";
    public static final String COMMENCER_LA_CUISSON_DU_POULET = "Commencer la cuisson du poulet";
    public static final String TERMINER_LA_CUISSON_DU_POULET = "Terminer la cuisson du poulet";
    public static final String ÉMINCER_LES_CAROTTES = "Émincer les carottes";
    public static final String ÉMINCER_LE_CÉLÉRI = "Émincer le céléri";
    public static final String RINCER_LES_NOISETTES = "Rincer les noisettes";
    public static final String RETIRER_LE_POULET = "Retirer le poulet";
    public static final String CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES = "Cuire les carottes, le céléri et les noisettes";
    public static final String MÉLANGER_LA_SAUCE_DE_CUISSON = "Mélanger la sauce de cuisson";
    public static final String REMETTRE_LE_POULET = "Remettre le poulet";
    public static final String AJOUTER_LA_SAUCE_DE_CUISSON = "Ajouter la sauce de cuisson";
    public static final String CUIRE_JUSQU_À_ÉPAISSISSEMENT = "Cuire jusqu'à épaississement";
    public static final String RETIRER_LE_PLAT_TERMINÉ = "Retirer le plat terminé";
    public static final String ARRIVÉE = "Arrivée";

    // Exemple d'utilisation
    public static void main(String[] args) {
        // Définir les sommets
        Set<String> sommets = new HashSet<>(Arrays.asList(
                DÉPART,
                PRÉPARER_LA_MARINADE,
                DÉCOUPER_LE_POULET,
                FAIRE_MARINER_LE_POULET,
                HACHER_L_AIL,
                HACHER_LE_GINGEMBRE,
                COMMENCER_LA_CUISSON_DU_POULET,
                AJOUTER_L_AIL_ET_LE_GINGEMBRE,
                TERMINER_LA_CUISSON_DU_POULET,
                ÉMINCER_LES_CAROTTES,
                ÉMINCER_LE_CÉLÉRI,
                RINCER_LES_NOISETTES,
                RETIRER_LE_POULET,
                CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES,
                MÉLANGER_LA_SAUCE_DE_CUISSON,
                REMETTRE_LE_POULET,
                AJOUTER_LA_SAUCE_DE_CUISSON,
                CUIRE_JUSQU_À_ÉPAISSISSEMENT,
                RETIRER_LE_PLAT_TERMINÉ,
                ARRIVÉE));

        // Définir la liste des arcs
        Map<String, List<String>> listArcs = new HashMap<>();
        listArcs.put(DÉPART, Arrays.asList(PRÉPARER_LA_MARINADE, DÉCOUPER_LE_POULET, HACHER_L_AIL, HACHER_LE_GINGEMBRE,ÉMINCER_LES_CAROTTES,ÉMINCER_LE_CÉLÉRI, RINCER_LES_NOISETTES, MÉLANGER_LA_SAUCE_DE_CUISSON));
        listArcs.put(PRÉPARER_LA_MARINADE, Arrays.asList(FAIRE_MARINER_LE_POULET));
        listArcs.put(DÉCOUPER_LE_POULET, Arrays.asList(FAIRE_MARINER_LE_POULET));
        listArcs.put(FAIRE_MARINER_LE_POULET, Arrays.asList(COMMENCER_LA_CUISSON_DU_POULET));
        listArcs.put(HACHER_L_AIL, Arrays.asList(AJOUTER_L_AIL_ET_LE_GINGEMBRE));
        listArcs.put(HACHER_LE_GINGEMBRE, Arrays.asList(AJOUTER_L_AIL_ET_LE_GINGEMBRE));
        listArcs.put(COMMENCER_LA_CUISSON_DU_POULET, Arrays.asList(AJOUTER_L_AIL_ET_LE_GINGEMBRE));
        listArcs.put(AJOUTER_L_AIL_ET_LE_GINGEMBRE,Arrays.asList(TERMINER_LA_CUISSON_DU_POULET));
        listArcs.put(TERMINER_LA_CUISSON_DU_POULET,Arrays.asList(RETIRER_LE_POULET));
        listArcs.put(RETIRER_LE_POULET,Arrays.asList(CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES));
        listArcs.put(ÉMINCER_LES_CAROTTES,Arrays.asList(CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES));
        listArcs.put(ÉMINCER_LE_CÉLÉRI,Arrays.asList(CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES));
        listArcs.put(RINCER_LES_NOISETTES,Arrays.asList(CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES));
        listArcs.put(CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES,Arrays.asList(REMETTRE_LE_POULET));
        listArcs.put(MÉLANGER_LA_SAUCE_DE_CUISSON,Arrays.asList(AJOUTER_LA_SAUCE_DE_CUISSON));
        listArcs.put(REMETTRE_LE_POULET,Arrays.asList(AJOUTER_LA_SAUCE_DE_CUISSON));
        listArcs.put(AJOUTER_LA_SAUCE_DE_CUISSON,Arrays.asList(CUIRE_JUSQU_À_ÉPAISSISSEMENT));
        listArcs.put(CUIRE_JUSQU_À_ÉPAISSISSEMENT,Arrays.asList(RETIRER_LE_PLAT_TERMINÉ));
        listArcs.put(RETIRER_LE_PLAT_TERMINÉ,Arrays.asList(ARRIVÉE));
        listArcs.put(ARRIVÉE, Collections.emptyList());

        // Définir les poids des arcs
        Map<String, Map<String, Double>> poids = new HashMap<>();
        poids.put(DÉPART, Map.of(PRÉPARER_LA_MARINADE, 2.0, DÉCOUPER_LE_POULET, 6.0, HACHER_L_AIL, 4.0,HACHER_LE_GINGEMBRE,3.0,ÉMINCER_LES_CAROTTES,4.0,ÉMINCER_LE_CÉLÉRI, 3.0, RINCER_LES_NOISETTES, 2.0, MÉLANGER_LA_SAUCE_DE_CUISSON, 3.0));
        poids.put(PRÉPARER_LA_MARINADE, Map.of(FAIRE_MARINER_LE_POULET, 15.0));
        poids.put(DÉCOUPER_LE_POULET, Map.of(FAIRE_MARINER_LE_POULET, 15.0));
        poids.put(FAIRE_MARINER_LE_POULET, Map.of(COMMENCER_LA_CUISSON_DU_POULET, 4.0));
        poids.put(HACHER_L_AIL, Map.of(AJOUTER_L_AIL_ET_LE_GINGEMBRE, 1.0));
        poids.put(HACHER_LE_GINGEMBRE, Map.of(AJOUTER_L_AIL_ET_LE_GINGEMBRE, 1.0));
        poids.put(COMMENCER_LA_CUISSON_DU_POULET, Map.of(AJOUTER_L_AIL_ET_LE_GINGEMBRE, 1.0));
        poids.put(AJOUTER_L_AIL_ET_LE_GINGEMBRE, Map.of(TERMINER_LA_CUISSON_DU_POULET, 2.0));
        poids.put(TERMINER_LA_CUISSON_DU_POULET, Map.of(RETIRER_LE_POULET, 1.0));
        poids.put(RETIRER_LE_POULET, Map.of(CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES, 4.0));
        poids.put(ÉMINCER_LES_CAROTTES, Map.of(CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES, 4.0));
        poids.put(ÉMINCER_LE_CÉLÉRI, Map.of(CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES, 4.0));
        poids.put(RINCER_LES_NOISETTES, Map.of(CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES, 4.0));
        poids.put(CUIRE_LES_CAROTTES_LE_CÉLÉRI_ET_LES_NOISETTES, Map.of(REMETTRE_LE_POULET, 1.0));
        poids.put(MÉLANGER_LA_SAUCE_DE_CUISSON, Map.of(AJOUTER_LA_SAUCE_DE_CUISSON, 1.0));
        poids.put(REMETTRE_LE_POULET, Map.of(AJOUTER_LA_SAUCE_DE_CUISSON, 1.0));
        poids.put(AJOUTER_LA_SAUCE_DE_CUISSON, Map.of(CUIRE_JUSQU_À_ÉPAISSISSEMENT, 3.0));
        poids.put(CUIRE_JUSQU_À_ÉPAISSISSEMENT, Map.of(RETIRER_LE_PLAT_TERMINÉ, 1.0));
        poids.put(RETIRER_LE_PLAT_TERMINÉ, Map.of(ARRIVÉE, 0.0));
        poids.put(ARRIVÉE, new HashMap<>());

        // Créer le graphe
        Graph G = new Graph(sommets, listArcs, poids);

        // Calculer les plus courts chemins depuis le sommet "DÉPART"
        Map<String, Object> result = DagPlusCourtChemin.dagPlusCourtChemin(G, DÉPART);

        // Afficher les résultats
        System.out.println("Distances les plus courtes : " + result.get("plusCourt"));
        System.out.println("Prédécesseurs : " + result.get("pred"));

        // Le plus court chemin entre le départ et l'arrivée est :
        //   - mélanger la sauce de cuisson (3)
        //   - ajouter la sauce de cuisson (1)
        //   - cuire jusqu'à épaississement (3)
        //   - retirer le plat terminé (1)
        // donc cela prend 8 unités de temps.
    }
}
