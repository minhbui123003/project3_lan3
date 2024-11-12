package com.javaweb.repository.custom;

import com.javaweb.entity.TransactionEntity;

import java.util.List;

public interface TransactionRepositoryCustom {
    List<TransactionEntity> findTranSacTionbyCustomerId(Long customerid, Long staffId) ;
}
