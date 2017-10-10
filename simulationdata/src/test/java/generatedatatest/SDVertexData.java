package generatedatatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ellen on 2017/10/10.
 */
public class SDVertexData {
    private static final int VNUM = 24;
    private static final int[] partSVertex = {1, 2, 3, 4, 5, 6, 7};
    private static final int[] partDVertex = {9, 10, 11, 12, 13, 14};
    //the all source and destination vertexs
    public static List<Vertex> getAllSVertex() {
        List<Vertex> list = new ArrayList<Vertex>();
        for (int i=0; i<VNUM; i++) {
            Vertex ver = new Vertex(i+1);
            list.add(ver);
        }
        return list;
    }

    public static List<Vertex> getAllDVertex() {
        List<Vertex> list = new ArrayList<Vertex>();
        for (int i=0; i<VNUM; i++) {
            Vertex ver = new Vertex(i+1);
            list.add(ver);
        }
        return list;
    }
    //the part source and destination vertex
    public static List<Vertex> getPartSVertex() {
        List<Vertex> list = new ArrayList<Vertex>();
        for (int i=0; i<partSVertex.length; i++) {
            Vertex ver = new Vertex(partSVertex[i]);
            list.add(ver);
        }
        return list;
    }

    public static List<Vertex> getPartDVertex() {
        List<Vertex> list = new ArrayList<Vertex>();
        for (int i=0; i<partDVertex.length; i++) {
            Vertex ver = new Vertex(partDVertex[i]);
            list.add(ver);
        }
        return list;
    }
}
