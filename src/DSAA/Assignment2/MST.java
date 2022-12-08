package DSAA.Assignment2;

import java.util.Random;
import java.util.random.RandomGenerator;

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

        Random r = new Random();
        double rand = 0;

        for (int i = 0; i < g.numVertices(); i++) {
            for (int j = 0; j < g.numVertices(); j++) {
                rand =
                g.addEdge(i, j, );
            }
        }



        return MatrixGraph a;
    }

    static Graph getBaseTree(Graph g){

    }

    static Edge LongestEdgeOnPath(Graph g, int source, int destination){

    }

    static Graph getMST(Graph g){
        
    }

}
