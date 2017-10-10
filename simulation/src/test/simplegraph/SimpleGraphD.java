package src.test.simplegraph;

import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ellen on 2017/9/27.
 */
public class SimpleGraphD extends SimpleWeightedGraph {
    private static final int VNUM = 14;
    private static final int ENUM = 21;
    private static SimpleGraphD simpleGraph;
    private static int[] partArray = {0, 1, 2, 4, 5, 6};
    public SimpleGraphD(Class edgeClass) {
        super(edgeClass);
    }

    public static SimpleGraphD getSimpleGraph() {
        simpleGraph = new SimpleGraphD(Edge.class);
        Vertex[] vs = new Vertex[VNUM];
        for (int i=0; i<VNUM; i++) {
            vs[i] = new Vertex(i);
            simpleGraph.addVertex(vs[i]);
        }
        //edge
        Edge[] edges = new Edge[ENUM];
        edges[0] = new Edge(vs[0],vs[1],118);
        edges[1] = new Edge(vs[0],vs[2],114);
        edges[2] = new Edge(vs[0],vs[3],147);
        edges[3] = new Edge(vs[1],vs[2],173);
        edges[4] = new Edge(vs[1],vs[7],395);
        edges[5] = new Edge(vs[2],vs[5],189);
        edges[6] = new Edge(vs[3],vs[4],113);
        edges[7] = new Edge(vs[3],vs[10],518);
        edges[8] = new Edge(vs[4],vs[5],124);
        edges[9] = new Edge(vs[4],vs[6],133);
        edges[10] = new Edge(vs[5],vs[9],320);
        edges[11] = new Edge(vs[5],vs[13],471);
        edges[12] = new Edge(vs[6],vs[7],96);
        edges[13] = new Edge(vs[7],vs[8],102);
        edges[14] = new Edge(vs[8],vs[9],342);
        edges[15] = new Edge(vs[8],vs[11],244);
        edges[16] = new Edge(vs[8],vs[12],304);
        edges[17] = new Edge(vs[10],vs[11],185);
        edges[18] = new Edge(vs[10],vs[12],311);
        edges[19] = new Edge(vs[11],vs[13],302);
        edges[20] = new Edge(vs[12], vs[13], 160);
        //simpleGraph.addEdge();

        for (int i=0; i<ENUM; i++) {
            simpleGraph.addEdge(edges[i].getS(), edges[i].getD(),edges[i]);
        }
        return simpleGraph;
    }

    public static List<Integer> getDistance() {
        SimpleGraphD simpleGraph = SimpleGraphD.getSimpleGraph();
        List<Edge> list ;
        //int min = Integer.MAX_VALUE;
        //int max = Integer.MIN_VALUE;
        List<Integer> shortestDistance = new ArrayList<Integer>();
        for (int i=0; i<VNUM-1; i++) {
            Vertex s = new Vertex(i);
            for (int j = i + 1; j < VNUM; j++) {
                Vertex d = new Vertex(j);
                list = DijkstraShortestPath.findPathBetween(simpleGraph, s, d);
                int distance = 0;
                for (int k=0; k<list.size(); k++) {
                    distance += list.get(k).getWeight();
                }
                shortestDistance.add(distance);
            }
        }
        return shortestDistance;
    }

    public static List<Integer> getPartDistance() {
        SimpleGraphD simpleGraph = SimpleGraphD.getSimpleGraph();
        List<Edge> list ;
        List<Integer> shortestDistance = new ArrayList<Integer>();
        for (int i=0; i<partArray.length-1; i++) {
            Vertex s = new Vertex(partArray[i]);
            for (int j = i + 1; j < partArray.length; j++) {
                Vertex d = new Vertex(partArray[j]);
                list = DijkstraShortestPath.findPathBetween(simpleGraph, s, d);
                int distance = 0;
                for (int k=0; k<list.size(); k++) {
                    distance += list.get(k).getWeight();
                }
                shortestDistance.add(distance);
            }
        }
        return shortestDistance;
    }

    //public static void main(String[] args) {
      //  SimpleGraphD simpleGraph = SimpleGraphD.getSimpleGraph();
        //List<Edge> list ;
        /*int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<VNUM-1; i++) {
            Vertex s = new Vertex(i);
            for (int j = i + 1; j < VNUM; j++) {
                Vertex d = new Vertex(j);
                list = DijkstraShortestPath.findPathBetween(simpleGraph, s, d);
                int distance = 0;
                for (int k=0; k<list.size(); k++) {
                    distance += list.get(k).getWeight();
                }
                min = Math.min(min, distance);
                max = Math.max(max, distance);
                *//*Iterator it = list.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }*//*
                System.out.println(s.getId() + "----->" + d.getId() + ": " + distance);
            }
        }
        System.out.println("the min: " + min);
        System.out.println("the max: " + max);*/
        //List<Integer> result = SimpleGraphD.getPartDistance();
        //System.out.println(result);
    //}

}
