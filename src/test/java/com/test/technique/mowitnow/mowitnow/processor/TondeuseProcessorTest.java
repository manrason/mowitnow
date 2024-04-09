package com.test.technique.mowitnow.mowitnow.processor;

import com.test.technique.mowitnow.mowitnow.config.TondeuseInput;
import com.test.technique.mowitnow.mowitnow.config.TondeuseOutput;
import com.test.technique.mowitnow.mowitnow.domain.Pelouse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TondeuseProcessorTest {

    @Mock
    private Pelouse pelouse;

    @InjectMocks
    private TondeuseItemProcessor processor;

    @Test
    public void testProcess() {
        when(pelouse.isInBounds(0, 0)).thenReturn(true);
        TondeuseInput input = new TondeuseInput();
        input.setX(0);
        input.setY(0);
        input.setOrientation('N');
        input.setInstructions("ADGAGAGA");

        TondeuseOutput output = processor.process(input);

        assertEquals(0, output.getX());
        assertEquals(2, output.getY());
        assertEquals('N', output.getOrientation());
    }

    @Test
    public void testProcessOutOfBounds() throws Exception {
        when(pelouse.isInBounds(1, 4)).thenReturn(true);
        when(pelouse.isInBounds(1, 5)).thenReturn(false);
        TondeuseInput input = new TondeuseInput();
        input.setX(1);
        input.setY(4);
        input.setOrientation('N');
        input.setInstructions("AA");

        TondeuseOutput output = processor.process(input);

        assertEquals(1, output.getX());
        assertEquals(4, output.getY());
        assertEquals('N', output.getOrientation());
    }

    @Test
    public void testProcessWithMultipleInstructions() throws Exception {
        when(pelouse.isInBounds(0, 0)).thenReturn(true);
        TondeuseInput input = new TondeuseInput();
        input.setX(0);
        input.setY(0);
        input.setOrientation('N');
        input.setInstructions("ADADADA");

        TondeuseOutput output = processor.process(input);

        assertEquals(0, output.getX());
        assertEquals(3, output.getY());
        assertEquals('N', output.getOrientation());
    }
}
