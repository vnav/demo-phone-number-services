package com.testCompany.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testCompany.demo.repository.entity.ActivationPhoneNumberEntity;

@Repository
public interface ActivationPhoneNumberRepository extends JpaRepository<ActivationPhoneNumberEntity, UUID> {
	Optional<ActivationPhoneNumberEntity> findByActivationCode(Long code);
}
