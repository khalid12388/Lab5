package aod.lab5.graph;

import java.util.List;

/**
 * Ett interface för en tvådimensionell graf med noder och kanter.
 * Varje nod innehåller information av typen T och har en position
 * i ett tvådimensionellt område.
 *
 * @param <T> typen av information som lagras i varje nod
 *
 * @author Emilia Forslin
 */
public interface GraphInterface<T> {

    /**
     * Returnerar en lista med alla noder som finns i grafen.
     *
     * @return en lista med alla {@link Vertex}-objekt
     */
    List<Vertex<T>> getAllVertices();

    /**
     * Returnerar alla kanter som är kopplade till noden som identifieras av
     * det angivna informationsvärdet.
     *
     * @param info nodens identifierare
     * @return en lista med alla {@link Edge}-objekt kopplade till noden
     */
    List<Edge<T>> getEdges(T info);

    /**
     * Lägger till en ny {@link Vertex} i grafen på den angivna positionen.
     *
     * @param x x-koordinaten
     * @param y y-koordinaten
     * @param info nodens information och identifierare
     */
    void addVertex(double x, double y, T info);

    /**
     * Lägger till en oriktad kant mellan två noder. Kanten lagras internt som
     * två riktade {@link Edge}-objekt, ett i varje riktning.
     *
     * @param infoA identifierare för nod A
     * @param infoB identifierare för nod B
     */
    void addEdge(T infoA, T infoB);

    /**
     * Tar bort {@link Vertex}-objektet som identifieras av info och alla
     * {@link Edge}-objekt som är kopplade till det.
     *
     * @param info identifierare för noden som ska tas bort
     */
    void remove(T info);

    /**
     * Returnerar antalet {@link Edge}-objekt i grafen. En dubbel kant mellan
     * två noder räknas som en kant.
     *
     * @return antal kanter
     */
    int numberOfEdges();

    /**
     * Returnerar antalet {@link Vertex}-objekt i grafen.
     *
     * @return antal noder
     */
    int numberOfVertices();
}
