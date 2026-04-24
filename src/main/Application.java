package main;

import main.io.EcrivainCSV;
import main.io.LecteurCSV;
import main.nettoyage.NettoyeurEspaces;
import main.nettoyage.NettoyeurMajuscules;
import main.nettoyage.NettoyeurValeursManquantes;
import main.service.ServiceNettoyage;
import model.FichierCSV;

// Point d'entrée du programme
public class Application {

    static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage : java Application <fichier_entree.csv> <fichier_sortie.csv>");
            return;
        }

        String cheminEntree = args[0];
        String cheminSortie = args[1];

        try {
            LecteurCSV lecteur = new LecteurCSV(",");
            EcrivainCSV ecrivain = new EcrivainCSV(",");

            // Affichage avant nettoyage
            System.out.println("=== AVANT NETTOYAGE ===");
            afficherFichier(lecteur.lire(cheminEntree));

            // Configuration du service
            ServiceNettoyage service = new ServiceNettoyage(lecteur, ecrivain);
            service.ajouterNettoyeur(new NettoyeurValeursManquantes("N/A"));
            service.ajouterNettoyeur(new NettoyeurEspaces());
            service.ajouterNettoyeur(new NettoyeurMajuscules());

            // Traitement
            service.traiter(cheminEntree, cheminSortie);

            // Affichage après nettoyage
            System.out.println("\n=== APRÈS NETTOYAGE ===");
            afficherFichier(lecteur.lire(cheminSortie));

            System.out.println("\nFichier nettoyé sauvegardé : " + cheminSortie);

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de configuration : " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erreur lors du traitement : " + e.getMessage());
        }
    }

    // Affiche le contenu d'un FichierCSV dans la console
    private static void afficherFichier(FichierCSV fichier) {
        System.out.println(String.join(" | ", fichier.getEntetes()));
        System.out.println("-".repeat(40));
        for (String[] ligne : fichier.getLignes()) {
            System.out.println(String.join(" | ", ligne));
        }
    }
}