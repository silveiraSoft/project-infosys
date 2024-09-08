package com.infytel.api.assembler;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class CustomerModelAssembler {
    @Autowired
    private ModelMapper modelMapper;

    public Optional<CustomerDTO> toModel(Customer customer) {
        if (Optional.ofNullable(customer).isPresent()) {
            return Optional.of(modelMapper.map(customer, CustomerDTO.class));
        }
        return Optional.empty();
    }

    public Optional<List<CustomerDTO>> toCollectionModel(List<Customer> customer) {
            if (Optional.ofNullable(customer).isPresent()) {
                return Optional.of(customer.stream()
                        .map(this::toModel)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList()));
            }
            return Optional.empty();
    }
}
