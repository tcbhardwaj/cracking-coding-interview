package org.practice.graph;

import java.util.List;

public interface Graph {
    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }
    void addEdge(int v1, int v2);
    void addEdge(int v1, int v2, int wright);
    List<Integer> getAdjacentVertices(int v);
    int getNumVertices();
    int getInDegree(int v);
    int getOutDegree(int v);
    void displayGraph();
}
