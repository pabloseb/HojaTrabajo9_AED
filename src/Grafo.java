import java.util.HashMap;

public class Grafo {


    private Matriz matriz;
    private HashMap<String, Integer> String_Integer = new HashMap<>();
    private HashMap<Integer, String> Integer_String = new HashMap<>();
    private Matriz costo;
    private Matriz caminos;
    private int size = 0;
    private boolean modified = false;

    Grafo(){
        matriz = new Matriz();
    }


    public void addNode(String nombre_ciudad) {
        if (!String_Integer.containsKey(nombre_ciudad)) {
            size++;
            String_Integer.put(nombre_ciudad, size);
            Integer_String.put(size, nombre_ciudad);
            matriz.AumentarMatriz();
            addEdge(nombre_ciudad, nombre_ciudad, 0);
            modified = true;
        }
    }

    public void addEdge(String origen, String destino, float dist) {
        addNode(origen);
        addNode(destino);
        int from = String_Integer.get(origen);
        int to = String_Integer.get(destino);
        if (matriz.get(from, to) > dist) {
            matriz.setData(from, to, dist);
            modified = true;
        }
    }

    public float getEdge(String origen, String destino) {
        addNode(origen);
        addNode(destino);
        return matriz.get(String_Integer.get(origen), String_Integer.get(destino));
    }

    public void FloydAlgo() {
        costo = matriz.GenerateCopy();
        caminos = new Matriz(size, true);

        for (int k=1; k<=size; k++) {
            for (int i=1; i<=size; i++) {
                for (int j=1; j<=size; j++) {
                    if (costo.get(i, j) > costo.get(i, k) + costo.get(k, j)) {
                        costo.setData(i, j, costo.get(i, k) + costo.get(k, j));
                        if (i != j) {
                            caminos.setData(i, j, k);
                        }
                    }
                }
            }
        }
        modified = false;
    }

    public String Centro() {
        if (modified) {
            FloydAlgo();
        }
        int id = costo.LowestIndex();
        String ciudad = Integer_String.get(id);
        if (ciudad == null) {
            return "El grafo no tiene un centro";
        }
        return "Centro: " + ciudad;
    }

    public String ShortestPath(String origen, String destino) {
        int from = String_Integer.get(origen);
        int to = String_Integer.get(destino);

        if (modified) {
            FloydAlgo();
        }

        if (costo.get(from, to) == costo.Infinity) {
            return "No existe camino entre " + origen + " y " + destino;
        }

        String txt = "Distancia: " + costo.get(from, to).toString() + "\n";

        return txt + path(from, to, origen + "->") + destino;


    }

    private String path(int i, int j, String txt) {
        if (caminos.get(i, j) != 0) {
            txt = path(i, (int) caminos.get(i, j).floatValue(), txt);
            txt += Integer_String.get((int) caminos.get(i, j).floatValue()) + "->";
            txt = path((int) caminos.get(i, j).floatValue(), j, txt);
            return txt;
        }
        return txt;
    }

    public void deleteEdge(String origen, String destino) {
        int from = String_Integer.get(origen);
        int to = String_Integer.get(destino);
        matriz.setData(from, to, matriz.Infinity);
    }

    @Override
    public String toString() {
        String txt = "";
        for (int i=1; i<size+1; i++) {
            txt += Integer_String.get(i) + ", ";
        }
        return txt.substring(0, txt.length() - 2) + "\n" + matriz.toString();
    }

    public Matriz getPaths() {
        return caminos;
    }

    public Matriz getCost() {
        return costo;
    }
}