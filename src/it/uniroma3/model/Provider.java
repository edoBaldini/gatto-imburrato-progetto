package it.uniroma3.model;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
public class Provider {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (nullable=false)
	private String name;
	private String phoneNumber;
	private String email;
	private String vatin;
	
	@ManyToMany
	private List<Product> products;
	
	@OneToOne(cascade={CascadeType.PERSIST})
	private Address address;
	
	public Provider(){
		this.products=new ArrayList<Product>();
	}
	
	public Provider(String name, String phoneNumber, String email, String vatin, Address address){
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.email=email;
		this.vatin=vatin;
		this.products=new ArrayList<Product>();
		this.address=address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVatin() {
		return vatin;
	}

	public void setVatin(String vatin) {
		this.vatin = vatin;
	}

	public Long getId() {
		return id;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(Product product) {
		this.products.add(product);
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public boolean equals(Object obj){
		Provider provider=(Provider)obj;
		return this.getName().equals(provider.getName()) && this.getPhoneNumber().equals(provider.getPhoneNumber());
	}
	
	public int hashCode(){
		return this.name.hashCode() + this.phoneNumber.hashCode();
	}
	
	public String toString(){
		final StringBuilder sb = new StringBuilder();
        sb.append("Provider"); 
        sb.append("{id=").append(id); 
        sb.append(", name='").append(name); 
        sb.append(", phoneNumber=").append(phoneNumber); 
        sb.append(", email='").append(email); 
        sb.append(", vatin='").append(vatin);
        sb.append(", product='").append(products);
        sb.append(", address='").append(address);
        sb.append("}\n");
        return sb.toString();
	}

	

}
