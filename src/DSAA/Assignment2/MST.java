package DSAA.Assignment2;

import java.util.*;

public class MST {

    public static void main(String[] args) {
        getTotalEdgeWeight(GraphOfEssex.getGraph());

   }

   //Assumes graph is undirected
    static double getTotalEdgeWeight (Graph g){
        double totalSoFar = 0.0d;

        for (int i = 0; i < (g.numVertices() -1); i++) {
            for (int j = i+1; j < g.numVertices(); j++) {
                totalSoFar += g.weight(i, j);
            }
        }

        return totalSoFar;
    }

    static Graph getRandomGraph (int n){

        Graph g = new MatrixGraph(n, Graph.UNDIRECTED_GRAPH);

        double[][] coord = new double[n][2];

        coord[0][0] = Math.random();
        coord[0][1] = Math.random();

        double weight;

        for (int i = 0; i < n; i++){
            coord[i+1][0] = Math.random();
            coord[i+1][1] = Math.random();
            //skip the case where we have (i == j)
            for (int j = i + 1; j < n; j++){

                weight = Math.sqrt(
                        Math.pow((coord[i][0] - coord[j][0]), 2)
                                +
                                Math.pow((coord[i][1] - coord[j][1]), 2)
                );
                g.addEdge(i, j, weight);
            }
        }
        return g;
    }

    static Graph getBaseTree(Graph g){
        //generating template for base tree
        MatrixGraph mg = new MatrixGraph(g.numVertices(), Graph.UNDIRECTED_GRAPH);

        //breadth-first search

        //Utility vars for BFS
        ArrayDeque<Integer> queue = new ArrayDeque();
        HashMap<Double, Boolean> hm = new HashMap<>();
        int cur;

        queue.add(0);
        hm.put(0.0, true);
        while (!queue.isEmpty()){
            cur = queue.remove();
            for (var i : g.neighbours(cur)) {
                if (!hm.get( (double) i) ){
                    hm.putIfAbsent( (double) i, true);
                    queue.add(i);
                    mg.addEdge(cur, i, g.weight(cur, i));
                }
            }
        }
        return mg;
    }

    static Edge LongestEdgeOnPath(Graph g, int source, int destination){

        HashMap<> hm = new HashMap();

        for (int i = 0; i < g.numVertices(); i++) {
            g.nei
        }

    }

    static Graph getMST(Graph g){
        
    }

}
