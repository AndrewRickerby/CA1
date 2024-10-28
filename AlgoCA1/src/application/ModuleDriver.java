
package application;

import java.util.Scanner;

import util.LinearNode;
import util.LinkedList;  /* I want to use MY version of a LinkedList */

/**
 * Driver class that uses the Module class with an LinkedList
 */
public class ModuleDriver
{
    LinkedList<Module> list; //Global variable
	

    /**
     * Constructor for objects of class ModuleDriver
     */
    public ModuleDriver()
    {
    	Scanner scan = new Scanner(System.in);
        list = new LinkedList<Module>();
        inputModules();       
        displayModules();
        
        scan.nextLine();
        removeFirstModule();
        displayModules();
    }

    public void inputModules()
    {
        Module m; //local variables
        String name, code;
        String course;
        
        Scanner scan = new Scanner(System.in);
        for (int count=1; count <=3; count++)
        {
            System.out.print("\nEnter name of the Employee  " + count + " : ");
            name = scan.nextLine();
            System.out.print("Enter Employee code for " + count + " : ");
            code = scan.nextLine();
            System.out.print("Enter course " + count + " : ");
            course = scan.nextLine();
            scan.nextLine();

            //Create a module
            m = new Module(name, code, course);

            //Add to LinkedList
            list.add(m);
        }
    }
    
    public void Menu(){
   	 System.out.println("D) Display books");
        System.out.println("");
        System.out.println("S) Search a Book");
        System.out.println("Q) Quit");

        String options = null;
        Scanner scan = new Scanner(System.in); // Capturing the input
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
               	 //addNew();
               	 
                
            }
        } while (!options.equals("Q")); // quitting the program
    }
 
    

    public void displayModules()
    {
        System.out.println("\nDisplaying all modules....");
       
        System.out.println(list.toString());  
        Menu();
    }

    public void removeFirstModule()
    {
    	System.out.println("\nRemoving the first element in the list...");
    	Module m = list.remove();
    	System.out.println("\n" + m.getName() + " has been deleted");
    	Menu();
    }
    
    public void searchModule()
    {
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("\n enter name");
    	String name = scan.nextLine();
    	
    	System.out.println("\n Looking for book...");
    	
    	boolean found= false;
    	
    	LinearNode<Module> current = list.getFront();
    	
    	while(current != null){
    		Module m = current.getElement();
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
    
    
    public static void main(String[] args)
    {
        new ModuleDriver();
    }
}
