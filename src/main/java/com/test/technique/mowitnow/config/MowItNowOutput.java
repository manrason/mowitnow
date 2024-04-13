package com.test.technique.mowitnow.config;

import com.test.technique.mowitnow.domain.Tondeuse;

import java.util.List;

public class MowItNowOutput {

    private List<Tondeuse> tondeuses;

    public MowItNowOutput(List<Tondeuse> tondeuses) {
        this.tondeuses=tondeuses;
    }

    public List<Tondeuse> getTondeuses() {
        return tondeuses;
    }

}
