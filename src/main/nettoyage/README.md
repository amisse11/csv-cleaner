**Package nettoyage**

Ce package contient toute la logique de nettoyage des données du fichier CSV. Il est organisé en quatre classes qui
collaborent ensemble.

L'interface INettoyeur définit une seule méthode nettoyer() que chaque nettoyeur doit obligatoirement fournir. Ça
permet de brancher n'importe quel nettoyeur dans le reste du programme sans avoir à modifier le code existant.

La classe abstraite NettoyeurAbstrait implémente INettoyeur et se charge de parcourir chaque ligne et chaque colonne
du fichier pour appeler nettoyerCase() sur chaque valeur. Cette méthode est abstraite, ce qui force chaque sous-classe
à définir sa propre façon de traiter une valeur.

Trois nettoyeurs concrets héritent de NettoyeurAbstrait, chacun avec une responsabilité précise :

- **NettoyeurEspaces** supprime les espaces inutiles en début et en fin de chaque valeur
- **NettoyeurMajuscules** convertit toutes les valeurs en majuscules
- **NettoyeurValeursManquantes** remplace les cases vides ou nulles par une valeur par défaut, configurable à la
  création de l'objet

Chacun de ces nettoyeurs n'a qu'une seule méthode à écrire. Tout le reste est hérité automatiquement de
NettoyeurAbstrait, ce qui évite la répétition de code.