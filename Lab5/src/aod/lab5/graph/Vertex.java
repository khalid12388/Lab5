package aod.lab5.graph;

import java.awt.Color;

/**
 * Represents a vertex in a graph with coordinates, information and color.
 *
 * @param <T> the type of information stored in the vertex
 */
public class Vertex<T> {

    private T info;
    private double x;
    private double y;
    private Color color;

    /**
     * Creates a new vertex.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @param info the information used to identify the vertex
     */
    public Vertex(double x, double y, T info) {
        this.x = x;
        this.y = y;
        this.info = info;
        this.color = Color.BLACK;
    }

    public T getInfo() {
        return info;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}