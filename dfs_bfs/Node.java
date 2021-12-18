package dfs_bfs;

import java.util.HashMap;
import java.util.HashSet;

public class Node {
    private int data;
    public HashSet<Node> adjacents;

    public Node(int data){
        this.adjacents = new HashSet<>();
        this.data = data;
    }

    public int getData(){ return this.data;}

    public void printAdjacents(){
        for (Node curr : this.adjacents)
            System.out.println(curr + " ");
    }

    public String toString(){
        return String.format("%d", this.data);
    }
    
}
