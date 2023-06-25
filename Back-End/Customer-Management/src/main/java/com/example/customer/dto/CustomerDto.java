package com.example.customer.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CustomerDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1472570235859975370L;

	private String name;
	private String gender;
	private Integer age;
	private String email;
	private String address;
	private String contact;
}
