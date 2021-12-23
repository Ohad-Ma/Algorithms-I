/*
How to find Strong connected components?
SCC(G):
    1) call DFS(G) to compute finishing times f[u] for all u 
    
    2) compute G^T (transposed graph)
    
    3) call DFS(G^T), but in the main loop, consider vertices in order
       of decreasing f[u] (as computed in first DFS)

    4) output the vertices in each tree of the depth-first forest
       formed in second DFS as sperate SCC

Running time: O(|V|+|E|) 

*/

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class SCC{
   /**
    * Basic directed graph inner class
    */
   class Graph{
      //#region variables
      private int vertices; // Amount of vertices
      private LinkedList<Integer> adjacent[]; // List of neighbours
      //#endregion

      //#region constructor
      Graph(int v){
         this.vertices = v;
         this.adjacent = new LinkedList[v];
         for(int i = 0; i < v; ++i){
            adjacent[i] = new LinkedList();
         }
      }
      //#endregion
      
      // Add edge to the graph
      void addEdge(int v, int w) { adjacent[v].add(w); }

      // Recursive DFS
      void DFS(int v, boolean visited[]){

         // Mark the current node as visited
         visited[v] = true;
         System.out.println(v + " ");

         int n; // Holds the next data 

         Iterator<Integer> i = adjacent[v].iterator();
         while(i.hasNext()){
            n = i.next();
            if (!visited[n]) DFS(n,visited);
         }
      }

      // Get a transposed graph
      Graph getTrasnapose(){
         Graph transposed = new Graph(this.vertices);
         for (int v = 0; v < this.vertices; v++){
            Iterator<Integer> i = adjacent[v].listIterator();
            while(i.hasNext()) transposed.adjacent[i.next()].add(v);
         }
         return transposed;
      }


      void fillOrder(int v, boolean visited[], Stack st){

         // Current node is visited
         visited[v] = true;

         Iterator<Integer> i = adjacent[v].iterator();
         while (i.hasNext()){
            int n = i.next();
            if(!visited[n]) fillOrder(n, visited, st);
         }

         // Get all reachable vertices from v and push v to st
         st.push(new Integer(v));
      }

      void getSCCs(){
         Stack st = new Stack();

         // All vertices set as "not visited"
         boolean visited[] = new boolean[this.vertices];
         for(int i = 0; i<this.vertices; i++) visited[i] = false;

         // Place vertices in stack according to their finding times - step 1 in algorithm
         for (int i = 0; i < this.vertices; i++){
            if(visited[i] == false) fillOrder(i, visited, st);
         }

         // Create transposed graph - step 2 in algorithm
         Graph transponsedGraph = getTrasnapose();
         
         
         // Turn all vertices as not visited
         for (int i = 0; i < this.vertices; i++) visited[i] = false;

         // Process all vertices in the stack (they're reversed)
         while(!st.empty()){

            // Pop a vertex from stack
            int vertex = (int)st.pop();

            // Print Strongly connected component of the popped vertex
            if (visited[vertex] == false){
               transponsedGraph.DFS(vertex, visited);
               System.out.println();
            }
         }
      }

   }
}