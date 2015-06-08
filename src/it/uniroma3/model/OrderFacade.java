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
	
/*	public List<Orders> getAllOrders(Long id){
		TypedQuery<Orders> o=em.createNamedQuery("all-orders-customer",Orders.class);
		o.setParameter("id", id);
		List<Orders> listOrders= o.getResultList();
		return listOrders;
	}*/
	
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
