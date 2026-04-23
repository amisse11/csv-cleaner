package main.service;

import java.util.ArrayList;
import java.util.List;

import main.io.IEcrivain;
import main.io.ILecteur;
import main.nettoyage.INettoyeur;
import model.FichierCSV;

// Orchestre la lecture, le nettoyage et l'écriture du fichier CSV
public class ServiceNettoyage {

    private final ILecteur lecteur;
    private final IEcrivain ecrivain;
    private final List<INettoyeur> nettoyeurs;

    // Injection de dépendances : on passe les composants depuis l'extérieur
    public ServiceNettoyage(ILecteur lecteur, IEcrivain ecrivain) {
        if (lecteur == null || ecrivain == null) {
            throw new IllegalArgumentException("Lecteur et ecrivain sont obligatoires");
        }
        this.lecteur = lecteur;
        this.ecrivain = ecrivain;
        this.nettoyeurs = new ArrayList<>();
    }

    // Ajoute un nettoyeur à la chaîne de traitement
    public void ajouterNettoyeur(INettoyeur nettoyeur) {
        if (nettoyeur == null) {
            throw new IllegalArgumentException("Le nettoyeur ne peut pas etre null");
        }
        nettoyeurs.add(nettoyeur);
    }

    // Lit, nettoie et sauvegarde le fichier
    public void traiter(String cheminEntree, String cheminSortie) {
        if (cheminEntree == null || cheminEntree.trim().isEmpty()) {
            throw new IllegalArgumentException("Chemin d'entree invalide");
        }
        if (cheminSortie == null || cheminSortie.trim().isEmpty()) {
            throw new IllegalArgumentException("Chemin de sortie invalide");
        }

        FichierCSV fichier = lecteur.lire(cheminEntree);

        // Applique chaque nettoyeur dans l'ordre d'ajout
        for (INettoyeur nettoyeur : nettoyeurs) {
            nettoyeur.nettoyer(fichier);
        }

        ecrivain.ecrire(fichier, cheminSortie);
    }
}
