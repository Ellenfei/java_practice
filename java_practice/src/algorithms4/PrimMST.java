package algorithms4;

/**
 * Created by Ellen on 2017/9/13.
 * ��С��������Prim�㷨
 */
public class PrimMST {
    private Edge[] edgeTo;          //����������ı�
    private double[] distTo;        //distTo[w]=edgeTo[w].weight
    private boolean[] marked;       //���v��������Ϊtrue
    private IndexMinPQ<Double> pq;  //��Ч�ĺ��б�

    public PrimMST (EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int v=0; v<G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        pq = new IndexMinPQ<>(G.V());
        distTo[0] = 0.0;    //��0��ʼ��pq
        while (!pq.isEmpty()) {
        //������Ķ�����ӵ�����
            
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
