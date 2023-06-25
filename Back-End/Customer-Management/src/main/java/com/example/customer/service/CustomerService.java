package com.example.customer.service;

import java.util.List;

import com.example.customer.dto.CustomerDto;
import com.example.customer.model.CustomerModel;

public interface CustomerService {

	CustomerModel createCustomer(CustomerDto customerDto);

	List<CustomerModel> getCustomersList();

	CustomerModel updateCustomer(Integer customerId, CustomerDto customerDto);

	String deleteCustomer(Integer customerId);

	CustomerModel getCustomerById(Integer customerId);

}
