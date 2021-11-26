package org.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListGraph implements Graph {
    private List<Vertex> vertexList = new ArrayList<>();
    private int numVertices;
    private GraphType graphType = GraphType.DIRECTED;

    public AdjacencyListGraph(int numVertices, GraphType graphType) {
        this.numVertices = numVertices;
        this.graphType = graphType;
        for(int i = 0; i < numVertices; i++) {
            vertexList.add(new Vertex(i));
        }
    }

    @Override
    public void addEdge(int v1, int v2) {
        if(v1 < 0 || v1 >= numVertices || v2 < 0 || v2 >= numVertices) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v1 +", " + v2);
        }
        vertexList.get(v1).addEdge(v2);
        if(graphType == GraphType.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1);
        }

    }

    @Override
    public void addEdge(int v1, int v2, int wright) {

    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if(v < 0 || v >= numVertices) {
            throw new IllegalArgumentException("Vertex number is not vallid: " + v);
        }

        return vertexList.get(v).getAdjacencyList();
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public int getInDegree(int v) {
        if(v < 0 || v >= numVertices) {
            throw new IllegalArgumentException("Vertex number is not vallid: " + v);
        }
        int indegree = 0;
        for(Vertex vertex : vertexList) {
            if(vertex.getAdjacencyList().contains(v)) {
                indegree++;
            }
        }
        return indegree;
    }

    @Override
    public int getOutDegree(int v) {
        if(v < 0 || v >= numVertices) {
            throw new IllegalArgumentException("Vertex number is not vallid: " + v);
        }
        return vertexList.get(v).getAdjacencyList().size();
    }

    @Override
    public void displayGraph() {
        System.out.println("Adjacency List");
        for(Vertex vertex : vertexList) {
            System.out.println("Edges from " + vertex.getVertexNumber() +" to " + vertex.getAdjacencyList());
        }

    }

    public static void main(String[] args) {
        Graph g = new AdjacencyListGraph(6, GraphType.DIRECTED);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(3, 2);

        g.displayGraph();
        System.out.println("Indegree of 2: "+g.getInDegree(2));
        System.out.println("Outdegree of 1: "+g.getOutDegree(1));
        System.out.println(g.getAdjacentVertices(1));
    }
}
