package com.test.technique.mowitnow.processor;

import com.test.technique.mowitnow.config.MowItNowInput;
import com.test.technique.mowitnow.config.MowItNowOutput;
import com.test.technique.mowitnow.domain.Pelouse;
import com.test.technique.mowitnow.domain.Tondeuse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TondeuseProcessorTest {


    @InjectMocks
    private TondeuseItemProcessor processor;

    @Test
    public void testProcess() {
        // Given
        List<Tondeuse> tondeuses = new ArrayList<>();
        Pelouse pelouse = new Pelouse(5,5);
        tondeuses.add(new Tondeuse(pelouse,1, 2, 'N', "GAGAGAGAA"));
        tondeuses.add(new Tondeuse(pelouse,3, 3, 'E',"AADAADADDA"));
        MowItNowInput input = new MowItNowInput(5,5, tondeuses);

        // When
        MowItNowOutput output = processor.process(input);

        // Then
        List<Tondeuse> expectedTondeuses = List.of(
                new Tondeuse(2, 3, 'N'),
                new Tondeuse(1, 3, 'E')
        );
        assert output != null;
        assertEquals(expectedTondeuses, output.getTondeuses());
    }

}
