package com.javaweb.api.web;

import com.javaweb.model.dto.CustomerDTO;
import com.javaweb.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "newAPIOfWeb")
@RequestMapping("/api/contact")
public class NewAPI {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(method = RequestMethod.POST)
    public CustomerDTO addOrUpdateCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO result = customerService.insertOrUpdateCustomer(customerDTO);
        return result;
    }
	
}
