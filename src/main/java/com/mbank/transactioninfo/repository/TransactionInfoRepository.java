package com.mbank.transactioninfo.repository;

import com.mbank.transactioninfo.entity.TransactionInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionInfoRepository extends JpaRepository<TransactionInfo, Long> {

    Page<TransactionInfo> findByCUSTOMERIdContainingOrAccountNoContainingOrDescriptionContaining(
            String customerId, String accountNo, String description, Pageable pageable);
}
