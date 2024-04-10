package com.test.technique.mowitnow.mowitnow.config;

import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;

import java.util.List;

public class MowItNowOutput {

    private Tondeuse[] tondeuses;

    public MowItNowOutput(List<Tondeuse> tondeuses) {
    }

    public Tondeuse[] getTondeuses() {
        return tondeuses;
    }

    public void setTondeuses(Tondeuse[] tondeuses) {
        this.tondeuses = tondeuses;
    }
}
