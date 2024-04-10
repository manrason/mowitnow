package com.test.technique.mowitnow.mowitnow.processor;

import com.test.technique.mowitnow.mowitnow.domain.Pelouse;
import org.springframework.batch.item.ItemProcessor;

public class PelouseItemProcessor implements ItemProcessor<Pelouse, Pelouse> {
    @Override
    public Pelouse process(Pelouse input) {
        return new Pelouse(input.getLargeur(), input.getHauteur());
    }
}
