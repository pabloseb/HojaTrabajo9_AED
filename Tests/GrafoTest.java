import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GrafoTest {

    @Test
    void testAdd() {
        Grafo g = new Grafo();
        g.addNode("Guatemala");
        g.addNode("Escuintla");
        g.addEdge("Guatemala", "Escuintla", 4f);
        g.addEdge("Escuintla", "Guatemala", 2f);
        g.addEdge("Guatemala", "SantaLucia", 5f);
        g.addEdge("SantaLucia", "Escuintla", -3f);
        assertEquals(g.getEdge("Guatemala", "Escuintla"), 4f);
        assertEquals(g.getEdge("Guatemala", "SantaLucia"), 5f);


    }


    @Test
    void testFloydPath() {
        Grafo g = new Grafo();
        g.addNode("Guatemala");
        g.addNode("Escuintla");
        g.addEdge("Guatemala", "Escuintla", 4f);
        g.addEdge("Escuintla", "Guatemala", 2f);
        g.addEdge("Guatemala", "SantaLucia", 5f);
        g.addEdge("SantaLucia", "Escuintla", -3f);

        Matriz P = new Matriz(3, true);
        P.setData(3, 1, 2);
        P.setData(1, 2, 3);
        P.setData(2, 3, 1);
        g.FloydAlgo();

        assertEquals(g.getPaths().toString(), P.toString());
    }


    @Test
    void testFloydCost() {
        Grafo g = new Grafo();
        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");
        g.addEdge("a", "b", 1);
        g.addEdge("b", "c", 2);
        g.addEdge("c", "e", 4);
        g.addEdge("e", "d", 5);
        g.addEdge("d", "b", 1);
        g.addEdge("c", "d", 2);
        g.addEdge("d", "c", 3);

        assertEquals(g.Centro(), "Centro: d");


        Matriz c = new Matriz(5);
        for (int i=1; i<=5; i++) {
            c.setData(i, i, 0f);
        }
        c.setData(1, 2, 1);
        c.setData(1, 3, 3);
        c.setData(1, 4, 5);
        c.setData(1, 5, 7);
        c.setData(2, 3, 2);
        c.setData(2, 4, 4);
        c.setData(2, 5, 6);
        c.setData(3, 2, 3);
        c.setData(3, 4, 2);
        c.setData(3, 5, 4);
        c.setData(4, 2, 1);
        c.setData(4, 3, 3);
        c.setData(4, 5, 7);
        c.setData(5, 2, 6);
        c.setData(5, 3, 8);
        c.setData(5, 4, 5);

        g.FloydAlgo();

        assertEquals(g.getCost().toString(), c.toString());


    }


    @Test
    void testDeleteEdge() {
        Grafo g = new Grafo();
        g.addNode("a");
        g.addNode("b");
        g.addNode("c");
        g.addNode("d");
        g.addNode("e");
        g.addEdge("a", "b", 1);
        g.addEdge("b", "c", 2);
        g.addEdge("c", "e", 4);
        g.addEdge("e", "d", 5);
        g.addEdge("d", "b", 1);
        g.addEdge("c", "d", 2);
        g.addEdge("d", "c", 3);

        g.deleteEdge("a", "b");
        assertEquals(g.ShortestPath("a", "b"), "No existe camino entre a y b");
    }

}