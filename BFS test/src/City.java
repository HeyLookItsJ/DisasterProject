public class City {

	private String Name;
	private double Pop;
	private double OC;
	
	static City[] Cities = new City[10];
	
	City(String newname, double Pop) { 
		this.Name=newname;
		this.Pop=Pop;
		OC=Pop*.5;}
	//Returns the population of the city at index "ref"
	public static double getPop(int ref) {return Cities[ref].Pop;}
	
	//Returns the Overload capacity of the city at index "ref"
	public static double getOC(int ref) {return Cities[ref].OC;}
	
	//Returns the name and population of a city at inex "ref", as the other "hidden" stats are not usually relevant. 
	public static String cityToString(int ref) {return Cities[ref].Name + ", with a population of "+ Cities[ref].Pop;}
	
	//Returns the name of the city at index "ref"
	public static String CityName(int ref) {return Cities[ref].Name;}
	
	
}