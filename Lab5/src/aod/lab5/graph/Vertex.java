package aod.lab5.graph;

import java.awt.Color;

/**
 * Represents a vertex in a graph.
 *
 * @param <T> the type of information stored in the vertex
 */
public final class Vertex<T> {

    /**
     * Information used to identify the vertex.
     */
    private T info;

    /**
     * The x-coordinate of the vertex.
     */
    private double x;

    /**
     * The y-coordinate of the vertex.
     */
    private double y;

    /**
     * The color of the vertex.
     */
    private Color color;

    /**
     * Creates a new vertex.
     *
     * @param xCoordinate the x-coordinate
     * @param yCoordinate the y-coordinate
     * @param vertexInfo the information stored in the vertex
     */
    public Vertex(final double xCoordinate, final double yCoordinate,
            final T vertexInfo) {
        this.x = xCoordinate;
        this.y = yCoordinate;
        this.info = vertexInfo;
        this.color = Color.BLACK;
    }

    /**
     * Returns the information stored in the vertex.
     *
     * @return the vertex information
     */
    public T getInfo() {
        return info;
    }

    /**
     * Returns the x-coordinate.
     *
     * @return the x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate.
     *
     * @return the y-coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Returns the vertex color.
     *
     * @return the vertex color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the vertex information.
     *
     * @param newInfo the new information
     */
    public void setInfo(final T newInfo) {
        this.info = newInfo;
    }

    /**
     * Sets the x-coordinate.
     *
     * @param newX the new x-coordinate
     */
    public void setX(final double newX) {
        this.x = newX;
    }

    /**
     * Sets the y-coordinate.
     *
     * @param newY the new y-coordinate
     */
    public void setY(final double newY) {
        this.y = newY;
    }

    /**
     * Sets the vertex color.
     *
     * @param newColor the new color
     */
    public void setColor(final Color newColor) {
        this.color = newColor;
    }
}
