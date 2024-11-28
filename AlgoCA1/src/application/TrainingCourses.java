/*
* AlgoCA1 :
* Andrew Rickerby :
* C23344333 :
* Description of class : main class allowing users to add, remove, search, display, and reverse employee records through the menu.
*/


package application;
import java.util.InputMismatchException;
import java.util.Scanner;

import util.LinearNode;
import util.LinkedList;  

public class TrainingCourses
{
    LinkedList<Employee> list; 
	

    
    public TrainingCourses()
    {
    	Scanner scan = new Scanner(System.in);
        list = new LinkedList<Employee>();
        inputModules();       
        displayModules();
        
        scan.nextLine();
        removeFirstModule();
        displayModules();
    }

    public void inputModules()
    {
        Employee m; 
        String name, code;
        Scanner scan = new Scanner(System.in);
        String course;
        int n = 11;
        while (n>10){
        try {
	        
		        System.out.print("\nHow many Employees do you want to enter(1-10): ");
		         n = scan.nextInt();
		        scan.nextLine(); 
		   }
        
        catch(InputMismatchException e) {
        	System.out.println("Invalid input.Please Enter an integer.");
        	scan.next();
        }
    }
        
        
        
            for (int count = 1; count <= n; count++) {
            	
                System.out.print("\nEnter name of the Employee " + count + " : ");
                 name = scan.nextLine();
  
                System.out.print("\nEnter Employee code for " + count + " : ");
                 code = scan.nextLine();

                while (true) {
                    System.out.print("Enter course (must start with 'Food'): ");
                    course = scan.nextLine();
                    if (course.startsWith("Food")) {
                        break;
                    } else {
                        System.out.println("Error: Course must start with 'Food'. Please try again.");
                    }
                }
                
                System.out.print("Enter the years of experince " + count + " : ");
                int years = scan.nextInt();
                scan.nextLine(); 

                // Create and add the Employee object
                m = new Employee(name, code, course, years);
                list.add(m);
            
        
        
        }
        }
   
    public void Menu(){
    	System.out.println("d) Display");
        System.out.println("s) Search for employee");
        System.out.println("r) Remove employee by number");
        System.out.println("c) Search by course");
        System.out.println("x) Delete by course");
        System.out.println("e) Add employees");
        System.out.println("v) Reverse the list"); 
        System.out.println("q) Quit");
        
        
        
        String options = null;
        Scanner scan = new Scanner(System.in); 
        do {
            options = scan.nextLine();
            switch (options) {
                case "d":
               	 displayModules();
                    break;
                case "r":
               	 removeFirstModule();
                case "s":
               	 searchModule();
                case "a":
                    removeFirstModule();
                case "c":
                    searchCourse();
                case "x":
                    deleteByCourse();
                case "e":
                	AddEmployees();
                case "t":
                	searchEmployees();
                case "v":
                	reverseList();
                case "Q":
                    System.out.println("Exiting the program...");
               	 
                
            }
        } while (!options.equals("Q"));
    }
 
    

    public void displayModules()
    {
        System.out.println("\nDisplaying all modules....");
       
        System.out.println(list.toString());  
        Menu();
    }

    public void removeFirstModule() {
    	Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter the employee code to search:");
        String code = scan.nextLine();
        System.out.println("\nLooking for the employee...");

        boolean found = false;
        LinearNode<Employee> current = list.getFront();
        LinearNode<Employee> previous = null;

        while (current != null) {
            Employee m = current.getElement();
            if (m.getCode().equalsIgnoreCase(code)) {
                found = true;
                System.out.println("\nEmployee " + m.getCode() + " has been found.");
                
              
                if (previous == null) {
                    
                    list.setFront(current.getNext());
                } else {
                    
                    previous.setNext(current.getNext());
                }

             
                if (current.getNext() == null) {
                    list.setLast(previous); 
                }

                

                System.out.println("\n" + m.getName() + " has been deleted.");
                break;
            }
            
           
            previous = current;
            current = current.getNext();
        }

        if (!found) {
            System.out.println("\nModule with code " + code + " has not been found.");
        }

     
        Menu();
    }
    
