package eRides;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class adminClass extends User {

	public void adminLogin()
	{
		String adminPass;
		Scanner adminScn = new Scanner(System.in);
		int i = 3;
		boolean isSuccessful2 = false;
		while(i>0)
		{
		System.out.println("Please enter the administrator password: ");
		adminPass = adminScn.nextLine();
		if(adminPass.equals("admin123"))
		{
			System.out.println("\nLogin to admin account successful.");
			System.out.println("\nWelcome, administrator!");
			isSuccessful2 = true;
			break;
		}
		else
		{
			System.out.println("\nPassword Incorrect! Login to admin account failed!");
			System.out.println("You have " + i + " login attempts remaining.");
			i--;
			continue;
		}
		}
		if(!isSuccessful2)
		{
			System.out.println("\nLogin to admin account failed, please try again later.");
		}
	}
}