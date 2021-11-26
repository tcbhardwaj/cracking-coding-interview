package org.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {
    private int[][] adjacencyMatrix;
    private int numVertices;
    GraphType graphType;

    public AdjacencyMatrixGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        this.graphType = graphType;
        this.adjacencyMatrix = new int[numVertices][numVertices];
        for(int i = 0; i < numVertices; i++) {
            for(int j = 0; j < numVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        addEdge(v1, v2, 1);
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        if(v1 >= numVertices || v2 >= numVertices || v1 < 0 || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        if(graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v2][v1] = weight;
        }
        adjacencyMatrix[v1][v2] = weight;
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if(v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        List<Integer> adjacencyVerticesList = new ArrayList<>();
        for(int i = 0; i < numVertices; i++) {
            if(adjacencyMatrix[v][i] != 0) {
                adjacencyVerticesList.add(i);
            }
        }

        return  adjacencyVerticesList;
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public int getInDegree(int v) {
        if(v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        int indegree = 0;
        for(int i = 0; i < numVertices; i++) {
            if(adjacencyMatrix[i][v] != 0) {
                indegree++;
            }
        }

        return indegree;
    }

    @Override
    public int getOutDegree(int v) {
        if(v >= numVertices && numVertices < 0) {
            throw new IllegalArgumentException("Vertx number is not valid");
        }
        int outDegree = 0;
        for(int i = 0; i < numVertices; i++) {
            if(adjacencyMatrix[v][i] != 0) {
                outDegree++;
            }
        }

        return outDegree;
    }

    @Override
    public void displayGraph() {
        System.out.print("Adjacency Matrix \n");
        System.out.print("    ");
        for(int i = 0; i < numVertices; i++){
            System.out.print(i + " ");
        }

        System.out.println();
        for(int i = 0; i < numVertices; i++) {
            System.out.print(i + " | ");
            for(int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        for(int i = 0; i < numVertices; i++) {
            System.out.print("Edges from " + i + " to : ");
            for(int j = 0; j < numVertices; j++) {
                if(adjacencyMatrix[i][j] > 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new AdjacencyMatrixGraph(6, GraphType.UNDIRECTED);
        g.addEdge(1, 2, 5);
        g.addEdge(1, 3, 2);
        g.addEdge(2, 5, 2);
        g.addEdge(3, 4);

        g.displayGraph();
        System.out.println("Indegree of 1: "+g.getInDegree(1));
        System.out.println("Outdegree of 1: "+g.getOutDegree(1));
        System.out.println(g.getAdjacentVertices(1));
    }
}
