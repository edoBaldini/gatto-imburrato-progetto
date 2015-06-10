package it.uniroma3.controller;

import it.uniroma3.model.Address;
import it.uniroma3.model.Product;
import it.uniroma3.model.Provider;
import it.uniroma3.model.ProviderFacade;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


@ManagedBean
public class ProviderController {
	
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	
	private String name;
	private String phoneNumber;
	private String email;
	private String vatin;
	private List<Product> products;
	private Address address;
	private Provider provider;
	private List<Provider> providers;
	
	
	@EJB
	private ProviderFacade providerFacade;
	
	public String createOrderLine(){
		this.provider = providerFacade.createProvider( name,  phoneNumber,  email,  vatin,  address);
		return "provider";
	}
	
	public String listOrderLines(){
		this.providers = providerFacade.getAllProviders();
		return "providers";
	}

	
	public String findProvider(){
		this.provider = providerFacade.getProvider(id);
		return "provider";
	}
	
	public String findProvider(Long id){
		this.provider = providerFacade.getProvider(id);
		return "provider";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public List<Provider> getProviders() {
		return providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}	
}
