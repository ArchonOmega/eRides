package eRides;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Ahmed Medhat
 * Abdulrahman Ayman
 * Mariam ElShazly
 */
public class driverLogIn extends User {
    
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
        File file = new File("database//drivers//" + LUsername +".txt");
            if(!file.exists()){
                System.out.println("Invalid username! Please re-enter correct Username: ");
                LUsername=in2.nextLine ();
                continue;
            }
            else{
            	break;
            }
    	}
            int passLine = 1;
            try {
				LVpass = Files.readAllLines(Paths.get("database//drivers//" + LUsername +".txt")).get(passLine);
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
     public static String getDrivername()
     {
    	 return LUsername;
     }
     void addFavorite(String loc, String Username) throws IOException
     {
    	 FileWriter w = new FileWriter("database//drivers//" + Username + "_" + "fav" +".txt", true);
         w.write(loc);
         w.write(System.getProperty( "line.separator" ));
         w.close();
         System.out.println("Added " + loc + " to favorite pickup locations successfully.");
     }
     void displayNotifs(String driverName) throws FileNotFoundException
     {
    	 System.out.println("Your notifications: ");
		 Scanner input = new Scanner(new File("database//drivers//" + driverName + "_" + "notif" + ".txt"));
		 while (input.hasNextLine())
		 {
			 System.out.println(input.nextLine());
		 }
     }
    
}
