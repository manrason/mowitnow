package com.test.technique.mowitnow.reader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class PelouseItemReaderTest {

    private PelouseItemReader reader;
    private InputStream inputStream;

    @BeforeEach
    public void setUp() {
        reader = new PelouseItemReader();
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
        String[] line = reader.read();

        // Then
        assertNotNull(line);
        assertEquals("5", line[0]);
        assertEquals("5", line[1]);
    }

    @Test
    public void testReadWithInvalidFile() throws Exception {
        // Given
        reader.setResource(new InputStreamResource(getClass().getClassLoader().getResourceAsStream("invalid_file.txt")));

        // When
        String[] line = reader.read();

        // Then
        assertNull(line);
    }
}
