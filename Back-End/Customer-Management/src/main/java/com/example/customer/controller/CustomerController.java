package com.example.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.constant.AppConstant;
import com.example.customer.dto.CustomerDto;
import com.example.customer.model.CustomerModel;
import com.example.customer.service.CustomerService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = AppConstant.API)
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}
	
	@PostMapping(value = AppConstant.CREATE)
	public ResponseEntity<CustomerModel> createCustomer(@RequestBody CustomerDto customerDto){
		CustomerModel createCustomer = customerService.createCustomer(customerDto);
		return new ResponseEntity<CustomerModel>(createCustomer, HttpStatus.CREATED);
	}

	@GetMapping(value = AppConstant.GET_BY_ID)
	public ResponseEntity<CustomerModel> getCustomerById(@PathVariable("id") Integer customerId){
		CustomerModel customerById = customerService.getCustomerById(customerId);
		return new ResponseEntity<CustomerModel>(customerById, HttpStatus.OK);
	}
	
	@GetMapping(value = AppConstant.GET_ALL_CUSTOMERS)
	public ResponseEntity<List<CustomerModel>> getCustomersList(){
		List<CustomerModel> customersList = customerService.getCustomersList();
		return new ResponseEntity<List<CustomerModel>>(customersList, HttpStatus.OK);
	}
	
	@PutMapping(value = AppConstant.UPDATE)
	public ResponseEntity<CustomerModel> updateCustomer(@PathVariable("id") Integer customerId, @RequestBody CustomerDto customerDto){
		CustomerModel updateCustomer = customerService.updateCustomer(customerId,customerDto);
		return new ResponseEntity<CustomerModel>(updateCustomer, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(value = AppConstant.DELETE)
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer customerId){
		String response = customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
