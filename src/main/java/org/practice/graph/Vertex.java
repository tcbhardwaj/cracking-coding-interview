package org.practice.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int vertexNumber;
    private List<Integer> adjacencyList = new ArrayList<>();

    public Vertex(int vertexNumber) {
        this.vertexNumber = vertexNumber;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void addEdge(int vertexNumber) {
        adjacencyList.add(vertexNumber);
    }

    public List<Integer> getAdjacencyList() {
        return adjacencyList;
    }
}
