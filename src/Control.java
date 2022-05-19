/**
 * @author Pablo Herrera
 * @since 19/05/2022
 */

import java.util.Scanner;

public class Control {

    private Scanner scanner;


    Control(){
        scanner = new Scanner(System.in);
    }

    public void print(String string) {
        System.out.println(string);
    }

    /**
     * Metodo para mostrar el menu del programa
     * @return opcion escogida del menu
     */
    public int Menu() {
        print("Ingrese una opcion del menu");
        print("1.Obtener la ruta mas contra entre dos ciudades");
        print("2.Obtener Centro del grafo");
        print("3.Mostrar Grafo implementado en la matriz de adyacencia");
        print("4.Eliminar conexion entre ciudades");
        print("5.Agregar una nueva conexion entre ciudades");
        print("6.Finalizar programa");

        int opcion = 0;
        while (opcion < 1 || opcion > 6) {
            try {
                opcion = scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                print("\nIngrese un valor dentro del menu\n");
                opcion = 0;
            }
        }
        return opcion;
    }

    /**
     * Metodo para obtener la ciudad de origen segun indique el usuario
     * @return Ciudad de Origen
     */
    public String Origen() {
        print("\nIngrese ciudad de origen");
        scanner.nextLine();
        return scanner.nextLine();
    }

    /**
     * Metodo para obtener la ciudad de Destino segun indique el usuario
     * @return Ciudad de Destino
     */
    public String Destino() {
        print("\nIngrese ciudad de destino");
        return scanner.nextLine();
    }

    /**
     * Metodo para obtener la distancia entre dos ciudades
     * @return distancia entre ciudades
     */
    public float Distancia() {
        print("\nIngrese distancia en KM");
        while (true) {
            try {
                return scanner.nextFloat();
            } catch (Exception e) {
                print("\nIngrese dato válido");
                return Distancia();
            }
        }
    }

    /**
     * Metodo para indicar la causa de eliminacion de conexion entre ciudades
     */
    public void Causa(){
        print("Ingrese la causa del bloqueo entre estas ciudades");
        scanner.nextLine();
    }
}