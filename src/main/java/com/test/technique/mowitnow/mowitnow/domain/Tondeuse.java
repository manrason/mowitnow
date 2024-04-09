package com.test.technique.mowitnow.mowitnow.domain;

public class Tondeuse {

    private int x;
    private int y;
    private char orientation;

    public Tondeuse(int x, int y, char orientation) {
        this.setX(x);
        this.setY(y);
        this.setOrientation(orientation);
    }

    public void avancer() {
        switch (getOrientation()) {
            case 'N' -> setY(getY() + 1);
            case 'E' -> setX(getX() + 1);
            case 'S' -> setY(getY() - 1);
            case 'W' -> setX(getX() - 1);
            default -> throw new IllegalStateException("Unexpected value: " + getOrientation());
        }
    }

    public void tournerDroite() {
        switch (getOrientation()) {
            case 'N' -> setOrientation('E');
            case 'E' -> setOrientation('S');
            case 'S' -> setOrientation('W');
            case 'W' -> setOrientation('N');
            default -> throw new IllegalStateException("Unexpected value: " + getOrientation());
        }
    }

    public void tournerGauche() {
        switch (getOrientation()) {
            case 'N' -> setOrientation('W');
            case 'E' -> setOrientation('N');
            case 'S' -> setOrientation('E');
            case 'W' -> setOrientation('S');
            default -> throw new IllegalStateException("Unexpected value: " + getOrientation());
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }
}
