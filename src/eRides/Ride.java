package eRides;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;



public class Ride {
	String source;
	String destination;
	int rate;
	int fare;
	String driver = "N/A";
	String active = "False";
    String dUsername = driverLogIn.getDrivername();
    driverSignUp dView = new driverSignUp();
	void createRide(String src, String dest) throws IOException{
		userLogIn usrGet = new userLogIn();
	    String fUsername = usrGet.getUsername();
        Scanner in = new Scanner (System.in);
        //System.out.println("Please enter new ride details:\n");
        //System.out.println("Source location: ");
        source = src;
        //System.out.println("Destination Location: ");
        destination = dest;
        /*System.out.println("Rating: ");
        Rating = in.nextLine();*/
        /*String costString = cost.toString();*/
        rate = 0;
        fare = 0;
             
             try {
        FileWriter w2 = new FileWriter("database//rides//" + fUsername + "//" + source + " - " + destination + ".txt", true);
        w2.write(source);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(destination);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(rate);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(fare);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(driver);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(active);
        w2.close();
        FileWriter w3 = new FileWriter("database//rides//" + fUsername + "//" + "rides.txt", true);
        w3.write(source + " - ");
        w3.write(destination);
        w3.write(System.getProperty( "line.separator" ));
        w3.close();
        
        
        }
              catch (Exception ae) {
      System.out.println("An error occurred.");
      System.out.println(ae);
      ae.printStackTrace(System.out);
    }
             System.out.println("New Ride from " + source + " to " + dest + " created successfully.");


}
	void listRides() throws FileNotFoundException
	{
		userLogIn usrGet = new userLogIn();
	    String fUsername = usrGet.getUsername();
		String user = fUsername;
		System.out.println("Your rides history: ");
		Scanner input = new Scanner(new File("database//rides//" + user + "//" + "rides.txt"));
		 while (input.hasNextLine())
		 {
			 System.out.println(input.nextLine());
		 }
	}
	void displayDetails(String source, String dest) throws IOException
	{
		userLogIn usrGet = new userLogIn();
	    String fUsername = usrGet.getUsername();
		int sourceLine = 0;
		int destLine = 1;
		int rateLine = 2;
		int fareLine = 3;
		int driverLine = 4;
		String disSource = Files.readAllLines(Paths.get("database//rides//" + fUsername + "//" + source + " - " + dest + ".txt")).get(sourceLine);
		String disDest = Files.readAllLines(Paths.get("database//rides//" + fUsername + "//" + source + " - " + dest + ".txt")).get(destLine);
		String disRate = Files.readAllLines(Paths.get("database//rides//" + fUsername + "//" + source + " - " + dest + ".txt")).get(rateLine);
		String disFare = Files.readAllLines(Paths.get("database//rides//" + fUsername + "//" + source + " - " + dest + ".txt")).get(fareLine);
		String disDriver = Files.readAllLines(Paths.get("database//rides//" + fUsername + "//" + source + " - " + dest + ".txt")).get(driverLine);
		System.out.println("Source: " + disSource);
		System.out.println("Destination: " + disDest);
		System.out.println("Rating: " + disRate);
		System.out.println("Fare: " + disFare);
		System.out.println("Driver: " + disDriver);
	}
	void notifyDrivers(String sourceDes, String Client) throws IOException
	{
		ArrayList<String> drFavs = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("database//drivers//" + "Drivers.txt"));

