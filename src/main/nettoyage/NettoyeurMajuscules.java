package main.nettoyage;

// Convertit chaque valeur en majuscules
public class NettoyeurMajuscules extends NettoyeurAbstrait {

    public NettoyeurMajuscules() {
        super("Nettoyeur majuscules");
    }

    @Override
    protected String nettoyerCase(String valeur) {
        if (valeur == null) {
            return null;
        }
        return valeur.toUpperCase();
    }
}