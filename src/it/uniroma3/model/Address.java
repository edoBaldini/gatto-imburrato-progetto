package it.uniroma3.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
	public Address(){}
	
	public Address(String street, String city, String state, String zipcode, String country){
		this.street= street;
		this.city= city;
		this.state=state;
		this.zipcode=zipcode;
		this.country=country;
	}
	
	public Long getId(){
		return this.id;
	}
	
	public String getStreet(){
		return this.street;
	}
	
	public void setStreet(String street){
		this.street=street;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public void setCity(String city){
		this.city=city;
	}
	
	public String getState(){
		return this.state;
	}
	
	public void setState(String state){
		this.state = state;
	}
	
	public String getZipcode(){
		return this.zipcode;
	}
	
	public void setZipcode(String zipcode){
		this.zipcode=zipcode;
	}
	
	public String getCountry(){
		return this.country;
	}
	
	public void setCountry(String country){
		this.country=country;
	}
	
	public boolean equals(Object obj){
		Address address=(Address) obj;
		return this.getCity().equals(address.getCity()) && this.getStreet().equals(address.getStreet())
			   && this.getState().equals(address.getState());
	}
	
	public int hashCode(){
		return this.city.hashCode() + this.street.hashCode() + this.state.hashCode();
	}
	
	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Address"); 
        sb.append("{id=").append(id); 
        sb.append(", street='").append(street); 
        sb.append(", city=").append(city); 
        sb.append(", state='").append(state); 
        sb.append(", zipcode='").append(zipcode);
        sb.append(", country='").append(country);
        sb.append("}\n");
        return sb.toString();
    }
}
