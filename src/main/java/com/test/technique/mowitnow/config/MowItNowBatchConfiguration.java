package com.test.technique.mowitnow.config;

import com.test.technique.mowitnow.processor.TondeuseItemProcessor;
import com.test.technique.mowitnow.reader.TondeuseItemReader;
import com.test.technique.mowitnow.writer.TondeuseItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class MowItNowBatchConfiguration extends DefaultBatchConfiguration{


    @Bean
    public Job job(JobRepository jobRepository, Step mowItNowStep) {
        return  new JobBuilder("job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(mowItNowStep)
                .build();
    }

    @Bean
    public Step mowItNowStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) {
        return new StepBuilder("mowItNowStep", jobRepository)
                .<MowItNowInput, MowItNowOutput>chunk(1, platformTransactionManager)
                .reader(tondeuseReader())
                .processor(mowItNowProcessor())
                .writer(mowItNowWriter())
                .build();
    }

    @Bean
    public FlatFileItemReader<MowItNowInput> tondeuseReader() {
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
