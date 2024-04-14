package com.test.technique.mowitnow.reader;

import com.test.technique.mowitnow.config.MowItNowInput;
import com.test.technique.mowitnow.domain.Pelouse;
import com.test.technique.mowitnow.domain.Tondeuse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TondeuseItemReader implements ItemReader<MowItNowInput> {

    private final Logger logger = LoggerFactory.getLogger(TondeuseItemReader.class);

    private String input = "";
    private int currentIndex;


    @Override
    public MowItNowInput read() {

        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/mowitnow.txt"));
            input = reader.readLine();


            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        MowItNowInput mowItNowInput = new MowItNowInput();

        int largeur, hauteur, x, y, x2,y2;
        char orientation, orientation2;
        String instructions, instructions2;

        if (currentIndex >= input.length()) {
            return null;
        }

        List<Tondeuse> tondeuses = new ArrayList<>();


        String[] fields = new String[10];
        for (int i = 0; i < 10; i++) {
            int endIndex = input.indexOf(' ', currentIndex);
            if (endIndex == -1) {
                endIndex = input.length();
            }

            String fieldValue = input.substring(currentIndex, endIndex).trim();

            fields[i] = fieldValue;

            currentIndex = endIndex + 1;
        }


        largeur = Integer.parseInt(fields[0]);
        hauteur = Integer.parseInt(fields[1]);
        x = Integer.parseInt(fields[2]);
        y = Integer.parseInt(fields[3]);
        orientation = (fields[4]).charAt(0);
        instructions = String.valueOf((fields[5]));
        x2 = Integer.parseInt(fields[6]);
        y2 = Integer.parseInt(fields[7]);
        orientation2 = (fields[8]).charAt(0);
        instructions2 = String.valueOf(fields[9]);



        Pelouse pelouse = new Pelouse(largeur,hauteur);
        mowItNowInput.setLargeur(largeur);
        mowItNowInput.setHauteur(hauteur);



        Tondeuse tondeuse = new Tondeuse(pelouse, x, y, orientation, instructions);
        Tondeuse tondeuse2 = new Tondeuse(pelouse, x2, y2, orientation2, instructions2);

        tondeuses.add(tondeuse);
        tondeuses.add(tondeuse2);

        mowItNowInput.setTondeuses(tondeuses);
        return mowItNowInput;
    }
}
