import java.text.*; // For decimal formatting
import java.util.*; // For Scanner objects, user input, and arrays


/**
 * This driver class utilizes the Employee and EmployeeException classes.
 * This driver also uses the ENode and EList classes for creating a linked list of employees.
 * A user runs this program to add, remove, print employees that earn
 * a certain amount of money, or print all employees. 
 *
 * @author        Von Tungeln, Hunter
 * @assignment    STEM Project
 * @date          March 22, 2023
 * @bugs          None.
 */
 
public class EmployeeManager {
   public static void main(String[] args) {
   
   // Scanner object created here
      Scanner userReader = new Scanner(System.in);
      
      // Variables defined here
      int userChoice = 1;
      int enumb = 0;
      double salary = 0;
      String name;
      //
      String streetAddress;
      String city;
      String state;
      int zipCode;
      String phoneNumber;
      String ssn;
      String birthdate;
      //
      double salaryPlaceholder = 0;
      double usualHours = 0;
      double exactWeekHours = 0;
      double grossYearPay = 0;
      double grossBiweeklyPay = 0;
      double fedTaxBracket = 0;
      double hawaiiTaxBracket = 0;
      double netYearPay = 0;
      double netBiweeklyPay = 0;
      //
      double salaryAmount = 0;
      //
      double qualityWorkRating = 0;
      double communicationRating = 0;
      double socialRating = 0;
      double punctualityRating = 0;
      double attendanceRating = 0;
      double overallAverage = 0;
      //
      int i;
      Employee employee;
      ENode employeeNode;
      EList employeeList = new EList();    
      
      // While the number selected by the user is not 0, this looped menu will repeat
      while (userChoice != 0) {
         welcomeMessage();
         try {
            userChoice = userReader.nextInt();
            
            // Switch statement for the user options
            switch (userChoice) {
               
               // Ends the program
               case 0: 
                  System.out.println("Thank you for using this program. This program is ending now.");
                  break;
               
               // Adds an employee
               case 1:
                  try {
                     
                     // Asks the employees for their information
                     System.out.print("Enter the employee number here: ");
                     enumb = userReader.nextInt();
                     System.out.print("Enter the employee salary here: ");
                     salary = userReader.nextDouble();
                     System.out.print("Enter the employee name here: ");
                     userReader.nextLine();
                     name = userReader.nextLine();
                     userReader.nextLine();
                     System.out.print("Enter the employee address here: ");
                     streetAddress = userReader.nextLine();
                     userReader.nextLine();
                     System.out.print("Enter the employee city here: ");
                     city = userReader.nextLine();
                     userReader.nextLine();
                     System.out.print("Enter the employee state here: ");
                     state = userReader.nextLine();
                     userReader.nextLine();
                     System.out.print("Enter the employee ZIP here: ");
                     zipCode = userReader.nextInt();
                     userReader.nextLine();
                     System.out.print("Enter the employee phone number here: ");
                     phoneNumber = userReader.nextLine();
                     userReader.nextLine();
                     System.out.print("Enter the employee SSN here: ");
                     ssn = userReader.nextLine();
                     userReader.nextLine();
                     System.out.print("Enter the employee birthdate here: ");
                     birthdate = userReader.nextLine();
                     userReader.nextLine();
                     
                     
                     employee = new Employee(enumb, salary, name, streetAddress, city, state, zipCode, phoneNumber, ssn, birthdate);
                                          
                     employeeList.add(employee);
                  }
                  
                  // If the object is created incorrectly with wrong values, this prints 
                  catch (EmployeeException ee) {
                     System.out.println("Error: One of the values are invalid. Please try again.");
                     System.out.println("Employee Number: Values between 10001 and 99999, inclusive.");
                     System.out.println("Employee Salary: Double values between 0 and 500000, inclusive.");
                     System.out.println("Employee Name: At least two, non-blank characters.\n");
                  
                  }
                  break;
               
               // Deletes an employee   
               case 2:
                  System.out.print("Enter the Employee ID of the Employee you wish to delete: ");
                  enumb = userReader.nextInt();
                  if (employeeList.remove(enumb) == true) {
                     System.out.println("Success. Employee removed.");
                  }
                  else {
                     System.out.println("Error, employee not found.");
                  }
                  
                  break;
               
               // Prints employees that earn more than a certain amount
               // Asks the user for the amount to compare to  
               case 3:
                  System.out.print("Enter the amount: ");
                  salaryAmount = userReader.nextDouble();
                  System.out.println("Printing employeees that earn more than $" + salaryAmount + "\n");
                  employeeList.printAllEmployeesMoreThan(salaryAmount);
                  
                  break;
            
               // Prints all employees, while not printing null objects   
               case 4:
                  System.out.println("\nPrinting all employees.\n");
                  employeeList.printAllEmployees();
                  break;
                  
               // Calculates an employee's payroll, based on a biweekly pay system
               case 5: 
                  System.out.print("Enter the Employee ID of the Employee who's pay you wish to calculate: ");
                  enumb = userReader.nextInt();
                  
                  // Checks to see if the employee exists
                  if (employeeList.find(enumb) == true) {
                     
                     // Finds salary of employee 
                     salaryPlaceholder = employeeList.findSalary(enumb);
                     
                     // User enters the employee hours
                     System.out.print("Please enter how many hours this employee USUALLY works in two weeks: ");
                     usualHours = userReader.nextDouble();
                     userReader.nextLine();
                     System.out.print("Please enter how many hours this employee worked in the last two weeks: ");
                     exactWeekHours = userReader.nextDouble();
                     userReader.nextLine();
                     
                     // Gross and net pay calculations done here by calling the functions to do so
                     grossYearPay = grossYearPay(salaryPlaceholder, usualHours);
                     grossBiweeklyPay = biweeklyGrossPay(salaryPlaceholder, exactWeekHours);
                     fedTaxBracket = federalTaxBracket(grossYearPay);
                     hawaiiTaxBracket = hawaiiTaxBracket(grossYearPay);
                     netYearPay = netYearPay(grossYearPay, fedTaxBracket, hawaiiTaxBracket);
                     netBiweeklyPay = netBiweeklyPay(grossBiweeklyPay, fedTaxBracket, hawaiiTaxBracket);
                     
                     // Formats the pay
                     DecimalFormat salaryFormatter = new DecimalFormat("$###,###.00");
                     String convertedHourlySalary = salaryFormatter.format(salaryPlaceholder);
                     String convertedGrossYearPay = salaryFormatter.format(grossYearPay);
                     String convertedGrossBiweeklyPay = salaryFormatter.format(grossBiweeklyPay);
                     String convertedNetYearPay = salaryFormatter.format(netYearPay);
                     String convertedNetBiweeklyPay = salaryFormatter.format(netBiweeklyPay);
                     
                     // Outputs the results of the calculation
                     String empPay = "";
                     empPay += ("This employee's hourly rate is " + convertedHourlySalary + " an hour\n");
                     empPay += ("This employee usually works " + usualHours + " hours per every two weeks\n");
                     empPay += ("This employee worked " + exactWeekHours + " hours in the last two weeks\n");
                     empPay += ("This employee's approximate gross yearly pay is " + convertedGrossYearPay + "\n");
                     empPay += ("This employee's approximate gross pay for the last two weeks is " + convertedGrossBiweeklyPay + "\n");
                     empPay += ("This employee's net pay for the year is " + convertedNetYearPay + "\n");
                     empPay += ("This employee's net pay for the last two weeks is " + convertedNetBiweeklyPay + "\n");
                     System.out.println(empPay);
                     
                  }
                  
                  // If employee does not exist
                  else {
                     System.out.print("Error: Employee not found\n");
                  }
                  break;
               
               // Employee performance calculation
               case 6: 
                  System.out.print("Enter the Employee ID of the Employee performance you would like to evaluate: ");
                  enumb = userReader.nextInt();
                  
                  // Finds the employee
                  if (employeeList.find(enumb) == true) {
                  
                     // Asks for the employee quality of work
                     System.out.print("How would you rate this employee's quality of work? (Scale of 1.0 - 5.0): ");
                     qualityWorkRating = userReader.nextDouble();
                     
                     // Input Verification
                     if (qualityWorkRating < 1.0 || qualityWorkRating > 5.0) {
                        System.out.println("Please enter a value between 1.0 and 5.0 next time.");
                        break;
                     }
                     
                     // Asks for communication rating
                     System.out.print("How would you rate this employee's communication? (Scale of 1.0 - 5.0): ");
                     communicationRating = userReader.nextDouble();
                     
                     // Input verification
                     if (communicationRating < 1.0 || communicationRating > 5.0) {
                        System.out.println("Please enter a value between 1.0 and 5.0 next time.");
                        break;
                     }
                     
                     // Asks for social skills rating
                     System.out.print("How would you rate this employee's social skills? (Scale of 1.0 - 5.0): ");
                     socialRating = userReader.nextDouble();
                     
                     // Input verification
                     if (socialRating < 1.0 || socialRating > 5.0) {
                        System.out.println("Please enter a value between 1.0 and 5.0 next time.");
                        break;
                     }
                     
                     // Punctuality rating asked
                     System.out.print("How would you rate this employee's punctuality? (Scale of 1.0 - 5.0): ");
                     punctualityRating = userReader.nextDouble();
                     
                     // Input verification
                     if (punctualityRating < 1.0 || punctualityRating > 5.0) {
                        System.out.println("Please enter a value between 1.0 and 5.0 next time.");
                        break;
                     }
                     
                     // Attendance rating
                     System.out.print("How would you rate this employee's attendance? (Scale of 1.0 - 5.0): ");
                     attendanceRating = userReader.nextDouble();
                     
                     // Input verification
                     if (attendanceRating < 1.0 || attendanceRating > 5.0) {
                        System.out.println("Please enter a value between 1.0 and 5.0 next time.");
                        break;
                     }
                     
                     // Calculates overall average and outputs the results
                     overallAverage = (qualityWorkRating + communicationRating + socialRating + punctualityRating + attendanceRating) / 5;
                     String perfOutput = "";
                     perfOutput += ("\nEmployee Number: " + enumb + "\n");
                     perfOutput += ("Quality of Work: " + qualityWorkRating + " out of 5.0\n");
                     perfOutput += ("Communication: " + communicationRating + " out of 5.0\n");
                     perfOutput += ("Social Skills: " + socialRating + " out of 5.0\n");
                     perfOutput += ("Punctuality: " + punctualityRating + " out of 5.0\n" );
                     perfOutput += ("Attendance: " + attendanceRating + " out of 5.0\n");
                     perfOutput += ("Overall: " + overallAverage + " out of 5.0\n");
                     System.out.print(perfOutput);
                  }
                  
                  // If employee is not found
                  else {
                     System.out.print("Error: Employee not found\n");
                  }
                  break;
               
               // If the wrong number is entered by the user, this executes.   
               default: 
                  System.out.println("Wrong number. Try Again.\n");
            }
         
         }
         
         // If the user inputs a string, this prints, and discards the value
         catch (InputMismatchException ime) {
            System.out.println("\nError: Invalid Input, please try again.\n");
            userReader.next();
         }
         
         
      
      }
   }
   
