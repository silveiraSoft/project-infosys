package com.infytel.api.controller;

import com.infytel.api.assembler.CustomerInputDisassembler;
import com.infytel.api.assembler.CustomerModelAssembler;
import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public List<CustomerDTO> list() {
        return customerService.listar();
    }

    @GetMapping("/{phone}")
    public CustomerDTO find(@PathVariable("phone") Long nrPhone) {
        return customerService.find(nrPhone);
    }

    @DeleteMapping("/{phone}")
    public void remove(@PathVariable("phone") Long nrPhone) {
        customerService.remove(nrPhone);
    }
}
