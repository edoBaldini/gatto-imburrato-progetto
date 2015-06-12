package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;


@Stateless
public class OrderLineFacade {

	@PersistenceContext(unitName = "unit-esame")
	private EntityManager em;

	public OrderLine createOrderLine(Float unitPrice, Integer quantity, Product product, Order order) {
		OrderLine orderLine = new OrderLine( unitPrice,  quantity,  product, order);
		em.persist(orderLine);
		return orderLine;
	}

	public OrderLine getOrderLine(Long id) {
		OrderLine orderLine = em.find(OrderLine.class, id);
		return orderLine;
	}


	public List<OrderLine> getAllOrderLines() {
		CriteriaQuery<OrderLine> cq = em.getCriteriaBuilder().createQuery(OrderLine.class);
		cq.select(cq.from(OrderLine.class));
		List<OrderLine> orderLines = em.createQuery(cq).getResultList();
		return orderLines;
	}


	public void updateOrderLine(OrderLine orderLine){
		em.merge(orderLine);
	}

	public void deleteOrderLine(OrderLine orderLine){
		em.remove(orderLine);
	}

	public void deleteOrderLine(Long id){
		OrderLine orderLine = em.find(OrderLine.class, id);
		deleteOrderLine(orderLine);
	}
	
	public Product getProduct(Long id){
		Product product= em.find(Product.class, id);
		return product;
	}

	public Order getOrder(Long id) {
		Order order = em.find(Order.class, id);
		return order;
	}

}
