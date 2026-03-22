package project;

import java.io.Serializable;
import java.time.LocalDate;
public class Journal_Sub  extends Item implements Serializable {
	private Periodicity publicationFrequency;
	private double impactFactor;


	public Journal_Sub(int ID, String title, Author author, double price, LocalDate publishingDate, LocalDate dueDate,
			Status status, Periodicity publicationFrequency, double impactFactor) {
		super(ID, title, author, price, publishingDate, dueDate, status);
		this.publicationFrequency = publicationFrequency;
		this.impactFactor = impactFactor;
	}


	public Periodicity getPublicationFrequency() {
		return publicationFrequency;
	}

	public void setPublicationFrequency(Periodicity publicationFrequency) {
		this.publicationFrequency = publicationFrequency;
	}

	public double getImpactFactor() {
		return impactFactor;
	}

	public void setImpactFactor(double impactFactor) {
		this.impactFactor = impactFactor;
	}



	public String toString() {
		return "Journal_Sub [publicationFrequency=" + publicationFrequency + ", impactFactor=" + impactFactor + "]";
	}
}


