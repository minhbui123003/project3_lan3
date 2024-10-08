package com.javaweb.repository.custom;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchBuilder;

import java.util.List;

public interface BuildingRepositoryCustom {
    List<BuildingEntity> findAllBuildings(BuildingSearchBuilder buildingSearchBuilder);
}
