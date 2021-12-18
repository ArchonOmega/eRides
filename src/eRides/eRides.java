package eRides;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import eRides.*;

public class eRides {
    @SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
	driverSignUp ds = new driverSignUp();
	userSignUp us = new userSignUp();
	driverLogIn dl = new driverLogIn();
	userLogIn ul = new userLogIn();
	RideManager rm = new RideManager();
    int choice;
    Scanner chc = new Scanner(System.in);
    String userType = null;
    Ride GeneralRideEntity = new Ride();
    while(true)
    {
    	System.out.println("\nPlease enter what you want to do: \n");
    	System.out.println("0. DATABASE INITIALIZATION (!!!PLEASE SELECT THIS OPTION ON THE FIRST EXECUTION ON YOUR LOCAL MACHINE!!!) \n");
    	System.out.println("1. Sign Up \n");
    	System.out.println("2. Log in \n");
    	System.out.println("3. Log in as admin \n");
    	System.out.println("4. Exit \n");
    	System.out.println("Please input your choice by entering the corresponding number: ");
    	choice = chc.nextInt();
    	if(choice == 0)
    	{
    		Scanner initS = new Scanner(System.in);
    		int initChoice;
    		System.out.println("\nWARNING: This option is intended to be run ONLY ONCE on the first run on your local machine.");
    		System.out.println("\nThis option initializes the software's database on your local machine in order to run properly and without errors.");
    		System.out.println("\nThis option may cause unintended side effects if run more than once on the same local machine or while the database is already initialized.");
    		System.out.println("\nSide effects include but are not limited to partial or complete loss of user data, use at your own discretion.");
    		System.out.println("\nBegin initialization process (Y/N)? ");
    		System.out.println("\n1. Yes");
    		System.out.println("\n2. No");
    		initChoice = initS.nextInt();
    		if(initChoice == 1)
    		{
    			dbInit initMain = new dbInit();
    			initMain.init();
    			continue;
    		}
    		else if (initChoice == 2)
    		{
    			System.out.println("Returning to previous menu...");
    			continue;
    		}
    		
    	}
    	if(choice == 1)
    	{
    		Scanner suC = new Scanner(System.in);
    		int suChoice;
    		System.out.println("1. Sign Up as Driver\n");
        	System.out.println("2. Sign up as User \n");
        	suChoice = suC.nextInt();
        	if(suChoice == 1)
        	{
        		ds.SignUp();
        		continue;
        	}
        	else if(suChoice == 2)
        	{
        		us.SignUp();
        		continue;
        	}
    		
    	}
    	else if (choice == 2)
    	{
    		Scanner liC = new Scanner(System.in);
    		int suChoice;
    		System.out.println("1. Log In as Driver\n");
        	System.out.println("2. Log In as User \n");
        	suChoice = liC.nextInt();
        	if(suChoice == 1)
        	{
        		dl.LogIn();
        		userType = "Driver";
        		break;
        	}
        	else if(suChoice == 2)
        	{
        		ul.LogIn();
        		userType = "User";
        		break;
        	}
    	}
    	else if (choice == 3)
    	{
    		adminClass admin1 = new adminClass();
    		admin1.adminLogin();
    		userType = "Admin";
    		break;
    	}
    	else if (choice == 4)
    	{
    		System.out.println("Program has been terminated successfully.");
    		System.exit(0);
    	}
    	else
    	{
    		System.out.println("Invalid Input! Please re-enter your choice.");
    		continue;
    	}
    }
    int choice1;
    Scanner chc1 = new Scanner(System.in);
    System.out.println("\nWelcome to eRides System!");
    System.out.println("\nTo begin, please select a feature from the following:");
    while(true)
    {
    	if(userType.equals("Driver"))
    	{
    		Scanner dC = new Scanner(System.in);
    		int dChoice;
    		System.out.println("\n1. Add Favorite Destination");
    		System.out.println("\n2. Display Notifications");
    		System.out.println("\n3. Update Ride Offer");
    		dChoice = dC.nextInt();
    		if(dChoice == 1)
    		{
    			Scanner locScr = new Scanner(System.in);
    			String location;
    			System.out.println("Please enter the name of the location you would like to add to favorites: ");
    			location = locScr.nextLine();
    			String driverName = dl.getDrivername();
    			dl.addFavorite(location, driverName);
    		}
    		else if(dChoice == 2)
    		{
    			String dName = dl.getDrivername();
    			dl.displayNotifs(dName);
    		}
    	}
    	else if(userType.equals("User"))
    	{
    		Scanner uC = new Scanner(System.in);
    		int usrChoice;
    		System.out.println("\n1. Request Ride");
        	System.out.println("\n2. Update Ride Offer");
        	usrChoice = uC.nextInt();
        	if(usrChoice == 1)
        	{
        		String User = ul.getUsername();
        		String src;
        		String dest;
        		Scanner sdScr = new Scanner(System.in);
        		System.out.println("Please input Source Location: ");
        		src = sdScr.nextLine();
        		System.out.println("Please input Destination Location: ");
        		dest = sdScr.nextLine();
        		System.out.println("Requesting Ride from " + src + " to " + dest + ". Please Stand by...");
        		rm.makeRide().createRide(src, dest);
        		GeneralRideEntity.notifyDrivers(src, User);
        		
        	}
    	}
    	else if(userType.equals("Admin"))
    	{
    		Scanner aC = new Scanner(System.in);
    		int adminChoice;
    		String verReq;
    		String driver;
    		System.out.println("\n1. Verify Driver Credentials");
    		adminChoice = aC.nextInt();
    		if(adminChoice == 1)
    		{
    			System.out.println("Listing all unverified Drivers: ");
    			Scanner input = new Scanner(new File("database//drivers//" + "Drivers.txt"));
        		while (input.hasNextLine())
        		{
        			String temp = input.nextLine();
        			String ver = Files.readAllLines(Paths.get("database//drivers//" + temp + ".txt")).get(6);
        			if(ver.equals("False"))
        			{
        				System.out.println(temp);
        			}
        		}
        		Scanner aS = new Scanner(System.in);
        		System.out.println("Please select Driver to display info: ");
        		driver = aS.nextLine();
        		Path dPath = Paths.get("database//drivers//" + driver + ".txt");
        		ds.displayDetails(driver);
        		System.out.println("Do you wish to verify this Driver (Y/N)?");
        		verReq = aS.nextLine();
        		if(verReq.equals("Y"))
        		{
        			List<String> lines = Files.readAllLines(dPath, StandardCharsets.UTF_8);
        		    lines.set(6, "True");
        		    Files.write(dPath, lines, StandardCharsets.UTF_8);
        		    System.out.println("Driver has been verified successfully!");
        		}
        		
    		}
    	}
    }
}
}