
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Validation {

	public static double getPosDouble(Scanner scnr, String prompt) {
		System.out.println(prompt);
		double answer;
		do {
			while (!scnr.hasNextDouble()) {
				scnr.nextLine();
				System.out.println("This is not a valid number.");
				System.out.println(prompt);
			}
			answer = scnr.nextDouble();
			scnr.nextLine();
			if (answer < 0.0) {
				System.out.println("The number must be 0 or greater.");
			}
		} while (answer < 0.0);
		return answer;
	}

	public static int getPosInt(Scanner scnr, String prompt) {
		System.out.println(prompt);
		int answer;
		do {
			while (!scnr.hasNextInt()) {
				scnr.nextLine();
				System.out.println("This is not a valid number.");
				System.out.println(prompt);
			}
			answer = scnr.nextInt();
			scnr.nextLine();

			if (answer < 0) {
				System.out.println("The number must be 0 or greater.");
				System.out.println(prompt);
			}
		} while (answer < 0);
		return answer;
	}

	public static int getRangeInt(Scanner scnr, String prompt, int lowRange, int highRange, String rangeString) {
		System.out.println(prompt);
		int answer;
		do {
			while (!scnr.hasNextInt()) {
				scnr.nextLine();
				System.out.println("This is not a valid number.");
				System.out.println(prompt);
			}
			answer = scnr.nextInt();
			scnr.nextLine();
			if (answer < lowRange || answer > highRange) {
				System.out.println(rangeString);
				System.out.println(prompt);
			}
		} while (answer < lowRange || answer > highRange);
		return answer;
	}

	public static int getDynamicRangeInt(Scanner scnr, String prompt, int lowRange, ArrayList<Object> array,
			String rangeString) {
		System.out.println(prompt);
		int answer;
		do {
			while (!scnr.hasNextInt()) {
				scnr.nextLine();
				System.out.println("This is not a valid number.");
				System.out.println(prompt);
			}
			answer = scnr.nextInt();
			scnr.nextLine();
			if (answer < lowRange || answer > array.size()) {
				System.out.println(rangeString);
				System.out.println(prompt);
			}
		} while (answer < lowRange || answer > array.size());
		return answer;
	}

	public static int getDynamicRangeInt(Scanner scnr, String prompt, int lowRange, ArrayList<Object> array,
			int exception, String rangeString) {
		System.out.println(prompt);
		int answer;
		do {
			while (!scnr.hasNextInt()) {
				scnr.nextLine();
				System.out.println("This is not a valid number.");
				System.out.println(prompt);
			}
			answer = scnr.nextInt();
			scnr.nextLine();
			if (answer < lowRange || answer > array.size() && answer != exception) {
				System.out.println(rangeString);
				System.out.println(prompt);
			}
		} while (answer < lowRange || answer > array.size() && answer != exception);
		return answer;
	}

	public static String getString(Scanner scnr, String prompt) {
		System.out.println(prompt);
		String string = "";
		do {
			while (!scnr.hasNextLine()) {
				System.out.println("This is not a valid entry.");
				System.out.println(prompt);
			}
			string = scnr.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
		} while (string.equals(""));
		return string;
	}

	public static boolean getYNString(Scanner scnr, String prompt) {
		System.out.println(prompt);
		String tempString = "";
		String goodString = "";
		boolean answer = true;
		do {
			while (!scnr.hasNextLine()) {
				System.out.println("This is not a valid entry.");
				System.out.println(prompt);
			}
			tempString = scnr.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
			if (tempString.startsWith("y") || tempString.startsWith("n")){
				goodString = "Good";
			}
			if (tempString.startsWith("y")) {
				answer = true;
			} else if (tempString.startsWith("n")) {
				answer = false;
			} else {
				System.out.println("Sorry, I didn't understand.");
				System.out.println(prompt);
			}
		} while (tempString.equals(""));
		return answer;
	}

	public static String matchString(Scanner scnr, String prompt, String str1, String str2) {
		System.out.print(prompt);
		String tempString;
		String answer = "";
		do {
			while (!scnr.hasNextLine()) {
				System.out.println("This is not a valid entry.");
				System.out.println(prompt);
			}
			tempString = scnr.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
			if (tempString.equals(str1) || tempString.equals(str2)){
				answer = tempString;
			} else {
				System.out.print("Sorry, I didn't understand.");
			}
		} while (answer.equals(""));
		return answer;
	}
	
	public static String matchString(Scanner scnr, String prompt, Map<String, Double> items) {
		System.out.print(prompt);
		String tempString;
		String answer = "";
		do {
			while (!scnr.hasNextLine()) {
				System.out.println("This is not a valid entry.");
				System.out.println(prompt);
			}
			tempString = scnr.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
			if (items.containsKey(tempString)) {
				answer = tempString;
			} else {
				System.out.print("Sorry, we don't carry that item. Please try again: ");
			}
		} while (answer.equals(""));
		return answer;
	}

	public static String matchString(Scanner scnr, String prompt, String str1, String str2, String str3, String str4) {
		String tempString;
		String answer = "";
		do {
			System.out.print(prompt);
			while (!scnr.hasNextLine()) {
				System.out.println("This is not a valid entry.");
				System.out.println(prompt);
			}
			tempString = scnr.nextLine().toLowerCase().replaceAll("\\s+", " ").trim();
			if (tempString.equals(str1) || tempString.equals(str2) || tempString.equals(str3)
					|| tempString.equals(str4)) {
				answer = tempString;
			} else {
				System.out.print("Sorry, I didn't understand.\n");
			}
		} while (answer.equals(""));
		return answer;
	}

	public static String capitalize(String userString) {
		String newString = userString.substring(0, 1).toUpperCase() + userString.substring(1).toLowerCase();
		return newString;
	}

	public static String capitalizeFullName(String userString) {
		String newString = "";
		if (userString.indexOf(" ") != -1) {
			int spaceIndex = userString.indexOf(" ");
			newString = userString.substring(0, 1).toUpperCase() + userString.substring(1, spaceIndex).toLowerCase()
					+ (" ") + userString.substring(spaceIndex + 1, spaceIndex + 2).toUpperCase()
					+ userString.substring(spaceIndex + 2).toLowerCase();
		} else {
			newString = userString.substring(0, 1).toUpperCase() + userString.substring(1).toLowerCase();
			return newString;
		}
		return newString;
	}
}
