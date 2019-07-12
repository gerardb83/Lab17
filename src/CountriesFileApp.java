
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountriesFileApp {
	static Path path = Paths.get("countries.txt");
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		
		boolean keepGoing = true;
		int selection = 0;
		
		System.out.println("Welcome to the countries of the world list!");
		do {
		System.out.println("1. Add country\n2. Remove country\n3. Quit");
		selection = Validation.getRangeInt(scan, "Please make a selection (enter number): ", 1, 3, "Your choices are numbers 1 - 3");
		if (selection == 1) {
		addCountry();
		} else if (selection == 2) {
		removeCountry();
		}
	} while (selection != 3);		
		System.out.println("Goodbye!");
		
}

	public static void printList() {
		List<Country> countries = CountriesTextFile.readFile();
		for (Country c : countries) {
			System.out.println(c.toString());
		}
	}
	
	public static void addCountry() {
		String name = Validation.capitalizeFullName(Validation.getString(scan, "Enter a country to add: "));
		int population = Validation.getPosInt(scan, "Enter the population: ");
		Country newCountry = new Country(name, population);
		try {
		CountriesTextFile.appendToFile(newCountry);	
		} catch (IOException e) {
			System.out.println("Something went wrong.");
		}
		System.out.println("Country added!");
		}		
	

	
	public static void removeCountry() throws IOException {
		String name = Validation.capitalizeFullName(Validation.getString(scan, "Enter a country to remove: "));
		List<Country> oldLines = CountriesTextFile.readFile();
		while(oldLines.contains(name)) {
			int index = oldLines.indexOf(name);
			oldLines.get(index);
			
		}
		System.out.println(oldLines);
		
		
	}
}
