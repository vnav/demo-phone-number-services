package com.testCompany.demo.repository.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
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
	@GeneratedValue
	private Long activationCode;
	
	@OneToOne
    @JoinColumn(name="customer_phone_number_id")
	private CustomerPhoneNumberEntity phoneNumber;
	
	@Enumerated(EnumType.STRING)
	private ActivationStatus status;
	
	private LocalDateTime createDt;
	
	private LocalDateTime updateDt; 
		
	/**
	 * @return the activationCode
	 */
	public Long getActivationCode() {
		return activationCode;
	}

	/**
	 * @param activationCode the activationCode to set
	 */
	public void setActivationCode(Long activationCode) {
		this.activationCode = activationCode;
	}

	/**
	 * @return the phoneNumber
	 */
	public CustomerPhoneNumberEntity getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(CustomerPhoneNumberEntity phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the status
	 */
	public ActivationStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ActivationStatus status) {
		this.status = status;
	}

	/**
	 * @return the createDt
	 */
	public LocalDateTime getCreateDt() {
		return createDt;
	}

	/**
	 * @param createDt the createDt to set
	 */
	public void setCreateDt(LocalDateTime createDt) {
		this.createDt = createDt;
	}

	/**
	 * @return the updateDt
	 */
	public LocalDateTime getUpdateDt() {
		return updateDt;
	}

	/**
	 * @param updateDt the updateDt to set
	 */
	public void setUpdateDt(LocalDateTime updateDt) {
		this.updateDt = updateDt;
	}

	
}
