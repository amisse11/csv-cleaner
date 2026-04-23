package main.nettoyage;

// Remplace les valeurs manquantes par une valeur par défaut
public class NettoyeurValeursManquantes extends NettoyeurAbstrait {

    private String remplacement;

    public NettoyeurValeursManquantes(String remplacement) {
        super("Nettoyeur valeurs manquantes");
        this.remplacement = remplacement;
    }

    @Override
    protected String nettoyerCase(String valeur) {
        if (valeur == null || valeur.trim().isEmpty()) {
            return remplacement;
        }
        return valeur;
    }
}
