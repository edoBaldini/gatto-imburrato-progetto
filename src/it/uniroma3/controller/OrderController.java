package it.uniroma3.controller;

import it.uniroma3.model.Customer;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class OrderController {
	
	//@ManagedProperty(value="#{param.id}")
	private Long id;
	private Date creationTime;
	private Customer customer;
	private Order order;
	private List<Order> orders;
	
	@EJB
	private OrderFacade orderFacade;
	
	public String createOrder(){
		this.order = orderFacade.createOrders(creationTime, customer);
		return "order";
	}
	
	public String listOrders(){
		this.orders = orderFacade.getAllOrders();
		return "orders";
	}
	
	public String listOrders(Long id){
		this.orders = orderFacade.getAllOrders(id);
		return "orders";
	}
	
	public String findOrder(){
		this.order = orderFacade.getOrder(id);
		return "order";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders.add(orders);
	}

	public OrderFacade getOrdersFacade() {
		return orderFacade;
	}

	public void setOrdersFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}
}
