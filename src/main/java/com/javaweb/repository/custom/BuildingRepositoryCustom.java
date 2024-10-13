package com.javaweb.repository.custom;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.request.BuildingSearchBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuildingRepositoryCustom {
//    List<BuildingEntity> findAllBuildings(BuildingSearchBuilder buildingSearchBuilder);
    Page<BuildingEntity> findAllBuildings(BuildingSearchBuilder buildingSearchBuilder , Pageable pageable);

}