   // This method is just a series of print statements with instructions for the user
   public static void welcomeMessage() {
      System.out.println("\nWelcome! Please select one of the options below.");
      System.out.println("1. add an employee");
      System.out.println("2. remove an employee");
      System.out.println("3. print employees that earn more than a given amount");
      System.out.println("4. print all the employees");
      System.out.println("5. calculate biweekly and yearly pay for an employee");
      System.out.println("6. calculate an employee's performance");
      System.out.println("0. end this program" + "\n");
      System.out.print("Enter your choice here: ");
         
   }
   
  /**
   * Calculates the gross pay for the year for an employee
   *
   * @param  salary            salary of the employee
   * @param  biweeklyHours     Hours the employee usually works over the course of two weeks
   * @return grossYearPay      approximate gross pay for the year
   */ 
   public static double grossYearPay(double salary, double biweeklyHours) {
      double grossYearPay = salary * biweeklyHours * 26;
      return grossYearPay;
   }
   
  /**
   * Calculates the gross pay for the last two weeks for an employee
   *
   * @param  salary                    salary of the employee
   * @param  biweeklyHours             Hours the employee usually works over the course of two weeks
   * @return biweeklyGrossYearPay      approximate gross pay for the last two weeks
   */ 
   public static double biweeklyGrossPay(double salary, double biweeklyHours) {
      double biweeklyGrossPay = salary * biweeklyHours;
      return biweeklyGrossPay;
   }
   
