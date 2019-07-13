import java.text.DecimalFormat;

public class Country {

	protected String name;
	protected int population;

	public Country() {
	}

	public Country(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		if (population < 100000) {
			return name + " has a population of " + df1.format(population) + ".";
		} else if (population < 1000000) {
			return name + " has a population of " + df2.format(population) + ".";
		} else if (population < 10000000) {
			return name + " has a population of " + df3.format(population) + ".";
		} else if (population < 100000000) {
			return name + " has a population of " + df4.format(population) + ".";
		} else if (population < 1000000000) {
			return name + " has a population of " + df5.format(population) + ".";
		} else {
			return name + " has a population of " + df6.format(population) + ".";
		}
	}

	public static DecimalFormat df1 = new DecimalFormat("00,000");
	public static DecimalFormat df2 = new DecimalFormat("000,000");
	public static DecimalFormat df3 = new DecimalFormat("0,000,000");
	public static DecimalFormat df4 = new DecimalFormat("00,000,000");
	public static DecimalFormat df5 = new DecimalFormat("000,000,000");
	public static DecimalFormat df6 = new DecimalFormat("0,000,000,000");
}
