package project;

import java.io.Serializable;
import java.time.LocalDate;

public class NewsPaper_Sub extends Item implements Serializable{

	private static final long serialVersionUID = -6154230811474830311L;
	private String issueLanguage;

	public String getIssueLanguage() {
		return issueLanguage;
	}

	public void setIssueLanguage(String issueLanguage) {
		this.issueLanguage = issueLanguage;
	}

	public NewsPaper_Sub(int iD, String title, Author author, double price, LocalDate publishingDate,
			LocalDate dueDate, Status status, String issueLanguage) {
		super(iD, title, author, price, publishingDate, dueDate, status);
		this.issueLanguage = issueLanguage;
	}


	public String toString() {
		return super.toString() +"NewsPapers_Sub [issueLanguage=" + issueLanguage + "]";
	}

}
