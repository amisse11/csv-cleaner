package main.io;

// Contrat pour tout écrivain de fichier
public interface IEcrivain {

    void ecrire(model.FichierCSV fichier, String chemin);
}
