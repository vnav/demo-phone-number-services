package com.testCompany.demo.repository.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.testCompany.demo.repository.PhoneNumberStatus;
import com.testCompany.demo.repository.PhoneNumberType;

@Entity
@Table(name = "customer_phone_numbers")
public class CustomerPhoneNumberEntity {	
	public CustomerPhoneNumberEntity() {		
	}
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="customer_id")
	private CustomerEntity customer;
	
	@Enumerated(EnumType.STRING)
	private PhoneNumberType type;
	
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	private PhoneNumberStatus status;
	
	@OneToOne(mappedBy = "phoneNumber")
	private ActivationPhoneNumberEntity activation;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public PhoneNumberType getType() {
		return type;
	}

	public void setType(PhoneNumberType type) {
		this.type = type;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneNumberStatus getStatus() {
		return status;
	}

	public void setStatus(PhoneNumberStatus status) {
		this.status = status;
	}

	public ActivationPhoneNumberEntity getActivation() {
		return activation;
	}

	public void setActivation(ActivationPhoneNumberEntity activation) {
		this.activation = activation;
	}
		
}
