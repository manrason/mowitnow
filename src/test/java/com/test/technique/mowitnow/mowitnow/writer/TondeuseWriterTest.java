package com.test.technique.mowitnow.mowitnow.writer;

import com.test.technique.mowitnow.mowitnow.domain.Pelouse;
import com.test.technique.mowitnow.mowitnow.domain.Tondeuse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TondeuseWriterTest {

    @Mock
    private org.springframework.batch.item.ExecutionContext testExecutionContext;

    @Mock
    private org.springframework.batch.core.StepContribution testStepContribution;

    @InjectMocks
    private TondeuseItemWriter writer;

    @Test
    void testWrite() {
        List<Tondeuse> outputs = new ArrayList<>();
        outputs.add(new Tondeuse(new Pelouse(1,1),1, 2, 'N',"G"));
        outputs.add(new Tondeuse(new Pelouse(1,1),3, 4, 'E',"G"));

        writer.write(outputs);

        verify(testExecutionContext).put("tondeuseOutput.0.x", 1);
        verify(testExecutionContext).put("tondeuseOutput.0.y", 2);
        verify(testExecutionContext).put("tondeuseOutput.0.orientation", 'N');
        verify(testExecutionContext).put("tondeuseOutput.1.x", 3);
        verify(testExecutionContext).put("tondeuseOutput.1.y", 4);
        verify(testExecutionContext).put("tondeuseOutput.1.orientation", 'E');
    }
}
