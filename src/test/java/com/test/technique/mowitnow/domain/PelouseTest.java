package com.test.technique.mowitnow.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PelouseTest {

    @Test
    void testIsInBounds() {
        Pelouse pelouse = new Pelouse(5, 5);
        assertTrue(pelouse.isInBounds(0, 0));
        assertTrue(pelouse.isInBounds(4, 4));

    }

    @Test
    void testIsOutBounds() {
        Pelouse pelouse = new Pelouse(5, 5);
        assertFalse(pelouse.isInBounds(-1, 0));
        assertFalse(pelouse.isInBounds(0, -1));
        assertFalse(pelouse.isInBounds(5, 5));
    }
}
