import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Archivos {

    public static Grafo leer() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("guategrafo.txt"));
        String row;
        Grafo g = new Grafo();
        while ((row = reader.readLine()) != null){
            String[] data = row.split(" ");
            g.addEdge(data[0], data[1], Float.valueOf(data[2]));
        }
        reader.close();
        return g;
    }
}