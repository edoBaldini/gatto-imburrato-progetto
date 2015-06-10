package it.uniroma3.controller;

import it.uniroma3.model.Address;
import it.uniroma3.model.AddressFacade;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class AddressController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private Address address;
	private List<Address> addresses;
	
	
	@EJB
	private AddressFacade addressFacade;
	
	public String createAddress(){
		this.address = addressFacade.createAddress( street,  city,  state,  zipcode,  country);
		return "address";
	}
	
	public String listAddresses(){
		this.addresses = addressFacade.getAllAddresses();
		return "addresses";
	}

	
	public String findAddress(){
		this.address = addressFacade.getAddress(id);
		return "address";
	}
	
	public String findAddress(Long id){
		this.address = addressFacade.getAddress(id);
		return "address";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	
}
