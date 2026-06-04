package aod.lab5.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * En grafstruktur som lagrar noder och oriktade kanter.
 *
 * @param <T> typen som används som information för varje nod
 */
public final class Graph<T> implements GraphInterface<T> {

    /**
     * Antal noder i grafen.
     */
    private int nVertices;

    /**
     * Antal oriktade kanter i grafen.
     */
    private int nEdges;

    /**
     * Alla noder lagrade efter deras informationsvärde.
     */
    private final HashMap<T, Vertex<T>> vertices;

    /**
     * Grannlistor för alla noder.
     */
    private final HashMap<T, ArrayList<Edge<T>>> edges;

    /**
     * Skapar en tom graf.
     */
    public Graph() {
        nVertices = 0;
        nEdges = 0;
        vertices = new HashMap<>();
        edges = new HashMap<>();
    }

    @Override
    public List<Vertex<T>> getAllVertices() {
        return new ArrayList<>(vertices.values());
    }

    @Override
    public List<Edge<T>> getEdges(final T info) {
        if (!edges.containsKey(info)) {
            return new ArrayList<>();
        }

        return new ArrayList<>(edges.get(info));
    }

    @Override
    public void addVertex(final double x, final double y, final T info) {
        if (vertices.containsKey(info)) {
            return;
        }

        final Vertex<T> vertex = new Vertex<>(x, y, info);
        vertices.put(info, vertex);
        edges.put(info, new ArrayList<>());

        nVertices++;
    }

    @Override
    public void addEdge(final T infoA, final T infoB) {
        if (!vertices.containsKey(infoA) || !vertices.containsKey(infoB)) {
            return;
        }

        if (infoA.equals(infoB)) {
            return;
        }

        if (hasEdge(infoA, infoB)) {
            return;
        }

        final Vertex<T> vertexA = vertices.get(infoA);
        final Vertex<T> vertexB = vertices.get(infoB);

        final Edge<T> edgeAB = new Edge<>(vertexA, vertexB);
        final Edge<T> edgeBA = new Edge<>(vertexB, vertexA);

        edges.get(infoA).add(edgeAB);
        edges.get(infoB).add(edgeBA);

        nEdges++;
    }

    /**
     * Kontrollerar om en kant redan finns mellan två noder.
     *
     * @param infoA identifierare för första noden
     * @param infoB identifierare för andra noden
     * @return true om kanten finns, annars false
     */
    private boolean hasEdge(final T infoA, final T infoB) {
        final ArrayList<Edge<T>> edgeList = edges.get(infoA);

        if (edgeList == null) {
            return false;
        }

        for (final Edge<T> edge : edgeList) {
            if (edge.getTo().getInfo().equals(infoB)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void remove(final T info) {
        if (!vertices.containsKey(info)) {
            return;
        }

        final int removedEdges = edges.get(info).size();

        for (final T key : edges.keySet()) {
            if (!key.equals(info)) {
                final ArrayList<Edge<T>> edgeList = edges.get(key);

                removeEdgesToInfo(edgeList, info);
            }
        }

        edges.remove(info);
        vertices.remove(info);

        nVertices--;
        nEdges -= removedEdges;
    }

    /**
     * Tar bort alla kanter i en lista som pekar på en given nod.
     *
     * @param edgeList listan som kanter ska tas bort från
     * @param info nodens identifierare som kanterna pekar på
     */
    private void removeEdgesToInfo(
            final ArrayList<Edge<T>> edgeList,
            final T info) {
        for (int i = edgeList.size() - 1; i >= 0; i--) {
            final Edge<T> edge = edgeList.get(i);

            if (edge.getTo().getInfo().equals(info)) {
                edgeList.remove(i);
            }
        }
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
