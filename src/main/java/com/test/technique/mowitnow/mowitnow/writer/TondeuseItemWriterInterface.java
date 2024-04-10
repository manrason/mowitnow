package com.test.technique.mowitnow.mowitnow.writer;

import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;

import java.util.List;

public interface TondeuseItemWriterInterface {
    void write(List<? extends Tondeuse> outputs);

    String getOutput();
}
