package aod.lab5.graph;

import java.awt.Color;

/**
 * Representerar en nod i en graf.
 *
 * @param <T> typen av information som lagras i noden
 */
public final class Vertex<T> {

    /**
     * Information som används för att identifiera noden.
     */
    private T info;

    /**
     * Nodens x-koordinat.
     */
    private double x;

    /**
     * Nodens y-koordinat.
     */
    private double y;

    /**
     * Nodens färg.
     */
    private Color color;

    /**
     * Skapar en ny nod.
     *
     * @param xCoordinate x-koordinaten
     * @param yCoordinate y-koordinaten
     * @param vertexInfo informationen som lagras i noden
     */
    public Vertex(
            final double xCoordinate,
            final double yCoordinate,
            final T vertexInfo) {
        x = xCoordinate;
        y = yCoordinate;
        info = vertexInfo;
        color = Color.BLACK;
    }

    /**
     * Returnerar informationen som lagras i noden.
     *
     * @return nodens information
     */
    public T getInfo() {
        return info;
    }

    /**
     * Returnerar x-koordinaten.
     *
     * @return x-koordinaten
     */
    public double getX() {
        return x;
    }

    /**
     * Returnerar y-koordinaten.
     *
     * @return y-koordinaten
     */
    public double getY() {
        return y;
    }

    /**
     * Returnerar nodens färg.
     *
     * @return nodens färg
     */
    public Color getColor() {
        return color;
    }

    /**
     * Ändrar nodens information.
     *
     * @param newInfo den nya informationen
     */
    public void setInfo(final T newInfo) {
        info = newInfo;
    }

    /**
     * Ändrar x-koordinaten.
     *
     * @param newX den nya x-koordinaten
     */
    public void setX(final double newX) {
        x = newX;
    }

    /**
     * Ändrar y-koordinaten.
     *
     * @param newY den nya y-koordinaten
     */
    public void setY(final double newY) {
        y = newY;
    }

    /**
     * Ändrar nodens färg.
     *
     * @param newColor den nya färgen
     */
    public void setColor(final Color newColor) {
        color = newColor;
    }
}
