package com.test.technique.mowitnow.mowitnow.config;

import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;

import java.util.List;

public class MowItNowInput {

    private int largeur;
    private int hauteur;
    private Tondeuse[] tondeuses;

    public MowItNowInput(int largeur, int hauteur, List<Tondeuse> tondeuses) {
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public Tondeuse[] getTondeuses() {
        return tondeuses;
    }

    public void setTondeuses(Tondeuse[] tondeuses) {
        this.tondeuses = tondeuses;
    }
}
