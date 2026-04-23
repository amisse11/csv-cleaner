# README - package io

Ce dossier contient 4 fichiers qui servent a lire et ecrire un fichier CSV.

## 1) ILecteur
- C est une interface.
- Elle definit la methode `lire(String chemin)`.
- Son role: dire comment une classe doit lire un fichier, sans imposer le detail du code.

## 2) IEcrivain
- C est une interface.
- Elle definit la methode `ecrire(FichierCSV fichier, String chemin)`.
- Son role: dire comment une classe doit ecrire un fichier, sans imposer le detail du code.

## 3) LecteurCSV
- C est une classe concrete qui `implements ILecteur`.
- Elle lit un fichier CSV depuis un chemin sur le disque.
- Elle transforme le contenu en objet `FichierCSV`:
  - la premiere ligne devient les entetes,
  - les autres lignes deviennent les donnees.
- En cas de probleme de lecture, elle leve une erreur.

## 4) EcrivainCSV
- C est une classe concrete qui `implements IEcrivain`.
- Elle prend un objet `FichierCSV` en memoire.
- Elle ecrit cet objet dans un fichier CSV sur le disque:
  - d abord les entetes,
  - puis toutes les lignes de donnees.
- En cas de probleme d ecriture, elle leve une erreur.

## Resume simple
- `ILecteur` et `IEcrivain` = les contrats (les regles).
- `LecteurCSV` et `EcrivainCSV` = les implementations concretes (le vrai travail).
