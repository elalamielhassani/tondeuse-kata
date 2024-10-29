package com.otmane.Tondeuse.components;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

@Component
public class FileWriterConfig {
    private final String filePath;

    public FileWriterConfig(@Value("${file.path.output}") String filePath) {
        this.filePath = filePath;
    }

    public FlatFileItemWriter<String> writer() {
        return new FlatFileItemWriterBuilder<String>()
                .name("writer")
                .resource(new FileSystemResource(filePath))
                .lineAggregator(item -> item)
                .build();
    }
}