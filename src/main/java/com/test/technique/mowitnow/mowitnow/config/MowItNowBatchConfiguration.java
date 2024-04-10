package com.test.technique.mowitnow.mowitnow.config;

import com.test.technique.mowitnow.mowitnow.processor.TondeuseItemProcessor;
import com.test.technique.mowitnow.mowitnow.reader.TondeuseItemReader;
import com.test.technique.mowitnow.mowitnow.writer.TondeuseItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
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
    public Job job() {
        return jobBuilderFactory.get("tondeuseJob")
                .incrementer(new RunIdIncrementer())
                .start(mowItNowStep())
                .build();
    }

    @Bean
    public Step mowItNowStep() {
        return stepBuilderFactory.get("mowItNowStep")
                .<MowItNowInput, MowItNowOutput>chunk(1)
                .reader(mowItNowReader())
                .processor(mowItNowProcessor())
                .writer(mowItNowWriter())
                .build();
    }

    @Bean
    public ItemReader<MowItNowInput> mowItNowReader() {
        return new TondeuseItemReader();
    }
    @Bean
    public ItemWriter<MowItNowOutput> mowItNowWriter() {
        return new TondeuseItemWriter();
    }

    @Bean
    public ItemProcessor<MowItNowInput, MowItNowOutput> mowItNowProcessor() {
        return new TondeuseItemProcessor();
    }


}
