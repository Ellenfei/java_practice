package src.test.simplegraph;

import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * Created by Ellen on 2017/9/27.
 */
public class Edge extends DefaultWeightedEdge {
    private Vertex s;
    private Vertex d;
    private double weight;
    public Edge (Vertex s, Vertex d, double weight) {
        this.s = s;
        this.d = d;
        this.weight = weight;
    }
    public Vertex getS() {
        return this.s;
    }
    public Vertex getD() {
        return this.d;
    }
    public double getWeight() {
        return this.weight;
    }
}
