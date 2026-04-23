**Classe FichierCSV**

La classe FichierCSV représente un fichier CSV chargé en mémoire. Elle contient deux attributs privés : un tableau de
chaînes de caractères pour les entêtes, et une liste de tableaux pour les lignes de données.

Le constructeur initialise automatiquement la liste de lignes, ce qui évite toute erreur d'accès à un objet nul. L'accès
aux attributs se fait uniquement via des méthodes publiques (getters et setters), conformément au principe
d'encapsulation. La méthode ajouterLigne() permet d'alimenter le fichier ligne par ligne lors de la lecture. Deux
méthodes utilitaires, getNombreLignes() et getNombreColonnes(), permettent d'interroger rapidement la taille du
fichier sans accéder directement aux attributs.

Cette classe a une seule responsabilité : **stocker les données**. Elle ne lit pas, ne nettoie pas et n'écrit pas. Ce
sont d'autres classes qui s'en chargent.