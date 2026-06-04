package aod.lab5.graph;

import java.awt.Color;

/**
 * Representerar en riktad kant mellan två noder.
 *
 * @param <T> typen av information som lagras i noderna
 */
public final class Edge<T> {

    /**
     * Kantens startnod.
     */
    private final Vertex<T> from;

    /**
     * Kantens slutnod.
     */
    private final Vertex<T> to;

    /**
     * Avståndet mellan noderna.
     */
    private final double distance;

    /**
     * Kantens färg.
     */
    private Color color;

    /**
     * Skapar en ny kant mellan två noder.
     *
     * @param startVertex startnoden
     * @param endVertex slutnoden
     */
    public Edge(final Vertex<T> startVertex, final Vertex<T> endVertex) {
        from = startVertex;
        to = endVertex;
        distance = calculateDistance(startVertex, endVertex);
        color = Color.GRAY;
    }

    /**
     * Beräknar avståndet mellan två noder.
     *
     * @param startVertex startnoden
     * @param endVertex slutnoden
     * @return avståndet mellan noderna
     */
    private double calculateDistance(
            final Vertex<T> startVertex,
            final Vertex<T> endVertex) {
        final double dx = endVertex.getX() - startVertex.getX();
        final double dy = endVertex.getY() - startVertex.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Returnerar startnoden.
     *
     * @return startnoden
     */
    public Vertex<T> getFrom() {
        return from;
    }

    /**
     * Returnerar slutnoden.
     *
     * @return slutnoden
     */
    public Vertex<T> getTo() {
        return to;
    }

    /**
     * Returnerar kantens avstånd.
     *
     * @return avståndet
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Returnerar kantens färg.
     *
     * @return kantens färg
     */
    public Color getColor() {
        return color;
    }

    /**
     * Ändrar kantens färg.
     *
     * @param newColor den nya färgen
     */
    public void setColor(final Color newColor) {
        color = newColor;
    }
}
