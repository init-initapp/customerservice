package com.example.batman;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demoapp/api/v1/customers")
public class Controller {

	@Autowired
	private Repository repository;

	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	
	@GetMapping
	public List<Customer> getAllCustomer() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") Long id) {
		
		return repository.findById(id);
	}
	
	@PostMapping(consumes = "application/json")
	public void createCustomer(@RequestBody Customer customer) {

		repository.save(customer);
	}
	
	@PutMapping("/{id}")
	public void updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer) {
		Optional<Customer> existingCustomer = repository.findById(id);
		if (existingCustomer != null)
		{
			customer.setId(id);
			repository.save(customer);
			
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") Long id) {
		repository.deleteById(id);
	}



}
