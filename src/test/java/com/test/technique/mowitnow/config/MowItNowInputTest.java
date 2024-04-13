package com.test.technique.mowitnow.config;

import com.test.technique.mowitnow.domain.Tondeuse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MowItNowInputTest {

    @Test
    public void testMowItNowInput() {
        // Given
        List<Tondeuse> tondeuses = List.of(
                new Tondeuse(0, 0, 'N'),
                new Tondeuse(1, 2, 'E')
        );

        MowItNowInput input = new MowItNowInput(5, 5, tondeuses);

        // When
        int largeur = input.getLargeur();
        int hauteur = input.getHauteur();
        List<Tondeuse> tondeusesFromInput = input.getTondeuses();

        // Then
        assertEquals(5, largeur);
        assertEquals(5, hauteur);
        assertEquals(tondeuses, tondeusesFromInput);
    }
}
