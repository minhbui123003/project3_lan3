package com.javaweb.enums;

import java.util.HashMap;
import java.util.Map;

public enum TypeCode {
    TANG_TRET("Tầng Trệt"),
    NOI_THAT("Nội Thất"),
    NGUYEN_CAN("Nguyên Căn");

    private final String name;
    private TypeCode(String name){
        this.name = name;
    }
    public String getName(){return name;   }

    public static Map<String,String> listTypeCode() {
        Map<String,String> listType = new HashMap<>();
        for(TypeCode item : TypeCode.values()){
            listType.put(item.toString() , item.name);
        }
        return listType;
    }
}
