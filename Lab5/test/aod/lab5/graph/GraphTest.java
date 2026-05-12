package aod.lab5.graph;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphTest {

    private Graph<String> graph;

    @BeforeEach
    void setUp() {
        graph = new Graph<>();

        graph.addVertex(0, 0, "A");
        graph.addVertex(3, 4, "B");
        graph.addVertex(10, 10, "C");
    }

    // addVertex()

    @Test
    void testAddVertexIncreasesNumberOfVertices() {
        graph.addVertex(5, 5, "D");

        assertEquals(4, graph.numberOfVertices());
    }

    @Test
    void testDuplicateVertexIsNotAdded() {
        graph.addVertex(100, 100, "A");

        assertEquals(3, graph.numberOfVertices());
    }

    // getAllVertices()

    @Test
    void testGetAllVerticesReturnsCorrectSize() {
        List<Vertex<String>> vertices = graph.getAllVertices();

        assertEquals(3, vertices.size());
    }

    @Test
    void testGetAllVerticesContainsAddedVertex() {
        graph.addVertex(5, 5, "D");

        boolean found = false;

        for (Vertex<String> vertex : graph.getAllVertices()) {
            if (vertex.getInfo().equals("D")) {
                found = true;
            }
        }

        assertTrue(found);
    }

    // addEdge()

    @Test
    void testAddEdgeIncreasesNumberOfEdges() {
        graph.addEdge("A", "B");

        assertEquals(1, graph.numberOfEdges());
    }

    @Test
    void testAddEdgeDoesNotAddDuplicateEdge() {
        graph.addEdge("A", "B");
        graph.addEdge("A", "B");

        assertEquals(1, graph.numberOfEdges());
    }

    // getEdges()

    @Test
    void testGetEdgesReturnsCorrectNumberOfEdges() {
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        assertEquals(2, graph.getEdges("A").size());
    }

    @Test
    void testGetEdgesReturnsCorrectConnectedVertex() {
        graph.addEdge("A", "B");

        Edge<String> edge = graph.getEdges("A").get(0);

        assertEquals("B", edge.getTo().getInfo());
    }

    // remove()

    @Test
    void testRemoveVertexDecreasesNumberOfVertices() {
        graph.remove("A");

        assertEquals(2, graph.numberOfVertices());
    }

    @Test
    void testRemoveVertexRemovesConnectedEdges() {
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        graph.remove("A");

        assertEquals(0, graph.numberOfEdges());
    }

    // numberOfEdges()

    @Test
    void testNumberOfEdgesInitiallyZero() {
        assertEquals(0, graph.numberOfEdges());
    }

    @Test
    void testNumberOfEdgesAfterAddingSeveralEdges() {
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        assertEquals(2, graph.numberOfEdges());
    }

    // numberOfVertices()

    @Test
    void testNumberOfVerticesInitiallyCorrect() {
        assertEquals(3, graph.numberOfVertices());
    }

    @Test
    void testNumberOfVerticesAfterAddingVertex() {
        graph.addVertex(20, 20, "D");

        assertEquals(4, graph.numberOfVertices());
    }
}