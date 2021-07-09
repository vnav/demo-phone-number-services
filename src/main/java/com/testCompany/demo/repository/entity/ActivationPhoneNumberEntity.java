package com.testCompany.demo.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.testCompany.demo.repository.ActivationStatus;

@Entity
@Table(name = "activation_phone_number")
public class ActivationPhoneNumberEntity {
	public ActivationPhoneNumberEntity() {		
	}	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long activationCode;
	
	@OneToOne
    @JoinColumn(name = "customer_phone_number_id", referencedColumnName = "id")
	private CustomerPhoneNumberEntity phoneNumber;
	
	@Enumerated(EnumType.STRING)
	private ActivationStatus status;
	
	private LocalDateTime createDt;
	
	private LocalDateTime updateDt; 
		
	public Long getActivationCode() {
		return activationCode;
	}

	public CustomerPhoneNumberEntity getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(CustomerPhoneNumberEntity phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public ActivationStatus getStatus() {
		return status;
	}

	public void setStatus(ActivationStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreateDt() {
		return createDt;
	}

	public void setCreateDt(LocalDateTime createDt) {
		this.createDt = createDt;
	}

	public LocalDateTime getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(LocalDateTime updateDt) {
		this.updateDt = updateDt;
	}

	public void setActivationCode(Long activationCode) {
		this.activationCode = activationCode;
	}	
}
