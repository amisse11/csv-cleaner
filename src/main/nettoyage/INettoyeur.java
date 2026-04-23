package main.nettoyage;

import model.FichierCSV;

// Contrat que tous les nettoyeurs doivent respecter
public interface INettoyeur {

    FichierCSV nettoyer(FichierCSV fichier);
}
