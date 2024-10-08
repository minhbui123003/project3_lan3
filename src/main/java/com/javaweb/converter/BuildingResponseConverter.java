package com.javaweb.converter;

import com.javaweb.config.ModelMapperConfig;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.BuildingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingResponseConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BuildingSearchResponse toBuildingSearchResponse (BuildingEntity item){
        BuildingSearchResponse buildingSearchResponse = modelMapper.map(item, BuildingSearchResponse.class);
        buildingSearchResponse.setAddress(item.getStreet()+" "+item.getWard()+""+item.getDistrict());

        List<RentAreaEntity> rentAreas = item.getRentAreas();
        String listRentArea = rentAreas.stream().map(value -> value.getValue().toString() ).collect(Collectors.joining(","));
        buildingSearchResponse.setRentArea(listRentArea);
        return buildingSearchResponse;
    }
}
