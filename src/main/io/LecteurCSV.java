package main.io;

// Lit un fichier CSV depuis le disque et retourne un FichierCSV
public class LecteurCSV implements ILecteur {

    private String separateur;

    public LecteurCSV(String separateur) {
        this.separateur = separateur;
    }

    @Override
    public model.FichierCSV lire(String chemin) {
        model.FichierCSV fichier = new model.FichierCSV();

        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(chemin));

            String premiereLigne = reader.readLine();
            if (premiereLigne == null) {
                reader.close();
                throw new RuntimeException("Le fichier est vide : " + chemin);
            }

            fichier.setEntetes(premiereLigne.split(separateur, -1));

            String ligne;
            while ((ligne = reader.readLine()) != null) {
                fichier.ajouterLigne(ligne.split(separateur, -1));
            }

            reader.close();
        } catch (java.io.IOException e) {
            throw new RuntimeException("Erreur de lecture du fichier CSV : " + e.getMessage());
        }

        return fichier;
    }
}
