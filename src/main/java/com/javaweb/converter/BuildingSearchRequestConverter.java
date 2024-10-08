package com.javaweb.converter;

import com.javaweb.model.request.BuildingSearchBuilder;
import com.javaweb.utils.MapUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class BuildingSearchRequestConverter {
    public BuildingSearchBuilder toBuildingSearchBuilder(Map<String,Object> params , List<String>typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setName(MapUtils.getObj(params,"name" ,String.class))
                .setFloorArea(MapUtils.getObj(params,"floorArea",Long.class))
                .setWard(MapUtils.getObj(params, "ward", String.class))
                .setStreet(MapUtils.getObj(params, "street", String.class))
                .setDistrict(MapUtils.getObj(params, "district", String.class))
                .setNumberOfBasement(MapUtils.getObj(params, "numberOfBasement", Long.class))
                .setTypeCode(typeCode)
                .setManagerName(MapUtils.getObj(params, "managerName", String.class))
                .setManagerPhone(MapUtils.getObj(params, "managerPhone", String.class))
                .setRentPriceFrom(MapUtils.getObj(params, "rentPriceFrom", Long.class))
                .setRentPriceTo(MapUtils.getObj(params, "rentPriceTo", Long.class))
                .setAreaFrom(MapUtils.getObj(params, "areaFrom", Long.class))
                .setAreaTo(MapUtils.getObj(params, "areaTo", Long.class))
                .setStaffId(MapUtils.getObj(params, "staffId", Long.class))
                .setLevel(MapUtils.getObj(params,"level",Long.class))
                .setDirection(MapUtils.getObj(params,"direction",String.class))
                .build();
        return buildingSearchBuilder;
    }
}
