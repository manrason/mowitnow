package com.test.technique.mowitnow.mowitnow.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TondeuseTest {

    @Test
    void givenCoordonnes0et0AndOrientationNWhenAvancerShouldReturnCorrectPositionAndOrientation() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.avancer();
        assertEquals(0, tondeuse.x);
        assertEquals(1, tondeuse.y);
        assertEquals('N', tondeuse.orientation);
    }

    @Test
    void givenCoordonnes0et0AndOrientationNWhenTournerDroiteShouldReturnCorrectPositionAndOrientation() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.tournerDroite();
        assertEquals(0, tondeuse.x);
        assertEquals(0, tondeuse.y);
        assertEquals('E', tondeuse.orientation);
    }

    @Test
    void givenCoordonnes0et0AndOrientationNWhenTournerGaucheShouldReturnCorrectPositionAndOrientation() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.tournerGauche();
        assertEquals(0, tondeuse.x);
        assertEquals(0, tondeuse.y);
        assertEquals('W', tondeuse.orientation);
    }

    @Test
    void testTournerHorsBornes() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.tournerDroite();
        tondeuse.tournerDroite();
        tondeuse.tournerDroite();
        tondeuse.tournerDroite();
        assertEquals(0, tondeuse.x);
        assertEquals(0, tondeuse.y);
        assertEquals('N', tondeuse.orientation);
    }
}
