package eRides;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.lang.*;



public class Ride {
	String source;
	String destination;
	int rate;
	int fare;
    String fUsername = userLogIn.getUsername();
    
	void createRide(String src, String dest) throws IOException{
        Scanner in = new Scanner (System.in);
        //System.out.println("Please enter new ride details:\n");
        //System.out.println("Source location: ");
        source = src;
        //System.out.println("Destination Location: ");
        destination = dest;
        /*System.out.println("Rating: ");
        Rating = in.nextLine();*/
        /*String costString = cost.toString();*/
             
             try {
        FileWriter w2 = new FileWriter("database//rides//" + fUsername + "//" + source + " - " + destination + ".txt", true);
        w2.write(source);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(destination);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(rate);
        w2.write(System.getProperty( "line.separator" ));
        w2.write(fare);
        w2.close();
        
        }
              catch (Exception ae) {
      System.out.println("An error occurred.");
      System.out.println(ae);
    }
             System.out.println("New Ride from " + source + " to " + dest + " created successfully.");


}
	void displayDetails(String source, String dest) throws IOException
	{
		int sourceLine = 0;
		int destLine = 1;
		int rateLine = 2;
		int fareLine = 3;
		String disSource = Files.readAllLines(Paths.get("database//rides//" + fUsername + "//" + source + " - " + dest + ".txt")).get(sourceLine);
		String disDest = Files.readAllLines(Paths.get("database//rides//" + fUsername + "//" + source + " - " + dest + ".txt")).get(destLine);
		String disRate = Files.readAllLines(Paths.get("database//rides//" + fUsername + "//" + source + " - " + dest + ".txt")).get(rateLine);
		String disFare = Files.readAllLines(Paths.get("database//rides//" + fUsername + "//" + source + " - " + dest + ".txt")).get(fareLine);
		System.out.println("Name: " + disSource);
		System.out.println("Nationality: " + disDest);
		System.out.println("Position: " + disRate);
		System.out.println("Club: " + disFare);
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
}
