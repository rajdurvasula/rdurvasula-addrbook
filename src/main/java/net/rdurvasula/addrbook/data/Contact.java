package net.rdurvasula.addrbook.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="contact")
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1048858394209396835L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, 
	generator="contact_id_seq")
	@SequenceGenerator(name="contact_id_seq", sequenceName="contact_id_seq", allocationSize=1)
	private long id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="title")
	private String title;
	@Column(name="company")
	private String company;
	@Column(name="group_name")
	private String groupName;
//	@OneToMany(mappedBy="contact")
//	private Set<PhoneNumber> phoneNumbers;
//	@OneToMany(mappedBy="contact")
//	private Set<EmailAddress> emailAddresses;
//	@OneToMany(mappedBy="contact")
//	private Set<ContactAddress> contactAddresses;
	
	public Contact() {
		
	}
	
	public Contact(String firstName, String lastName, String title, String company, String groupName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
		this.company = company;
		this.groupName = groupName;
	}
	
	public long getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
//	public Set<PhoneNumber> getPhoneNumbers() {
//		return phoneNumbers;
//	}
//	public void setPhoneNumbers(Set<PhoneNumber> phoneNumbers) {
//		this.phoneNumbers = phoneNumbers;
//	}
//	public Set<EmailAddress> getEmailAddresses() {
//		return emailAddresses;
//	}
//	public void setEmailAddresses(Set<EmailAddress> emailAddresses) {
//		this.emailAddresses = emailAddresses;
//	}
//	public Set<ContactAddress> getContactAddresses() {
//		return contactAddresses;
//	}
//	public void setContactAddresses(Set<ContactAddress> contactAddresses) {
//		this.contactAddresses = contactAddresses;
//	}
	
	
}
