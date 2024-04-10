package com.test.technique.mowitnow.mowitnow.reader;

import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

public class TondeuseItemReader extends FlatFileItemReader<String[]> {

    @Value("${file.path}")
    private Resource inputFile;
    @Bean
    public FlatFileItemReader<Tondeuse> tondeuseReader() {
        FlatFileItemReader<Tondeuse> reader = new FlatFileItemReader<>();
        reader.setResource(inputFile);
        reader.setLineMapper(tondeuseLineMapper());
        return reader;
    }



    private LineMapper<Tondeuse> tondeuseLineMapper() {
        DefaultLineMapper<Tondeuse> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tondeuseLineTokenizer());
        lineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
            setTargetType(Tondeuse.class);
        }});
        return lineMapper;
    }



    private LineTokenizer tondeuseLineTokenizer() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(" ");
        tokenizer.setNames("x", "y", "orientation", "instructions");
        return tokenizer;
    }
}
