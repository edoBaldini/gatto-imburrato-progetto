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
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Date creationTime;
	private Customer customer;
	private Order order;
	private Date closingDate;
	private Date processingDate;
	private List<Order> orders;
	private List<OrderLine> orderLines;

	@EJB
	private OrderFacade orderFacade;
	
	public String createOrder(){
		this.order = orderFacade.createOrders(creationTime, customer,closingDate,processingDate);
		return "order";
	}
	
	public String listOrders(){
		this.orders = orderFacade.getAllOrders();
		return "orders";
	}
	
	public String listOrders(Long id){
		this.orders = orderFacade.getAllOrders(id);
		this.id=id;
		return "orders";
	}
	
	public String findOrder(){
		this.order = orderFacade.getOrder(id);
		this.orderLines= this.order.getOrderLines();
		return "orderLines";
	}
	
	public String findOrder(Long id){
		this.order = orderFacade.getOrder(id);
		this.orderLines= this.order.getOrderLines();
		return "orderLines";
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

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public OrderFacade getOrdersFacade() {
		return orderFacade;
	}

	public void setOrdersFacade(OrderFacade orderFacade) {
		this.orderFacade = orderFacade;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Date getProcessingDate() {
		return processingDate;
	}

	public void setProcessingDate(Date processingDate) {
		this.processingDate = processingDate;
	}
	
}
