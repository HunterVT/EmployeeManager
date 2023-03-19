/**
 * This class defines a EmployeeException to be thrown whenever an invalid value in the Employee class is passed in. 
 *
 * @author        Von Tungeln, Hunter
 * @assignment    STEM Project
 * @date          March 22, 2023
 * @bugs          None.
 */

public class EmployeeException extends Exception {
   
   // Message that outputs when the exception is thrown
   private String message = "";
   
  /**
   * Constructs an empty exception (EmployeeException)
   */ 
   public EmployeeException() {
   
   }
   
   public void setMessage(String newMessage) {
      this.message = newMessage;
   }
   
   public String getMessage() {
      return this.message;
   }
}