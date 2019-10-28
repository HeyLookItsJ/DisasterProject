import java.util.ArrayList;
import java.util.Arrays;

public class Active {
	  
    public static void main(String args[]) 
    { 
    	
    	int tc=Event.GetTarget();
    	double tcpop = 1;
    	int i=1;
       
    	//Creation of the city objects held in the "Cities" array
    	ArrayList<String> ImpactedCities = new ArrayList<String>(); 
    	try {
    	City.Cities[0]= new City("Miami", 500);
		City.Cities[1]= new City("Tampa", 240);
		City.Cities[2]= new City("Orlando", 150);
		City.Cities[3]= new City("Jacksonville", 160);
		City.Cities[4]= new City("Sarasota", 640);
		City.Cities[5]= new City("Fort Myers", 530);
		City.Cities[6]= new City("Palm Bay", 450);
		City.Cities[7]= new City("Port Saint Lucie", 380);
		City.Cities[8]= new City("Daytona", 350);
		City.Cities[9]= new City("Pensacola", 340);
		
     int s=2;
     //Creation of the graph "f"
       Graph f = new Graph(10);  
		Graph.addEdge( 0, 7); 
		Graph.addEdge( 2, 1);
		Graph.addEdge( 3, 1);
		Graph.addEdge( 4, 1);
		Graph.addEdge( 5, 4); 
		Graph.addEdge( 5, 0); 	
		Graph.addEdge( 6, 7); 
		Graph.addEdge( 6, 8);  
		Graph.addEdge( 7, 5); 
		Graph.addEdge( 8, 2);
		Graph.addEdge( 8, 3); 
		Graph.addEdge( 9, 1); 
		Graph.addEdge( 9, 3);
		
		//declares the target city. Calling the target city this way prevents a re-selection of the city
        System.out.println("The target city is " + City.cityToString(tc)); 
        
       
        
        //Passes the index of TC to the BFS algorithm
        Graph.BFS(tc);
        //Assigns the value of TCs population to tcpop
        tcpop=City.getPop(tc);
        
        //This do-while loop is what moves populations, records impacted cities and executes fail checks
        do {
        //Makes a call to the failCheck() method, which has a 1 in 10 chance to fail. 
        //In the even of failure, the message is printed and the index tracker (i) is iterated, bypassing the node. 
     
             if (Event.failCheck()== false){
        System.out.println("There was a transit failure between "+ City.CityName(tc)+" and "+ City.CityName((Graph.getOrder(i))));
       i++;}
        //The "true" counterpart of the previous case. Assuming a success, tcpop is reduced by the overload capacity 
        //of the city at the "i"th index in the getOrder() array and the name of the city at index "i"th is added        
        // to the impactedCities array and i is iterated. 
        else if (Event.failCheck()== true) {
        tcpop=tcpop-City.getOC(Graph.getOrder(i));
        ImpactedCities.add(City.CityName((Graph.getOrder(i))));
        i++;}
        
        
        
        } while (tcpop>0 );
        //this loop iterates as long as tcpop is above zero.
        }catch(IndexOutOfBoundsException e){
        System.out.println("All nodes in the network exhausted. Remaining population: " +tcpop);}
    	//in the even that all the nodes in the getOrder() array are utilized, an exception is caught and the 
    	//program prints the remaining population in tc and then finishes the program 
    	{   
    	//Prints the size of ImpactedCities, a way to determine how many moves were made 
        System.out.println("Number of moves: "+ ImpactedCities.size());
        //Prints the actual list of cities impacted 
        System.out.println("Cities impacted: "+Arrays.toString(ImpactedCities.toArray()));
       
    } 
} }
