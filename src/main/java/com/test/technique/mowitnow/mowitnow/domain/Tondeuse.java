package com.test.technique.mowitnow.mowitnow.domain;

public class Tondeuse {

    public int x;
    public int y;
    public char orientation;

    public Tondeuse(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public void avancer() {
        switch (orientation) {
            case 'N' -> y++;
            case 'E' -> x++;
            case 'S' -> y--;
            case 'W' -> x--;
        }
    }

    public void tournerDroite() {
        switch (orientation) {
            case 'N' -> orientation = 'E';
            case 'E' -> orientation = 'S';
            case 'S' -> orientation = 'W';
            case 'W' -> orientation = 'N';
        }
    }

    public void tournerGauche() {
        switch (orientation) {
            case 'N' -> orientation = 'W';
            case 'E' -> orientation = 'N';
            case 'S' -> orientation = 'E';
            case 'W' -> orientation = 'S';
        }
    }

    public String getPosition() {
        return String.format("%d %d %c", x, y, orientation);
    }
}
