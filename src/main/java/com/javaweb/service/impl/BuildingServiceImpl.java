package com.javaweb.service.impl;

import com.javaweb.converter.BuildingResponseConverter;
import com.javaweb.converter.BuildingSearchRequestConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.request.BuildingSearchBuilder;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BuildingSearchRequestConverter buildingSearchRequestConverter;
    @Autowired
    private BuildingResponseConverter buildingResponseConverter;

    @Override
    public ResponseDTO listStaffs(Long buildingId) {
        BuildingEntity building = buildingRepository.findById(buildingId).get();
        List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1,"STAFF");
        List<UserEntity> staffAssignmentBuilding = building.getUserEntities();
        List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();

        ResponseDTO result = new ResponseDTO();

        for(UserEntity item : staffs){
            StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
            staffResponseDTO.setFullName(item.getFullName());
            staffResponseDTO.setStaffId(item.getId());
            if(staffAssignmentBuilding.contains(item)){
                staffResponseDTO.setChecked("checked");
            }
            else
            {
                staffResponseDTO.setChecked("no success");
            }
            staffResponseDTOS.add(staffResponseDTO);
        }

        result.setData(staffResponseDTOS);
        result.setMessage("success");
        return result ;
    }


    @Override
    public List<BuildingSearchResponse> findAllBuildings(Map<String, Object> params, List<String> typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchRequestConverter.toBuildingSearchBuilder( params,typeCode);
        List<BuildingEntity> listBuildingEntities = buildingRepository.findAllBuildings(buildingSearchBuilder);

        List<BuildingSearchResponse> result = new ArrayList<BuildingSearchResponse>();


        for(BuildingEntity item : listBuildingEntities){
            BuildingSearchResponse buildingSearchResponse = buildingResponseConverter.toBuildingSearchResponse(item);

            // Thêm các trường audit nếu chưa có
            buildingSearchResponse.setCreatedDate(item.getCreatedDate()); // Thêm
            buildingSearchResponse.setCreatedBy(item.getCreatedBy()); // Thêm
            buildingSearchResponse.setModifiedDate(item.getModifiedDate()); // Thêm
            buildingSearchResponse.setModifiedBy(item.getModifiedBy()); // Thêm

            result.add(buildingSearchResponse);

        }


        return result;
    }

}
