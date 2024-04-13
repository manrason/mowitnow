package com.test.technique.mowitnow.writer;

import com.test.technique.mowitnow.config.MowItNowOutput;
import com.test.technique.mowitnow.domain.Tondeuse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TondeuseWriterTest {

    @Test
    public void testWriteSingleTondeuse() {
        // Given
        List<Tondeuse> tondeuses = List.of(
                new Tondeuse(0, 0, 'N')
        );
        MowItNowOutput output = new MowItNowOutput(tondeuses);

        TondeuseItemWriter writer = new TondeuseItemWriter();

        // When
        String result = writer.writeList(output);

        // Then
        String expectedOutput = "0 0 N";
        assertEquals(expectedOutput, result);
    }

    @Test
    public void testWriteDoubleTondeuse() {
        // Given
        List<Tondeuse> tondeuses = List.of(
                new Tondeuse(0, 0, 'N'),
                new Tondeuse(1, 2, 'E')
        );
        MowItNowOutput output = new MowItNowOutput(tondeuses);

        TondeuseItemWriter writer = new TondeuseItemWriter();

        // When
        String result = writer.writeList(output);

        // Then
        String expectedOutput = "0 0 N 1 2 E ";
        assertEquals(expectedOutput, result);
    }

}
