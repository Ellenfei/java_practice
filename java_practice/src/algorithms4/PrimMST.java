package algorithms4;

/**
 * Created by Ellen on 2017/9/13.
 * 最小生成树的Prim算法
 */
public class PrimMST {
    private Edge[] edgeTo;          //距离树最近的边
    private double[] distTo;        //distTo[w]=edgeTo[w].weight
    private boolean[] marked;       //如果v在树中则为true
    private IndexMinPQ<Double> pq;  //有效的横切边

    public PrimMST (EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v=0; v<G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        pq = new IndexMinPQ<>(G.V());
        distTo[0] = 0.0;    //用0初始化pq
        while (!pq.isEmpty()) {
        //将最近的顶点添加到树中
            
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) {}
                else pq.insert(w, distTo[w]);
            }
        }
    }
}
