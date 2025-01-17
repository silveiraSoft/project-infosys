package com.infytel.service;
import com.infytel.dto.CustomerDTO;
public interface CustomerService {
    // Method to access the repository layer method to insert Customer record
    public void insert(CustomerDTO customer);
    // Method to access the repository layer method to delete Customer record
    public int remove(Long phoneNo);
}

