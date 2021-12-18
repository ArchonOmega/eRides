package eRides;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class userLogIn extends User {
    
    static String LUsername;
    String Lpass;
   // String LVemail;
    String LVpass;

    
     void LogIn() throws FileNotFoundException {
    	Scanner in2 = new Scanner(System.in);
    	System.out.println("Please enter your login credentials now (Username and Password): ");
    	System.out.println("Username: ");
    	LUsername = in2.nextLine();
    	int i=3;
    	boolean isSuccessful = false;
    	while(true) {
    	//File file = new File("D://Eclipse//database//users//" + Lemail +".txt");
        File file = new File("database//users//" + LUsername +".txt");
            if(!file.exists()){
                System.out.println("Invalid Username! Please re-enter correct Username: ");
                LUsername=in2.nextLine ();
                continue;
            }
            else{
            	break;
            }
    	}
            int passLine = 1;
            try {
				LVpass = Files.readAllLines(Paths.get("database//users//" + LUsername +".txt")).get(passLine);
                       //LVpass = Files.readAllLines(Paths.get("D:\\Downloads\\FBleuge4\\FBLeague\\database\\users\\" + Lemail +".txt")).get(passLine);

			} catch (IOException e) {
				e.printStackTrace();
			}
            System.out.println("Password: ");
            Lpass=in2.nextLine();
            while(i>0)
            {
            	if(!Lpass.equals(LVpass))
            	{
            		System.out.println("Incorrect Login Password. " + i + " attempts remaining");
            		System.out.println("Please Re-enter password: ");
            		Lpass=in2.nextLine();
            		i--;
            		continue;
            	}
            	else
            	{
            		System.out.println("Login Successful.");
            		isSuccessful = true;
            		break;
            	}            	
            }
            if(!isSuccessful)
            System.out.println("Login Failed (Maximum attempts reached). Please try again later.");            
            {
            }
            }
     public static String getUsername()
     {
    	 return LUsername;
     }
    
}