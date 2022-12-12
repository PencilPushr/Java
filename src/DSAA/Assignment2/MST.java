package DSAA.Assignment2;

import java.lang.reflect.Array;
import java.util.*;

public class MST {

    public static void main(String[] args) {
        //      ----    6A  ----
        System.out.println("total edge weight of GoE = "
                + getTotalEdgeWeight(GraphOfEssex.getGraph()));

        //      ----    6B  ----
        /*
         * It gives the answer 112, I have worked on the MST for a whole 2/3 days
         * I do not know why it's always 112, I have changed it so many times I give up.
         * To Dr. Richerby, I know this is incorrect, but I don't know why it is incorrect.
         *
         */

        System.out.println("Total mst edge weight of GoE = "
                + getTotalEdgeWeight(getMST(GraphOfEssex.getGraph()))
                );

        //      ----    6C  ----
        double averageWeight= 0.0d;
        double averageMSTWeight = 0.0d;

        for (int i = 0; i < 100; i++) {
            Graph g = getRandomGraph(50);

            averageWeight += getTotalEdgeWeight(g);
            averageMSTWeight += getTotalEdgeWeight(getMST(g));
        }

        averageWeight = averageWeight / 100;
        averageMSTWeight = averageMSTWeight / 100;

        /*
         * This gives me the right averageMSTWeight tho lol:
         * averageMSTWeight = averageMSTWeight / 10000;
         */

        System.out.println(averageWeight);
        System.out.println(averageMSTWeight);



   }

   //Assumes graph is undirected
    static double getTotalEdgeWeight (Graph g){
        double totalSoFar = 0.0d;
        //REMEMBER: edges are bidirectional, don't count twice!
        //No vertex links to itself!
        //We can ignore the last vertex, we've already checked every link to it
        for(int i = 0; i < (g.numVertices() -1); i++){
            for (int j = i+1; j < g.numVertices(); j++){
                if (g.isEdge(i, j))
                    totalSoFar = totalSoFar + g.weight(i, j);
            }
        }
        return totalSoFar;
    }

    //generates an undirected graph with n number of vertices.
    static Graph getRandomGraph (int n){

        Graph g = new MatrixGraph(n, Graph.UNDIRECTED_GRAPH);

        //coordinates to generate
        double[][] coord = new double[n][2];

        //initial assignment - faster than looping through and making the 2d space.
        //Which is what I did initially
        coord[0][0] = Math.random();
        coord[0][1] = Math.random();

        //the weight that we generate for each edge based on the distance between the nodes
        double weight;

        for (int i = 0; i < n; i++){

            //i+1 -> skip the case where we have (i == j)
            for (int j = i + 1; j < n; j++){

                //generate the next pair of coordinates to calculate distance
                coord[j][0] = Math.random();
                coord[j][1] = Math.random();

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

    //Generates a spanning tree using BFS
    static Graph getBaseTree(Graph g){
        //generating template for base tree
        MatrixGraph mg = new MatrixGraph(g.numVertices(), Graph.UNDIRECTED_GRAPH);

        //      ------  breadth-first search ------

        //Utility vars for BFS

        //queue will act as our iterator
        ArrayDeque<Integer> queue = new ArrayDeque();
        HashSet<Integer> visited = new HashSet<>();

        //current vertex we are on
        int cur;

        //BFS
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty()){
            cur = queue.remove();

            //for all the neighbouring vertices that are linked to our current
            for (var v : g.neighbours(cur)) {
                //if the hashset does not have the node we have visited yet
                if (!visited.contains(v)){

                    //add it to our set
                    visited.add(v);

                    //next loop we will go through the neighbouring V's
                    queue.add(v);

                    //if we have a valid edge, add it to our tree
                    mg.addEdge(cur, v, g.weight(cur, v));
                }
            }
        }
        return mg;
    }

    // To Dr. Richerby, THIS IS WRONG BUT I DON'T KNOW WHY, EVERYTHING ELSE WORKS PERFECTLY FINE

    // iterates through a graph using BFS to get from the source node to the destination node.
    // keeps a track of the previously encountered nodes using a hashmap.
    static Edge LongestEdgeOnPath(Graph g, int source, int destination){

        double longestEdgeSoFar = 0.0d;

        if (source == destination) return null;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();

        //keep track for each vertex record the vertex we came from when we first visited the node
        HashMap<Integer, Integer> xypair = new HashMap<>();

        int cur;

        q.add(source);
        visited.add(source);

        while(!q.isEmpty()){
            cur = q.remove();
            for (var i : g.neighbours(cur)) {
                if (!visited.contains(i)){
                    visited.add(i);
                    q.add(i);

                    //track the node we came from and went to putting it in the hashmap
                    xypair.put(cur, i);

                    //this is dumb there has to be a better way to do this.
                    if (i == destination) {
                        Edge e = new Edge(source, i, g.weight(source, i));
                        for (var v : xypair.entrySet()) {
                            longestEdgeSoFar = g.weight(v.getKey(), v.getKey()+1);
                            if (longestEdgeSoFar > e.w){
                                e.x = v.getKey();
                                e.y = v.getKey()+1;
                                e.w = longestEdgeSoFar;
                            }
                        }
                        return e;
                    }
                }
            }
        }

        //we fucked up if we got to this point
        return null;

    }

    //Finds minimum spanning tree of g
    static Graph getMST(Graph g){

        //first generate the base tree
        Graph MSTgraph = getBaseTree(g);
        //the longest edge to be calculated
        Edge lEdge;

        for (int i = 0; i < g.numVertices(); i++) {
            for (int j = i+1; j < g.numVertices(); j++) {
                //if the MSTgraph weight is not a number -> calculate it
                if (Double.isNaN(MSTgraph.weight(i, j))) {
                    //generate the longest edge
                    lEdge = LongestEdgeOnPath(MSTgraph, i, j);
                    assert lEdge != null;
                    if (g.weight(i, j) < lEdge.w){
                        MSTgraph.deleteEdge(lEdge.x, lEdge.y);
                        MSTgraph.addEdge(i, j, g.weight(i, j));
                    }
                }
            }
        }

        //return generated MST
        return MSTgraph;
    }

}
