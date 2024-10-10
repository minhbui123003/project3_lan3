package com.javaweb.service;

import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;

import java.util.List;
import java.util.Map;

public interface BuildingService {
    ResponseDTO listStaffs(Long buildingId);
    List<BuildingSearchResponse> findAllBuildings(Map<String, Object> params, List<String> typeCode);
    BuildingDTO createBuilding(BuildingDTO buildingDTO);
    void deleteBuilding(List<Long> ids);
    BuildingDTO findBuildingById(Long id);
}
