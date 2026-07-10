package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.*;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customer,Integer> {
	
	@Query(value = """
			SELECT
			c.customer_id,
			u.first_name,
			u.last_name,
			u.email,
			c.pan_number,
			c.aadhaar_number,
			c.gender,
			c.dob,
			c.address,
			c.city,
			c.pincode
			FROM customers c
			JOIN users u
			ON c.user_id = u.user_id
			""", nativeQuery = true)
			List<Object[]> getAllCustomers();
}