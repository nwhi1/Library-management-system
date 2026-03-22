package project;

import java.io.File;
import java.util.Scanner;

public class Console {
    private Library library;
    private Scanner scanner;

    public Console() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
        
    }
    
    public void displayMenu() {
    	
    	while (true) {
    		
            System.out.println("Main Menu");
            System.out.println("Select an option:");
            System.out.println("1- Add new Customer.");
            System.out.println("2- Add new Book.");
            System.out.println("3- Update Book Details.");
            System.out.println("4- Delete existing Book.");
            System.out.println("5- Add new Journal.");
            System.out.println("6- Update Journal Details.");
            System.out.println("7- Delete existing Journal.");
            System.out.println("8- Add new Magazine.");
            System.out.println("9- Update Magazine Details.");
            System.out.println("10- Delete existing Magazine.");
            System.out.println("11- Add new Newspaper.");
            System.out.println("12- Update Newspaper Details.");
            System.out.println("13- Delete existing Newspaper.");
            System.out.println("14- New Borrow Transaction.");
            System.out.println("15- New Return Transaction.");
            System.out.println("16- List all items not yet returned.");
            System.out.println("17- List all Author publications.");
            System.out.println("18- Save and Exit");
           
            int choice = getUserChoice();
            String filePath = "E:/java/projrctt/data.txt";

            File e =new File(filePath);
            
            switch (choice) {
            
                case 1:
                    library.AddCustomer();
                    break;
                case 2:
                    library.AddBook();
                    break;
                case 3:
                    library.UpdateBook();
                    break;
                case 4:
                    library.DeleteBook();
                    break;
                case 5:
                    library.AddJournal();
                    break;
                case 6:
                    library.UpdateJournal();
                    break;
                case 7:
                    library.DeleteJournal();
                    break;
                case 8:
                    library.AddMagazine();
                    break;
                case 9:
                   library.UpdateMagazine();
                    break;
                case 10:
                    library.DeleteMagazine();
                    break;
                
                case 11:
                    library.addNewspaper();
                    break;
                case 12:
                	library.UpdateNewsPapers_sub();
                	 break;
                case 13:
                	library.DeleteNewsPapers();
                	 break;
                case 14:
                	library.BorrowTransaction();
                	 break;
                case 15:
                	library.ReturnTransaction();
                	 break;
                case 16:
                	library.items_not_returned();
                	 break;
                case 17:
                	library.author_publications();
                	 break;
                case 18:
                	System.out.print("exitting the app......"+"\n");
                	System.out.print("exit done");
                	library.addArrayList();
                    System.exit(0);
                    
               
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); 
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void main(String[] args) {
        Console console = new Console();
        
        console.displayMenu();
    }
}

