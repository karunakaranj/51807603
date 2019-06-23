package com.usecase.personalloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usecase.personalloan.model.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

}
