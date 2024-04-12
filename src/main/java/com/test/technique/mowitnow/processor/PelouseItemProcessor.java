package com.test.technique.mowitnow.processor;

import com.test.technique.mowitnow.domain.Pelouse;
import org.springframework.batch.item.ItemProcessor;

public class PelouseItemProcessor implements ItemProcessor<Pelouse, Pelouse> {
    @Override
    public Pelouse process(Pelouse input) {
        return new Pelouse(input.getLargeur(), input.getHauteur());
    }
}
