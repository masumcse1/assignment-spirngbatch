package com.mbank.transactioninfo.repository;

import com.mbank.transactioninfo.entity.TransactionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionInfoRepository extends JpaRepository<TransactionInfo, Long> {

    List<TransactionInfo> findByCUSTOMERId(String customerId);

    List<TransactionInfo> findByAccountNo(String accountNo);

    @Query("SELECT t FROM TransactionInfo t WHERE t.description LIKE %:description%")
    List<TransactionInfo> findByDescriptionContaining(@Param("description") String description);
}
