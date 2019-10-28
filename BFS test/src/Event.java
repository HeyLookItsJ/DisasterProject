import java.util.Random;

public class Event {
	static int c;
	static int f;
	static Random rand = new Random();
	
	//Event constructor 
	Event(){}
	//returns the target city's index
	public static int GetTarget() {
		 c=rand.nextInt(10);
		 return c;
	}
	//When called, returns a boolean value that will determine if there is a transit failure.
	public static boolean failCheck() {
		 f=rand.nextInt(10);
		 if (f==0)
		 return false;
		 else 
		return true;
	}
}
