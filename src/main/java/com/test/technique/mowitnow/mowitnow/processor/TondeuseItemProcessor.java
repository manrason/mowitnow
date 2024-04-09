package com.test.technique.mowitnow.mowitnow.processor;

import com.test.technique.mowitnow.mowitnow.config.TondeuseInput;
import com.test.technique.mowitnow.mowitnow.config.TondeuseOutput;
import com.test.technique.mowitnow.mowitnow.domain.Pelouse;
import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;
import org.springframework.batch.item.ItemProcessor;

public class TondeuseItemProcessor implements ItemProcessor<TondeuseInput, TondeuseOutput> {

    @Override
    public TondeuseOutput process(TondeuseInput input) {
        Pelouse pelouse = new Pelouse(input.getX(), input.getY());
        Tondeuse tondeuse = new Tondeuse(input.getX(), input.getY(), input.getOrientation());
        for (char instruction : input.getInstructions().toCharArray()) {
            switch (instruction) {
                case 'A' -> tondeuse.avancer();
                case 'D' -> tondeuse.tournerDroite();
                case 'G' -> tondeuse.tournerGauche();
            }
            if (!pelouse.isInBounds(tondeuse.x, tondeuse.y)) {
                break;
            }
        }

        TondeuseOutput output = new TondeuseOutput();
        output.setX(tondeuse.x);
        output.setY(tondeuse.y);
        output.setOrientation(tondeuse.orientation);

        return output;
    }
}
