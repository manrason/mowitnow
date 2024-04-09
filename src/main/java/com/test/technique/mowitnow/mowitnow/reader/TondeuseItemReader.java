package com.test.technique.mowitnow.mowitnow.reader;

import com.test.technique.mowitnow.mowitnow.config.TondeuseInput;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

public class TondeuseItemReader extends FlatFileItemReader<String[]> {

    public FlatFileItemReader<TondeuseInput> tondeuseItemReader() {
        FlatFileItemReader<TondeuseInput> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("src/resources/mowitnow.txt"));
        reader.setLineMapper(lineMapper());
        reader.setLinesToSkip(1);
        return reader;
    }

    @Bean
    public LineMapper<TondeuseInput> lineMapper() {
        DefaultLineMapper<TondeuseInput> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("x", "y", "orientation", "instructions");
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
            setTargetType(TondeuseInput.class);
        }});
        return lineMapper;
    }
}
