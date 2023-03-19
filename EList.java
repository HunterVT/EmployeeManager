/**
 * This class contains an Employee Linked List (EList) that stores Employee Nodes (ENodes).
 * This class ENode class to create new ENodes to store within the linked list.
 * This class contains several methods, like a constructor, and methods that add, remove, or print the list. 
 *
 * @author        Von Tungeln, Hunter
 * @assignment    STEM Project
 * @date          March 22, 2023
 * @bugs          None.
 */
 
public class EList {

   // Initializes ENode and count variables
   private static int count = 0;
   private ENode front = null;
   private ENode back = null;

  /**
   * Empty Constructor for EList objects
   */
   public EList () {
   
   }

  /**
   * Adds an employee to the linked list
   *
   * @param employee     employee object is passed into here and also passed into ENode to create a new node for the list
   */ 
   public void add(Employee employee) {
      
      // If there is nothing in the list
      if (count == 0) {
         ENode newENode = new ENode(employee);
         front = newENode;
         back = newENode;
         System.out.println("Success. Employee Created.");
         count++;
      }
      
      // If there are already nodes in the list
      else {
         ENode newENode = new ENode(employee);
         
         ENode precursor = null;
         ENode cursor = front;
         while ((cursor != null) && (cursor.getEmp().getEnumb() != employee.getEnumb())) {
            precursor = cursor;
            cursor = cursor.getNext();      
         }
         
         // If a duplicate enumb is used this happens
         if (cursor != null && cursor.getEmp().getEnumb() == employee.getEnumb()) {
            System.out.println("Error, ID already in use");
            return;
         }
         
         // Creates a new ENode at the back of the list
         else {
            back.setNext(newENode);
            System.out.println("Success. Employee Created.");
            back = back.getNext();
            count++;
         }
      }
   }

  /**
   * Removes an employee from the linked list
   *
   * @param  enumb       employee object's enumb is compared to the value passed in to find the correct one
   * @return contains    boolean variable that tells whether or not the deletion was successful
   */ 
   public boolean remove(int enumb) {
      boolean contains = false;
      ENode cursor = front;
      ENode precursor = cursor;
      
      // Iterates through the list to see if there is a enumb that matches
      for (int i = 1; i <= count; i ++) {
         precursor = cursor;
         cursor = cursor.getNext();
         
         // Since cursor was already set for the second value, the precursor is checked for the first
         if (precursor.getEmp().getEnumb() == enumb) {
            front = front.getNext();
            count--;
            contains = true;
            break;
         }
         
         // Checks cursor's enumb against the enumb passed in
         if (cursor.getEmp().getEnumb() == enumb) {
            precursor.setNext(cursor.getNext());
            cursor = null;
            count--;
            contains = true;
            break;
         }
      }
      return contains;
   }
   
  /**
   * Finds an employee from the linked list
   *
   * @param  enumb       employee object's enumb is compared to the value passed in to find the correct one
   * @return contain     boolean variable that tells whether or not the employee was found
   */ 
   public boolean find(int enumb) {
      boolean contains = false;
      ENode cursor = front;
      ENode precursor = cursor;
      
      // Iterates through the list to see if there is a enumb that matches
      for (int i = 1; i <= count; i ++) {
         precursor = cursor;
         cursor = cursor.getNext();
         
         // Since cursor was already set for the second value, the precursor is checked for the first
         if (precursor != null) {
            if (precursor.getEmp().getEnumb() == enumb) {
               contains = true;
               break;
            }
         }
         
         // Checks cursor's enumb against the enumb passed in
         if (cursor != null) {
            if (cursor.getEmp().getEnumb() == enumb && cursor != null) {
               contains = true;
               break;
            }
         }
      
      }
      return contains;
   }
   
  /**
   * Finds an employee from the linked list
   *
   * @param  enumb       employee object's enumb is compared to the value passed in to find the correct one
   * @return contain     boolean variable that tells whether or not the employee was found
   */ 
   public double findSalary(int enumb) {
      double empSalary = 0;
      ENode cursor = front;
      ENode precursor = cursor;
      
      // Iterates through the list to see if there is a enumb that matches
      for (int i = 1; i <= count; i ++) {
         precursor = cursor;
         cursor = cursor.getNext();
         
         // Since cursor was already set for the second value, the precursor is checked for the first
         if (precursor.getEmp().getEnumb() == enumb && precursor != null) {
            empSalary = precursor.getEmp().getSalary();
            break;
         }
         
         // Checks cursor's enumb against the enumb passed in
         if (cursor.getEmp().getEnumb() == enumb && cursor != null) {
            empSalary = cursor.getEmp().getSalary();
            break;
         }
      }
      return empSalary;
   }
   
  /**
   * Prints all employees in the list. Calls a rercursive function to do so.
   */ 
   public void printAllEmployees() {
      ENode cursor = front;
      printAllRecurse(cursor);
      
   }

  /**
   * Prints all employees in the list that earn more than a certain amount. 
   * Calls a rercursive function to do so.
   *
   * @param limit   double value that employee salaries are compared to that determines whether they get printed or not
   */ 
   public void printAllEmployeesMoreThan(double limit) {
      ENode cursor = front;
      printAllMoreRecurse(cursor, limit);
   }
   
  /**
   * Prints all employees in the list recursively. 
   *
   * @param cursor  Node that constantly gets printed and assigned the next value to print employees
   */ 
   public void printAllRecurse(ENode cursor) {
      
      // If list is empty
      if (count == 0) {
         System.out.println("There are no employees.");
         return;
      }
      if (cursor != null) {
         System.out.println(cursor);
         printAllRecurse(cursor.getNext());
      }
   }

  /**
   * Prints all employees in the list that earn more than a certain amount recursively. 
   *
   * @param cursor  Node that constantly gets printed and assigned the next value to print employees
   * @param limit   Double value that employee salary is compared to
   */ 
   public void printAllMoreRecurse(ENode cursor, double limit) {
      // If list is empty
      if (count == 0) {
         System.out.println("There are no employees.");
         return;
      }
      
      // Checks employee salary
      if (cursor != null) {
         if (cursor.getEmp().getSalary() > limit) {
            System.out.println(cursor);
         }
         cursor = cursor.getNext();
         printAllMoreRecurse(cursor, limit);
      }
   }
   
   
}