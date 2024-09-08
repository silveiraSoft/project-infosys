package com.infytel;

import java.util.List;

import com.infytel.dto.input.CustomerInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.infytel.domain.Customer;
import com.infytel.dto.CustomerDTO;
import com.infytel.service.CustomerService;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Client implements CommandLineRunner {

    @Autowired
    ApplicationContext context;

    @Autowired
    CustomerService service;

    public static void main(String[] args) {
        SpringApplication.run(Client.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //CustomerDTO customer1 = new CustomerDTO(7022713754L, "Adam", 27, 'M', "Chicago", 1);
        //CustomerDTO customer2 = new CustomerDTO(7022713744L, "Susan", 25, 'F', "Alberta", 2);
        //CustomerDTO customer3 = new CustomerDTO(7022713745L, "Andrew", 27, 'M', "Chicago", 2);
        CustomerInputDTO customer1 = CustomerInputDTO.builder()
                .phoneNumber(7022713754L)
                        .name("Adalberto")
                                .age(41)
                                        .gender('M')
                                                .address("Cuba").planId(3).build();


        // invoke service layer method to insert Customer
        service.insertCustomer(customer1);
        //service.insertCustomer(customer2);
        //service.insertCustomer(customer3);

        List<Customer> cus1 = service.searchCustomer(null, null, 'F', null);
        System.out.println(cus1);

        List<Customer> cus2 = service.searchCustomer("Adam", null, 'M', null);
        System.out.println(cus2);

        List<Customer> cus3 = service.searchCustomer(null, null,null , 27);
        System.out.println(cus3);

        List<Customer> cus4 = service.searchCustomer("Susan","Alberta",null, null);
        System.out.println(cus4);

    }

}
