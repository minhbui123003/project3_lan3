package com.javaweb.service.impl;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.dto.TransactionDTO;
import com.javaweb.repository.CustomerRepository;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.ITransactionService;
import org.modelmapper.ModelMapper;
import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionDTO insertTran(TransactionDTO transactionDTO) {
        TransactionEntity gd = modelMapper.map(transactionDTO, TransactionEntity.class);
        if(SecurityUtils.getAuthorities().contains("ROLE_STAFF")){
            Long staffId = SecurityUtils.getPrincipal().getId();
            gd.setStaffid(staffId);
        }
        CustomerEntity customer = customerRepository.findById(transactionDTO.getCustomerid()).get() ;
        gd.setCustomerEntity(customer);
        transactionRepository.save(gd) ;
        return transactionDTO ;
    }
    @Override
    public void delete(Long id) {
        TransactionEntity t = transactionRepository.findById(id).get() ;
        transactionRepository.delete(t);
    }
}
