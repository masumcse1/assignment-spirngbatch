package com.mbank.transactioninfo.config;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    private final ResourceLoader resourceLoader;

    @Value("${transactioninfo.file.path}")
    private String inputFilePath;

    public JobCompletionNotificationListener(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        // No action needed before job
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        Resource inputFile = resourceLoader.getResource(inputFilePath);

        try {
            File file = inputFile.getFile();
            if (file.exists()) {
                boolean deleted = file.delete();
                if (!deleted) {
                    System.err.println("Failed to delete file: " + file.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
