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
    public void testWrite() {
        // Given
        List<Tondeuse> tondeuses = List.of(
                new Tondeuse(0, 0, 'N'),
                new Tondeuse(1, 2, 'E')
        );
        MowItNowOutput output = new MowItNowOutput(tondeuses);

        TondeuseItemWriter writer = new TondeuseItemWriter();

        // When
        writer.writeList(List.of(output));

        // Then
        String expectedOutput = "0 0 N\n1 2 E\n";
        assertEquals(expectedOutput, System.out.toString());
    }

    @Test
    public void testWriteWithMultipleOutputs() {
        // Given
        List<Tondeuse> tondeuse1 = List.of(
                new Tondeuse(0, 0, 'N'),
                new Tondeuse(1, 2, 'E')
        );
        List<Tondeuse> tondeuse2 = List.of(
                new Tondeuse(3, 3, 'S'),
                new Tondeuse(4, 4, 'W')
        );
        MowItNowOutput output1 = new MowItNowOutput(tondeuse1);
        MowItNowOutput output2 = new MowItNowOutput(tondeuse2);

        TondeuseItemWriter writer = new TondeuseItemWriter();

        // When
        writer.writeList(List.of(output1, output2));

        // Then
        String expectedOutput = "0 0 N\n1 2 E\n3 3 S\n4 4 W\n";
        assertEquals(expectedOutput, System.out.toString());
    }
}
