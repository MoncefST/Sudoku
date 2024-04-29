# Résolveur de Sudoku 🧩

Ce projet vise à créer un programme en Java pour la résolution de grilles de [Sudoku](https://fr.wikipedia.org/wiki/Sudoku). Ce projet a été réalisée dans le cadre du [SAÉ2.01 "Développement d'une application"](https://www.iut-fbleau.fr/sitebp/pt21/21_2023/A75DYGZ82RZL3PGH.php) lors du deuxième semestre de BUT 1 à l'IUT de Fontainebleau.

## Table des matières
- [Introduction](#introduction)
- [Lancement du programme](#lancement-du-programme)
  - [Compilation](#compilation)
  - [Lancement du créateur de grille](#Lancement-du-créateur-de-grille)
  - [Lancement du solveur de grille](#Lancement-du-solveur-de-grille)
- [Suppression des fichiers](#suppression-des-fichiers)
- [Générer la documentation](#générer-la-documentation)
- [Crédits](#crédits)


## Introduction
Le Sudoku est un jeu de logique consistant à remplir une grille de 9x9 cases divisée en régions de 3x3 cases avec des chiffres de 1 à 9. Le but est de remplir chaque case de manière à ce que chaque ligne, chaque colonne et chaque région contienne une fois chaque chiffre de 1 à 9.


## Lancement du programme
### Compilation

Utiliser la commande suivante pour compiler :
```bash
make
```

### Lancement du créateur de grille

Utiliser la commande suivante pour lancer le créateur de grille :
```bash
make GridMaker
```
### Lancement du solveur de grille

Utiliser la commande suivante pour lancer le solveur de grille :
```bash
make GridSolveur
```

## Suppression des fichiers .class et de la documentation
```bash
make clean
```
## Générer la documentation
```bash
make doc
```

## Crédits 🚀
 -   Programme réalisé par Moncef STITI (@stiti) et Marco ORFAO (@orfao)
