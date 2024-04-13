package com.test.technique.mowitnow.writer;

import com.test.technique.mowitnow.config.MowItNowOutput;
import com.test.technique.mowitnow.domain.Tondeuse;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class TondeuseItemWriter implements ItemWriter<MowItNowOutput> {


    @Override
    public void write(Chunk<? extends MowItNowOutput> chunk) {
        for (MowItNowOutput output : chunk) {
            for (Tondeuse tondeuse : output.getTondeuses()) {
                System.out.println(tondeuse.getX() + " " + tondeuse.getY() + " " + tondeuse.getOrientation());
            }
        }
    }

    public void write(List<Tondeuse> outputs) {
        for (Tondeuse tondeuse : outputs) {
            System.out.println(tondeuse.getX() + " " + tondeuse.getY() + " " + tondeuse.getOrientation());
        }
    }
}
