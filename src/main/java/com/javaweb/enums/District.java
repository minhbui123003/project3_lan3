package com.javaweb.enums;


import java.util.Map;
import java.util.TreeMap;

public enum District {
    QUAN_1 ("Quận 1"),
    QUAN_2 ("Quận 2"),
    QUAN_3 ("Quận 3"),
    QUAN_4 ("Quận 4"),
    QUAN_5 ("Quận 5"),
    QUAN_6 ("Quận 6"),
    QUAN_7 ("Quận 7"),
    QUAN_8 ("Quận 8"),
    BA_DINH ("Quận Ba Đình"),
    HOAN_KIEM ("Quận Hoàn Kiếm"),
    TAY_HO ("Quận Tây Hồ"),
    CAU_GIAY ("Quận Cầu Giấy"),
    DONG_DA ("Quận Đống Đa"),
    HAI_BA_TRUNG ("Quận Hai Bà Trưng"),
    HOANG_MAI ("Quận Hoàng Mai"),
    LONG_BIEN ("Quận Long Biên"),
    NAM_TU_LIEM ("Quận Nam Từ Liêm"),
    BAC_TU_LIEM ("Quận Bắc Từ Liêm")
    ;


    private final String districtName;
    District(String districtName) {
        this.districtName = districtName;
    }

    public String getDistrictName() {
        return districtName;
    }


    public static Map<String,String> type(){
        Map<String,String> listType = new TreeMap<>();
        for(District item : District.values()){
            listType.put(item.toString() , item.districtName);
        }
        return listType;
    }
}
