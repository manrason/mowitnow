package com.test.technique.mowitnow.mowitnow.writer;

import com.test.technique.mowitnow.mowitnow.config.MowItNowOutput;
import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import java.io.PrintWriter;

public class TondeuseItemWriter implements ItemWriter<MowItNowOutput> {


    @Override
    public void write(Chunk<? extends MowItNowOutput> chunk) throws Exception {
        for (MowItNowOutput output : chunk) {
            for (Tondeuse tondeuse : output.getTondeuses()) {
                System.out.println(tondeuse.getX() + " " + tondeuse.getY() + " " + tondeuse.getOrientation());
            }
        }
    }
}
