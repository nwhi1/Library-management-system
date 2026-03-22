package project;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Book_sub extends Item implements Serializable   {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5226570061081659598L;
	private String ISBN;
	private Genre genre;
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Book_sub(int iD, String title, Author author, double price, LocalDate publishingDate, LocalDate dueDate,
			Status status, String iSBN, Genre genre) {
		super(iD, title, author, price, publishingDate, dueDate, status);
		ISBN = iSBN;
		this.genre = genre;
	}

	public Book_sub(int iD, String title, Author author, double price, LocalDate publishingDate, LocalDate dueDate,
			Status status) {
		super(iD, title, author, price, publishingDate, dueDate, status);
	}
	public String toString() {
		return super.toString() +"Book_sub [ISBN=" + ISBN + ", genre=" + genre + "]";
	}



}