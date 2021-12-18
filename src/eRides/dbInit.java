package eRides;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class dbInit {
	void init() throws IOException
	{
		
		System.out.println("\nDatabase Initialization has been started, please stand by...");
		Path currentWorkingDir = Paths.get("").toAbsolutePath();
		Path Users = Paths.get(currentWorkingDir.normalize().toString() + "//database//users//");
		Path Drivers = Paths.get(currentWorkingDir.normalize().toString() + "//database//drivers//");
		Path Rides = Paths.get(currentWorkingDir.normalize().toString() + "//database//rides//");
		System.out.println("\nInitializing Users Database...");
		Files.createDirectories(Users);
		System.out.println("\nInitializing Drivers Database...");
		Files.createDirectories(Drivers);
		System.out.println("\nInitializing Rides Database...");
		Files.createDirectories(Rides);
		System.out.print("\nDatabase Initialization Complete. You may now freely use the software. \n");
	}

}
