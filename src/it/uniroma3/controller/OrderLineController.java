package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.List;

import it.uniroma3.model.Order;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.OrderLineFacade;
import it.uniroma3.model.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


@ManagedBean
public class OrderLineController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	private Float unitPrice;
	private Integer quantity;
	private Product product;
	private Order order;
	private OrderLine orderLine;
	private List<OrderLine> orderLines;
	@ManagedProperty(value="#{param.idOrder}")
	private Long idOrder;
	
	@EJB
	private OrderLineFacade orderLineFacade;
	
	public String createOrderLine(){
		this.order = orderLineFacade.getOrder(idOrder);
		this.product = orderLineFacade.getProduct(id);
		this.unitPrice = this.product.getPrice(); 
		this.orderLine = orderLineFacade.createOrderLine(unitPrice, quantity, product,this.order);
		this.order.getOrderLines().add(this.orderLine);
		return "orders";
	}
	
	public String listOrderLines(){
		this.orderLines = orderLineFacade.getAllOrderLines();
		return "orderLines";
	}

	
	public String findOrderLine(){
		this.orderLine = orderLineFacade.getOrderLine(id);
		return "orderLines";
	}
	
	public String findOrder(Long id){
		this.orderLine = orderLineFacade.getOrderLine(id);
		return "orderLines";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderLine getOrderLine() {
		return orderLine;
	}

	public void setOrderLine(OrderLine orderLine) {
		this.orderLine = orderLine;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Long getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Long idOrder) {
		this.idOrder = idOrder;
	}


}
