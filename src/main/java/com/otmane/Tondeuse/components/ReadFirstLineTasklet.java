package com.otmane.Tondeuse.components;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class ReadFirstLineTasklet implements Tasklet {

    private final String filePath;

    public ReadFirstLineTasklet(@Value("${file.path.input}") String filePath) {
        this.filePath = filePath;
    }

    @Override
    public RepeatStatus execute(@NonNull StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Exécution du ReadFirstLineTasklet");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String firstLine = reader.readLine().trim();
            chunkContext.getStepContext()
                    .getStepExecution()
                    .getJobExecution()
                    .getExecutionContext()
                    .put("firstLineData", firstLine);
        }
        return RepeatStatus.FINISHED;
    }
}