  /**
   * Calculates the federal tax bracket for an employee based on their annual gross salary
   *
   * @param  grossYearPay           Approximate gross pay for the employee
   * @return federalTaxBracket      Decimal value of the federal tax bracket they fall into
   */ 
   public static double federalTaxBracket(double grossYearPay) {
      double federalTaxBracket = 0;
      
      if (grossYearPay > 0 && grossYearPay < 10000) {
         federalTaxBracket = 0.10;
      }
      else if (grossYearPay < 40000) {
         federalTaxBracket = 0.12;
      }
      else if (grossYearPay < 90000) {
         federalTaxBracket = 0.22;
      }
      else if (grossYearPay < 170000) {
         federalTaxBracket = 0.24;
      }
      else if (grossYearPay < 215000) {
         federalTaxBracket = 0.32;
      }
      else if (grossYearPay < 540000) {
         federalTaxBracket = 0.35;
      }
      else {
         federalTaxBracket = 0.37;
      }
      return federalTaxBracket;
   }
   
  /**
   * Calculates the federal tax bracket for an employee based on their annual gross salary
   *
   * @param  grossYearPay           Approximate gross pay for the employee
   * @return hawaiiTaxBracket       Decimal value of the Hawaii tax bracket they fall into
   */ 
   public static double hawaiiTaxBracket(double grossYearPay) {
      double hawaiiTaxBracket = 0;
      
      if (grossYearPay > 0 && grossYearPay < 2400) {
         hawaiiTaxBracket = 0.014;
      }
      else if (grossYearPay < 4800) {
         hawaiiTaxBracket = 0.032;
      }
      else if (grossYearPay < 9600) {
         hawaiiTaxBracket = 0.055;
      }
      else if (grossYearPay < 14400) {
         hawaiiTaxBracket = 0.064;
      }
      else if (grossYearPay < 19200) {
         hawaiiTaxBracket = 0.068;
      }
      else if (grossYearPay < 24000) {
         hawaiiTaxBracket = 0.072;
      }
      else if (grossYearPay < 36000) {
         hawaiiTaxBracket = 0.076;
      }
      else if (grossYearPay < 48000) {
         hawaiiTaxBracket = 0.079;
      }
      else if (grossYearPay < 150000) {
         hawaiiTaxBracket = 0.0825;
      }
      else if (grossYearPay < 175000) {
         hawaiiTaxBracket = 0.09;
      }
      else if (grossYearPay < 200000) {
         hawaiiTaxBracket = 0.10;
      }
      else {
         hawaiiTaxBracket = 0.11;
      }
      return hawaiiTaxBracket;
   }
   
