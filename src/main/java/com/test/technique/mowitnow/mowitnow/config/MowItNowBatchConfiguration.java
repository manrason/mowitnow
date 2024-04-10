package com.test.technique.mowitnow.mowitnow.config;

import com.test.technique.mowitnow.mowitnow.processor.TondeuseItemProcessor;
import com.test.technique.mowitnow.mowitnow.reader.TondeuseItemReader;
import com.test.technique.mowitnow.mowitnow.writer.TondeuseItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MowItNowBatchConfiguration {



    @Bean
    public Job job(JobRepository jobRepository) {
        return new JobBuilder("tondeuseJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(mowItNowStep(jobRepository))
                .build();
    }

    @Bean
    public Step mowItNowStep(JobRepository jobRepository) {
        return new StepBuilder("mowItNowStep", jobRepository)
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
