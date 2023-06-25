package com.example.customer.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.customer.constant.AppConstant;

import lombok.Data;

@Data
@Entity
@Table(name = AppConstant.TABLE)
public class CustomerModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5658006240775221889L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String name;
	private String gender;
	private Integer age;
	private String email;
	private String address;
	private String contact;
}
