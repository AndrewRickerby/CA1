/*
* AlgoCA1 :
* Andrew Rickerby :
* C23344333 :
* Description of class :
*/


package application;

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
        String course;
        Scanner scan = new Scanner(System.in);
        System.out.print("\nHow many Employees do you want to enter ");
        int n = scan.nextInt();
        
        
        for (int i = 1; i <= n; ++i) {
        
        for (int count=1; count <=3; count++)
        {
            System.out.print("\nEnter name of the Employee  " + count + " : ");
            name = scan.nextLine();
            System.out.print("Enter Employee code for " + count + " : ");
            code = scan.nextLine();
            System.out.print("Enter course of publication " + count + " : ");
            course = scan.nextLine();
            scan.nextLine();

       
            m = new Employee(name, code, course);

          
            list.add(m);
        
        }
        }
    }
    
    public void Menu(){
   	 System.out.println("D) Display books");
        System.out.println("Search an employee");
        System.out.println("S) Search for employee");
        System.out.println("Q) Quit");
        System.out.println("Q) Quit");
        System.out.println("Q) Quit");
        System.out.println("Q) Quit");
        
        
        
        String options = null;
        Scanner scan = new Scanner(System.in); 
        do {
            options = scan.nextLine();
            switch (options) {
                case "D":
               	 displayModules();
                    break;
                case "R":
               	 removeFirstModule();
                case "S":
               	 searchModule();
                case "A":
                    removeFirstModule();
                case "C":
                    searchCourse();
                case "X":
                    deleteByCourse();
                case "E":
                	searchEmployees();
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
        System.out.println("\nEnter the module code to search:");
        String code = scan.nextLine();
        System.out.println("\nLooking for the module...");

        boolean found = false;
        LinearNode<Employee> current = list.getFront();
        LinearNode<Employee> previous = null;

        while (current != null) {
            Employee m = current.getElement();
            if (m.getCode().equalsIgnoreCase(code)) {
                found = true;
                System.out.println("\nModule " + m.getCode() + " has been found.");
                
              
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

        System.out.println("\nLooking for course...");

        boolean found = false;
        LinearNode<Employee> current = list.getFront();

       
        while (current != null) {
            Employee m = current.getElement();

            // Check if the course matches
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

    public void deleteByCourse() {
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter course name to delete all employees: ");
        String course = scan.nextLine();

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

    
    
    public static void main(String[] args)
    {
        new TrainingCourses();
    }
}
