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
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@ActiveProfiles("test")
@SpringBatchTest
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class BatchConfigurationTest {

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
    void importUserJob_WhenJobEnds_ThenStatusCompleted() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        Assertions.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());

        File outputFile = new File(outputFilePath);
        Assertions.assertTrue(outputFile.exists());
        verifyFilesContent();
    }

    private void verifyFilesContent() throws Exception {
        List<String> actualContent = Files.readAllLines(Path.of(outputFilePath));
        List<String> expectedContent = Files.readAllLines(Path.of(expectedOutputFilePath));

        Assertions.assertEquals(expectedContent, actualContent, "The contents of the files do not match");
    }

}
