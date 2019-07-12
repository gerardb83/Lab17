
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountriesTextFile {
	
	private static FileLinesHelper linesHelper = new FileLinesHelper("countries.txt");
	
	private static Country convertLineToItem(String line) {
		String[] parts = line.split("\t");
		Country country = new Country();
		country.setName(parts[0]);
		country.setPopulation(Integer.parseInt(parts[1]));
		return country;
	}
	
	private static String convertItemToLine(Country country) {
		return String.format("%s\t%d", country.getName(), country.getPopulation());
	}

	public static List<Country> readFile() {
		List<String> lines = linesHelper.readFile();
		List<Country> items = new ArrayList<>(lines.size());
		for (String line : lines) {
			items.add(convertLineToItem(line));
		}
		return items;
	}
	
	public static void rewriteFile(List<Country> items) throws IOException {
		List<String> lines = new ArrayList<>(items.size());
		for (Country item : items) {
			lines.add(convertItemToLine(item));
		}
		linesHelper.rewriteFile(lines);
	}
	
	public static void appendToFile(Country item) throws IOException {
		String line = convertItemToLine(item);
		linesHelper.appendToFile(line);
	}
}