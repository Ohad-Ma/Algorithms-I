package dfs_bfs;
/*
Colors: 
    WHITE - Undiscovered Node
    GRAY = Discovered Node but unfinished
    Black = Finished

Time Complexity:
O(|V| + |E|) 
V number of vertices 
E number of Edges

Psuedo code:
BFS(G,s){
    for each vertex u in V[G] - {s}
        do color[u] <- white
            d[u] <- INF
            pai[u] <- NULL
    color[s] <- gray
    d[s] <- 0
    pai[s] <- NULL
    Q <- (|) (fi)
    enqueue(Q,s)
    while Q != (|) (fi)
        do u <- dequeue(Q)
            for each v in Adj[u]
                do if color[v] = white
                    then color[v] <- gray
                        d[v] <- d[u] + 1
                        pai[v] <- u
                        enqueue(Q,v)
            color[u] <- black
}

Solution:
Input: G = (V,E), directed or undirected
Output:
    for all v in V:
        d[v] = discovery time (v turns from WHITE to GRAY)
        f[v] = finishing time (v turns from GRAY to BLACK)
        Builds breadth-first tree with root s that contains all reachable vertices.
*/
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void bfs(Node start){
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> seen = new HashSet<>();

        q.add(start);

        while(!q.isEmpty()){
            Node current = q.poll();

            if(!seen.contains(current)){
                seen.add(current);
                System.out.println(current +" ");
            }

            for (Node adjacent : current.adjacents){
                if(!seen.contains(adjacent)) q.add(adjacent);
            }
        }

    }
    
}
