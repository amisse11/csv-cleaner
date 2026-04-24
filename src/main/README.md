**Application.java**

C'est le point d'entrée du programme. C'est ici que tout démarre quand on lance l'application.

**Ce qu'elle fait**

Elle attend deux arguments au lancement : le chemin du fichier CSV à nettoyer, et le chemin où sauvegarder le résultat.
Si ces deux arguments ne sont pas fournis, elle affiche un message d'utilisation et s'arrête.

Ensuite elle :

1. Lit le fichier d'entrée et affiche son contenu dans la console
2. Configure le service de nettoyage avec trois nettoyeurs, dans cet ordre :
    - NettoyeurValeursManquantes - remplace les cases vides par "N/A"
    - NettoyeurEspaces - supprime les espaces inutiles en début et fin de valeur
    - NettoyeurMajuscules - convertit toutes les valeurs en majuscules
3. Lance le traitement
4. Lit le fichier de sortie et affiche le résultat nettoyé dans la console

**Méthodes**

- main(String[] args) - point d'entrée, orchestre toutes les étapes
- afficherFichier(FichierCSV fichier) - méthode utilitaire privée qui affiche les entêtes et les lignes d'un fichier
  dans la console

**Gestion des erreurs**

Deux cas sont interceptés :

- IllegalArgumentException - paramètres invalides (ex. chemin vide)
- RuntimeException - erreur de lecture ou d'écriture du fichier

**Comment lancer le programme**

Dans IntelliJ, aller dans **Edit Configurations > Program arguments** et entrer :


src/main/entree.csv src/main/sortie.csv


Le fichier sortie.csv est créé automatiquement après le traitement.