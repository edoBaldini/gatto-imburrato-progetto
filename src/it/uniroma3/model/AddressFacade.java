package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class AddressFacade {
	@PersistenceContext(unitName = "unit-esame")
	private EntityManager em;

	public Address createAddress(String street, String city, String state, String zipcode, String country) {
		Address address = new Address( street,  city,  state, zipcode, country);
		em.persist(address);
		return address;
	}
	
	public Address getAddress(Long id) {
		Address address = em.find(Address.class, id);
		return address;
	}
	
	public List<Address> getAllAddresses() {
		CriteriaQuery<Address> cq = em.getCriteriaBuilder().createQuery(Address.class);
		cq.select(cq.from(Address.class));
		List<Address> addresses = em.createQuery(cq).getResultList();
		return addresses;
	}


	public void updateAddress(Address address){
		em.merge(address);
	}

	public void deleteAddress(Address address){
		em.remove(address);
	}

	public void deleteAddress(Long id){
		Address address = em.find(Address.class, id);
		deleteAddress(address);
	}
	
	public Customer getCustomer(Long id){
		return em.find(Customer.class, id);
	}
	
	public void updateCustomer(Customer customer){
		em.merge(customer);
	}
	
}
