package aod.lab5.graph;

import java.awt.Color;

/**
 * Represents a directed edge between two vertices.
 *
 * @param <T> the type of information stored in the vertices
 */
public final class Edge<T> {

    /**
     * The start vertex of the edge.
     */
    private Vertex<T> from;

    /**
     * The end vertex of the edge.
     */
    private Vertex<T> to;

    /**
     * The distance between the vertices.
     */
    private double distance;

    /**
     * The color of the edge.
     */
    private Color color;

    /**
     * Creates a new edge between two vertices.
     *
     * @param startVertex the start vertex
     * @param endVertex the end vertex
     */
    public Edge(final Vertex<T> startVertex, final Vertex<T> endVertex) {
        this.from = startVertex;
        this.to = endVertex;
        this.distance = calculateDistance(startVertex, endVertex);
        this.color = Color.GRAY;
    }

    /**
     * Calculates the distance between two vertices.
     *
     * @param startVertex the start vertex
     * @param endVertex the end vertex
     * @return the distance between the vertices
     */
    private double calculateDistance(final Vertex<T> startVertex,
            final Vertex<T> endVertex) {
        double dx = endVertex.getX() - startVertex.getX();
        double dy = endVertex.getY() - startVertex.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Returns the start vertex.
     *
     * @return the start vertex
     */
    public Vertex<T> getFrom() {
        return from;
    }

    /**
     * Returns the end vertex.
     *
     * @return the end vertex
     */
    public Vertex<T> getTo() {
        return to;
    }

    /**
     * Returns the distance of the edge.
     *
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Returns the edge color.
     *
     * @return the edge color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the edge color.
     *
     * @param newColor the new color
     */
    public void setColor(final Color newColor) {
        this.color = newColor;
    }
}
