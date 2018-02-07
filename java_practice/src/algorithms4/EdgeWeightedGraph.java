package algorithms4;

import java.io.DataInputStream;

import java.util.LinkedList;


/**
 * Created by Ellen on 2017/9/12.
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new LinkedList[V];
        for (int v=0; v<V; v++) {
            adj[v] = new LinkedList<>();
        }
    }

    public EdgeWeightedGraph(DataInputStream in) throws Exception{
        this(in.readInt());
        for (int i=0; i<E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            int weight = in.readInt();
            Edge e = new Edge(v,w,weight);
            addEdge(e);
        }
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public int V() { return V;}
    public Iterable<Edge> adj(int v) {
        return adj(v);
    }
}
