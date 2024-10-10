package com.javaweb.service.impl;

import com.javaweb.converter.BuildingConverter;
import com.javaweb.converter.BuildingResponseConverter;
import com.javaweb.converter.BuildingSearchRequestConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchBuilder;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BuildingSearchRequestConverter buildingSearchRequestConverter;
    @Autowired
    private BuildingResponseConverter buildingResponseConverter;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private BuildingConverter buildingConverter;

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

    @Override
    public BuildingDTO createBuilding(BuildingDTO dto) {
//        cập nhật
       if(dto.getId()!= null){

           BuildingEntity building = buildingRepository.findById(dto.getId()).get();
           building = buildingConverter.toBuildingEntity(dto);
           buildingRepository.save(building) ;

           List<String> list = Arrays.asList(dto.getRentArea().split(","));

           List<RentAreaEntity> rentAreaEntities= rentAreaRepository.findAll(dto.getId());
           for(RentAreaEntity db : rentAreaEntities){
               rentAreaRepository.delete(db);
           }

           for (String it: list) {
               RentAreaEntity rnew = new RentAreaEntity() ;
               rnew.setValue(it);
               rnew.setBuilding(building);
               rentAreaRepository.save(rnew) ;
           }


       }
//       thêm
       else {
           BuildingEntity building = buildingConverter.toBuildingEntity(dto);
           buildingRepository.save(building) ;
           List<String> list = Arrays.asList(dto.getRentArea().split(","));
           for (String it: list) {
               RentAreaEntity rnew = new RentAreaEntity() ;
               rnew.setValue(it);
               rnew.setBuilding(building);
               rentAreaRepository.save(rnew) ;
           }

       }
       return dto;
    }

    @Override
    public void deleteBuilding(List<Long> ids) {
       for(Long id : ids)
       {
           BuildingEntity buildingEntity = buildingRepository.findById(id).get();
           List<RentAreaEntity> rentAreaEntities  = rentAreaRepository.findAll(id);
           for(RentAreaEntity it : rentAreaEntities){
               rentAreaRepository.delete(it);
           }
           buildingEntity.getUserEntities().clear();
           buildingRepository.delete(buildingEntity);
       }
    }

    @Override
    public BuildingDTO findBuildingById(Long id) {
       BuildingEntity building = buildingRepository.findById(id).get();
       BuildingDTO buildingDTO = buildingConverter.toBuildingDTO(building);
       List<RentAreaEntity> list = rentAreaRepository.findAll(building.getId());
//       taoj một chuỗi để lưu giá trị của rentAreaValues
        StringBuilder rentAreaValues = new StringBuilder();
        for (RentAreaEntity it : list) {
            if (rentAreaValues.length() > 0) {
                rentAreaValues.append(", "); // phân cách giữa các giá trị
            }
            rentAreaValues.append(it.getValue());
        }

        // Set chuỗi chứa nhiều giá trị vào DTO
        buildingDTO.setRentArea(rentAreaValues.toString());
       return buildingDTO;
    }

}
