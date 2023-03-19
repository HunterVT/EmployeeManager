import java.text.*; // For decimal formatting

/**
 * This class contains the employee class and contains a constructor with several instance variables,
 * with various methods to call on, including set methods, get methods, and a toString method.
 * This class also validates values passed into it. When invalid values are passed in, 
 * exceptions will be thrown.
 *
 * @author        Von Tungeln, Hunter
 * @assignment    STEM Project
 * @date          March 22, 2023
 * @bugs          None.
 */
 
public class Employee {

   // Instance variables used in the Employee class
   // enumb = Employee number, unique ID number assigned to them
   // salary = how much the employee earns
   // Name = you can figure this one out
   private int enumb = 0;
   private double salary = 0;
   private String name = "";
   private String streetAddress = "";
   private String city = "";
   private String state = "";
   private int zipCode = 0; 
   private String phoneNumber = "";
   private String ssn = "";
   private String birthdate;
   
  /**
   * Constructor for Employee Objects
   * 
   * @param enumb                    Employee's Unique ID Number
   * @param salary                   How much the employee gets paid - their salary ._.
   * @param Name                     Employee's name
   *
   * Added February 2023
   * @param streetAddress                  Employee Home Address
   * @param city
   * @param state
   * @param zipCode
   * @param phoneNumber
   * @param ssn
   * @param birthdate
   * 
   *
   * @exception EmployeeException    Thrown if enumb is not between 10001 and 99999, inclusive
   * @exception EmployeeException    Thrown if salary is not between 0 and 500000, inclusive
   * @exception EmployeeException    Thrown if name is not at least 2, non-blank characters long
   */
   public Employee(int enumb, double salary, String name, String streetAddress, String city, String state, int zipCode, String phoneNumber, 
   String ssn, String birthdate) throws EmployeeException {
      setEnumb(enumb);
      setSalary(salary);
      setName(name);
      setStreetAddress(streetAddress);
      setCity(city);
      setState(state);
      setZipCode(zipCode);
      setPhoneNumber(phoneNumber);
      setSSN(ssn);
      setBirthdate(birthdate);
   }
   
   
  /**
   * Returns a string value when the object is printed
   * Example:
   *  Employee Name: Derek
   *  Employee ID: 69420
   *  Salary: $13,463.00
   *
   */
   public String toString() {
      double salaryPlaceholder = this.salary;
      DecimalFormat salaryFormatter = new DecimalFormat("$###,###.00");
      String convertedSalary = salaryFormatter.format(salaryPlaceholder);
      String output = "";
      output += "Employee Name: " + this.name;
      output += "\nEmployee ID: " + this.enumb;
      output += "\nSalary: " + convertedSalary;
      output += "\nAddress: " + this.streetAddress;
      output += "\nCity: " + this.city;
      output += "\nState: " + this.state;
      output += "\nZIP: " + this.zipCode;
      output += "\nPhone Number: " + this.phoneNumber;
      output += "\nSSN: " + this.ssn;
      output += "\nBirthdate: " + this.birthdate;
      output += "\n";
      return output;      
   }
   
   // Get methods
   public int getEnumb() {
      return this.enumb;
   }
   
   public double getSalary() {
      return this.salary;
   }
   
   public String getName() {
      return this.name;
   }
   
   public String getStreetAddress() {
      return this.streetAddress;
   }
   
   public String getCity() {
      return this.city;
   }
   
   public String getState() {
      return this.state;
   }
   
   public int getZIPCode() {
      return this.zipCode;
   }
   
   public String getPhoneNumber() {
      return this.phoneNumber;
   }
   
   public String getSSN() {
      return this.ssn;
   }
   
   public String getBirthdate() {
      return this.birthdate;
   }
   
   // Set methods
   
  /**
   * Sets the Employee Number (enumb) to a new value
   * However, the enumb value must be between 10001 and 99999, inclusive
   *
   * @param       newEnumb              New value the employee number is set to
   * @exception   EmployeeException     Thrown if newEmployee is not between 10001 and 99999, inclusive   
   */

   public void setEnumb(int newEnumb) throws EmployeeException {
      if (newEnumb >= 10001 && newEnumb <= 99999) {
         this.enumb = newEnumb;
      }
      else {
         EmployeeException ee = new EmployeeException();
         ee.setMessage("Error: the value of " + newEnumb + " is not valid. Only integers between 10001 and 99999 are valid");
         throw ee;
      }
   }
   
  /**
   * Sets the Employee salary to a new value
   * However, the salary double value must be between 0 and 500000, inclusive
   *
   * @param       newSalary             New value the employee salary is set to
   * @exception   EmployeeException     Thrown if newSalary is not between 0 and 500000, inclusive   
   */

   public void setSalary(double newSalary) throws EmployeeException {
      if (newSalary >= 0 && newSalary <= 500000) {
         this.salary = newSalary;
      }
      else {
         EmployeeException ee = new EmployeeException();
         ee.setMessage("Error: the value of " + newSalary + " is not valid. Only values between 0 and 500000 are valid, decimals are okay.");
         throw ee;
      }
   }
   
  /**
   * Sets the Employee name to a new value
   * However, the name string value must be at least two, non-blank characters
   *
   * @param       newName               New value the employee salary is set to
   * @exception   EmployeeException     Thrown if newName is not at least two, non-blank characters   
   */

   public void setName(String newName) throws EmployeeException {
      newName = newName.trim();
      if (newName.length() < 2) {
         EmployeeException ee = new EmployeeException();
         ee.setMessage("Error: the value of " + newName + " is not valid. Only names that are at least two, non-blank characters are valid.");
         throw ee;
      }
      
      else {
         this.name = newName;
      }
   }
   
  /**
   * Sets the Employee street address to a new value
   *
   * @param       newStreetAddress      New value the employee address is set to  
   */

   public void setStreetAddress(String newStreetAddress) {
      this.streetAddress = newStreetAddress;
   }
   
  /**
   * Sets the Employee cityaddress to a new value
   *
   * @param       newCity      New value the employee city is set to  
   */

   public void setCity(String newCity) {
      this.city = newCity;
   }
   
  /**
   * Sets the Employee state address to a new value
   *
   * @param       newState      New value the employee state is set to  
   */

   public void setState(String newState) {
      this.state = newState;
   }
   
  /**
   * Sets the Employee phone number to a new value
   *
   * @param       newPhoneNumber      New value the employee phone number is set to  
   */

   public void setPhoneNumber(String newPhoneNumber) {
      this.phoneNumber = newPhoneNumber;
   }
   
  /**
   * Sets the Employee ssn to a new value
   *
   * @param       newSSN      New value the employee ssn is set to  
   */

   public void setSSN(String newSSN) {
      this.ssn = newSSN;
   }
   
  /**
   * Sets the Employee ssn to a new value
   *
   * @param       newSSN      New value the employee ssn is set to  
   */

   public void setBirthdate(String newBirthdate) {
      this.birthdate = newBirthdate;
   }
   
  /**
   * Sets the Employee zip code to a new value
   *
   * @param       newZipCode      New value the employee ssn is set to  
   */

   public void setZipCode(int newZipCode) {
      this.zipCode = newZipCode;
   }
      
}
