package project;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable {


	private static final long serialVersionUID = 6619050776021835166L;
	private int customerID;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String address;
	private int phoneNumber;


	public Customer(int customerID, String firstName, String lastName, LocalDate dateOfBirth, String address, int phoneNumber) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}


	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}


}