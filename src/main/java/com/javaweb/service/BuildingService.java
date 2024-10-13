package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BuildingService {
//    trả về ds nhân viên
    ResponseDTO listStaffs(Long buildingId);
//    tìm tất cả hoặc 1 tòa nhà
    Page<BuildingSearchResponse> findAllBuildings(Map<String, Object> params, List<String> typeCode , Pageable pageable);
//    tạo tòa nhà hoặc sửa tòa nhà
    BuildingDTO createBuilding(BuildingDTO buildingDTO);
//    xóa 1 hoặc nhiều tòa nhà
    void deleteBuilding(List<Long> ids);
//    tìm 1 tòa nhà để trả DB lên font-end khi sửa
    BuildingDTO findBuildingById(Long id);
//    update nhân viên giao tòa nhà
    void updateAssignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);

}
