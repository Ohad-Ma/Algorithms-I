package dfs_bfs;

import java.util.HashSet;
import java.util.Stack;

/*
Colors: 
    WHITE - Undiscovered Node
    GRAY = Discovered Node but unfinished
    Black = Finished

Time Complexity:
O(|v| + |E|) 
V number of vertices 
E number of Edges

Psuedo code:

    DFS-Visit(u){
        color[u] <- GRAY
        time <- time + 1
        d[u] <- time
        for each v in Adj[u]
            do if color[v] = WHITE
                    then pai[v] <- u
                            DFS-Visit(v)
        color[u] <- BLACK
        f[u] <- time <- time+1
    }

    DFS-Coat(u){
        for each vertex u in V[G]
            do color[u] <- WHITE
                pai[u] <- NULL
        time <- 0
        for each vertex u in V[G]
            do if color[u] = WHITE
                    then DFS-Visit(u)
    }

Solution:
Input: G = (V,E), directed or undirected
Output:
    for all v in V:
        d[v] = discovery time (v turns from WHITE to GRAY)
        f[v] = finishing time (v turns from GRAY to BLACK)
    pai[v] : predecessor of v = u, such that v was discovered during the scan of u's adjaceny list.
    
*/
class DFS{
    public static void depthFirstSearch(Node start){
        Stack<Node> st = new Stack<>();
        HashSet<Node> seen = new HashSet<>();

        // add start to the search
        st.push(start);

        while(!st.isEmpty()){
            // pull a node
            Node current = st.pop();

            if(!seen.contains(current)){
                // current haven't been visited
                seen.add(current);
                System.out.println("current: " + current);
            }

            for(Node adjacent : current.adjacents){
                if(!seen.contains(adjacent)) st.push(adjacent);
            }
        }


    }
}