package com.test.technique.mowitnow.reader;

import com.test.technique.mowitnow.config.MowItNowInput;
import com.test.technique.mowitnow.domain.Tondeuse;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.FileSystemResource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TondeuseItemReader extends FlatFileItemReader<MowItNowInput> {

    public TondeuseItemReader() {
        this.setResource(new FileSystemResource("src/resources/mowitnow.txt"));
        this.setLineMapper(lineMapper());
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

    @Override
    protected MowItNowInput doRead() throws Exception {
        MowItNowInput input = super.read();
        if (input != null) {
            String tondeusesString = input.getTondeuses().toString();
            List<Tondeuse> tondeusesList = Arrays.stream(tondeusesString.substring(1, tondeusesString.length() - 1).split(", "))
                    .map(Tondeuse::new)
                    .collect(Collectors.toList());
            input.setTondeuses(tondeusesList);
        }
        return input;
    }
}
