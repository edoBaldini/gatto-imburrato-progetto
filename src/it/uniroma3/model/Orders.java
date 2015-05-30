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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="orders_id")
	private List<OrderLine> orderLine;
	
	public Orders(){
		this.orderLine=new ArrayList<OrderLine>();
	}
	public Orders(Date creationTime, Customer costumer){
		this.creationTime=creationTime;
		this.customer=costumer;
		this.orderLine=new ArrayList<OrderLine>();
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
	public List<OrderLine> getOrderLine() {
		return orderLine;
	}
	public void setOrderLine(OrderLine orderLine) {
		this.orderLine.add( orderLine);
	}
	public Long getId() {
		return id;
	}
	
	public boolean equals(Object obj){
		Orders order=(Orders)obj;
		return this.getCustomer().equals(customer) && order.getCreationTime().equals(order.getCreationTime());
	}
	
	public int hashCode(){
		return this.customer.hashCode() + this.creationTime.hashCode();
	}
	
	public String toString(){
		final StringBuilder sb = new StringBuilder();
        sb.append("Orders"); 
        sb.append("{id=").append(id); 
        sb.append(", costumer='").append(customer); 
        sb.append(", creationTime=").append(creationTime); 
        sb.append(", orderLine='").append(orderLine); 
        sb.append("}\n");
        return sb.toString();
	}

}
