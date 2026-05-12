package aod.lab5.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A graph structure that stores vertices and undirected edges.
 *
 * @param <T> the type used as information/identifier for each vertex
 */
public final class Graph<T> implements GraphInterface<T> {

    private int nVertices;
    private int nEdges;

    private HashMap<T, Vertex<T>> vertices;
    private HashMap<T, ArrayList<Edge<T>>> edges;

    /**
     * Creates an empty graph.
     */
    public Graph() {
        this.nVertices = 0;
        this.nEdges = 0;
        this.vertices = new HashMap<>();
        this.edges = new HashMap<>();
    }

    @Override
    public List<Vertex<T>> getAllVertices() {
        return new ArrayList<>(vertices.values());
    }

    @Override
    public List<Edge<T>> getEdges(T info) {
        if (!edges.containsKey(info)) {
            return new ArrayList<>();
        }

        return new ArrayList<>(edges.get(info));
    }

    @Override
    public void addVertex(double x, double y, T info) {
        if (vertices.containsKey(info)) {
            return;
        }

        Vertex<T> vertex = new Vertex<>(x, y, info);
        vertices.put(info, vertex);
        edges.put(info, new ArrayList<>());

        nVertices++;
    }

    @Override
    public void addEdge(T infoA, T infoB) {
        if (!vertices.containsKey(infoA) || !vertices.containsKey(infoB)) {
            return;
        }

        if (infoA.equals(infoB)) {
            return;
        }

        if (hasEdge(infoA, infoB)) {
            return;
        }

        Vertex<T> vertexA = vertices.get(infoA);
        Vertex<T> vertexB = vertices.get(infoB);

        Edge<T> edgeAB = new Edge<>(vertexA, vertexB);
        Edge<T> edgeBA = new Edge<>(vertexB, vertexA);

        edges.get(infoA).add(edgeAB);
        edges.get(infoB).add(edgeBA);

        nEdges++;
    }

    /**
     * Checks if an edge already exists between two vertices.
     *
     * @param infoA the first vertex identifier
     * @param infoB the second vertex identifier
     * @return true if an edge exists, otherwise false
     */
    private boolean hasEdge(T infoA, T infoB) {
        ArrayList<Edge<T>> edgeList = edges.get(infoA);

        if (edgeList == null) {
            return false;
        }

        for (Edge<T> edge : edgeList) {
            if (edge.getTo().getInfo().equals(infoB)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void remove(T info) {
        if (!vertices.containsKey(info)) {
            return;
        }

        int removedEdges = edges.get(info).size();

        for (T key : edges.keySet()) {
            if (!key.equals(info)) {
                ArrayList<Edge<T>> edgeList = edges.get(key);

                for (int i = edgeList.size() - 1; i >= 0; i--) {
                    Edge<T> edge = edgeList.get(i);

                    if (edge.getTo().getInfo().equals(info)) {
                        edgeList.remove(i);
                    }
                }
            }
        }

        edges.remove(info);
        vertices.remove(info);

        nVertices--;
        nEdges -= removedEdges;
    }
    
    @Override
    public int numberOfEdges() {
        return nEdges;
    }

    @Override
    public int numberOfVertices() {
        return nVertices;
    }
}
