package com.test.technique.mowitnow.reader;

import com.test.technique.mowitnow.config.MowItNowInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TondeuseItemReaderTest {
    private TondeuseItemReader tondeuseItemReader;

    @BeforeEach
    public void setUp() {
        tondeuseItemReader = new TondeuseItemReader();
    }

    @Test
    public void testReadValidInput() {


        MowItNowInput result = tondeuseItemReader.read();

        assertNotNull(result);
        assertEquals(5, result.getLargeur());
        assertEquals(5, result.getHauteur());
        assertEquals(1, result.getTondeuses().get(0).getX());
        assertEquals(2, result.getTondeuses().get(0).getY());
        assertEquals('N', result.getTondeuses().get(0).getOrientation());
        assertEquals("GAGAGAGAA", result.getTondeuses().get(0).getInstructions());
        assertEquals(3, result.getTondeuses().get(1).getX());
        assertEquals(3, result.getTondeuses().get(1).getY());
    }

}