package project;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Library {
	File fe=new File("E:\\java\\projectd\\src\\projrctt\\data.dat");


	private ArrayList<Item> items=new ArrayList<Item>();
	private ArrayList<Author> authors= new ArrayList<Author>();
	private ArrayList<Customer> customers=new ArrayList<Customer>();
	private ArrayList<Transaction> transactions=new ArrayList<Transaction>();

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	public Library() {

	}

	public void AddCustomer()  {
		boolean customerExists = false;


		int customerID=0;
		String lastName=null;
		String firstName=null;
		String date=null;
		LocalDate dateOfBirth=null;
		String address=null;
		int phoneNumber=0;
		String line;
		String id;
		String number;   


		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Scanner scann=new Scanner(System.in);
		System.out.print("write the customerID");
		id=scann.nextLine();
		customerID =Integer.parseInt(id);

		System.out.print("write the firstName");
		firstName=scann.nextLine();
		System.out.print("write the lastName");
		lastName=scann.nextLine();
		System.out.print("write the dateOfBirth \\\"yyyy-MM-dd\\\"");
		date= scann.nextLine();
		dateOfBirth= LocalDate.parse(date, formatter);
		System.out.print("write the address");
		address=scann.nextLine();
		System.out.print("write the phoneNumber ");
		number=scann.nextLine();
		phoneNumber=Integer.parseInt(number);

		if(customers!=null) {
			for(Customer c:customers) {
				if(c.getCustomerID()==customerID) {
					System.out.print("the Customer is already added");
					customerExists=true;
					return;
				}
			}}

		if (customerExists==false) { 
			customers.add(new Customer(customerID, firstName, lastName, dateOfBirth, address, phoneNumber));
			System.out.print("the Customer is added Succesfuly!!");
		}

	}


	public void AddBook() {
		Book_sub book;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String ISBN=null;
		String gen=null;
		Genre genere=null;
		int id=0;
		String title;
		String firstname;
		String lastname;
		Double price;
		LocalDate publishingDate;
		String date;
		String datee;
		String dateee;
		Author author;
		LocalDate dueDate;
		LocalDate dateOfBirth;
		Status status;
		String stat;

		boolean BookExists = false;



		Scanner scan=new Scanner(System.in);

		System.out.print("please enter the id of the book:"); 
		id=scan.nextInt();
		scan.nextLine();
		System.out.print("enter the title of the book:");
		title=scan.nextLine();
		System.out.print("enter the first name of the author");
		firstname=scan.nextLine();
		System.out.print("enter the last name of the author");
		lastname=scan.nextLine();
		System.out.print("enter the dateOfBirth of the author");
		dateee=scan.nextLine();
		dateOfBirth=LocalDate.parse(dateee, formatter);
		System.out.print("enter the price of the book");
		price=scan.nextDouble();
		scan.nextLine();
		System.out.print("enter the checkOutDate of the book  ");
		date=scan.nextLine();
		publishingDate=LocalDate.parse(date, formatter);
		System.out.print("enter the dueDate of the book \"yyyy-MM-dd\" ");
		datee=scan.nextLine();
		dueDate=LocalDate.parse(datee, formatter);
		System.out.print("enter the status");
		stat=scan.nextLine();
		while (!stat.equals("borrowed") && !stat.equals("available")) {
			System.out.print("please enter the Status correctly ( borrowed, available) ");
			stat = scan.nextLine();
		}
		status=Status.valueOf(stat.toUpperCase());
		System.out.print("enter The International Standard Book Number");
		ISBN=scan.nextLine();
		System.out.print("enter The Genre");
		gen=scan.nextLine();
		while (!gen.equalsIgnoreCase("HORROR") && !gen.equalsIgnoreCase("MYSTERY") &&
				!gen.equalsIgnoreCase("DRAMA") && !gen.equalsIgnoreCase("SCIENTIFIC")) {
			System.out.print("please enter the genre correctly (HORROR, MYSTERY, DRAMA, SCIENTIFIC)");
			gen = scan.nextLine();
		}
		genere=Genre.valueOf(gen.toUpperCase());
		author=new Author(firstname,lastname,dateOfBirth);

		if(items!=null) {
			for(Item i:items) {
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if(i.getID()==id) {
						System.out.print("the book is already added"+'\n');
						BookExists=true;
						return;
					}
				}}}
		if (BookExists==false) { 
			items.add(new Book_sub(id,title,author,price,publishingDate,dueDate,status,ISBN,genere));
			System.out.print("the book is added Succesfuly!!"+'\n');}

	}

	public void AddJournal() {
		boolean JournalExists = false;
		Journal_Sub journal;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		int id=0;
		String title;
		String firstname;
		String lastname;
		Double price;
		LocalDate publishingDate;
		String date;
		String datee;
		String dateee;
		Author author;
		LocalDate dueDate;
		LocalDate dateOfBirth;
		Status status;
		Periodicity publicationFrequency;
		double impactFactor;
		String fre;
		String stat;





		Scanner scan=new Scanner(System.in);

		System.out.print("please enter the id of the Journal:"); 
		id=scan.nextInt();
		scan.nextLine();
		System.out.print("enter the title of the book:");
		title=scan.nextLine();
		System.out.print("enter the first name of the author");
		firstname=scan.nextLine();
		System.out.print("enter the last name of thge author");
		lastname=scan.nextLine();
		System.out.print("enter the dateOfBirth of the author");
		dateee=scan.nextLine();
		dateOfBirth=LocalDate.parse(dateee, formatter);

		System.out.print("enter the price of the book");
		price=scan.nextDouble();
		scan.nextLine();
		System.out.print("enter the checkOutDate of the book \"yyyy-MM-dd\" ");
		date=scan.nextLine();
		publishingDate=LocalDate.parse(date, formatter);
		System.out.print("enter the dueDate of the book \"yyyy-MM-dd\" ");
		datee=scan.nextLine();
		dueDate=LocalDate.parse(datee, formatter);
		System.out.print("enter the status");
		stat=scan.nextLine();
		while (!stat.equals("borrowed") && !stat.equals("available")) {
			System.out.print("please enter the Status correctly ( borrowed, available) ");
			stat = scan.nextLine();
		}
		status=Status.valueOf(stat.toUpperCase());
		System.out.print("enter the publicationFrequency");
		fre=scan.nextLine();
		while (!fre.equalsIgnoreCase("MONTHLY") && !fre.equalsIgnoreCase("QUARTERLY") &&
				!fre.equalsIgnoreCase("ANNUAL") && !fre.equalsIgnoreCase("DAILY")) {
			System.out.print("please enter the Periodicity correctly ");
			fre = scan.nextLine();
		}
		publicationFrequency=Periodicity.valueOf(fre.toUpperCase());
		System.out.print("enter the impactFactor");
		impactFactor=scan.nextDouble();
		author=new Author(firstname,lastname,dateOfBirth);
		if(items!=null) {
			for(Item i:items) {

				if(i instanceof Journal_Sub) {	
					journal= (Journal_Sub) i;
					if(i.getID()==id) {
						System.out.print("the Journal is already added");
						JournalExists=true;
						return;
					}
				}}}
		if (JournalExists==false) { 
			items.add(new Journal_Sub(id,title,author,price,publishingDate,dueDate,status,publicationFrequency,impactFactor));
			System.out.print("the Journal is added Succesfuly!!");
		}

	}
	public void AddMagazine() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Magazines_Sub magazine;
		int id=0;
		String title;
		String firstname;
		String lastname;
		Double price;
		LocalDate publishingDate;
		String date;
		String datee;
		String dateee;
		Author author;
		LocalDate dueDate;
		LocalDate dateOfBirth;
		Status status;
		boolean MagazineExists = false;
		String stat;

		int issueNumber;



		Scanner scan=new Scanner(System.in);

		System.out.print("please enter the id of the Magazine:"); 
		id=scan.nextInt();
		scan.nextLine();
		System.out.print("enter the title of the book:");
		title=scan.nextLine();
		System.out.print("enter the first name of thge author");
		firstname=scan.nextLine();
		System.out.print("enter the last name of thge author");
		lastname=scan.nextLine();
		System.out.print("enter the dateOfBirth of the author");
		dateee=scan.nextLine();
		dateOfBirth=LocalDate.parse(dateee, formatter);
		System.out.print("enter the price of the book");
		price=scan.nextDouble();
		scan.nextLine();
		System.out.print("enter the checkOutDate of the book \"yyyy-MM-dd\" ");
		date=scan.nextLine();
		publishingDate=LocalDate.parse(date, formatter);
		System.out.print("enter the dueDate of the book \"yyyy-MM-dd\" ");
		datee=scan.nextLine();
		dueDate=LocalDate.parse(datee, formatter);
		System.out.print("enter the status");
		stat=scan.nextLine();
		while (!stat.equals("borrowed") && !stat.equals("available")) {
			System.out.print("please enter the Status correctly ( borrowed, available) ");
			stat = scan.nextLine();
		}
		status=Status.valueOf(stat.toUpperCase());
		System.out.print("enter the issueNumber");
		issueNumber=scan.nextInt();
		author=new Author(firstname,lastname,dateOfBirth);
		if(items!=null) {
			for(Item i:items) {
				if(i instanceof Magazines_Sub) {
					magazine= (Magazines_Sub) i;
					if(i.getID()==id) {
						System.out.print("the Magazine is already added");
						MagazineExists=true;
						return;
					}
				}}}
		if (MagazineExists==false) { 
			items.add(new Magazines_Sub(id,title,author,price,publishingDate,dueDate,status,issueNumber));
			System.out.print("the Magazine is added Succesfuly!!");
		}

	}
	public void UpdateBook () {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		Book_sub book;
		int choice=0;
		int id;
		int newid=0;
		String title;
		String firstname;
		String lastname;
		String date;
		LocalDate dateOfBirth;
		int price;
		LocalDate publishingDate;
		LocalDate duedate;
		String stat;
		Status status;
		String ISBN;
		String gen;
		Genre genre;
		boolean found=false;


		Scanner scanner =new Scanner(System.in);
		System.out.print("Choose the number of what you need to ubdate (id=1,title=2,Author=3,price=4,publishingDate=5,dueDate=6,status=7,isbn=8,Genre=9)");
		choice=scanner.nextInt();
		while(choice!=1&&choice!=2&&choice!=3&&choice!=4&&choice!=5&&choice!=6&&choice!=7&&choice!=8&&choice!=9) {
			System.out.print("please enter the Choise correctly (id=1,title=2,Author=3,price=4,publishingDate=5,dueDate=6,status=7,isbn=8,Genre=9)");
			choice=scanner.nextInt();
		}
		if(choice==1) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			System.out.print("choose the new id");
			newid=scanner.nextInt();
			for(Item i:items) {
				System.out.print("update done");
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if( i.getID()==id) {
						found=true;
						i.setID(newid);
					}
				}
			}



		}
		if(choice==2) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new title of the book");
			title=scanner.nextLine();
			for(Item i:items) {
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if( i.getID()==id) {
						System.out.print("update done");
						found=true;
						i.setTitle(title);
					}
				}
			}

		}
		if(choice==3) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the first name of the Author");
			firstname=scanner.nextLine();
			System.out.print("enter the last name of the Author");
			lastname=scanner.nextLine();
			System.out.print("enter the dateofbirth of the author");
			date=scanner.nextLine();
			dateOfBirth=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if( i.getID()==id){
						System.out.print("update done");
						found=true;
						Author a=new Author(firstname,lastname,dateOfBirth);
						i.setAuthor(a);
					}

				}

			}

		}
		if(choice==4) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			System.out.print("enter the new price of the item");
			price=scanner.nextInt();
			for(Item i:items) {
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if( i.getID()==id) {
						System.out.print("update done");
						found=true;
						i.setPrice(price);
					}}}

		}
		if(choice==5) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new publishingDate of the item");
			date=scanner.nextLine();
			publishingDate=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if( i.getID()==id) {
						System.out.print("update done");
						found=true;
						i.setPublishingDate(publishingDate);
					}}}

		}
		if(choice==6) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.next();
			System.out.print("enter the new dueDate of the item");
			date=scanner.nextLine();
			duedate=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if( i.getID()==id) {
						System.out.print("update done");
						found=true;
						i.setPublishingDate(duedate);
					}}}

		}
		if(choice==7) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new status of the item");
			stat=scanner.nextLine();
			while (!stat.equals("borrowed") && !stat.equals("available")) {
				System.out.print("please enter the Status correctly ( borrowed, available) ");
				stat = scanner.nextLine();
			}
			status=Status.valueOf(stat);
			for(Item i:items) {
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if( i.getID()==id) {
						System.out.print("update done");
						found=true;
						i.setStatus(status);;
					}}}

		}
		if(choice==8) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new ISBN of the item");
			ISBN=scanner.nextLine();

			for(Item i:items) {
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if( i.getID()==id) {
						System.out.print("update done");
						found=true;
						((Book_sub) i).setISBN(ISBN);
					}}}

		}
		if(choice==9) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new Genre of the item");
			gen=scanner.nextLine();
			while (!gen.equalsIgnoreCase("HORROR") && !gen.equalsIgnoreCase("MYSTERY") &&
					!gen.equalsIgnoreCase("DRAMA") && !gen.equalsIgnoreCase("SCIENTIFIC")) {
				System.out.print("please enter the genre correctly (HORROR, MYSTERY, DRAMA, SCIENTIFIC)");
				gen = scanner.nextLine();
			}
			genre=Genre.valueOf(gen);

			for(Item i:items) {
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if( i.getID()==id) {
						System.out.print("update done");
						found=true;
						((Book_sub) i).setGenre(genre);
					}}}


		}

		if(found==false) {
			System.out.print("the iteam does not exist");
		}

	}


	public void DeleteBook() {
		String ISBN;
		Scanner scan= new Scanner(System.in);
		boolean Exsist=false;
		Book_sub book;



		System.out.print("please enter the isbn of the book:");
		ISBN=scan.nextLine();

		if(items!=null) {
			for(Item i :items) {
				if(i instanceof Book_sub) {
					book= (Book_sub) i;
					if(((Book_sub) i).getISBN().equals(ISBN)) {
						Exsist=true;
						System.out.print("item deleted");
						items.remove(i);
						return;
					}
				}
			}
		}
		if(Exsist==false) {
			System.out.print("the iteam does not exist");
			return;}




	}
	public void DeleteJournal() {
		Journal_Sub jou;
		boolean Exist=false;
		int ID;
		Scanner scan =new Scanner(System.in);

		System.out.print("please enter the id of the journal you want to Delete");
		ID=scan.nextInt();
		if(items!=null) {
			for(Item i:items) {
				if(i instanceof Journal_Sub) {
					jou = ( Journal_Sub) i;
					if(i.getID()==ID) {
						Exist=true;
						items.remove(i);
						System.out.print(" item deleted "+"\n");


						return;
					}
				}
			}
		}


		if(Exist==false) {
			System.out.print("the iteam does not exist");
			return;}
	}
	public void DeleteMagazine() {
		Magazines_Sub mag;
		int ID;
		boolean Exist=false;
		Scanner scan =new Scanner(System.in);

		System.out.print("please enter the id of the Magazine you want to Delete");
		ID=scan.nextInt();

		for(Item i:items) {
			if(i instanceof Magazines_Sub) {
				mag = (Magazines_Sub) i;
				if(i.getID()==ID) {
					Exist=true;
					items.remove(i);
					System.out.print("done delete");

					return;

				}

			}

		}

		if(Exist==false) {
			System.out.print("the iteam does not exist");}
		return;
	}



	public void UpdateJournal() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		int choice=0;
		int id;
		int newid=0;
		String title;
		String firstname;
		String lastname;
		String date;
		LocalDate dateOfBirth;
		int price;
		LocalDate publishingDate;
		LocalDate duedate;
		String stat;
		Status status;
		String ISBN;
		boolean found=false;
		Periodicity periodicity;
		String fre;
		int ImpactFactor;

		Journal_Sub jou;


		Scanner scanner =new Scanner(System.in);
		System.out.print("Choose the number of what you need to ubdate (id=1,title=2,Author=3,price=4,publishingDate=5,dueDate=6,status=7,Periodicity=8,ImpactFactor=9)");
		choice=scanner.nextInt();
		while(choice!=1&&choice!=2&&choice!=3&&choice!=4&&choice!=5&&choice!=6&&choice!=7&&choice!=8&&choice!=9) {
			System.out.print("please enter the Choise correctly (id=1,title=2,Author=3,price=4,publishingDate=5,dueDate=6,status=7,periodicity=8,ImpactFactor=9)");
			choice=scanner.nextInt();
		}
		if(choice==1) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			System.out.print("choose the new id");
			newid=scanner.nextInt();
			for(Item i:items) {
				if(i instanceof Journal_Sub) {
					jou = ( Journal_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setID(newid);
					}
				}
			}



		}
		if(choice==2) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new title of the book");
			title=scanner.nextLine();
			for(Item i:items) {
				if(i instanceof Journal_Sub) {
					jou = ( Journal_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setTitle(title);
					}
				}
			}

		}
		if(choice==3) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the first name of the Author");
			firstname=scanner.nextLine();
			System.out.print("enter the last name of the Author");
			lastname=scanner.nextLine();
			System.out.print("enter the dateofbirth of the author");
			date=scanner.nextLine();
			dateOfBirth=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof Journal_Sub) {
					jou = ( Journal_Sub) i;
					if( i.getID()==id){
						System.out.print("Update done");
						found=true;
						Author a=new Author(firstname,lastname,dateOfBirth);
						i.setAuthor(a);
					}

				}

			}

		}
		if(choice==4) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			System.out.print("enter the new price of the item");
			price=scanner.nextInt();
			for(Item i:items) {
				if(i instanceof Journal_Sub) {
					System.out.print("Update done");
					jou = ( Journal_Sub) i;
					if( i.getID()==id) {
						found=true;
						i.setPrice(price);
					}}}

		}
		if(choice==5) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new publishingDate of the item");
			date=scanner.nextLine();
			publishingDate=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof Journal_Sub) {
					jou = ( Journal_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setPublishingDate(publishingDate);
					}}}

		}
		if(choice==6) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new dueDate of the item");
			date=scanner.nextLine();
			duedate=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof Journal_Sub) {
					jou = ( Journal_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setPublishingDate(duedate);
					}}}

		}
		if(choice==7) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new status of the item");
			stat=scanner.nextLine();

			while (!stat.equals("borrowed") && !stat.equals("available")) {
				System.out.print("please enter the Status correctly ( borrowed, available) ");
				stat = scanner.nextLine();
			}
			status=Status.valueOf(stat);
			for(Item i:items) {
				if(i instanceof Journal_Sub) {
					jou = ( Journal_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setStatus(status);;
					}}}

		}
		if(choice==8) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new periodicity of the item");
			fre=scanner.nextLine();
			while (!fre.equalsIgnoreCase("MONTHLY") && !fre.equalsIgnoreCase("QUARTERLY") &&
					!fre.equalsIgnoreCase("ANNUAL") && !fre.equalsIgnoreCase("DAILY")) {
				System.out.print("please enter the Periodicity correctly ");
				fre = scanner.nextLine();
			}
			periodicity=Periodicity.valueOf(fre);

			for(Item i:items) {
				if(i instanceof Journal_Sub) {
					jou = ( Journal_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						((Journal_Sub) i).setPublicationFrequency(periodicity);
					}}}

		}
		if(choice==9) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			System.out.print("enter the new ImpactFactor of the item");
			ImpactFactor=scanner.nextInt();
			for(Item i:items) {
				if(i instanceof Journal_Sub) {
					jou = ( Journal_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						((Journal_Sub) i).setImpactFactor(ImpactFactor);;
					}}}


		}
		if(found==false) {
			System.out.print("the iteam does not exist"+"\n");
		}
	}


	public void UpdateMagazine () {
		Magazines_Sub mag;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Scanner in=null;

		int choice=0;
		int id;
		int newid=0;
		String title;
		String firstname;
		String lastname;
		String date;
		LocalDate dateOfBirth;
		int price;
		LocalDate publishingDate;
		LocalDate duedate;
		String stat;
		Status status;
		String ISBN;
		int issueNumber;
		boolean found=false;
		String Line;
		Item o;
		int idd;





		Scanner scanner =new Scanner(System.in);
		System.out.print("Choose the number of what you need to ubdate (id=1,title=2,Author=3,price=4,publishingDate=5,dueDate=6,status=7,issueNumber=8");
		choice=scanner.nextInt();
		while(choice!=1&&choice!=2&&choice!=3&&choice!=4&&choice!=5&&choice!=6&&choice!=7&&choice!=8&&choice!=9) {
			System.out.print("please enter the Choise correctly (id=1,title=2,Author=3,price=4,publishingDate=5,dueDate=6,status=7,issueNumber=8)");
			choice=scanner.nextInt();
		}
		if(choice==1) {


			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			System.out.print("choose the new id");
			newid=scanner.nextInt();
			for(Item i:items) {
				if(i instanceof Magazines_Sub) {
					mag = (Magazines_Sub) i;
					if( i.getID()==id) {
						found=true;
						System.out.print("id updated");
						i.setID(newid);


					}
				}
			}



		}
		if(choice==2) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new title of the book");
			title=scanner.nextLine();
			for(Item i:items) {
				if(i instanceof Magazines_Sub) {
					mag = (Magazines_Sub) i;
					if( i.getID()==id) {
						found=true;
						System.out.print("Update done");
						i.setTitle(title);
						System.out.print(i);
					}
				}
			}

		}
		if(choice==3) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the first name of the Author");
			firstname=scanner.nextLine();
			System.out.print("enter the last name of the Author");
			lastname=scanner.nextLine();
			System.out.print("enter the dateofbirth of the author");
			date=scanner.nextLine();
			dateOfBirth=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof Magazines_Sub) {
					mag = (Magazines_Sub) i;
					if( i.getID()==id){
						System.out.print("Update done");
						found=true;
						Author a=new Author(firstname,lastname,dateOfBirth);
						i.setAuthor(a);
					}

				}

			}

		}
		if(choice==4) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			System.out.print("enter the new price of the item");
			price=scanner.nextInt();
			for(Item i:items) {
				if(i instanceof Magazines_Sub) {
					mag = (Magazines_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setPrice(price);
					}}}

		}
		if(choice==5) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new publishingDate of the item");
			date=scanner.nextLine();
			publishingDate=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof Magazines_Sub) {
					mag = (Magazines_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setPublishingDate(publishingDate);
					}}}

		}
		if(choice==6) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new dueDate of the item");
			date=scanner.nextLine();
			duedate=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof Magazines_Sub) {
					mag = (Magazines_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setPublishingDate(duedate);
					}}}

		}
		if(choice==7) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new status of the item");
			stat=scanner.nextLine();
			while (!stat.equals("borrowed") && !stat.equals("available")) {
				System.out.print("please enter the Status correctly ( borrowed, available) ");
				stat = scanner.nextLine();
			}
			status=Status.valueOf(stat);
			for(Item i:items) {
				if(i instanceof Magazines_Sub) {
					mag = (Magazines_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setStatus(status);;
					}}}

		}
		if(choice==8) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			System.out.print("enter the new issueNumber of the item");
			issueNumber=scanner.nextInt();

			for(Item i:items) {
				if(i instanceof Magazines_Sub) {
					mag = (Magazines_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						((Magazines_Sub) i).setIssueNumber(issueNumber);
					}}}

		}
		if(found==false) {
			System.out.print("the iteam does not exist");
		}


	}



	public void addNewspaper() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		NewsPaper_Sub newspaper;
		int id=0;
		String title;
		String firstname;
		String lastname;
		Double price;
		LocalDate publishingDate;
		String date;
		String datee;
		String dateee;
		Author author;
		LocalDate dueDate;
		LocalDate dateOfBirth;
		Status status;
		boolean newspaperExists = false;
		String stat;

		String issueLanguage;



		Scanner scan=new Scanner(System.in);
		System.out.print("please enter the id of the newspaper:"); 
		id=scan.nextInt();
		scan.nextLine();
		System.out.print("enter the title of the newspaper:");
		title=scan.nextLine();
		System.out.print("enter the first name of thge author");
		firstname=scan.nextLine();
		System.out.print("enter the last name of thge author");
		lastname=scan.nextLine();
		System.out.print("enter the dateOfBirth of the author");
		dateee=scan.nextLine();
		dateOfBirth=LocalDate.parse(dateee, formatter);
		System.out.print("enter the price of the book");
		price=scan.nextDouble();
		scan.nextLine();
		System.out.print("enter the checkOutDate of the book \"yyyy-MM-dd\" ");
		date=scan.nextLine();
		publishingDate=LocalDate.parse(date, formatter);
		System.out.print("enter the dueDate of the newspaper \"yyyy-MM-dd\" ");
		datee=scan.nextLine();
		dueDate=LocalDate.parse(datee, formatter);
		System.out.print("enter the status");
		stat=scan.nextLine();
		while (!stat.equals("borrowed") && !stat.equals("available")) {
			System.out.print("please enter the Status correctly ( borrowed, available) ");
			stat = scan.nextLine();
		}
		status=Status.valueOf(stat.toUpperCase());
		System.out.print("enter the issueNumber");
		issueLanguage=scan.nextLine();
		author=new Author(firstname,lastname,dateOfBirth);
		if(items!=null) {
			for(Item i:items) {
				if(i instanceof NewsPaper_Sub) {
					newspaper= ( NewsPaper_Sub) i;
					if(i.getID()==id) {
						System.out.print("the newspaper is already added");
						newspaperExists=true;
						return;
					}
				}}}
		if (newspaperExists==false) { 
			items.add(new NewsPaper_Sub(id,title,author,price,publishingDate,dueDate,status,issueLanguage));
			System.out.print("the newspaper is added Succesfuly!!");
		}
	}






	public void UpdateNewsPapers_sub() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		Scanner in=null;
		NewsPaper_Sub newspaper;
		int choice=0;
		int id;
		int newid=0;
		String title;
		String firstname;
		String lastname;
		String date;
		LocalDate dateOfBirth;
		int price;
		LocalDate publishingDate;
		LocalDate duedate;
		String stat;
		Status status;
		String ISBN;
		String issueLanguage;
		boolean found=false;
		String Line;
		Item o;
		int idd;





		Scanner scanner =new Scanner(System.in);
		System.out.print("Choose the number of what you need to ubdate (id=1,title=2,Author=3,price=4,publishingDate=5,dueDate=6,status=7,issueLanguage=8");
		choice=scanner.nextInt();
		while(choice!=1&&choice!=2&&choice!=3&&choice!=4&&choice!=5&&choice!=6&&choice!=7&&choice!=8&&choice!=9) {
			System.out.print("please enter the Choise correctly (id=1,title=2,Author=3,price=4,publishingDate=5,dueDate=6,status=7,issueLanguage=8)");
			choice=scanner.nextInt();
		}
		if(choice==1) {


			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			System.out.print("choose the new id");
			newid=scanner.nextInt();
			while(in.hasNextLine()) {
				Line=in.nextLine();
				if(newid==in.nextInt()) {
					idd=newid;
				}}
			for(Item i:items) {
				if(i instanceof NewsPaper_Sub) {
					newspaper= ( NewsPaper_Sub) i;
					if( i.getID()==id) {
						found=true;
						System.out.print("id updated");
						i.setID(newid);


					}
				}
			}



		}
		if(choice==2) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new title of the NewsPaper");
			title=scanner.nextLine();
			for(Item i:items) {
				if(i instanceof NewsPaper_Sub) {
					newspaper= ( NewsPaper_Sub) i;
					if( i.getID()==id) {
						found=true;
						System.out.print("done");
						i.setTitle(title);
						System.out.print(i);
					}
				}
			}

		}
		if(choice==3) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the first name of the Author");
			firstname=scanner.nextLine();
			System.out.print("enter the last name of the Author");
			lastname=scanner.nextLine();
			System.out.print("enter the dateofbirth of the author");
			date=scanner.nextLine();
			dateOfBirth=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof  NewsPaper_Sub) {
					newspaper= ( NewsPaper_Sub) i;
					if( i.getID()==id){
						System.out.print("Update done");
						found=true;
						Author a=new Author(firstname,lastname,dateOfBirth);
						i.setAuthor(a);
					}

				}

			}

		}
		if(choice==4) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			System.out.print("enter the new price of the item");
			price=scanner.nextInt();
			for(Item i:items) {
				if(i instanceof NewsPaper_Sub) {
					newspaper= ( NewsPaper_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setPrice(price);
					}}}

		}
		if(choice==5) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new publishingDate of the item");
			date=scanner.nextLine();
			publishingDate=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof NewsPaper_Sub) {
					newspaper= ( NewsPaper_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setPublishingDate(publishingDate);
					}}}

		}
		if(choice==6) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new dueDate of the item");
			date=scanner.nextLine();
			duedate=LocalDate.parse(date, formatter);
			for(Item i:items) {
				if(i instanceof NewsPaper_Sub) {
					newspaper= ( NewsPaper_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setPublishingDate(duedate);
					}}}

		}
		if(choice==7) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new status of the item");
			stat=scanner.nextLine();
			while (!stat.equals("borrowed") && !stat.equals("available")) {
				System.out.print("please enter the Status correctly ( borrowed, available) ");
				stat = scanner.nextLine();
			}
			status=Status.valueOf(stat);
			for(Item i:items) {
				if(i instanceof NewsPaper_Sub) {
					newspaper= ( NewsPaper_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						i.setStatus(status);;
					}}}

		}
		if(choice==8) {
			System.out.print("enter the id of the item you want to update");
			id=scanner.nextInt();
			scanner.nextLine();
			System.out.print("enter the new issueLanguage of the item");
			issueLanguage=scanner.nextLine();

			for(Item i:items) {
				if(i instanceof NewsPaper_Sub) {
					newspaper= ( NewsPaper_Sub) i;
					if( i.getID()==id) {
						System.out.print("Update done");
						found=true;
						((NewsPaper_Sub) i).setIssueLanguage(issueLanguage);
					}}}

		}



		if(found==false) {
			System.out.print("the iteam does not exist");
		}


	}
	public void DeleteNewsPapers() {
		int ID;
		boolean Exist=false;
		Scanner scan =new Scanner(System.in);
		NewsPaper_Sub newspaper;

		System.out.print("please enter the id of the newspaper you want to Delete");
		ID=scan.nextInt();

		for(Item i:items) {
			if(i instanceof NewsPaper_Sub) {
				newspaper= ( NewsPaper_Sub) i;
				if(i.getID()==ID) {
					Exist=true;
					System.out.print("done delete");
					items.remove(i);
					return;


				}
			}
		}

		if(Exist=false) {
			System.out.print("the iteam does not exist");}
		return;
	}

	public void BorrowTransaction() {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter the ID of the customer: ");
		int customer_id=scan.nextInt();
		boolean exist=false;
		for(Customer customer:customers) {
			if(customer!=null) {
				if(customer.getCustomerID()==customer_id) {
					System.out.println("Enter item id: ");
					int item_id= scan.nextInt();
					for(Item item:items) {
						if(item!=null && item.getID()== item_id && item.getStatus().equals(Status.AVAILABLE)) {
							Transaction t= new Transaction();
							int transactionID= t.getTransactionID();
							if(!transactions.contains(transactionID)) {
								transactions.add(new Transaction(transactionID,customer,item,t.getCheckOutDate(),t.getCheckInDate()));
								item.setStatus(Status.BORROWED);
								item.setDueDate(t.getCheckInDate());
								exist=true;
								return;
							}
						}
					}
				}
			}
		}
		if(exist==false) {
			System.out.print("doesnt exist");
		}
	}
	public void ReturnTransaction() {
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter the ID of the customer: "+"\n");
		int customer_id=scan.nextInt();
		for(Customer customer:customers) {
			if(customer!=null) {
				if(customer.getCustomerID()==customer_id) {
					for(Transaction transaction:transactions) {
						if(transaction.getCustomer().getCustomerID()==customer_id
								&& transaction.getItem().getStatus()==Status.BORROWED) {
							System.out.println(transaction);
						}
					}
					System.out.println("Enter the transaction id of the item you want to return: "+"\n");
					long ti= scan.nextLong();
					for(Transaction transaction:transactions) {
						if(transaction.getTransactionID()==ti) {
							transaction.getItem().setStatus(Status.AVAILABLE);
							transaction.setCheckInDate(transaction.getItem().getDueDate());
							return;
						}
					}
				}
			}
		}

	}
	public ArrayList<String> items_not_returned(){
		boolean exist=false;
		ArrayList<String> borrowed_items= new ArrayList<String>();
		for(Transaction transaction:transactions) {
			if(transaction.getItem().getStatus().equals(Status.BORROWED)) {
				exist=true;
				borrowed_items.add(transaction.getItem().getTitle());
				System.out.print("item added");
			}
		}
		if(exist==false) {
			System.out.print("item doesnt exist");
		}
		return borrowed_items;
	}

	public ArrayList<String> author_publications(){
		boolean exist=false;
		ArrayList<String> author_publication= new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter author last name: ");
		String lastName= scan.nextLine();
		for(Item item:items) {
			if(item.getAuthor().getLastName().equalsIgnoreCase(lastName)){
				exist=true;
				author_publication.add(item.getTitle());
				System.out.print("here is the item"+"\n");
				System.out.print(item);
				System.out.print("item added to the list!!!!"+"\n");
			}
		}
		if(exist==false) {
			System.out.print("item doesnt exist"+"\n");
		}
		return author_publication;

	}

	public void readCustomersFromTheFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream("E:\\java\\projectd\\src\\projrctt\\data.dat"));
			customers = new ArrayList<Customer>();
			customers = (ArrayList<Customer>)  objectIn.readObject();
			items= new ArrayList<Item>();
			items = (ArrayList<Item>)  objectIn.readObject();
		} catch (Exception e) {

		}
	}

	public void addArrayList() {
		ObjectOutputStream obj=null;
		try {
			obj=new ObjectOutputStream(new FileOutputStream("C:\\Windows.old\\Desktop\\workplace_java\\project\\src\\project\\data.dat"));
			for (Customer c:customers) {
				obj.writeObject(c);
			}
			for (Item f:items) {
				obj.writeObject(f);
			}
			for (Author d: authors) {
				obj.writeObject(d);
			}
			for (Transaction g:transactions) {
				obj.writeObject(g);
			}


		}
		catch(Exception ee) {
			ee.printStackTrace();
		}
		finally {try {
			obj.close();
		} catch (IOException e) {

			e.printStackTrace();
		}}

	}
	public void readArrayList() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\1\\Windows.old\\Desktop\\workplace_java\\project\\src\\project\\data.dat"))) {
			while (true) {
				try {
					Object object = ois.readObject();

					if (object instanceof Customer) {
						customers.add((Customer) object);
					} else if (object instanceof Customer) {
						customers.add((Customer) object);
					}
					System.out.println(customers);
				} catch (EOFException eof) {
					break;
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


