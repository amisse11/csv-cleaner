**README - CSV Cleaner**

Petit outil Java pour nettoyer un fichier CSV. Il lit un fichier, applique une série de nettoyages sur les données, et
sauvegarde le résultat dans un nouveau fichier.

***

**Auteurs**

- Anthony MISSE
- Cabrel NGOUANET

***

**Fonctionnalités**

- Lecture d'un fichier CSV depuis le disque
- Remplacement des valeurs manquantes par une valeur par défaut (N/A)
- Suppression des espaces inutiles en début et fin de valeur
- Conversion de toutes les valeurs en majuscules
- Sauvegarde du fichier nettoyé
- Affichage du contenu avant et après nettoyage dans la console

***

**Structure du projet**

```
csv-cleaner/
├── src/
│   ├── main/
│   │   ├── Application.java
│   │   └── service/
│   │       └── ServiceNettoyage.java
│   ├── model/
│   │   └── FichierCSV.java
│   ├── io/
│   │   ├── ILecteur.java
│   │   ├── IEcrivain.java
│   │   ├── LecteurCSV.java
│   │   └── EcrivainCSV.java
│   ├── nettoyage/
│   │   ├── INettoyeur.java
│   │   ├── NettoyeurAbstrait.java
│   │   ├── NettoyeurValeursManquantes.java
│   │   ├── NettoyeurEspaces.java
│   │   └── NettoyeurMajuscules.java
│   └── resources/
│       └── entree.csv
└── README.md
```

***

**Packages**

| Package   | Rôle                                                                 |
|-----------|----------------------------------------------------------------------|
| model     | Contient FichierCSV, la classe qui représente les données en mémoire |
| io        | Gère la lecture et l'écriture des fichiers CSV                       |
| nettoyage | Contient toute la logique de nettoyage des données                   |
| service   | Orchestre la lecture, le nettoyage et l'écriture                     |

***

**Concepts POO appliqués**

- **Interfaces** - ILecteur, IEcrivain et INettoyeur définissent des contrats clairs entre les composants
- **Classe abstraite** - NettoyeurAbstrait fournit la logique commune à tous les nettoyeurs
- **Héritage** - les trois nettoyeurs concrets héritent de NettoyeurAbstrait et n'implémentent que leur propre logique
- **Encapsulation** - tous les attributs sont privés et accessibles uniquement via des méthodes
- **Injection de dépendances** - ServiceNettoyage reçoit ses collaborateurs via le constructeur

***

**Principes SOLID appliqués**

- **S - Single Responsibility** : chaque classe a une seule responsabilité. FichierCSV stocke les données,
  LecteurCSV lit, EcrivainCSV écrit, chaque nettoyeur nettoie à sa façon
- **O - Open/Closed** : le programme est ouvert à l'extension mais fermé à la modification. Pour ajouter un nouveau
  nettoyeur, on crée une nouvelle classe qui hérite de NettoyeurAbstrait - sans toucher au code existant
- **L - Liskov Substitution** : NettoyeurEspaces, NettoyeurMajuscules et NettoyeurValeursManquantes peuvent
  remplacer NettoyeurAbstrait partout sans que le programme casse
- **I - Interface Segregation** : les interfaces sont petites et ciblées. ILecteur ne contient que lire(),
  IEcrivain que ecrire(), INettoyeur que nettoyer()
- **D - Dependency Inversion** : ServiceNettoyage dépend des interfaces ILecteur, IEcrivain et INettoyeur,
  jamais des classes concrètes directement

***

**Comment lancer le programme**

Dans IntelliJ, aller dans **Edit Configurations → Program arguments** et entrer :

src/main/entree.csv src/main/sortie.csv

Le fichier sortie.csv est généré automatiquement dans le même dossier après le traitement.

***

**Exemple de résultat**

=== AVANT NETTOYAGE ===

nom | age | ville | email

alice | 25 |   paris   | alice@email.com

  BOB   |  | Montreal | bob@email.com

Marie | 30 | lyon | 

 | 22 | Toronto | test@email.com

Carlos   |   28   |    | carlos@email.com

***

=== APRÈS NETTOYAGE ===

nom | age | ville | email

ALICE | 25 | PARIS | ALICE@EMAIL.COM

BOB | N/A | MONTREAL | BOB@EMAIL.COM

MARIE | 30 | LYON | N/A

N/A | 22 | TORONTO | TEST@EMAIL.COM

CARLOS | 28 | N/A | CARLOS@EMAIL.COM

Fichier nettoyé sauvegardé : src/resources/sortie.csv
