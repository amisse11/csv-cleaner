package main.io;

// Écrit un FichierCSV sur le disque
public class EcrivainCSV implements IEcrivain {

    private String separateur;

    public EcrivainCSV(String separateur) {
        this.separateur = separateur;
    }

    @Override
    public void ecrire(model.FichierCSV fichier, String chemin) {
        try {
            java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(chemin));

            writer.write(String.join(separateur, fichier.getEntetes()));
            writer.newLine();

            for (String[] ligne : fichier.getLignes()) {
                writer.write(String.join(separateur, ligne));
                writer.newLine();
            }

            writer.close();
        } catch (java.io.IOException e) {
            throw new RuntimeException("Erreur d'ecriture du fichier CSV : " + e.getMessage());
        }
    }
}
