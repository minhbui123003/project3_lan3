package com.javaweb.api.admin;


import com.javaweb.model.dto.*;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.ICustomerService;
import com.javaweb.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "customerAPIOfAdmin")
@RequestMapping("/api/customer")
@Transactional
public class CustomerAPI {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITransactionService transactionService;

    // hàm load giao nhân viên
    @GetMapping("/{id}/staffs")
    public ResponseDTO staff_of_customer(@PathVariable Long id){
        ResponseDTO result = customerService .listStaffs(id) ;
        return result ;
    }

    //   hàm sửa hoặc update tòa nhà
    @PostMapping
    public CustomerDTO addOrUpdateCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO result = customerService.insertOrUpdateCustomer(customerDTO);
        return result;
    }

    //  hàm xóa
    @DeleteMapping("/{ids}")
    public void deleteBuilding(@PathVariable List<Long> ids ) {
        customerService.deletedCustomer(ids);
    }

    //  update việc khách hàng
    @PostMapping("/assignment")
    public void updateAssignmentBuilding (@RequestBody AssignmentCustomerDTO assignmentCustomerDTO) {
//        gọi hàm update
        customerService.updateAssignmentCustomer(assignmentCustomerDTO);
        System.out.println("Update đã xong");
    }

    @PostMapping("/transactionof")
    public TransactionDTO addTransactionCustomer(@RequestBody TransactionDTO transactionDTO){
        return transactionService.insertTran(transactionDTO) ;
    }

    @DeleteMapping ("/transactionof/{id}")
    public void deleteTransactionCustomer(@PathVariable Long id){
        transactionService.delete(id) ;
    }


}
