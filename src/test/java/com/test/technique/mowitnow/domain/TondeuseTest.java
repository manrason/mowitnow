package com.test.technique.mowitnow.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TondeuseTest {

    @Test
    void givenCoordonnes0et0AndOrientationNWhenAvancerShouldReturnCorrectPositionAndOrientation() {
        Pelouse pelouse = new Pelouse(1,1);
        Tondeuse tondeuse = new Tondeuse(pelouse,0, 0, 'N',"A");
        tondeuse.avancer();
        assertEquals(0, tondeuse.getX());
        assertEquals(1, tondeuse.getY());
        assertEquals('N', tondeuse.getOrientation());
    }

    @Test
    void givenCoordonnes0et0AndOrientationNWhenTournerDroiteShouldReturnCorrectPositionAndOrientation() {
        Pelouse pelouse = new Pelouse(1,1);
        Tondeuse tondeuse = new Tondeuse(pelouse,0, 0, 'N',"D");
        tondeuse.tournerDroite();
        assertEquals(0, tondeuse.getX());
        assertEquals(0, tondeuse.getY());
        assertEquals('E', tondeuse.getOrientation());
    }

    @Test
    void givenCoordonnes0et0AndOrientationNWhenTournerGaucheShouldReturnCorrectPositionAndOrientation() {
        Tondeuse tondeuse = new Tondeuse(new Pelouse(1,1),0, 0, 'N',"G");
        tondeuse.tournerGauche();
        assertEquals(0, tondeuse.getX());
        assertEquals(0, tondeuse.getY());
        assertEquals('W', tondeuse.getOrientation());
    }

    @Test
    void testTournerHorsBornes() {
        Tondeuse tondeuse = new Tondeuse(new Pelouse(1,1),0, 0, 'S',"DDAA");
        tondeuse.tournerDroite();
        tondeuse.tournerDroite();
        tondeuse.avancer();
        tondeuse.avancer();
        assertEquals(0, tondeuse.getX());
        assertEquals(1, tondeuse.getY());
        assertEquals('N', tondeuse.getOrientation());
    }
}
