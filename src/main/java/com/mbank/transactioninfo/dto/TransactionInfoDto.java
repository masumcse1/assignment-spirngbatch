package com.mbank.transactioninfo.dto;

import lombok.Data;

@Data
public class TransactionInfoDto {


    private String ACCOUNT_NUMBER;
    private double TRX_AMOUNT;
    private String DESCRIPTION;
    private String TRX_DATE;
    private String TRX_TIME;
    private String CUSTOMER_ID;




}
