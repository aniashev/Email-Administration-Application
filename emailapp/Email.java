//package emailapp;
import java.util.Scanner;

public class Email {
  private String firstName;
  private String lastName;
  private String password;
  private String department;
  private String email;
  private int mailboxCapacity = 500;
  private int passwordLength = 8;
  private String alternateEmail;
  private String companySuffix = "anycompany.com";

  // Constructor to receive first and last name
  public Email(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  

    //Call a method asking for the department
    this.department = setDepartment();
    

    //Call a method that returns a random passowrd
    this.password = randomPassword(passwordLength);
    System.out.println("Your password is " + this.password);

    //Combine elements to generate email
    email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
  }
  
  // Ask for the department
  private String setDepartment(){
    System.out.println("New worker: " + firstName + " " + lastName+  "\n. Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n Enter department code: ");
    Scanner in = new Scanner(System.in);
    int depChoice = in.nextInt();
    if(depChoice == 1) {
      return "sales";
    }
    else if (depChoice == 2){
      return "dev";
    }
    else if (depChoice == 3){
      return "acct";
    }
    else { return " ";
    }
  }
  
  // Generate a random password
    private String randomPassword(int length){
      String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$&";
      char[] password = new char[length];
      for (int i = 0; i < length; i++){
        int rand = (int) (Math.random()* passwordSet.length());
        password[i] = passwordSet.charAt(rand);
      }
    return new String(password);
    }
  // Set mailbox capacity

  public void setMailBoxCapacity(int capacity){
    this.mailboxCapacity = capacity;
  }

  // Set alternate email

  public void setAltEmail(String altemail){
    this.alternateEmail = altemail;
  }

  // Change the passowrd
    public void changePassword(String password){
    this.password = password;
  }

  public int getMailboxCapacity(){return mailboxCapacity;}
  public String getAlternateEmail(){return alternateEmail;}
  public String getPassword(){ return password;}

  public String showInfo(){
    return "DISPLAY NAME: " + firstName + " " + lastName +
      "\nCOMPANY EMAIL: " + email + 
      "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
  }
}