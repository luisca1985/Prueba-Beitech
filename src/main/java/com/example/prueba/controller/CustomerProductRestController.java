package com.example.prueba.controller;

import com.example.prueba.model.*;
import com.example.prueba.repo.*;
import com.example.prueba.exception.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerProductRestController {
	
	@Autowired
	private CustomerProductRepository repo;
	
	CustomerProductRestController(CustomerProductRepository repo){
		this.repo = repo;
	}
	  
	// Raiz
	@GetMapping("/customersproducts")
	List<CustomerProduct> all() {
		return repo.findAll();
		}
	
	// Items individuales

	@GetMapping("/customersproducts/{id}")
	CustomerProduct one(@PathVariable CustomerProductId id) {
		return repo.findById(id)
				.orElseThrow(() -> new CustomerProductNotFoundException(id.toString()));
		}
}
