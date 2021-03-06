package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;


@Stateless
public class OrderFacade {


	@PersistenceContext(unitName = "unit-esame")
	private EntityManager em;

	public Order createOrders(Date creationTime, Customer customer) {
		Order order = new Order(creationTime, customer);
		em.persist(order);
		return order;
	}

	
	public Order getOrder(Long id) {
		Order order = em.find(Order.class, id);
		return order;
	}
	
	public List<Order> getAllOrders() {
		CriteriaQuery<Order> cq = em.getCriteriaBuilder().createQuery(Order.class);
		cq.select(cq.from(Order.class));
		List<Order> orders = em.createQuery(cq).getResultList();
		return orders;
	}

	public List<Order> getOrders(Long id){
		List<Order> orders = new ArrayList<Order>();
		for(Order order: this.getAllOrders())
			if (order.getCustomer().getId().equals(id))
				orders.add(order);
		return orders;
	}
	
	public void updateOrder(Order order){
		em.merge(order);
	}
	
	public void deleteOrder(Order order){
		em.remove(em.merge(order));
	}
	
	public void deleteOrder(Long id){
        Order order = em.find(Order.class, id);
        em.remove(order);
        
	}
	public Customer getCustomer(Long id){
		Customer customer = em.find(Customer.class, id);
		return customer;
	}
	
	public List<Product> getAllProducts(){
		CriteriaQuery<Product> cq = em.getCriteriaBuilder().createQuery(Product.class);
        cq.select(cq.from(Product.class));
        List<Product> products = em.createQuery(cq).getResultList();
		return products;
	}

	
}
