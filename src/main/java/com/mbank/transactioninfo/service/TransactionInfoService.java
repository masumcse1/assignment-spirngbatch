package com.mbank.transactioninfo.service;

import com.mbank.transactioninfo.entity.TransactionInfo;
import com.mbank.transactioninfo.repository.TransactionInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionInfoService {

    @Autowired
    private TransactionInfoRepository repository;

    public Page<TransactionInfo> searchTransactions(String customerId, String accountNo, String description, Pageable pageable) {
        return repository.findByCustomerIdContainingOrAccountNoContainingOrDescriptionContaining(
                customerId, accountNo, description, pageable);
    }

    @Transactional
    public TransactionInfo updateDescription(Long id, String description) throws Exception {
        Optional<TransactionInfo> optionalTransactionInfo = repository.findById(id);
        if (optionalTransactionInfo.isPresent()) {
            TransactionInfo transactionInfo = optionalTransactionInfo.get();
            transactionInfo.setDescription(description);
            return repository.save(transactionInfo);
        } else {
            throw new Exception("Transaction not found");
        }
    }
}
