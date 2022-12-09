package DSAA.Assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MST {

    public static void main(String[] args) {


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

        double weight;

        for (int i = 0; i < n; i++){
            coord[i][0] = Math.random();
            coord[i][1] = Math.random();
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
        //use breadth-first search



    }

    static Edge LongestEdgeOnPath(Graph g, int source, int destination){

    }

    static Graph getMST(Graph g){
        
    }

}
