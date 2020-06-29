package com.example.batman;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Customer, Long> {
	

}
