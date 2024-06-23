package com.mbank.transactioninfo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;

@Entity
@Data
public class TransactionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNo;
    private double transactionAmount;
    private String description;
    private Date transactionDate;
    private Date transactionTime;
    private String CUSTOMERId;

}
