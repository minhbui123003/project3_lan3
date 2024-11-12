package com.javaweb.service;

import com.javaweb.model.dto.TransactionDTO;

public interface ITransactionService {
    TransactionDTO insertTran(TransactionDTO transactionDTO) ;

    void delete(Long id);
}
