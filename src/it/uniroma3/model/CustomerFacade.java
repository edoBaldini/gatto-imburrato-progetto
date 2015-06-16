package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

@Stateless()
public class CustomerFacade {
	
	@PersistenceContext(unitName="unit-esame")
	private EntityManager em;
	
	public Customer createCustomer(String firstname, String lastname, String email,
			String phonenumber, Date dateofbirth,Date registerdata,String password){
		Customer customer = new Customer(firstname, lastname, email, phonenumber, dateofbirth, registerdata,password);
		em.persist(customer);
		return customer;
		
	}
	
	public Customer getCustomer(Long id){
		Customer customer = em.find(Customer.class, id);
		return customer;
	}
	
	public Customer getCustomer(String email, String password){
		TypedQuery<Customer> c=em.createNamedQuery("check-email",Customer.class);
		c.setParameter("email", email);
		c.setParameter("password", password);
		List<Customer> customer= c.getResultList();
		return customer.get(0);
				
	}
	
	
	public List<Customer> getAllCustomers(){
		CriteriaQuery<Customer> cq = em.getCriteriaBuilder().createQuery(Customer.class);
		cq.select(cq.from(Customer.class));
		List<Customer> customers = em.createQuery(cq).getResultList();
		return customers;
	}
	
	public void updateCustomer(Customer customer){
		em.merge(customer);
	}
	
	public void deleteCustomer(Customer customer){
		em.remove(customer);
	}
	
	public void deleteCustomer(Long id){
		Customer customer = em.find(Customer.class, id);
		em.remove(customer);
	}

	public Order create(Date creationTime, Customer customer) {
		Order order = new Order(creationTime, customer);
		em.persist(order);
		return order;
	}
	
	public void updateOrder(Order order){
		em.merge(order);
	}
	
	public Order getOrder(Long id){
		Order order = em.find(Order.class, id);
		return order;
	}
	
	public List<Order> getAllOrders(){
		CriteriaQuery<Order> cq = em.getCriteriaBuilder().createQuery(Order.class);
		cq.select(cq.from(Order.class));
		List<Order> orders = em.createQuery(cq).getResultList();
		return orders;
	}

	public void deleteOrder(Order order){
		em.remove(em.merge(order));
	}
	
	public List<Order> getOrders(Long id){
		List<Order> orders = new ArrayList<Order>();
		for (Order order: this.getAllOrders()){
			if (order.getCustomer().getId().equals(id) )
					orders.add(order);
		}
		return orders;
	}

}
