package com.test.technique.mowitnow.reader;

import com.test.technique.mowitnow.domain.Pelouse;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

public class PelouseItemReader extends FlatFileItemReader<String[]>{

    @Value("${file.path}")
    private Resource inputFile;
    @Bean
    public FlatFileItemReader<Pelouse> pelouseReader() {
        FlatFileItemReader<Pelouse> reader = new FlatFileItemReader<>();
        reader.setResource(inputFile);
        reader.setLineMapper(pelouseLineMapper());
        return reader;
    }

    private LineMapper<Pelouse> pelouseLineMapper() {
        DefaultLineMapper<Pelouse> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(pelouseLineTokenizer());
        lineMapper.setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
            setTargetType(Pelouse.class);
        }});
        return lineMapper;
    }

    private LineTokenizer pelouseLineTokenizer() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(" ");
        tokenizer.setNames("largeur", "hauteur");
        return tokenizer;
    }

    public void setInputFile(Resource inputFile) {
        this.inputFile = inputFile;
    }
}
