package com.otmane.Tondeuse.config;

import com.otmane.Tondeuse.components.FileWriterConfig;
import com.otmane.Tondeuse.components.ReadFirstLineTasklet;
import com.otmane.Tondeuse.components.TondeuseDataReader;
import com.otmane.Tondeuse.components.TondeuseProcessor;
import com.otmane.Tondeuse.components.listeners.JobCompletionNotificationListener;
import com.otmane.Tondeuse.components.listeners.TondeuseDataReaderListener;
import com.otmane.Tondeuse.entities.Tondeuse;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TondeuseJobConfiguration {

    private final PlatformTransactionManager transactionManager;
    private final FileWriterConfig fileWriterConfig;

    public TondeuseJobConfiguration(
            PlatformTransactionManager transactionManager,
            FileWriterConfig fileWriterConfig) {
        this.transactionManager = transactionManager;
        this.fileWriterConfig = fileWriterConfig;
    }

    @Bean
    public Job processFileJob(Step readFirstLineStep,
                              Step processPairsStep,
                              JobRepository jobRepository,
                              JobCompletionNotificationListener listener) {
        return new JobBuilder("processFileJob", jobRepository)
                .listener(listener)
                .start(readFirstLineStep)
                .next(processPairsStep)
                .build();
    }

    @Bean
    public Step readFirstLineStep(JobRepository jobRepository,
                                  ReadFirstLineTasklet readFirstLineTasklet,
                                  DataSourceTransactionManager transactionManager) {

        return new StepBuilder("readFirstLineStep", jobRepository)
                .tasklet(readFirstLineTasklet, transactionManager)
                .build();
    }

    @Bean
    public Step processPairsStep(JobRepository jobRepository,
                                 TondeuseDataReader reader,
                                 TondeuseProcessor processor,
                                 DataSourceTransactionManager transactionManager,
                                 TondeuseDataReaderListener tondeuseDataReaderListener) {
        return new StepBuilder("processPairsStep", jobRepository)
                .<Tondeuse, String>chunk(1, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(fileWriterConfig.writer())
                .listener(tondeuseDataReaderListener)
                .build();
    }
}
