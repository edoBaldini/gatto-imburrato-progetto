package it.uniroma3.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Column;
import javax.persistence.OneToOne;

@Entity
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private Float unitPrice;
	private Integer quantity;
	@OneToOne
	private Product product;

	public OrderLine(){}

	public OrderLine(Float unitPrice, Integer quantity, Product product){
		this.unitPrice=unitPrice;
		this.quantity=quantity;
		this.product=product;
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

	public Long getId() {
		return id;
	}

	public boolean equals(Object obj){
		OrderLine orderLine= (OrderLine)obj;
		return this.getQuantity()==orderLine.getQuantity() && this.getUnitPrice()==orderLine.getUnitPrice();
	}

	public int hashCode(){
		return this.quantity.hashCode()+this.unitPrice.hashCode();
	}
	public String toString(){
		final StringBuilder sb = new StringBuilder();
		sb.append("OrderLine"); 
		sb.append("{id=").append(id); 
		sb.append(", quantity='").append(quantity); 
		sb.append(", unitPrice=").append(unitPrice); 
		sb.append(", product='").append(product); 
		sb.append("}\n");
		return sb.toString();
	}
}