    public void searchModule()
    {
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("\n enter name");
    	String name = scan.nextLine();
    	
    	System.out.println("\n Looking for book...");
    	
    	boolean found= false;
    	
    	LinearNode<Employee> current = list.getFront();
    	
    	while(current != null){
    		Employee m = current.getElement();
    		if (m.getName().equalsIgnoreCase(name)){
    		System.out.println("\n" + m.getName()+ "has been found");
    		found = true;
    		break;
		   
    		}
    		current = current.getNext();
    		
    		
    	}
    	
    	if (!found){
    		
    	
    	System.out.println("\n" + name + " has not been found");
    	
}
    	Menu();
    }
    public void searchCourse() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter course:");
        String course = scan.nextLine();

        if (!course.startsWith("Food")) {
            System.out.println("Error: Course must start with 'Food'.");
            Menu();
            return;
        }

        System.out.println("\nLooking for course...");

        boolean found = false;
        LinearNode<Employee> current = list.getFront();

        while (current != null) {
            Employee m = current.getElement();

            if (m.getCourse().equalsIgnoreCase(course)) {
                if (!found) {
                    System.out.println("\nCourse \"" + course + "\" has been found. Employees on this course:");
                    found = true;
                }
                System.out.println("- " + m.getName());
            }

            current = current.getNext();
        }

        if (!found) {
            System.out.println("\nCourse \"" + course + "\" has not been found.");
        }

        Menu();
    }
    
    
    public void searchEmployees() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter course name: ");
        String course = scan.nextLine();

        LinearNode<Employee> current = list.getFront();
        boolean found = false;

        System.out.println("\nEmployees on course \"" + course + "\":");
        while (current != null) {
            Employee m = current.getElement();
            if (m.getCourse().equalsIgnoreCase(course)) {
                System.out.println("- " + m.getName());
                found = true;
            }
            current = current.getNext();
        }

        if (!found) {
            System.out.println("No employees found on course \"" + course + "\".");
        }
    }
    
    public void reverseList() {
        System.out.println("\nReversing the list...");
        list.reverse();
        System.out.println("The list has been reversed.");
        displayModules();
    }

    public void deleteByCourse() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter course name to delete all employees: ");
        String course = scan.nextLine();

        if (!course.startsWith("Food")) {
            System.out.println("Error: Course must start with 'Food'.");
            displayModules();
            return;
        }

        LinearNode<Employee> current = list.getFront();
        LinearNode<Employee> previous = null;
        boolean found = false;

        while (current != null) {
            Employee m = current.getElement();
            if (m.getCourse().equalsIgnoreCase(course)) {
                if (previous == null) {
                    list.setFront(current.getNext());
                } else {
                    previous.setNext(current.getNext());
                }
                if (current.getNext() == null) {
                    list.setLast(previous);
                }
                current = (previous == null) ? list.getFront() : previous.getNext();
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }

        if (found) {
            System.out.println("\nAll employees on course \"" + course + "\" have been removed.");
        } else {
            System.out.println("\nNo employees found on course \"" + course + "\".");
        }

        displayModules();
    }

    public void AddEmployees() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nEnter employee name:");
        String name = scan.nextLine();
        System.out.println("Enter employee code:");
        String code = scan.nextLine();
        System.out.println("years of experinece here:");
        int years = scan.nextInt();

        String course = ""; 
        while (true) {
            System.out.print("Enter course (must start with 'Food'): ");
            course = scan.nextLine(); 
            if (course.startsWith("Food")) {
                break; 
            } else {
                System.out.println("Error: Course must start with 'Food'. Please try again.");
            }
        }

        Employee newEmployee = new Employee(name, code, course, years); 
        System.out.println("Enter position to add the employee (0 for the start, " + list.size() + " for the end):");
        int position = scan.nextInt();

        try {
            list.addAt(position, newEmployee);
            System.out.println("Employee added successfully.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid position. Employee not added.");
        }

        Menu();
    }

    public static void main(String[] args)
    {
        new TrainingCourses();
    }
}
