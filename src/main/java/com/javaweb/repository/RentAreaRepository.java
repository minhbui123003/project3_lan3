package com.javaweb.repository;

import com.javaweb.entity.RentAreaEntity;

import java.util.List;

public interface RentAreaRepository {
    List<RentAreaEntity> getvalueByBuildingId(Long id);
}
