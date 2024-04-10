package com.test.technique.mowitnow.mowitnow.config;

import com.test.technique.mowitnow.mowitnow.domain.Pelouse;
import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;
import com.test.technique.mowitnow.mowitnow.processor.PelouseItemProcessor;
import com.test.technique.mowitnow.mowitnow.processor.TondeuseItemProcessor;
import com.test.technique.mowitnow.mowitnow.reader.PelouseItemReader;
import com.test.technique.mowitnow.mowitnow.reader.TondeuseItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MowItNowBatchConfiguration {


    //TODO solution for deperecated method
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;


    @Bean
    public Job job(PelouseItemReader pelouseReader, TondeuseItemReader tondeuseReader) {
        return jobBuilderFactory.get("tondeuseJob")
                .incrementer(new RunIdIncrementer())
                .start(pelouseStep(pelouseReader.pelouseReader()))
                .next(tondeuseStep(tondeuseReader.tondeuseReader()))
                .build();
    }

    @Bean
    public Step pelouseStep(ItemReader<Pelouse> pelouseReader) {
        return stepBuilderFactory.get("pelouseStep")
                .<Pelouse, Pelouse>chunk(10)
                .reader(pelouseReader)
                .processor(pelouseProcessor())
                .build();
    }

    @Bean
    public Step tondeuseStep(ItemReader<Tondeuse> tondeuseReader) {
        return stepBuilderFactory.get("tondeuseStep")
                .<Tondeuse, Tondeuse>chunk(10)
                .reader(tondeuseReader)
                .processor(tondeuseProcessor())
                .build();
    }


    @Bean
    public TondeuseItemProcessor tondeuseProcessor() {
        return new TondeuseItemProcessor();
    }

    @Bean
    public PelouseItemProcessor pelouseProcessor() {
        return new PelouseItemProcessor();
    }

}
