package com.otmane.Tondeuse.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.TestPropertySourceUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@ActiveProfiles("test")
@SpringBatchTest
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@TestPropertySource(properties = "file.path.input=src/test/resources/data/expected_output.txt")  // chemin du fichier de test

class BatchConfigurationErrorTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    private JobRepositoryTestUtils jobRepositoryTestUtils;

    @Autowired
    private Job processFileJob;

    @Autowired
    private ConfigurableApplicationContext context;

    @Value("${file.path.output}")
    private String outputFilePath;
    @Value("${file.path.expected_output}")
    private String expectedOutputFilePath;

    @BeforeEach
    void setUp() {
        jobLauncherTestUtils.setJob(processFileJob);
        File outputFile = new File(outputFilePath);
        if (outputFile.exists()) {
            outputFile.delete();
        }
    }

    @AfterEach
    void tearDown() {
        jobRepositoryTestUtils.removeJobExecutions();
        File outputFile = new File(outputFilePath);
        if (outputFile.exists()) {
            outputFile.delete();
        }

    }

    @Test
    void importUserJob_WhenJobEnds_ThenStatusFails() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        Assertions.assertEquals(ExitStatus.FAILED.getExitCode(), jobExecution.getExitStatus().getExitCode());
    }
}
