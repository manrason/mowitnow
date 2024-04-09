package com.test.technique.mowitnow.mowitnow.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TondeuseTest {

    @Test
    void givenCoordonnes0et0AndOrientationNWhenAvancerShouldReturnCorrectPositionAndOrientation() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.avancer();
        assertEquals(0, tondeuse.getX());
        assertEquals(1, tondeuse.getY());
        assertEquals('N', tondeuse.getOrientation());
    }

    @Test
    void givenCoordonnes0et0AndOrientationNWhenTournerDroiteShouldReturnCorrectPositionAndOrientation() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.tournerDroite();
        assertEquals(0, tondeuse.getX());
        assertEquals(0, tondeuse.getY());
        assertEquals('E', tondeuse.getOrientation());
    }

    @Test
    void givenCoordonnes0et0AndOrientationNWhenTournerGaucheShouldReturnCorrectPositionAndOrientation() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.tournerGauche();
        assertEquals(0, tondeuse.getX());
        assertEquals(0, tondeuse.getY());
        assertEquals('W', tondeuse.getOrientation());
    }

    @Test
    void testTournerHorsBornes() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.tournerDroite();
        tondeuse.tournerDroite();
        tondeuse.tournerDroite();
        tondeuse.tournerDroite();
        assertEquals(0, tondeuse.getX());
        assertEquals(0, tondeuse.getY());
        assertEquals('N', tondeuse.getOrientation());
    }
}
