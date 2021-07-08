package com.testCompany.demo.repository.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class CustomerEntity {
	public CustomerEntity() {		
	}
		
	@Id
	@GeneratedValue
	private Long customerId;
	
	private String firstname;
	
	private String lastname;
	
	 @OneToMany(mappedBy = "customer") 
	 List<CustomerAccountsEntity> accountList;
	 
	 @OneToMany(mappedBy = "customer") 
	 List<CustomerPhoneNumberEntity> phoneNumberList;
	 	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public List<CustomerAccountsEntity> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<CustomerAccountsEntity> accountList) {
		this.accountList = accountList;
	}

	public List<CustomerPhoneNumberEntity> getPhoneNumberList() {
		return phoneNumberList;
	}

	public void setPhoneNumberList(List<CustomerPhoneNumberEntity> phoneNumberList) {
		this.phoneNumberList = phoneNumberList;
	}
	
}
