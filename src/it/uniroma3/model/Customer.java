package it.uniroma3.model;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Column;
import javax.persistence.OneToOne;

@Entity

@NamedQuery(name="check-emaill",
			query="SELECT c FROM Customer c WHERE c.email = :email")

public class Customer {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@Column(nullable = false)
	private String firstname;
	private String lastname;
	private String email;
	private String phonenumber;
	private Date dateofbirth;
	private Date registerdate;
	private String password;

	@OneToOne(cascade={CascadeType.PERSIST})
	private Address address_id;

	public Customer (){};
	public Customer(String firstname, String lastname, String email,
			String phonenumber, Date dateofbirth,Date registerdata,String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.dateofbirth = dateofbirth;
		this.registerdate=registerdata;
		this.password =  password;
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
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public Address getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Address address_id) {
		this.address_id = address_id;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int hashCode() {
		return this.firstname.hashCode() + this.lastname.hashCode() + this.address_id.hashCode(); 
	}

	public String toString(){
		final StringBuilder sb = new StringBuilder();
		sb.append("Product"); 
		sb.append("{id=").append(id); 
		sb.append(", firstname='").append(firstname); 
		sb.append(", lastname=").append(lastname); 
		sb.append(", email='").append(email); 
		sb.append(", phonenumber='").append(phonenumber);
		sb.append(", dateofbirth='").append(dateofbirth);
		sb.append(", registerdate='").append(registerdate);
		sb.append(", address_id='").append(address_id);
		sb.append(", password='").append(password);
		sb.append("}\n");
		return sb.toString();


	}
}
