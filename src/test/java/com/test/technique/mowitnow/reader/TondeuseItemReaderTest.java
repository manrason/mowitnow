package com.test.technique.mowitnow.reader;

import com.test.technique.mowitnow.config.MowItNowInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.core.io.ClassPathResource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TondeuseItemReaderTest {
    private TondeuseItemReader reader;

    @BeforeEach
    void setUp() throws Exception {
        reader = new TondeuseItemReader();
    }

    @Test
    void testRead() throws Exception {
        reader.setResource(new ClassPathResource("src/main/resources/mowitnow.txt"));
        MowItNowInput input = reader.read();
        assertEquals(5, input.getLargeur());
        assertEquals(5, input.getHauteur());
        assertEquals(2, input.getTondeuses().size());
        assertEquals(1, input.getTondeuses().get(0).getX());
        assertEquals(2, input.getTondeuses().get(0).getY());
        assertEquals('N', input.getTondeuses().get(0).getOrientation());
        assertEquals(3, input.getTondeuses().get(1).getX());
        assertEquals(3, input.getTondeuses().get(1).getY());
        assertEquals('E', input.getTondeuses().get(1).getOrientation());
    }

    @Test
    void testReadWithInvalidFile() {
        reader.setResource(new ClassPathResource("invalid_file.txt"));
        assertThrows(FlatFileParseException.class, () -> reader.read());
    }
}