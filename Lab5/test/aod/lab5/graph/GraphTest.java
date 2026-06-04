package aod.lab5.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testklass för Graph.
 */
class GraphTest {

    /**
     * Talet noll.
     */
    private static final int ZERO = 0;

    /**
     * Talet ett.
     */
    private static final int ONE = 1;

    /**
     * Talet två.
     */
    private static final int TWO = 2;

    /**
     * Talet tre.
     */
    private static final int THREE = 3;

    /**
     * Talet fyra.
     */
    private static final int FOUR = 4;

    /**
     * Talet fem.
     */
    private static final int FIVE = 5;

    /**
     * Talet tio.
     */
    private static final int TEN = 10;

    /**
     * Talet tjugo.
     */
    private static final int TWENTY = 20;

    /**
     * Talet hundra.
     */
    private static final int HUNDRED = 100;

    /**
     * Grafen som används i testerna.
     */
    private Graph<String> graph;

    /**
     * Skapar en ny graf inför varje test.
     */
    @BeforeEach
    void setUp() {
        graph = new Graph<>();

        graph.addVertex(ZERO, ZERO, "A");
        graph.addVertex(THREE, FOUR, "B");
        graph.addVertex(TEN, TEN, "C");
    }

    /**
     * Testar att addVertex ökar antalet noder.
     */
    @Test
    void testAddVertexIncreasesNumberOfVertices() {
        graph.addVertex(FIVE, FIVE, "D");

        assertEquals(FOUR, graph.numberOfVertices());
    }

    /**
     * Testar att en duplicerad nod inte läggs till.
     */
    @Test
    void testDuplicateVertexIsNotAdded() {
        graph.addVertex(HUNDRED, HUNDRED, "A");

        assertEquals(THREE, graph.numberOfVertices());
    }

    /**
     * Testar att getAllVertices returnerar rätt antal noder.
     */
    @Test
    void testGetAllVerticesReturnsCorrectSize() {
        final List<Vertex<String>> vertices = graph.getAllVertices();

        assertEquals(THREE, vertices.size());
    }

    /**
     * Testar att getAllVertices innehåller en tillagd nod.
     */
    @Test
    void testGetAllVerticesContainsAddedVertex() {
        graph.addVertex(FIVE, FIVE, "D");

        boolean found = false;

        for (final Vertex<String> vertex : graph.getAllVertices()) {
            if (vertex.getInfo().equals("D")) {
                found = true;
            }
        }

        assertTrue(found);
    }

    /**
     * Testar att addEdge ökar antalet kanter.
     */
    @Test
    void testAddEdgeIncreasesNumberOfEdges() {
        graph.addEdge("A", "B");

        assertEquals(ONE, graph.numberOfEdges());
    }

    /**
     * Testar att addEdge inte lägger till duplicerade kanter.
     */
    @Test
    void testAddEdgeDoesNotAddDuplicateEdge() {
        graph.addEdge("A", "B");
        graph.addEdge("A", "B");

        assertEquals(ONE, graph.numberOfEdges());
    }

    /**
     * Testar att getEdges returnerar rätt antal kanter.
     */
    @Test
    void testGetEdgesReturnsCorrectNumberOfEdges() {
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        assertEquals(TWO, graph.getEdges("A").size());
    }

    /**
     * Testar att getEdges returnerar rätt ansluten nod.
     */
    @Test
    void testGetEdgesReturnsCorrectConnectedVertex() {
        graph.addEdge("A", "B");

        final Edge<String> edge = graph.getEdges("A").get(ZERO);

        assertEquals("B", edge.getTo().getInfo());
    }

    /**
     * Testar att remove minskar antalet noder.
     */
    @Test
    void testRemoveVertexDecreasesNumberOfVertices() {
        graph.remove("A");

        assertEquals(TWO, graph.numberOfVertices());
    }

    /**
     * Testar att remove tar bort anslutna kanter.
     */
    @Test
    void testRemoveVertexRemovesConnectedEdges() {
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        graph.remove("A");

        assertEquals(ZERO, graph.numberOfEdges());
    }

    /**
     * Testar att antalet kanter först är noll.
     */
    @Test
    void testNumberOfEdgesInitiallyZero() {
        assertEquals(ZERO, graph.numberOfEdges());
    }

    /**
     * Testar antal kanter efter flera tillagda kanter.
     */
    @Test
    void testNumberOfEdgesAfterAddingSeveralEdges() {
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        assertEquals(TWO, graph.numberOfEdges());
    }

    /**
     * Testar att antalet noder först är korrekt.
     */
    @Test
    void testNumberOfVerticesInitiallyCorrect() {
        assertEquals(THREE, graph.numberOfVertices());
    }

    /**
     * Testar antalet noder efter att en nod har lagts till.
     */
    @Test
    void testNumberOfVerticesAfterAddingVertex() {
        graph.addVertex(TWENTY, TWENTY, "D");

        assertEquals(FOUR, graph.numberOfVertices());
    }
}
