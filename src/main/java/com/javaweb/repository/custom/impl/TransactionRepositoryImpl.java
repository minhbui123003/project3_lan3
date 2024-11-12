package com.javaweb.repository.custom.impl;

import com.javaweb.entity.TransactionEntity;
import com.javaweb.repository.custom.TransactionRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class TransactionRepositoryImpl implements TransactionRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TransactionEntity> findTranSacTionbyCustomerId(Long customerid, Long staffId) {
        StringBuilder sql = new StringBuilder(" select * from transaction where customerid =  "+ customerid +" " );
        if(staffId != null){
            sql.append(" and staffid = " + staffId + " " );
        }
        Query query = entityManager.createNativeQuery(sql.toString(), TransactionEntity.class);
        return query.getResultList();
    }
}
