package com.javaweb.converter;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.dto.BuildingDTO;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {
    public BuildingDTO toBuildingEntity (BuildingEntity buildingEntity) {

        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setId(buildingEntity.getId());
        buildingDTO.setName(buildingEntity.getName());
        buildingDTO.setFloorArea(buildingEntity.getFloorArea());
        buildingDTO.setDistrict(buildingEntity.getDistrict());
        buildingDTO.setWard(buildingEntity.getWard());
        buildingDTO.setStructure(buildingEntity.getStructure());
        buildingDTO.setStreet(buildingEntity.getStreet());
        buildingDTO.setNumberOfBasement(buildingEntity.getNumberOfBasement());
        buildingDTO.setDirection(buildingEntity.getDirection());
        buildingDTO.setLevel(buildingEntity.getLevel());
        buildingDTO.setRentPrice(buildingEntity.getRentPrice());
        buildingDTO.setRentPriceDescription(buildingEntity.getRentPriceDesc());
        buildingDTO.setServiceFee(buildingEntity.getServiceFee());
        buildingDTO.setCarFee(buildingEntity.getCarFee());
        buildingDTO.setMotorbikeFee(buildingEntity.getMotoFee());
        buildingDTO.setOverTimeFee(buildingEntity.getOvertimeFee());
        buildingDTO.setElectricityFee(buildingEntity.getElectricFee());
        buildingDTO.setDeposit(buildingEntity.getDeposit());
        buildingDTO.setRentTime(buildingEntity.getRentTime());
        buildingDTO.setDecorationTime(buildingEntity.getDecorTime());
        buildingDTO.setBrokerageFee(buildingEntity.getBrokerageFee());
        buildingDTO.setManagerName(buildingEntity.getManagerName());
        buildingDTO.setManagerPhone(buildingEntity.getManagerPhone());
        buildingDTO.setPayment(buildingEntity.getPayment());
        buildingDTO.setNote(buildingEntity.getNote());
        buildingDTO.setImage(buildingEntity.getAvatar());

//        xử lý phần rentArea cho diện tích
        List<RentAreaEntity> rentareas = buildingEntity.getRentAreas();
        buildingDTO.setRentArea(rentareas.stream().map(it -> it.toString()).collect(Collectors.joining(",")));
//        từ string về list
        buildingDTO.setTypeCode(Arrays.stream(buildingEntity.getTypeCode().split(",")).collect(Collectors.toList())) ;

        return buildingDTO;
    }
   public  BuildingEntity toBuildingDTO (BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = new BuildingEntity();
        buildingEntity.setId(buildingDTO.getId());
        buildingEntity.setName(buildingDTO.getName());
        buildingEntity.setFloorArea(buildingDTO.getFloorArea());
        buildingEntity.setDistrict(buildingDTO.getDistrict());
        buildingEntity.setWard(buildingDTO.getWard());
        buildingEntity.setStructure(buildingDTO.getStructure());
        buildingEntity.setStreet(buildingDTO.getStreet());
        buildingEntity.setNumberOfBasement(buildingDTO.getNumberOfBasement());
        buildingEntity.setDirection(buildingDTO.getDirection());
        buildingEntity.setLevel(buildingDTO.getLevel());
        buildingEntity.setRentPrice(buildingDTO.getRentPrice());
        buildingEntity.setRentPriceDesc(buildingDTO.getRentPriceDescription());
        buildingEntity.setServiceFee(buildingDTO.getServiceFee());
        buildingEntity.setCarFee(buildingDTO.getCarFee());
        buildingEntity.setMotoFee(buildingDTO.getMotorbikeFee());
        buildingEntity.setOvertimeFee(buildingDTO.getOverTimeFee());
        buildingEntity.setElectricFee(buildingDTO.getElectricityFee());
        buildingEntity.setDeposit(buildingDTO.getDeposit());
        buildingEntity.setRentTime(buildingDTO.getRentTime());
        buildingEntity.setDecorTime(buildingDTO.getDecorationTime());
        buildingEntity.setBrokerageFee(buildingDTO.getBrokerageFee());
        buildingEntity.setManagerName(buildingDTO.getManagerName());
        buildingEntity.setManagerPhone(buildingDTO.getManagerPhone());
        buildingEntity.setTypeCode(String.join(",", buildingDTO.getTypeCode())); // Chuyển đổi từ List<String> sang String
        buildingEntity.setPayment(buildingDTO.getPayment());
        buildingEntity.setNote(buildingDTO.getNote());
        buildingEntity.setAvatar(buildingDTO.getImageName());

        return buildingEntity;
    }
}
