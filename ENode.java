/**
 * This class contains an Employee Node (ENode) to be used with an Employee Linked List (EList).
 * This class uses the Employee class to create employee objects and store them within nodes.
 * This class contains several methods, like a constructor, set, and get methods. 
 *
 * @author        Von Tungeln, Hunter
 * @assignment    STEM Project
 * @date          March 22, 2023
 * @bugs          None.
 */
 
public class ENode {

   // Instance variables used in the Employee class
   // Initializes an employee and ENode object
   private Employee employee = null;
   private ENode next = null;
   
  /**
   * Constructor for ENode objects
   *
   * @param employee
   */
   public ENode(Employee employee) {
      this.employee = employee;
      this.next = null;
   }
   
  /**
   * Assigns a variable to points to the next ENode within the list
   *
   * @param  next      Method uses this to set to the next ENode
   */
   public void setNext(ENode next) {
      this.next = next;
   }
   
  /**
   * Retrieves the value of the next ENode within the list
   */
   public ENode getNext() {
      return this.next;
   }
   
  /**
   * Sets the ENode to an employee passed in
   *
   * @param employee  employee object is used to set the value of the ENode to the employee
   */
   public void setEmp(Employee employee) {
      this.employee = employee;
   }
   
  /**
   * Retrieves the employee from the node
   */
   public Employee getEmp() {
      return this.employee;
   }
  
  /**
   * Prints the object within the node using the Employee class toString method
   */
   public String toString () {
      String s = this.getEmp().toString();
      return s;
   }
   
}