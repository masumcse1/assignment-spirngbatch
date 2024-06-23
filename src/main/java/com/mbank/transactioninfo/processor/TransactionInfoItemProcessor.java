package com.mbank.transactioninfo.processor;

import com.mbank.transactioninfo.dto.TransactionInfoDto;
import com.mbank.transactioninfo.entity.TransactionInfo;
import com.mbank.transactioninfo.mapper.DateUtil;
import com.mbank.transactioninfo.mapper.TransactionInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionInfoItemProcessor implements ItemProcessor<TransactionInfoDto, TransactionInfo> {
    private final TransactionInfoMapper transactionInfoMapper;

    @Override
    public TransactionInfo process(TransactionInfoDto item) throws Exception {
        log.info("processing the item: {}",item.toString());
        return transactionInfoMapper.getEntityFromDto(item);
    }


}