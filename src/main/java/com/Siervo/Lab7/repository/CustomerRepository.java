package com.Siervo.Lab7.repository;

import com.Siervo.Lab7.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
