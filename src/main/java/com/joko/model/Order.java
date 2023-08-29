package com.joko.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="order")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	
    private Long id;
	
	@NotBlank
	@Size(max = 120)
	@Column(name = "seller")
    private String seller;
	@Size(max = 120)
	@Column(name = "buyer")
    private String buyer;
	@Size(max = 120)
	@Column(name = "product")
    private String product;
	@Size(max = 255)
	@Column(name = "description")
    private String description;
	//@Size(max = 255)
	@Column(name = "price")
    private BigDecimal price;
	@Size(max = 50)
	@Column(name = "quantity")
    private int quantity;
	//@Size(max = 200)
	@Column(name = "total")
	@NotNull
    private BigDecimal total;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "order_date")
    private Date orderDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name = "send_date")
    private Date sendDate;
    
    @Size(max = 120)
	@Column(name = "address")
    private String address;
    @Size(max = 120)
    @Column(name = "senderby")
    private String senderBy;
    @Size(max = 120)
    @Column(name = "paymentby")
    private String paymentBy;
	@Override
	public String toString() {
		return "Order [seller=" + seller + ", buyer=" + buyer + ", product=" + product + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + ", total=" + total + ", orderDate=" + orderDate
				+ ", sendDate=" + sendDate + ", address=" + address + ", senderBy=" + senderBy + ", paymentBy="
				+ paymentBy + "]";
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDescription() {
		return description;
	}
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSenderBy() {
		return senderBy;
	}
	public void setSenderBy(String senderBy) {
		this.senderBy = senderBy;
	}
	public String getPaymentBy() {
		return paymentBy;
	}
	public void setPaymentBy(String paymentBy) {
		this.paymentBy = paymentBy;
	}

/*	public void calculateTotal(Order order) {
		// TODO Auto-generated method stub
		BigDecimal total = order.getPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
		order.setTotal(total);}
	*/
	
	/*
	 * public void calculateTotal() { total = quantity * price; }
	 */

	
	 public void calculateTotal() { 
		this.total =price.multiply(BigDecimal.valueOf(quantity)); }
	 
}
