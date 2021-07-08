package com.testCompany.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.testCompany.demo.api.DemoApiDelegate;
import com.testCompany.demo.model.CustomerPhoneNumber;
import com.testCompany.demo.repository.ActivationPhoneNumberRepository;
import com.testCompany.demo.repository.ActivationStatus;
import com.testCompany.demo.repository.CustomerPhoneNumberRepository;
import com.testCompany.demo.repository.CustomerRepository;
import com.testCompany.demo.repository.PhoneNumberStatus;
import com.testCompany.demo.repository.entity.ActivationPhoneNumberEntity;
import com.testCompany.demo.repository.entity.CustomerEntity;
import com.testCompany.demo.repository.entity.CustomerPhoneNumberEntity;

@Service
public class CustomerPhoneService implements DemoApiDelegate {
	private final CustomerPhoneNumberRepository customerPhoneNumberRepository;
	private final CustomerRepository customerRepository;
	private final ActivationPhoneNumberRepository activationPhoneNumberRepository;
	
	public CustomerPhoneService(CustomerRepository customerRepository,
								CustomerPhoneNumberRepository customerPhoneNumberRepository,
								ActivationPhoneNumberRepository activationPhoneNumberRepository) {
		this.customerRepository = customerRepository;
		this.customerPhoneNumberRepository = customerPhoneNumberRepository;
		this.activationPhoneNumberRepository = activationPhoneNumberRepository;
	}
	
	@Override
	@Transactional
	public ResponseEntity<CustomerPhoneNumber> activatePhoneNumber(Long activationCode) {
		Optional<ActivationPhoneNumberEntity> searchResult = activationPhoneNumberRepository.findByActivationCode(activationCode);
		if (searchResult.isPresent()) {
			ActivationPhoneNumberEntity entity = searchResult.get();
			
			if (ActivationStatus.NEW.equals(entity.getStatus())) {
				entity.setStatus(ActivationStatus.ACTIVATED);
				CustomerPhoneNumberEntity phoneNumber = entity.getPhoneNumber();
				phoneNumber.setStatus(PhoneNumberStatus.ACTIVE);
				
				return new ResponseEntity<>(buildCustomerPhoneNumber(entity.getPhoneNumber()), HttpStatus.OK);
			} else if (ActivationStatus.EXPIRED.equals(entity.getStatus())) {
				throw new ActivationExpiredException("Activation code has expired");
			} else {
				throw new ActivationException("Code has already been activated");
			}
		} else {
			throw new EntityNotFoundException("ACtivation code does not exist");
		}
	}
	
	
	@Override
	public ResponseEntity<List<CustomerPhoneNumber>> getCustomerPhoneNumbers(Long customerId) {
		Optional<CustomerEntity> searchResult = customerRepository.findByCustomerId(customerId);
		if (searchResult.isPresent()) {
			CustomerEntity customerEntity = searchResult.get();			
			return new ResponseEntity<>(buildGetCustomerPhoneNumberResponse(customerEntity.getPhoneNumberList()), HttpStatus.OK);
		} else {
			throw new EntityNotFoundException(String.format("Customer with id:%d does not exist", customerId));
		}
	}
	
	
	@Override
	public ResponseEntity<List<CustomerPhoneNumber>> getCustomersPhoneNumbers() {
		List<CustomerPhoneNumberEntity> phoneNumberList = customerPhoneNumberRepository.findAll();

        return new ResponseEntity<>(buildGetCustomerPhoneNumberResponse(phoneNumberList), HttpStatus.OK);
	}

	
	private List<CustomerPhoneNumber> buildGetCustomerPhoneNumberResponse(List<CustomerPhoneNumberEntity> entityList) {
		List<CustomerPhoneNumber> result = new ArrayList<>();
		for (CustomerPhoneNumberEntity entity : entityList) {
			result.add(buildCustomerPhoneNumber(entity));
		}
		return result;
	}
	
	private CustomerPhoneNumber buildCustomerPhoneNumber(CustomerPhoneNumberEntity entity) {
		CustomerPhoneNumber customerPhoneNumber = new CustomerPhoneNumber();
		customerPhoneNumber.setCustomerId(entity.getCustomer().getCustomerId());
		customerPhoneNumber.setPhoneNumber(entity.getPhoneNumber());
		customerPhoneNumber.setStatus(entity.getStatus().toString());
		customerPhoneNumber.setType(entity.getType().toString());
		return customerPhoneNumber;
	}
	
	
}
