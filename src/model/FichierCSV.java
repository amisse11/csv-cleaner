package model;

import java.util.ArrayList;
import java.util.List;

// Représente un fichier CSV chargé en mémoire (entêtes + lignes de données)
public class FichierCSV {

    private final List<String[]> lignes;
    private String[] entetes;

    // Constructeur : initialise la liste vide
    public FichierCSV() {
        this.lignes = new ArrayList<>();
    }

    // Getters / Setters

    public String[] getEntetes() {
        return entetes;
    }

    public void setEntetes(String[] entetes) {
        this.entetes = entetes;
    }

    public List<String[]> getLignes() {
        return lignes;
    }

    // Ajoute une ligne de données
    public void ajouterLigne(String[] ligne) {
        this.lignes.add(ligne);
    }

    // Retourne le nombre de lignes de données (sans compter les entêtes)
    public int getNombreLignes() {
        return lignes.size();
    }

    // Retourne le nombre de colonnes (basé sur les entêtes)
    public int getNombreColonnes() {
        if (entetes == null) {
            return 0;
        }
        return entetes.length;
    }
}
