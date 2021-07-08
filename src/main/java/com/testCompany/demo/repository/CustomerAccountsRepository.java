package com.testCompany.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testCompany.demo.repository.entity.CustomerAccountsEntity;

@Repository
public interface CustomerAccountsRepository extends JpaRepository<CustomerAccountsEntity, UUID> {

}
