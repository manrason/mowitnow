package com.test.technique.mowitnow.reader;

import com.test.technique.mowitnow.config.MowItNowInput;
import com.test.technique.mowitnow.domain.Pelouse;
import com.test.technique.mowitnow.domain.Tondeuse;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TondeuseItemReader implements ItemReader<MowItNowInput>, ItemStream {

    private BufferedReader reader;


    @Value("${file.path}")
    private Resource inputFile;


    @Override
    public MowItNowInput read() throws Exception {
        if (reader == null) {
            reader = new BufferedReader(new FileReader(inputFile.getFile()));
        }

        String line;
        List<Tondeuse> tondeuses = new ArrayList<>();

        // Read the first line containing the width and height of the pelouse
        line = reader.readLine();
        String[] dimensions = line.split(" ");
        int largeur = Integer.parseInt(dimensions[0]);
        int hauteur = Integer.parseInt(dimensions[1]);

        // Read the second line containing the number of tondeuses
        int numTondeuses = Integer.parseInt(reader.readLine());

        // Read the data for each tondeuse
        for (int i = 0; i < numTondeuses; i++) {
            line = reader.readLine();
            String[] tondeuseData = line.split(" ");
            int x = Integer.parseInt(tondeuseData[0]);
            int y = Integer.parseInt(tondeuseData[1]);
            char orientation = tondeuseData[2].charAt(0);
            String instructions = tondeuseData[3];

            tondeuses.add(new Tondeuse(new Pelouse(largeur,hauteur), x, y, orientation, instructions));
        }

        return new MowItNowInput(largeur, hauteur, tondeuses);
    }

    @Override
    public void open(ExecutionContext executionContext) {
        // No-op, as we're not using Spring's built-in file handling
    }

    @Override
    public void update(ExecutionContext executionContext) {
        // No-op, as we're not using Spring's built-in file handling
    }

    @Override
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
