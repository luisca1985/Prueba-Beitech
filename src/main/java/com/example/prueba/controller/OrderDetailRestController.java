package com.example.prueba.controller;

import com.example.prueba.model.*;
import com.example.prueba.repo.*;
import com.example.prueba.exception.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderDetailRestController {
	
	@Autowired
	private OrderDetailRepository repo;
	
	OrderDetailRestController(OrderDetailRepository repo){
		this.repo = repo;
	}
	  
	// Raiz
	@GetMapping("/ordersdetails")
	List<OrderDetail> all() {
		return repo.findAll();
		}
	
	
	@PostMapping("/ordersdetails")
	OrderDetail newOrderDetail(@RequestBody OrderDetail newOrderDetail) {
	    return repo.save(newOrderDetail);
	}
	
	// Items individuales

	@GetMapping("/ordersdetails/{id}")
	OrderDetail one(@PathVariable int id) {
		return repo.findById(id)
				.orElseThrow(() -> new OrderNotFoundException(id));
		}
	
	@PutMapping("/ordersdetails/{id}")
	OrderDetail replaceOrderDetail(@RequestBody OrderDetail newOrderDetail, @PathVariable int id) {
		return repo.findById(id)
				.map(orderDetail -> {
					orderDetail.setOrder(newOrderDetail.getOrder());
					orderDetail.setProduct(newOrderDetail.getProduct());
					orderDetail.setProductDescription(newOrderDetail.getProduct().getProductDescription());
					orderDetail.setPrice(newOrderDetail.getProduct().getPrice());
					orderDetail.setQuantity(newOrderDetail.getQuantity());
					return repo.save(orderDetail);
					})
				.orElseGet(() -> {
					newOrderDetail.setOrderDetailId(id);
					return repo.save(newOrderDetail);
					});
		}
	
	@DeleteMapping("/ordersdetails/{id}")
	void deleteOrderDetail(@PathVariable int id) {
		repo.deleteById(id);
		}
}
