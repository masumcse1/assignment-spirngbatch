package com.mbank.transactioninfo.controller;

import com.mbank.transactioninfo.entity.TransactionInfo;
import com.mbank.transactioninfo.service.TransactionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionInfoController {

    @Autowired
    private TransactionInfoService transactionInfoService;

    @GetMapping("/search")
    public Page<TransactionInfo> searchTransactions(
            @RequestParam(required = false) String customerId,
            @RequestParam(required = false) String accountNo,
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        return transactionInfoService.searchTransactions(customerId, accountNo, description, pageable);
    }

    @GetMapping("/search/customer")
    public List<TransactionInfo> searchByCustomerId(@RequestParam String customerId) {
        return transactionInfoService.getTransactionsByCustomerId(customerId);
    }

    @GetMapping("/search/account")
    public List<TransactionInfo> searchByAccountNo(@RequestParam String accountNo) {
        return transactionInfoService.getTransactionsByAccountNo(accountNo);
    }

    @GetMapping("/search/description")
    public List<TransactionInfo> searchByDescription(@RequestParam String description) {
        return transactionInfoService.getTransactionsByDescription(description);
    }


    @PutMapping("/update/{id}")
    public TransactionInfo updateDescription(@PathVariable Long id, @RequestParam String description) throws Exception {
        return transactionInfoService.updateDescription(id, description);
    }


}
