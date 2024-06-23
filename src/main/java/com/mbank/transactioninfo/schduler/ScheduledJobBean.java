package com.mbank.transactioninfo.schduler;

import com.mbank.transactioninfo.mapper.DateUtil;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledJobBean
{
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;


    @Scheduled(cron = "${cron.value}")
    public void perform() throws Exception
    {

        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();

        jobLauncher.run(job, params);
    }
}