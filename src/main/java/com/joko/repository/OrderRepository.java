package com.joko.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joko.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
