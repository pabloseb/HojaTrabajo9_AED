import java.io.IOException;

public class main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Control control = new Control();
        while(true){
            try{
                grafo = Archivos.leer();
                break;
            }catch (IOException e){
                control.print("No se ha encontrado el archivo guategrafo.txt dentro del proyecto, por favor agreguelo e intente de nuevo");
            }
        }
        int opcion_usuario = 1;
        while(opcion_usuario >= 1 && opcion_usuario <= 6){
            opcion_usuario = control.Menu();
            switch (opcion_usuario){
                case 1:
                    try{
                        String Origen = control.Origen();
                        String Destino = control.Destino();
                        control.print("\n"+ grafo.ShortestPath(Origen,Destino));
                    }catch (Exception e){
                        control.print("\nNo se han encontrado las ciudades especificadas, intente de nuevo");
                    }
                    break;
                case 2:
                    control.print(grafo.Centro());
                    break;
                case 3:
                    control.print(grafo.toString());
                    break;
                case 4:
                    try{
                        String Origen = control.Origen();
                        String Destino = control.Destino();
                        control.Causa();
                        grafo.deleteEdge(Origen,Destino);
                        control.print("Se han calculado las nuevas rutas y se Ha calculado el nuevo centro del grafo");
                        control.print(grafo.Centro());
                    }catch (Exception e){
                        control.print("No se han encontrado las rutas especificadas");
                    }
                    break;
                case 5:
                    try{
                        String Origen = control.Origen();
                        String Destino = control.Destino();
                        float Distancia = control.Distancia();
                        grafo.addEdge(Origen,Destino,Distancia);
                        control.print("Se han calculado las nuevas rutas y se Ha calculado el nuevo centro del grafo");
                        control.print(grafo.Centro());
                    }catch (Exception e){
                        control.print("No se han encontrado las rutas especificadas");
                    }
                    break;
                case 6:
                    control.print("Finalizando el programa");
                    System.exit(0);
                    break;
            }
        }
    }
}
