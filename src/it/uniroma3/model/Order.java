package it.uniroma3.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	private Date closingDate;
	private Date processingDate;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="order",cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	//@JoinColumn(name="orders_id")
	private List<OrderLine> orderLines;

	public Order(){
		this.orderLines=new ArrayList<OrderLine>();
	}
	public Order(Date creationTime, Customer costumer){
		this.creationTime=creationTime;
		this.customer=costumer;
		this.orderLines=new ArrayList<OrderLine>();
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
	public void setCostumer(Customer costumer) {
		this.customer = costumer;
	}
	public List<OrderLine> getOrderLines() {
		return orderLines;
	}
	
	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean equals(Object obj){
		Order order=(Order)obj;
		return order.getCreationTime().equals(order.getCreationTime());
	}
	
	public int hashCode(){
		return this.creationTime.hashCode();
	}
	
	public String toString(){
		final StringBuilder sb = new StringBuilder();
        sb.append("Orders"); 
        sb.append("{id=").append(id); 
        sb.append(", costumer='").append(customer); 
        sb.append(", creationTime=").append(creationTime); 
        sb.append(", orderLine='").append(orderLines); 
        sb.append("}\n");
        return sb.toString();
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
