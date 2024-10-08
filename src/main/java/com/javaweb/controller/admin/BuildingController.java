package com.javaweb.controller.admin;
import com.javaweb.enums.District;
import com.javaweb.enums.TypeCode;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.service.IUserService;
import com.javaweb.utils.DistrictCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
//
@Controller (value="buildingControllerOfAdmin")
public class BuildingController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/admin/building-list",method = RequestMethod.GET)
    public ModelAndView buildingList(@ModelAttribute BuildingSearchRequest buildingSearchRequest, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelSearch",buildingSearchRequest);
//        xuống DB laays data
        List<BuildingSearchResponse> responseList = new ArrayList<>();
        BuildingSearchResponse bd1 = new BuildingSearchResponse();
        bd1.setId(1L);
        bd1.setName("khánh linh Building");
        bd1.setFloorArea(123L);
        bd1.setAddress("02 văn tiến dũng hà nội");
        bd1.setNumberOfBasement(3L);
        bd1.setManagerName("BQM");


        BuildingSearchResponse bd2 = new BuildingSearchResponse();
        bd2.setId(4L);
        bd2.setName("BKL Building");
        bd2.setFloorArea(333L);
        bd2.setAddress("01 văn tiến dũng hà nội");
        bd2.setNumberOfBasement(6L);
        bd2.setManagerName("BQM");
        bd2.setManagerPhoneNumber("0900126130");
        responseList.add(bd1);
        responseList.add(bd2);

        mav.addObject("buildingList",responseList);
        mav.addObject("listStaffs",userService.getStaffs());
        mav.addObject("listDistricts", District.type());
        mav.addObject("listTypeCode", TypeCode.listTypeCode());
        return mav;
    }

    @RequestMapping(value = "/admin/building-edit",method = RequestMethod.GET)
    public ModelAndView buildingEdit(@ModelAttribute("buildingEdit") BuildingDTO buildingDTO , HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");


        mav.addObject("listDistricts", District.type());
        mav.addObject("listTypeCode", TypeCode.listTypeCode());

        return mav;
    }

    @RequestMapping(value = "/admin/building-edit-{id}",method = RequestMethod.GET)
    public ModelAndView buildingEdit(@PathVariable("id") Long id, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("admin/building/edit");
//        xuống DB tìm building theo id
        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setId(id);
        buildingDTO.setName("khánh linh Building");
        buildingDTO.setFloorArea(123L);
        mav.addObject("buildingEdit",buildingDTO);

        mav.addObject("listDistricts", District.type());
        mav.addObject("listTypeCode", TypeCode.listTypeCode());
        return mav;
    }
}
