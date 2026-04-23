package main.nettoyage;

import model.FichierCSV;

// Classe abstraite qui fournit la logique commune à tous les nettoyeurs
public abstract class NettoyeurAbstrait implements INettoyeur {

    protected String nom;

    public NettoyeurAbstrait(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    // Parcourt chaque case du fichier et applique le nettoyage
    @Override
    public FichierCSV nettoyer(FichierCSV fichier) {
        if (fichier == null) {
            throw new IllegalArgumentException("Le fichier ne peut pas être null");
        }
        for (String[] ligne : fichier.getLignes()) {
            for (int i = 0; i < ligne.length; i++) {
                ligne[i] = nettoyerCase(ligne[i]);
            }
        }
        return fichier;
    }

    // Chaque sous-classe définit comment nettoyer une seule case
    protected abstract String nettoyerCase(String valeur);
}
