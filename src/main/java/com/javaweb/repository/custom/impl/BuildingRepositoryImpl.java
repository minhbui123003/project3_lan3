package com.javaweb.repository.custom.impl;

import com.javaweb.entity.BuildingEntity;

import com.javaweb.model.request.BuildingSearchBuilder;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.utils.NumberDifferent0;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    private static void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder join) {
        Long staffId = buildingSearchBuilder.getStaffId();
        if(NumberDifferent0.checkNumberKhacO(staffId)) {
            join.append("  inner join assignmentbuilding on assignmentbuilding.buildingid = b.id    ");
        }

    }

    private static void queryNomal (BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
        try
        {
            Field[] fields = buildingSearchBuilder.getClass().getDeclaredFields();
            for (Field item : fields) {
                item.setAccessible(true);
                String fieldName = item.getName();
                if(!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.startsWith("area") && !fieldName.startsWith("rentPrice") ) {
                    Object value = item.get(buildingSearchBuilder);
                    if(value instanceof String) {
                        value = ((String) value).trim();
                    }
                    if(value != null && !(value instanceof String && ((String) value).trim().isEmpty())  ) {
                        if(item.getType().getName().equals("java.lang.Long") || item.getType().getName().equals("java.lang.Integer") 
                                ||item.getType().getName().equals("java.lang.Float")) 
                        {
                            where.append(" and  b."+fieldName+" =  "+value+"   " );
                        }
                        else if (item.getType().getName().equals("java.lang.String")) {
                            where.append(" and  b."+fieldName+" like '%"+value+"%'   ");
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void querySpecial (BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
        Long staffId = buildingSearchBuilder.getStaffId();
        if(NumberDifferent0.checkNumberKhacO(staffId)) {
            where.append(" and assignmentbuilding.staffId = "+staffId+"  ");
        }
        Long areaTo = buildingSearchBuilder.getAreaTo();
        Long areaFrom = buildingSearchBuilder.getAreaFrom();
        if(NumberDifferent0.checkNumberKhacO(areaTo) && NumberDifferent0.checkNumberKhacO(areaFrom)) {
            where.append(" and exists (select * from rentarea r where b.id = r.buildingid  ");
            if(NumberDifferent0.checkNumberKhacO(areaFrom)) {
                where.append(" and r.value >= " +areaFrom +"   ");
            }
            if(NumberDifferent0.checkNumberKhacO(areaTo)) {
                where.append(" and r.value <= " +areaTo +"   ");
            }
            where.append(" )  ");
        }

        Long rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
        Long rentPriceTo = buildingSearchBuilder.getRentPriceTo();
        if(NumberDifferent0.checkNumberKhacO(rentPriceFrom) && NumberDifferent0.checkNumberKhacO(rentPriceTo)) {

            if(NumberDifferent0.checkNumberKhacO(rentPriceFrom)) {
                where.append(" and b.rentprice >= " +rentPriceFrom +"   ");
            }
            if(NumberDifferent0.checkNumberKhacO(rentPriceTo)) {
                where.append(" and b.rentprice <= " +rentPriceTo +"   ");
            }

        }

        List<String> typeCode = buildingSearchBuilder.getTypeCode();
        if(typeCode!=null && typeCode.size() != 0)  {
            where.append("  and (  ");
            String sql = typeCode.stream().map(it->"b.type like '%"+it+"%' ").collect(Collectors.joining(" or "));
            where.append(sql);
            where.append(" ) ");
        }
    }


    @Override
    public Page<BuildingEntity> findAllBuildings(BuildingSearchBuilder buildingSearchBuilder , Pageable pageable) {
        System.out.println("Connecting with database building");

//        StringBuilder sql = new StringBuilder("SELECT b.id, b.name, b.numberofbasement, b.ward, b.street, b.district, b.managername," +
//                " b.managerphone, b.floorarea, b.rentprice, b.servicefee FROM building b");
        StringBuilder sql = new StringBuilder("select b.* from building b");

        //  Join các bảng lại
        joinTable(buildingSearchBuilder, sql);

        // Where clause
        StringBuilder where = new StringBuilder(" WHERE 1=1 ");
        queryNomal(buildingSearchBuilder, where);
        querySpecial(buildingSearchBuilder, where);

        // thêm câu lệnh where
        sql.append(where);

        // Tính tổng số bản ghi và ta biết mỗi trang có bao nhiêu bản thì có thể tính d
        String countSql = "SELECT COUNT(*) FROM (" + sql.toString() + ") AS countQuery";
        Query countQuery = entityManager.createNativeQuery(countSql);
        Long total = ((Number) countQuery.getSingleResult()).longValue();

        // Thêm điều kiện phân trang
        sql.append(" LIMIT ").append(pageable.getPageSize()).append(" OFFSET ").append(pageable.getPageNumber() * pageable.getPageSize());

        System.out.println("câu lệnh sql : "+sql);

        // Execute the query
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);

        // Get results
        List<BuildingEntity> resultList = query.getResultList();

        // Tạo Page kết quả
        return new PageImpl<>(resultList, pageable, total);
    }


}
