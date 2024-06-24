package com.mbank.transactioninfo.config;

import com.mbank.transactioninfo.dto.TransactionInfoDto;
import com.mbank.transactioninfo.entity.TransactionInfo;
import com.mbank.transactioninfo.processor.TransactionInfoItemProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import javax.persistence.EntityManagerFactory;

@Configuration
@RequiredArgsConstructor
public class TransactionInfoJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;
    private final TransactionInfoItemProcessor transactionInfoItemProcessor;


    @Bean
    public Job importTransacitonInfo(){
        return jobBuilderFactory.get("importTransacitonInfo")
                .incrementer(new RunIdIncrementer())
                .start(fromFileIntoDataBase())
                .build();
    }


    @Bean
    public Step fromFileIntoDataBase(){
        return stepBuilderFactory.get("fromFileIntoDataBase")
                .<TransactionInfoDto,TransactionInfo>chunk(10)
                .reader(transactIoninfoInfoFileReader())
                .processor(transactionInfoItemProcessor)
                .writer(transactionInfoItemWriter())
                .build();
    }

    @Bean
    public FlatFileItemReader<TransactionInfoDto> transactIoninfoInfoFileReader(){
        return new FlatFileItemReaderBuilder<TransactionInfoDto>()
                .resource(new ClassPathResource("data/dataSource.txt"))
                .name("transactioninfoInfoFileReader")
                .delimited()
                .delimiter("|")
                .names(new String[]{"ACCOUNT_NUMBER","TRX_AMOUNT","DESCRIPTION","TRX_DATE","TRX_TIME","CUSTOMER_ID"})
                .linesToSkip(1)
                .targetType(TransactionInfoDto.class)
                .build();
    }

    @Bean
    public JpaItemWriter<TransactionInfo> transactionInfoItemWriter(){
        return new JpaItemWriterBuilder<TransactionInfo>()
                .entityManagerFactory(entityManagerFactory)
                .build();
    }


}
