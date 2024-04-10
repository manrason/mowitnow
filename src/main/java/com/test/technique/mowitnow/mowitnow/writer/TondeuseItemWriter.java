package com.test.technique.mowitnow.mowitnow.writer;

import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class TondeuseItemWriter implements ItemWriter<Tondeuse>, TondeuseItemWriterInterface {

    @Override
    public void write(List<? extends Tondeuse> outputs) {
        for (Tondeuse output : outputs) {
            System.out.println(output.getX() + " " + output.getY() + " " + output.getOrientation());
        }
    }

    @Override
    public String getOutput() {
        return null;
    }

    @Override
    public void write(Chunk<? extends Tondeuse> chunk) {

    }
}
