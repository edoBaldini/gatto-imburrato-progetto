package it.uniroma3.controller;

import it.uniroma3.model.Customer;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Order;
import it.uniroma3.model.OrderFacade;
import it.uniroma3.model.Product;

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
	private List<Product> products;

	@EJB
	private OrderFacade orderFacade;

	public String createOrder(){
		this.creationTime = new Date();
		this.customer = orderFacade.getCustomer(id);
		this.order = orderFacade.createOrders(this.creationTime, customer);
		this.customer.getOrders().add(this.order);
		return this.listOrders();
	}

	public String createOrder(Long id){
		this.creationTime = new Date();
		this.customer = orderFacade.getCustomer(id);
		this.order = orderFacade.createOrders(this.creationTime, customer);
		this.customer.getOrders().add(this.order);
		this.id=this.order.getId();
		return "creationOrder";
	}


	public String listOrders(){
		this.orders = this.orderFacade.getOrders(this.order.getCustomer().getId());
		return "orders";
	}
	
	public String listOrders(Long id){
		this.orders = this.order.getCustomer().getOrders();
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

	public String listProductsOrder(){
		this.order = orderFacade.getOrder(id);
		this.products = orderFacade.getAllProducts();
		return "newOrderLine"; 
	}
	
	public String listProductsOrder(Long id){
		this.order = orderFacade.getOrder(id);
		this.products = orderFacade.getAllProducts();
		return "newOrderLine"; 
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	public String closedOrder(){
		this.order = orderFacade.getOrder(id);
		this.order.setClosingDate(new Date());
		this.orderFacade.updateOrder(this.order);
		this.customer = this.order.getCustomer();
		this.customer.getOrders().add(this.order);
		return "customer";
	}
	
	public String retrievesClient(){
		try{
		this.order = orderFacade.getOrder(id);
		this.customer = this.order.getCustomer();
		return "retrievesClient";}
		catch(Exception e){
			return "customer";
		}
	}
	
	public String eliminaOrder(){
		this.order = orderFacade.getOrder(id);
		this.order.getCustomer().getOrders().remove(this.order);
		orderFacade.deleteOrder(this.order);
		return listOrders();
	}
	
	public String eliminaOrder(Long id){
		this.order = orderFacade.getOrder(id);
		this.order.getCustomer().getOrders().remove(this.order);
		orderFacade.deleteOrder(order);
		return listOrders();
	}
}
