package com.infytel.dto.input;

import com.infytel.domain.Customer;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerInputDTO {

    private Long phoneNumber;
    private String name;
    private Integer age;
    private Character gender;
    private String address;
    private Integer planId;

    /*
    public CustomerInputDTO() {}

    public CustomerInputDTO(Long phoneNumber, String name, Integer age, Character gender, String address, Integer planId) {
        super();
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.planId = planId;
    }
    public Long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Character getGender() {
        return gender;
    }
    public void setGender(Character gender) {
        this.gender = gender;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getPlanId() {
        return planId;
    }
    public void setPlanId(Integer planId) {
        this.planId = planId;
    }
    @Override
    public String toString() {
        return "Customer [phoneNumber=" + phoneNumber + ", name=" + name + ", age=" + age + ", gender=" + gender
                + ", address=" + address + ", planId=" + planId + "]";
    }

    public static Customer prepareCustomerEntity(CustomerInputDTO customerDTO)
    {
        Customer customerEntity = new Customer();
        customerEntity.setPhoneNumber(customerDTO.getPhoneNumber());
        customerEntity.setName(customerDTO.getName());
        customerEntity.setGender(customerDTO.getGender());
        customerEntity.setAge(customerDTO.getAge());
        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setPlanId(customerDTO.getPlanId());
        return customerEntity;

    }
     */
}
