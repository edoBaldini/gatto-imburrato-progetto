package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import it.uniroma3.model.Address;
import it.uniroma3.model.Customer;
import it.uniroma3.model.CustomerFacade;
import it.uniroma3.model.Order;

@ManagedBean
@SessionScoped
public class CustomerController{

	private Long id;

	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String phonenumber;
	private Date dateofbirth;
	private Date registerdata;
	private Customer customer;
	private Address address;
	private Order order;
	private List<Order> orders;
	private List<Customer> customers;

	@EJB
	private CustomerFacade customerFacade;

	public String createCustomer(){
		this.customer = customerFacade.createCustomer(firstname,lastname,email,phonenumber,dateofbirth,
				registerdata,password);
		return "customer";
	}

	public String listCustomers(){
		this.customers = customerFacade.getAllCustomers();
		return "customers";
	}

	public String findCustomer(Long id){
		Customer customer = customerFacade.getCustomer(id);
		return "customer";
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public Date getRegisterdata() {
		return registerdata;
	}

	public void setRegisterdata(Date registerdata) {
		this.registerdata = registerdata;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer getCustomer(){
		return customer;
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public String loginCustomer(){
		try{
			this.customer = customerFacade.getCustomer(email, password);
			this.id = this.customer.getId();
			this.email = this.loginAdministrator(email);
			return "customer";
		}catch(Exception e){
			return "login";
		}

	}
	
	public String loginAdministrator(String email){
		try{
			String administratorEmail;
			administratorEmail = email.substring(email.length()-17,email.length());
			if (administratorEmail.equals("@administrator.it"))
				return administratorEmail;
			else return email;
		}
		catch (Exception e){
			return email;
		}
	}

	public String logoutCustomer(){
		this.customer = null;
		return "login";
	}

	public String listOrders(){
		this.orders=customerFacade.getAllOrders();
		return "orders";
	}

	public String createOrder(){
		this.order = customerFacade.create(new Date(), this.customer);
		this.customer.getOrders().add(this.order);
		return this.listOrders();
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String closedOrder(){
		try{
			this.order = customerFacade.getOrder(id);
			if(order.getClosingDate()!=null){
				return this.listOrders();
			}
			else{
				this.order.setClosingDate(new Date());
				this.customerFacade.updateOrder(this.order);
				this.customer.getOrders().add(this.order);}
				return this.listOrders();}
		catch (Exception e){
			return this.listOrders();
		}
	}
}