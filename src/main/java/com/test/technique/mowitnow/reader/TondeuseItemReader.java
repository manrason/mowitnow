package com.test.technique.mowitnow.reader;

import com.test.technique.mowitnow.config.MowItNowInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;


public class TondeuseItemReader extends FlatFileItemReader<MowItNowInput> {

    private final Logger logger = LoggerFactory.getLogger(TondeuseItemReader.class);

    public TondeuseItemReader() throws Exception {
        FlatFileItemReader<MowItNowInput> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("src/main/resources/mowitnow.txt"));
        reader.setLineMapper(lineMapper());
        reader.open(new ExecutionContext());
        reader.read();
    }

    private LineMapper<MowItNowInput> lineMapper() {
        DefaultLineMapper<MowItNowInput> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setNames("largeur", "hauteur", "tondeuses");
        tokenizer.setDelimiter(" ");
        BeanWrapperFieldSetMapper<MowItNowInput> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(MowItNowInput.class);
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

//    @Override
//    public MowItNowInput read() throws Exception {
//        FlatFileItemReader<MowItNowInput> reader = new FlatFileItemReader<>();
//        logger.debug("Reading ItemReader");
//        reader.open(new ExecutionContext());
//        MowItNowInput input = reader.read();
//        if (input != null) {
//            input.setTondeuses(input.getTondeuses());
//        }
//        return input;
//    }
}
