package com.joko.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joko.model.Order;
import com.joko.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	private final OrderRepository orderRepository;
	
	public void calculateTotal(Order order) {
		BigDecimal total = order.getPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
		order.setTotal(total);
	}

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/order")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @PostMapping("/order")
    public Order createOrder(@RequestBody Order order) {
    	 order.calculateTotal(); // Calculate the total before saving the order
    	 //order.setTotal(order.getPrice()*order.getQuantity());
        return orderRepository.save(order);
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order ID: " + id));
    }

    @PutMapping("/order/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid order ID: " + id));

        existingOrder.setSeller(updatedOrder.getSeller());
        existingOrder.setBuyer(updatedOrder.getBuyer());
        existingOrder.setProduct(updatedOrder.getProduct());
        existingOrder.setDescription(updatedOrder.getDescription());
        existingOrder.setPrice(updatedOrder.getPrice());
        existingOrder.setQuantity(updatedOrder.getQuantity());
        existingOrder.setTotal(updatedOrder.getTotal());
        existingOrder.setOrderDate(updatedOrder.getOrderDate());
        existingOrder.setSendDate(updatedOrder.getSendDate());
        existingOrder.setAddress(updatedOrder.getAddress());
        existingOrder.setSenderBy(updatedOrder.getSenderBy());
        existingOrder.setPaymentBy(updatedOrder.getPaymentBy());
        
        existingOrder.calculateTotal(); // Recalculate the total
        //existingOrder.setTotal(existingOrder.getPrice()*existingOrder.getQuantity());

        return orderRepository.save(existingOrder);
    }

    @DeleteMapping("/order/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
    
	  @DeleteMapping("/order")
	  public ResponseEntity<HttpStatus> deleteAllOrder() {
	    try {
	    	orderRepository.deleteAll();
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
