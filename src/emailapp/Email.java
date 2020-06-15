package emailapp;

import java.util.Scanner ;

public class Email {
  private String firstname;
  private String lastname;
  private String password;
  private String department;
  private String email;
  private int mailboxCapacity = 800;
  private int defaultpasswordlength=8;
  private String AlternateEmail;
  private String CompanySuffix="acer.com";
 
//Constructor to receive first and last name
  
  public Email() {
	  String Firstname ;
	  String Lastname ;
	  Scanner in = new Scanner(System.in);
	  System.out.println(" Enter first name ");
	  Firstname = in.next();
	  System.out.println(" Enter last name ");	  
	  Lastname = in.next();
	  this.firstname = Firstname;
	  this.lastname = Lastname;
	 System.out.println("Email Created :"+this.firstname+" "+this.lastname);
	  
  //Call a method asking for the department - return the department
	  
	  this.department = SetDepartment();
	System.out.println("Department : "+this.department);
	  
  //Call a method that returns random password
	  
	  this.password = randomPassword(defaultpasswordlength);
	  System.out.println(" your Password is : "+this.password);
	int choice;
	  do
	{
	  System.out.println(" Do you want to change password: \n1.yes \n2.no ");
	   choice = in.nextInt();
	  if(choice==1) {
		  System.out.println(" Enter new Password  : ");
		  password = in.next();
		  System.out.println(" your final Password is : "+password);
	  }
	  else if(choice==2)
	  {
		  System.out.println(" your final Password is : "+this.password);
	  }
	  else 
	  {
		  System.out.println("INVALID INPUT!...Try again");        
	  }
	}
	while(choice>2 ||choice<1 );
	  
	
  //Combine elements to generate email
	  
	  email = firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+department+"."+CompanySuffix;
	// System.out.println("Your Email is : " +email);
	  
	  
  }
  
  //Ask for the department 
  
  private String SetDepartment() {
	  System.out.print("New worker :" + firstname+"\nDepartment codes : \n1 for sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code :");
	  Scanner in = new Scanner(System.in);
	 int depChoice = in.nextInt();
	 if(depChoice==1) {return "sales" ;}
	 else if(depChoice==2) {return "Devlopment" ;}
	 else if(depChoice==3) {return "Accounting" ;}
	 else { return ""; }
  }
  
  //Generate a random password
  
  private String randomPassword(int length) {
	  String passwordSet ="ABCDEFGHIJKLMOPQRSTUVWXYZ0123456789!@#$%";
	  char[] password = new char[length]; 
	  for(int i=0;i<length;i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i]= passwordSet.charAt(rand);	
	  }
	  return new String(password); 
  }
  
  //Set the MailBox Capacity
  public void setMailBoxCapacity(int capacity)  {
	  this.mailboxCapacity = capacity;
	  
  }
  
  // Set the AlternateEmail
  public void setAlternateEmail(String altemail) {
	  this.AlternateEmail = altemail;
  }
   
  //change the password
  public void changePassword(String password) {
	this.password = password ;
  }
  
  public int getMailboxCapacity() { return mailboxCapacity ;}
  public String getAlternateEmail() {return AlternateEmail ;}
  public String getpassword() {return password ;}
  public String ShowInfo() {
	 return "\n\tProfile :\n\t\t\tNAME :" +firstname+" "+lastname+
			 "\n\t\t\tCOMPANY EMAIL :" +email+
			 "\n\t\t\tMAIL BOX CAPACITY :" +mailboxCapacity+"mb";
  }
  
}
