package project;

import java.time.LocalDate;
public abstract class Item {
	private int ID;
	private String title;
	private Author author;
	private double price;
	private LocalDate publishingDate;
	private LocalDate dueDate;
	private Status status;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public LocalDate getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(LocalDate publishingDate) {
		this.publishingDate = publishingDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Item(int iD, String title, Author author, double price, LocalDate publishingDate, LocalDate dueDate,
			Status status) {
		super();
		ID = iD;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publishingDate = publishingDate;
		this.dueDate = dueDate;
		this.status = status;
	}

	public String toString() {
		return "[ID=" + ID + ", title=" + title + ", author=" + author + ", price=" + price + ", publishingDate="
				+ publishingDate + ", dueDate=" + dueDate + ", status=" + status + "]";
	}

}