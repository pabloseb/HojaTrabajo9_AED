import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MatrizTest {

    @Test
    void testConstructScale() {
        Matriz m = new Matriz(2);
        assertEquals(m.toString(), "[INF,\tINF]\n[INF,\tINF]\n");
        m.AumentarMatriz();
        assertEquals(m.toString(), "[INF,\tINF,\tINF]\n[INF,\tINF,\tINF]\n[INF,\tINF,\tINF]\n");

    }

    @Test
    void testSetGet() {
        Matriz m = new Matriz(2);
        m.setData(1, 2, 3f);
        m.setData(2, 1, 2f);
        assertEquals(m.toString(), "[INF,\t3.0]\n[2.0,\tINF]\n");
        m.AumentarMatriz();
        assertEquals(m.toString(), "[INF,\t3.0,\tINF]\n[2.0,\tINF,\tINF]\n[INF,\tINF,\tINF]\n");
        assertEquals(m.get(2,1), 2f);
    }

    @Test
    void testMaxArray() {
        Matriz m = new Matriz(2);
        m.setData(1, 2, 3f);
        m.setData(2, 1, 2f);
        m.setData(1, 1, 1f);
        assertEquals(m.LowestIndex(), 1);
    }

}