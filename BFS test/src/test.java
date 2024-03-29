import java.util.*; 
  

class Graph 
{ 
    private static int V;
    private static LinkedList<Integer> adj[]; 
     
    static ArrayList<Integer> listOrder = new ArrayList<Integer>();
    //Create the graph with a declared amount of vertices
    Graph(int v) 
    { 
    
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
   //Method returns the array generated by the BFS
    public static int getOrder(int index){
    	return listOrder.get(index);
    }
  // Add edge, then add the reverse direction edge. (A->B, B->A) 
    static void addEdge(int v,int w) 
    { 
        adj[v].add(w); 
        
       adj[w].add(v); 
       
    } 
  //Breadth First Search algorithm method that generates the map array. 
   static void BFS(int s) 
    { 
        // Mark all the vertices as not visited (Default state is false) 
   
        boolean visited[] = new boolean[V]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
      
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
       
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            listOrder.add(s);
           
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                }}}}}

   
	
  
