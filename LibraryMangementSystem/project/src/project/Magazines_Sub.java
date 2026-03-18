package project;


import java.io.Serializable;
import java.time.LocalDate;

public class Magazines_Sub extends Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1745947656864909688L;
	private int issueNumber;


	public Magazines_Sub(int ID, String title, Author author, double price, LocalDate publishingDate, LocalDate dueDate,
			Status status, int issueNumber) {
		super(ID, title, author, price, publishingDate, dueDate, status);
		this.issueNumber = issueNumber;
	}


	public int getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(int issueNumber) {
		this.issueNumber = issueNumber;
	}


	@Override
	public String toString() {
		return super.toString()+"Magazines_Sub [issueNumber=" + issueNumber + "]";
	}



}

