package generatedatatest;

/**
 * Created by Ellen on 2017/10/10.
 */
public class Vertex {
    private int id;
    public Vertex(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex v = (Vertex) o;

        return id == v.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
