package com.infytel.api.assembler;

import com.infytel.domain.Customer;
import com.infytel.dto.input.CustomerInputDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerInputDisassembler {
    @Autowired
    private ModelMapper modelMapper;

    public Customer toDomainObjet(CustomerInputDTO customerInputDTO){
        return modelMapper.map(customerInputDTO, Customer.class);
    }
    public void CopyToDomainObjet(CustomerInputDTO customerInputDTO, Customer customer){
        //customer.setPlan(nre Plan());
        modelMapper.map(customerInputDTO, customer);
    }
}
