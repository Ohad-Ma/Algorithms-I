/**
 * Build a data structure that stores disjoint sets, and supports the 
 * following operations:
 * • CREATE a new element as a singleton
 * • FIND the representative of the set that contains a given element (useful to determine whether two elements belong to the same set)
 * • MERGE 2 sets (“union”)
 * 
 * 
 * 
 */
// A union by rank and path compression
public class UnionFind {
    /**
     * Basic graph class
     */
    class Graph{
        int V,E;
        Edge[] edge;

        //#region constructor
        Graph(int V,int E){
            this.V = V;
            this.E = E;
            this.edge = new Edge[E];
            for(int i = 0 ; i < E; i++){
                edge[i] = new Edge();
            }
        }
        //#endregion
        //#region inner class for Edges
        class Edge{
            int src,dest;
        }
        //#endregion
        //#region basic Subset inner class
        class Subset{
            int parent,rank;
        }
        //#endregion
    
        /**
         * Find method
         * @return node's parent
         */
        int find(Subset[] subsets, int i){
            if(subsets[i].parent != i){
                subsets[i].parent = find(subsets, subsets[i].parent);
            }
            return subsets[i].parent;
        }

        /**
         * Union two disjoint sets using path compression
         * @param subsets
         * @param A
         * @param B
         */
        void Union(Subset[] subsets, int A, int B){
            int aRoot = find(subsets, A), bRoot = find(subsets, B);

            if(subsets[aRoot].rank < subsets[bRoot].rank) subsets[aRoot].parent = bRoot;
            else if(subsets[bRoot].rank < subsets[aRoot].rank) subsets[bRoot].parent = aRoot;
            else {
                subsets[aRoot].parent = bRoot;
                subsets[bRoot].rank++;
            }
        }
    
    }
    
}
