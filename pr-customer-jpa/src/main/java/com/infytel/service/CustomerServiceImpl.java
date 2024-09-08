package com.infytel.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.infytel.api.assembler.CustomerInputDisassembler;
import com.infytel.api.assembler.CustomerModelAssembler;
import com.infytel.api.exception.EntityNotFoundException;
import com.infytel.dto.input.CustomerInputDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.repository.CustomerRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service("customerService")
@Slf4j
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository  repository;

    @Autowired
    CustomerInputDisassembler customerInputDisassembler;

    @Autowired
    CustomerModelAssembler customerModelAssembler;

    @Override
    @ResponseStatus
    public List<CustomerDTO> listar() {
        Optional<List<CustomerDTO>> result = customerModelAssembler.toCollectionModel(repository.findAll());
        if(result.isPresent())
           return result.get();
        throw new EntityNotFoundException("Data not found");
    }

    public void insertCustomer(CustomerInputDTO customerInputDTO) {
        repository.saveAndFlush(customerInputDisassembler.toDomainObjet(customerInputDTO));
    }

    @Override
    public List<Customer> searchCustomer(String name, String address, Character gender, Integer age) {
        return repository.searchCustomer(name, address, gender, age);
    }

    @Override
    public CustomerDTO find(Long phone) {
        //Customer customer = repository.findByPhoneNumber(phone).orElseThrow(()-> EntityNotFoundException(String.format("Customer not found with number %d", phone)));
        Optional<CustomerDTO> result = customerModelAssembler.toModel(repository.findByPhoneNumber(phone));
        if(result.isPresent())
            return result.get();
        throw new EntityNotFoundException(String.format("Customer not found with number %d", phone));
    }

    @Override
    public void remove(Long nrPhone) {
        try {
            if(!Objects.isNull(find(nrPhone)));
            {
                repository.deleteById(nrPhone);
                log.info(String.format("Customer with id %d was deleted", nrPhone));
            }
        } catch (EntityNotFoundException e) {
            log.info(String.format("Customer with id %d was deleted", nrPhone));
        }
    }

    @Override
    public String updateCustomer(Long phoneNo, Integer newPlanId) {
        Optional<Customer> optionalCustomer = repository.findById(phoneNo);
        Customer customerEntity = optionalCustomer.get();
        customerEntity.setPlanId(newPlanId);
        repository.save(customerEntity);
        return "The plan for the customer with phone number :" + phoneNo + " has been updated successfully.";
    }
}
