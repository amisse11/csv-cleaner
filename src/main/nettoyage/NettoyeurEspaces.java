package main.nettoyage;

// Supprime les espaces en début et en fin de chaque valeur
public class NettoyeurEspaces extends NettoyeurAbstrait {

    public NettoyeurEspaces() {
        super("Nettoyeur d'espaces");
    }

    @Override
    protected String nettoyerCase(String valeur) {
        if (valeur == null) {
            return null;
        }
        return valeur.trim();
    }
}