package com.test.technique.mowitnow.config;

import com.test.technique.mowitnow.domain.Tondeuse;

import java.util.List;

public class MowItNowInput {

    private int largeur;
    private int hauteur;
    private List<Tondeuse> tondeuses;

    public MowItNowInput(int largeur, int hauteur, List<Tondeuse> tondeuses) {
        this.largeur=largeur;
        this.hauteur=hauteur;
        this.tondeuses=tondeuses;
    }

    public MowItNowInput() {
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public List<Tondeuse> getTondeuses() {
        return this.tondeuses;
    }

    public void setTondeuses(List<Tondeuse> tondeuses) {
        this.tondeuses = tondeuses;
    }
}
