package com.test.technique.mowitnow.reader;

import com.test.technique.mowitnow.config.MowItNowInput;
import com.test.technique.mowitnow.domain.Pelouse;
import com.test.technique.mowitnow.domain.Tondeuse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TondeuseItemReaderTest {

    private TondeuseItemReader reader;
    private InputStream inputStream;

    @BeforeEach
    public void setUp() {
        reader = new TondeuseItemReader();
        inputStream = getClass().getClassLoader().getResourceAsStream("src/main/resources/mowitnow.txt");
    }

    @AfterEach
    public void tearDown() {
        reader = null;
    }

    @Test
    public void testRead() throws Exception {
        // Given
        reader.setInputFile(new FileSystemResource("src/main/resources/mowitnow.txt"));

        // When
        MowItNowInput input = reader.read();

        // Then
        assertEquals(5, input.getLargeur());
        assertEquals(5, input.getHauteur());
        assertEquals(2, input.getTondeuses().size());
        assertEquals(new Tondeuse(new Pelouse(5, 5), 1, 2, 'N', "LFLFLFLFF"), input.getTondeuses().get(0));
        assertEquals(new Tondeuse(new Pelouse(5, 5), 3, 3, 'E', "FFF"), input.getTondeuses().get(1));
    }

    @Test
    public void testReadWithInvalidFile() throws Exception {
        // Given
        reader.setInputFile(new FileSystemResource("invalid_file.txt"));

        // When
        MowItNowInput input = reader.read();

        // Then
        assertNull(input);
    }

}