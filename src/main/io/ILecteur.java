package main.io;

// Contrat pour tout lecteur de fichier
public interface ILecteur {

    model.FichierCSV lire(String chemin);
}
