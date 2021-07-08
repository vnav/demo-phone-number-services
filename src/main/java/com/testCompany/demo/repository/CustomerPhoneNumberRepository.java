package com.testCompany.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testCompany.demo.repository.entity.CustomerPhoneNumberEntity;

@Repository
public interface CustomerPhoneNumberRepository extends JpaRepository<CustomerPhoneNumberEntity, Long> {

}