		for (String line = br.readLine(); line != null; line = br.readLine()) {
			BufferedReader br2 = new BufferedReader(new FileReader("database//drivers//" + line + "_" + "fav" +".txt"));

			for (String line2 = br2.readLine(); line2 != null; line2 = br2.readLine()) {
				if(line2.equals(sourceDes))
				{
					FileWriter wR = new FileWriter("database//drivers//" + line + "_" + "notif" +".txt", true);
					wR.write("Ride has been requested from favorite area " + sourceDes + " by User " + Client);
					wR.write(System.getProperty( "line.separator" ));
					wR.close();
				}
			}
			
			
		}
	}
	void Offer(String client, String source, String dest, String driver) throws IOException
	{
		Scanner da = new Scanner(System.in);
		int initFare;
		//Path ride = Paths.get("database//rides//" + client + "//" + source + " - " + dest + "_offers" + ".txt");
	    System.out.println("Please enter fare offer: ");
	    initFare = da.nextInt();
	    String initF = Integer.toString(initFare);
	    FileWriter w = new FileWriter("database//rides//" + client + "//" + source + " - " + dest + "_offers" + ".txt", true);
	    w.write(driver);
	    w.write(System.getProperty( "line.separator" ));
	    w.write(initF);
	    w.write(System.getProperty( "line.separator" ));
	    w.close();
	    System.out.println("An offer of " + initF + " has been made to Rider " + client + " on the ride from " + source + " to " + dest + " successfully."); 
		/*List<String> lines = Files.readAllLines(ride, StandardCharsets.UTF_8);
	    lines.set(4, driver);
	    lines.set(3, initF);
	    Files.write(ride, lines, StandardCharsets.UTF_8);*/
	}
	void selectOffer(String source, String dest) throws IOException
	{
		userLogIn usrGet = new userLogIn();
	    String fUsername = usrGet.getUsername();
		String User = fUsername;
		Path ride = Paths.get("database//rides//" + User + "//" + source + " - " + dest + ".txt");
		System.out.println("Offers for the selected ride: ");
		Scanner view = new Scanner (System.in);
		Scanner slct = new Scanner (System.in);
		Scanner input = new Scanner(new File("database//rides//" + User + "//" + source + " - " + dest + "_offers" + ".txt"));
		 while (input.hasNextLine())
		 {
			 System.out.println(input.nextLine());
		 }
		 while(true)
		 {
		 System.out.println("Please enter driver name to view details, or enter 'Continue' to end viewing and select a driver: ");
		 String driverView = view.nextLine();
		 if(driverView.equals("Continue"))
		 {
			 System.out.println("Continuing...");
			 break;
		 }
		 else {
		 dView.displayDetails(driverView);
		 }
		 }
		 System.out.println("Please select driver by entering driver name: ");
		 String dSlct = slct.nextLine();
		 
		 File file = new File("database//rides//" + User + "//" + source + " - " + dest + "_offers" + ".txt");
		 LineNumberReader rdr = new LineNumberReader(new FileReader(file));
		 String line = rdr.readLine();
		        if (line.indexOf(dSlct) >=0 ) {
		            String fareSlct = Files.readAllLines(Paths.get("database//rides//" + User + "//" + source + " - " + dest + "_offers" + ".txt")).get((rdr.getLineNumber()));
		            List<String> lines = Files.readAllLines(ride, StandardCharsets.UTF_8);
				    lines.set(4, dSlct);
				    lines.set(3, fareSlct);
				    Files.write(ride, lines, StandardCharsets.UTF_8);
				    System.out.println("Driver " + dSlct + " with fare " + fareSlct + " has been selected for this ride.");
		        }
	}
	void userAccept(String source, String dest) throws IOException
	{
		userLogIn usrGet = new userLogIn();
	    String fUsername = usrGet.getUsername();
		String user = fUsername;
		String Driver = Files.readAllLines(Paths.get("database//rides//" + user + "//" + source + " - " + dest +".txt")).get(4);
		String Cost = Files.readAllLines(Paths.get("database//rides//" + user + "//" + source + " - " + dest +".txt")).get(3);
		String balance = Files.readAllLines(Paths.get("database//drivers//" + Driver +".txt")).get(6);
		int balanceInt = Integer.parseInt(balance);
		int costInt = Integer.parseInt(Cost);
		int newBalance = balanceInt + costInt;
		String newBalanceStr = Integer.toString(newBalance);
		System.out.println("Price accepeted, starting trip...");
		Path ride = Paths.get("database//rides//" + user + "//" + source + " - " + dest + ".txt");
		List<String> lines = Files.readAllLines(ride, StandardCharsets.UTF_8);
		lines.set(5, "True");
		Files.write(ride, lines, StandardCharsets.UTF_8);
		Path driver = Paths.get("database//drivers//" + Driver + ".txt");
		List<String> linesD = Files.readAllLines(driver, StandardCharsets.UTF_8);
		linesD.set(6, newBalanceStr);
		Files.write(driver, linesD, StandardCharsets.UTF_8);
		
	}
	void listUnrated() throws IOException
	{
		userLogIn usrGet = new userLogIn();
	    String fUsername = usrGet.getUsername();
		String user = fUsername;
		System.out.println("Your currently unrated rides: ");
		String ride;
		String rStatus;
		Scanner input = new Scanner(new File("database//rides//" + user + "//" + "rides.txt"));
		 while (input.hasNextLine())
		 {
			 ride = input.nextLine();
			 rStatus = Files.readAllLines(Paths.get("database//rides//" + user + "//" + ride +".txt")).get(2);
			 if(rStatus.equals("0"))
			 {
				 System.out.println(ride);
			 }
		 }
	}
	void rate(String source, String dest) throws IOException
	{
		userLogIn usrGet = new userLogIn();
	    String fUsername = usrGet.getUsername();
		int rating;
		Scanner rateScr = new Scanner(System.in);
		System.out.println("Please input rating: ");
		rating = rateScr.nextInt();
		String rateStr = Integer.toString(rating);
		String user = fUsername;
		Path ride = Paths.get("database//rides//" + user + "//" + source + " - " + dest + ".txt");
		List<String> lines = Files.readAllLines(ride, StandardCharsets.UTF_8);
		lines.set(2, rateStr);
		Files.write(ride, lines, StandardCharsets.UTF_8);
		System.out.println("Ride from " + source + " to " + dest + " has been rated " + rateStr + " successfully.");
	}
}
