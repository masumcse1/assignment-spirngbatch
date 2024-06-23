package com.mbank.transactioninfo.entity;

import lombok.Data;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class TransactionInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String CUSTOMERId;
    private String accountNo;
    private BigDecimal transactionAmount;
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private String description;

}
