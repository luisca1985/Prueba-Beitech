package com.example.prueba.controller;

import com.example.prueba.model.*;
import com.example.prueba.repo.*;
import com.example.prueba.exception.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerRestController {
	
	@Autowired
	private CustomerRepository repo;
	
	CustomerRestController(CustomerRepository repo){
		this.repo = repo;
	}
	  
	// Raiz
	@GetMapping("/customers")
	List<Customer> all() {
		return repo.findAll();
		}
	
	// Items individuales

	@GetMapping("/customers/{id}")
	Customer one(@PathVariable int id) {
		return repo.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
		}
}
