package com.test.technique.mowitnow.mowitnow.processor;

import com.test.technique.mowitnow.mowitnow.domain.Pelouse;
import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;
import org.springframework.batch.item.ItemProcessor;

public class TondeuseItemProcessor implements ItemProcessor<Tondeuse, Tondeuse> {

    @Override
    public Tondeuse process(Tondeuse input) {
        Pelouse pelouse = new Pelouse(input.getX(), input.getY());
        Tondeuse tondeuse = new Tondeuse(pelouse,input.getX(), input.getY(), input.getOrientation(), input.getInstructions());
        for (char instruction : input.getInstructions().toCharArray()) {
            switch (instruction) {
                case 'A' -> tondeuse.avancer();
                case 'D' -> tondeuse.tournerDroite();
                case 'G' -> tondeuse.tournerGauche();
                default -> throw new IllegalStateException("Unexpected value: " + instruction);
            }
            if (!pelouse.isInBounds(tondeuse.getX(), tondeuse.getY())) {
                break;
            }
        }

        Tondeuse output = new Tondeuse();
        output.setX(tondeuse.getX());
        output.setY(tondeuse.getY());
        output.setOrientation(tondeuse.getOrientation());

        return output;
    }
}
