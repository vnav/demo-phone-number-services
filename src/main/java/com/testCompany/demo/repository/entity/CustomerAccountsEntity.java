package com.testCompany.demo.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_accounts")
public class CustomerAccountsEntity {
	public CustomerAccountsEntity() {		
	}
	
	@Id
	@GeneratedValue
	private Long accountId;
	
	@ManyToOne
    @JoinColumn(name="customer_id")
	private CustomerEntity customer;
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}
	
}
