package it.uniroma3.model;

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

	public Order createOrders(Date creationTime, Customer customer, Date closingDate, Date processingDate) {
		Order order = new Order(creationTime, customer, closingDate, processingDate);
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
	
	public List<Order> getAllOrders(Long id){
		TypedQuery<Order> o=em.createNamedQuery("all-orders-customer",Order.class);
		o.setParameter("id", id);
		List<Order> orders= o.getResultList();
		return orders;
	}
	
	public void updateOrder(Order order){
		em.merge(order);
	}
	
	public void deleteOrder(Order order){
		em.remove(order);
	}
	
	public void deleteOrder(Long id){
        Order order = em.find(Order.class, id);
        deleteOrder(order);
	}

	
}