  /**
   * Calculates the net pay for an employee for the year
   *
   * @param  grossYearPay           Approximate gross pay for the employee
   * @param  fedTaxBracket          Decimal value of the federal tax bracket of the employee
   * @param  hawaiiTaxBracket       Decimal value of the Hawaii tax bracket of the employee
   * @return netYearPay             Net pay of the employee for the year
   */ 
   public static double netYearPay(double grossYearPay, double fedTaxBracket, double hawaiiTaxBracket) {
      double ssTax = 0.062;
      double medicareTax = 0.0145;
      double netYearPay = 0;
      netYearPay = grossYearPay - (grossYearPay * fedTaxBracket) - (grossYearPay * hawaiiTaxBracket)
         - (grossYearPay * ssTax) - (grossYearPay * medicareTax);
      return netYearPay;
   }
   
  /**
   * Calculates the net pay for an employee for the last two weeks
   *
   * @param  grossBiweeklyPay       Approximate gross pay for the employee
   * @param  fedTaxBracket          Decimal value of the federal tax bracket of the employee
   * @param  hawaiiTaxBracket       Decimal value of the Hawaii tax bracket of the employee
   * @return netbiWeeklyPay         Net pay of the employee
   */ 
   public static double netBiweeklyPay(double grossBiweeklyPay, double fedTaxBracket, double hawaiiTaxBracket) {
      double ssTax = 0.062;
      double medicareTax = 0.0145;
      double netBiweeklyPay = 0;
      netBiweeklyPay = grossBiweeklyPay - (grossBiweeklyPay * fedTaxBracket) - (grossBiweeklyPay * hawaiiTaxBracket)
         - (grossBiweeklyPay * ssTax) - (grossBiweeklyPay * medicareTax);
      return netBiweeklyPay;
   }

}
