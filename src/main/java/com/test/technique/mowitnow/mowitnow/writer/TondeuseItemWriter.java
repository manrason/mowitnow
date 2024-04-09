package com.test.technique.mowitnow.mowitnow.writer;

import com.test.technique.mowitnow.mowitnow.config.TondeuseOutput;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class TondeuseItemWriter implements ItemWriter<TondeuseOutput>, TondeuseItemWriterInterface {

    @Override
    public void write(List<? extends TondeuseOutput> outputs) {
        for (TondeuseOutput output : outputs) {
            System.out.println(output.getX() + " " + output.getY() + " " + output.getOrientation());
        }
    }

    @Override
    public void write(Chunk<? extends TondeuseOutput> chunk) {

    }
}
