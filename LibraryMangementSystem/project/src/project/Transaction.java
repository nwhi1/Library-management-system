package project;

import java.time.LocalDate;
import java.util.Random;

public class Transaction {
	private int transactionID;
	private Customer customer;
	private Item item;
	private LocalDate checkOutDate;
	private LocalDate checkInDate;  
	

	public Transaction(int transactionID, Customer customer, Item item, LocalDate checkOutDate, LocalDate checkInDate) {
		this.transactionID = transactionID;
		this.customer = customer;
		this.item = item;
		this.checkOutDate = checkOutDate;
		this.checkInDate = null; 
	}

	public Transaction() {}

	public int getTransactionID() {
		Random random = new Random();
        int num=random.nextInt(1000000,10000000);
        setTransactionID(num);
        return num;
	}

	public void setTransactionID(int transactionID) {
		this.transactionID=transactionID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", customer=" + customer + ", item=" + item
				+ ", checkOutDate=" + checkOutDate + ", checkInDate=" + checkInDate + "]";
	}


}
