package com.example.prueba.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.prueba.model.*;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
