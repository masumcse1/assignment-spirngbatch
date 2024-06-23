package com.mbank.transactioninfo.mapper;

import com.mbank.transactioninfo.dto.TransactionInfoDto;
import com.mbank.transactioninfo.entity.TransactionInfo;
import org.springframework.stereotype.Component;

@Component
public class TransactionInfoMapper {

  public  TransactionInfo getEntityFromDto(TransactionInfoDto transactionInfoDto){

        TransactionInfo transactionInfo = new TransactionInfo();
        transactionInfo.setCUSTOMERId(transactionInfoDto.getCUSTOMER_ID());
        transactionInfo.setAccountNo(transactionInfoDto.getACCOUNT_NUMBER());
        transactionInfo.setTransactionAmount(transactionInfoDto.getTRX_AMOUNT());
        transactionInfo.setDescription(transactionInfoDto.getDESCRIPTION());
        transactionInfo.setTransactionDate(DateUtil.getDate(transactionInfoDto.getTRX_DATE(),"yyyy-MM-dd"));
        transactionInfo.setTransactionTime(DateUtil.getTime(transactionInfoDto.getTRX_TIME(),"HH:mm:ss"));

        return transactionInfo;
    }
}
