package com.example.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dto.CustomerDto;
import com.example.customer.model.CustomerModel;
import com.example.customer.repository.CustomerRepo;

@Service
public class CustomerServiceImplement implements CustomerService {

	private CustomerRepo customerRepo;

	@Autowired
	public CustomerServiceImplement(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
	}

	@Override
	public CustomerModel createCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		CustomerModel customerModel = new CustomerModel();
		customerModel.setName(customerDto.getName());
		customerModel.setGender(customerDto.getGender());
		customerModel.setAge(customerDto.getAge());
		customerModel.setEmail(customerDto.getEmail());
		customerModel.setAddress(customerDto.getAddress());
		customerModel.setContact(customerDto.getContact());

		CustomerModel createCustomer = customerRepo.save(customerModel);
		return createCustomer;
	}

	@Override
	public List<CustomerModel> getCustomersList() {
		// TODO Auto-generated method stub
		List<CustomerModel> customersList = customerRepo.findAll();
		return customersList;
	}

	@Override
	public CustomerModel updateCustomer(Integer customerId, CustomerDto customerDto) {
		// TODO Auto-generated method stub
		Optional<CustomerModel> optional = customerRepo.findById(customerId);
		if (optional.isPresent()) {
			CustomerModel customerModel = optional.get();
			customerModel.setName(customerDto.getName());
			customerModel.setGender(customerDto.getGender());
			customerModel.setAge(customerDto.getAge());
			customerModel.setEmail(customerDto.getEmail());
			customerModel.setAddress(customerDto.getAddress());
			customerModel.setContact(customerDto.getContact());

			CustomerModel updateCustomer = customerRepo.save(customerModel);
			return updateCustomer;
		}
		return null;
	}

	@Override
	public String deleteCustomer(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<CustomerModel> optional = customerRepo.findById(customerId);
		if (optional.isPresent()) {
			CustomerModel customerModel = optional.get();

			customerRepo.delete(customerModel);
			return "Cuatomer deleted successfully with id : " + customerId;
		}
		return null;
	}

	@Override
	public CustomerModel getCustomerById(Integer customerId) {
		// TODO Auto-generated method stub
		Optional<CustomerModel> optional = customerRepo.findById(customerId);
		if (optional.isPresent()) {
			CustomerModel customerModel = optional.get();
			return customerModel;
		}
		return null;
	}

}
