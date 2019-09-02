package com.example.prueba.controller;

import com.example.prueba.model.*;
import com.example.prueba.repo.*;
import com.example.prueba.exception.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderRestController {
	
	@Autowired
	private OrderRepository repo;
	
	OrderRestController(OrderRepository repo){
		this.repo = repo;
	}


	@GetMapping("/orders")
	List<Order> all() {
		return repo.findAll();
		}	
	
	@PostMapping("/orders")
	Order newOrder(@RequestBody Order newOrder) {
	    return repo.save(newOrder);
	}
	
	// Items individuales

	@GetMapping("/orders/{id}")
	Order one(@PathVariable int id) {
		return repo.findById(id)
				.orElseThrow(() -> new OrderNotFoundException(id));
		}
	
	@PutMapping("/orders/{id}")
	Order replaceOrder(@RequestBody Order newOrder, @PathVariable int id) {
		return repo.findById(id)
				.map(order -> {
					order.setCustomer(newOrder.getCustomer());
					order.setCreationDate(newOrder.getCreationDate());
					order.setDeliveryAddress(newOrder.getDeliveryAddress());
					order.setTotal(newOrder.getTotal());
					return repo.save(order);
					})
				.orElseGet(() -> {
					newOrder.setOrderId(id);
					return repo.save(newOrder);
					});
		}
	
	@DeleteMapping("/orders/{id}")
	void deleteOrder(@PathVariable int id) {
		repo.deleteById(id);
		}
}