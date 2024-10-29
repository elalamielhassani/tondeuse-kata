package com.otmane.Tondeuse.components.listeners;

import com.otmane.Tondeuse.components.TondeuseDataReader;
import com.otmane.Tondeuse.exception.ReaderException;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TondeuseDataReaderListener implements StepExecutionListener {

    private final TondeuseDataReader reader;

    public TondeuseDataReaderListener(TondeuseDataReader reader) {
        this.reader = reader;
    }

    @Override
    public ExitStatus afterStep(@NonNull StepExecution stepExecution) {

        try {
            reader.closeReader();
        } catch (IOException e) {
            throw new ReaderException(e.getMessage());
        }

        return stepExecution.getExitStatus();
    }
}
