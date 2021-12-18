package eRides;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class userSignUp extends User {
	
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
        int i=0;
        while(i<=3) {
        if(passwd.equals(pass2)){
             System.out.println("Sign Up successful\n");
             
             try {
        FileWriter w1 = new FileWriter("database//users//" + Username +".txt", true);
        w1.write(email);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(passwd);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(Username);
        w1.write(System.getProperty( "line.separator" ));
        w1.write(phoneNo);
        w1.write(System.getProperty( "line.separator" ));
        w1.close();
        FileWriter w2 = new FileWriter("database//users//" + "Users.txt", true);
        w2.write(Username);
        w2.write(System.getProperty( "line.separator" ));
        w2.close();
        Path usrRides = Paths.get("database//rides//" + Username);
        Files.createDirectories(usrRides);
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
    
}
