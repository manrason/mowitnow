package com.test.technique.mowitnow.mowitnow.domain;

public class Pelouse {

    private int largeur;
    private int hauteur;

    public Pelouse(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public boolean isInBounds(int x, int y) {
        return x >= 0 && x < largeur && y >= 0 && y < hauteur;
    }
}
