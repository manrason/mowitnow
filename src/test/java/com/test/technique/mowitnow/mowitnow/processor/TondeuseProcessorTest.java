package com.test.technique.mowitnow.mowitnow.processor;

import com.test.technique.mowitnow.mowitnow.domain.Pelouse;
import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TondeuseProcessorTest {

    @Mock
    private Pelouse pelouse;

    @InjectMocks
    private TondeuseItemProcessor processor;

    @Test
    void testProcess() {
        when(pelouse.isInBounds(0, 0)).thenReturn(true);
        Tondeuse input = new Tondeuse();
        input.setX(0);
        input.setY(0);
        input.setOrientation('N');
        input.setInstructions("ADGAGAGA");

        Tondeuse output = processor.process(input);

        assertEquals(0, output.getX());
        assertEquals(2, output.getY());
        assertEquals('N', output.getOrientation());
    }

    @Test
    void testProcessOutOfBounds() {
        when(pelouse.isInBounds(1, 4)).thenReturn(true);
        when(pelouse.isInBounds(1, 5)).thenReturn(false);
        Tondeuse input = new Tondeuse();
        input.setX(1);
        input.setY(4);
        input.setOrientation('N');
        input.setInstructions("AA");

        Tondeuse output = processor.process(input);

        assertEquals(1, output.getX());
        assertEquals(4, output.getY());
        assertEquals('N', output.getOrientation());
    }

    @Test
    void testProcessWithMultipleInstructions() {
        when(pelouse.isInBounds(0, 0)).thenReturn(true);
        Tondeuse input = new Tondeuse();
        input.setX(0);
        input.setY(0);
        input.setOrientation('N');
        input.setInstructions("ADADADA");

        Tondeuse output = processor.process(input);

        assertEquals(0, output.getX());
        assertEquals(3, output.getY());
        assertEquals('N', output.getOrientation());
    }
}
