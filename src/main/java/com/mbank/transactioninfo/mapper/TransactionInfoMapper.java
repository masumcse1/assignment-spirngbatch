package com.mbank.transactioninfo.mapper;

import com.mbank.transactioninfo.dto.TransactionInfoDto;
import com.mbank.transactioninfo.entity.TransactionInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class TransactionInfoMapper {

  public  TransactionInfo getEntityFromDto(TransactionInfoDto transactionInfoDto){

        TransactionInfo transactionInfo = new TransactionInfo();
        transactionInfo.setCUSTOMERId(transactionInfoDto.getCUSTOMER_ID());
        transactionInfo.setAccountNo(transactionInfoDto.getACCOUNT_NUMBER());
        transactionInfo.setTransactionAmount(BigDecimal.valueOf(transactionInfoDto.getTRX_AMOUNT()));
        transactionInfo.setDescription(transactionInfoDto.getDESCRIPTION());
        transactionInfo.setTransactionDate(LocalDate.parse(transactionInfoDto.getTRX_DATE(), DateTimeFormatter.ofPattern(DateUtil.DATEFORMAT)));
        transactionInfo.setTransactionTime(LocalTime.parse(transactionInfoDto.getTRX_TIME(), DateTimeFormatter.ofPattern(DateUtil.TIMEFORMAAT) ));
        return transactionInfo;
    }
}
