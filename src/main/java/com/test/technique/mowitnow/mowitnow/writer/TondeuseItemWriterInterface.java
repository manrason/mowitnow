package com.test.technique.mowitnow.mowitnow.writer;

import com.test.technique.mowitnow.mowitnow.config.TondeuseOutput;

import java.util.List;

public interface TondeuseItemWriterInterface {
    void write(List<? extends TondeuseOutput> outputs);
}
