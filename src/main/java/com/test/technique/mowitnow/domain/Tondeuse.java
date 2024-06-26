package com.test.technique.mowitnow.domain;

public class Tondeuse {

    private Pelouse pelouse;

    private int x;
    private int y;
    private char orientation;
    private String instructions;


    public Tondeuse(Pelouse pelouse, int x, int y, char orientation, String instructions) {
        this.pelouse = pelouse;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions = instructions;
    }

    public Tondeuse() {
    }

    public void avancer() {
        int newX = this.x;
        int newY = this.y;
        switch (getOrientation()) {
            case 'N' -> newY++;
            case 'E' -> newX++;
            case 'S' -> newY--;
            case 'W' -> newX--;
            default -> throw new IllegalStateException("Unexpected value: " + getOrientation());
        }
        if (newX >= 0 && newX > pelouse.getLargeur()) {
            setX(x);
        }else if ( newY >= 0 && newY > pelouse.getHauteur()){
            setY(y);
        }else {
            setX(newX);
            setY(newY);
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

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
}
