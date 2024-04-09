package com.test.technique.mowitnow.mowitnow.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TondeuseTest {

    @Test
    public void testAvancer() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.avancer();
        assertEquals(0, tondeuse.x);
        assertEquals(1, tondeuse.y);
        assertEquals('N', tondeuse.orientation);
    }

    @Test
    public void testTournerDroite() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.tournerDroite();
        assertEquals(0, tondeuse.x);
        assertEquals(0, tondeuse.y);
        assertEquals('E', tondeuse.orientation);
    }

    @Test
    public void testTournerGauche() {
        Tondeuse tondeuse = new Tondeuse(0, 0, 'N');
        tondeuse.tournerGauche();
        assertEquals(0, tondeuse.x);
        assertEquals(0, tondeuse.y);
        assertEquals('W', tondeuse.orientation);
    }

    @Test
    public void testAvancerHorsBornes() {
        Tondeuse tondeuse = new Tondeuse(0, 4, 'N');
        tondeuse.avancer();
        assertEquals(0, tondeuse.x);
        assertEquals(4, tondeuse.y);
        assertEquals('N', tondeuse.orientation);
    }

    @Test
    public void testTournerHorsBornes() {
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
