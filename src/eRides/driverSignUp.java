package eRides;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class driverSignUp extends Driver {
	
	String pass2;
	
     void SignUp() throws IOException{
        Scanner in = new Scanner (System.in);
        System.out.println("Please enter details:\n");
        System.out.println("Username: ");
        Username = in.nextLine ();
        System.out.println("Email: ");
        email = in.nextLine ();
        System.out.println("Enter your phone number: ");
        phoneNo = in.nextLine ();    
        System.out.println("Password: ");
        passwd = in.nextLine ();
        System.out.println("Re-enter password: ");
        pass2=in.nextLine ();
        System.out.println("Enter Driver's License: ");
        dLicense = in.nextLine();
        System.out.println("Enter National ID: ");
        natId = in.nextLine();
        System.out.println("Enter Favorite Area 1: ");
        String favArea = in.nextLine();
        verified = "False";
        int suBalance = 0;
        curBalance = Integer.toString(suBalance);
        
        int i=0;
        while(i<=3) {
        if(passwd.equals(pass2)){
             System.out.println("Sign Up successful\n");
             
             try {
        FileWriter w1 = new FileWriter("database//drivers//" + Username +".txt", true);
        w1.write(email);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(passwd);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(Username);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(phoneNo);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(dLicense);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(natId);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(curBalance);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(verified);
        w1.write(System.getProperty( "line.separator" ));
        w1.close();
        FileWriter w2 = new FileWriter("database//drivers//" + "Drivers.txt", true);
        w2.write(Username);
        w2.write(System.getProperty( "line.separator" ));
        w2.close();
        FileWriter w3 = new FileWriter("database//drivers//" + Username + "_" + "fav" +".txt", true);
        w3.write(favArea);
        w3.close();
        FileWriter w4 = new FileWriter("database//drivers//" + Username + "_" + "notif" +".txt", true);
        w4.write("Your Notifications: ");
        w4.write(System.getProperty( "line.separator" ));
        w4.close();
        
        
        }
              catch (Exception ae) {
      System.out.println("An error occurred.");
      System.out.println(ae);
    }
        
        break;
        }
        else
        {
            System.out.println("Passwords do not match! please re-enter password:\n");
            System.out.println("Password:\n");
            passwd = in.nextLine ();
            System.out.println("Re-enter password:\n");
            pass2=in.nextLine ();
            i++;
            continue;
           
        }
        }

        
       
    
    }
     
     void displayDetails(String Username) throws IOException
 	{
 		int nameLine = 2;
 		int mailLine = 0;
 		int phoneLine = 3;
 		int passLine = 1;
 		int dLine = 4;
 		int natLine = 5;
 		int verLine = 7;
 		
 		String disName = Files.readAllLines(Paths.get("database//drivers//" + Username + ".txt")).get(nameLine);
 		String disMail = Files.readAllLines(Paths.get("database//drivers//" + Username + ".txt")).get(mailLine);
 		String disPhone = Files.readAllLines(Paths.get("database//drivers//" + Username + ".txt")).get(phoneLine);
 		String disLicense = Files.readAllLines(Paths.get("database//drivers//" + Username + ".txt")).get(dLine);
 		String disNat = Files.readAllLines(Paths.get("database//drivers//" + Username + ".txt")).get(natLine);
 		String disVer = Files.readAllLines(Paths.get("database//drivers//" + Username + ".txt")).get(verLine);
 		System.out.println("Name: " + disName);
 		System.out.println("E-Mail: " + disMail);
 		System.out.println("Phone Number: " + disPhone);
 		System.out.println("Driving License: " + disLicense);
 		System.out.println("National ID: " + disNat);
 		System.out.println("Verification Status: " + disVer);
 	}
    
}
