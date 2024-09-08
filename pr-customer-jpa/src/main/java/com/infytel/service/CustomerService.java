package com.infytel.service;


import java.util.List;
import java.util.Optional;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.dto.input.CustomerInputDTO;

public interface CustomerService {

    public List<CustomerDTO> listar();

    public void insertCustomer(CustomerInputDTO customerInputDTO);

    public List<Customer> searchCustomer(String name, String address, Character gender, Integer age) ;

    CustomerDTO find(Long phone);

    void remove(Long nrPhone);

    String updateCustomer(Long phoneNo, Integer newPlanId);
}
