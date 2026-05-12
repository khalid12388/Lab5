package aod.lab5.graph;

import java.awt.Color;

/**
 * Represents a directed edge between two vertices in a graph.
 *
 * @param <T> the type of information stored in the vertices
 */
public class Edge<T> {

    private Vertex<T> from;
    private Vertex<T> to;
    private double distance;
    private Color color;

    /**
     * Creates an edge from one vertex to another.
     *
     * @param from the start vertex
     * @param to the end vertex
     */
    public Edge(Vertex<T> from, Vertex<T> to) {
        this.from = from;
        this.to = to;
        this.distance = calculateDistance(from, to);
        this.color = Color.GRAY;
    }

    /**
     * Calculates the distance between two vertices using Pythagoras.
     */
    private double calculateDistance(Vertex<T> from, Vertex<T> to) {
        double dx = to.getX() - from.getX();
        double dy = to.getY() - from.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public double getDistance() {
        return distance;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}