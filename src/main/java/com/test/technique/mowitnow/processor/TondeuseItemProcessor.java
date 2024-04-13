package com.test.technique.mowitnow.processor;

import com.test.technique.mowitnow.config.MowItNowInput;
import com.test.technique.mowitnow.config.MowItNowOutput;
import com.test.technique.mowitnow.domain.Tondeuse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.util.ArrayList;
import java.util.List;

public class TondeuseItemProcessor implements ItemProcessor<MowItNowInput, MowItNowOutput> {

    private final Logger logger = LoggerFactory.getLogger(TondeuseItemProcessor.class);
    @Override
    public MowItNowOutput process(MowItNowInput input) {
        List<Tondeuse> tondeuses = new ArrayList<>();
        logger.debug("Processing ItemProcessor");
        for (Tondeuse tondeuse : input.getTondeuses()) {
            char[] instructions = tondeuse.getInstructions().toCharArray();
            for (char instruction : instructions) {
                switch (instruction) {
                    case 'A' -> tondeuse.avancer();
                    case 'D' -> tondeuse.tournerDroite();
                    case 'G' -> tondeuse.tournerGauche();
                    default -> throw new IllegalStateException("Unexpected value: " + instruction);
                }
            }
            tondeuses.add(tondeuse);
        }
        return new MowItNowOutput(tondeuses);
    }
}
