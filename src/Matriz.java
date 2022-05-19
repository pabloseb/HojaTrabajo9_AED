/**
 * @author Pablo Herrera
 * @since 19/05/2022
 */

import java.util.ArrayList;

/**
 * Matriz de adyacencia para la implementacion del grafo
 */
public class Matriz {

    private ArrayList<ArrayList<Float>> data;
    final float Infinity = Float.POSITIVE_INFINITY;
    final float NegativeInfinity = Float.NEGATIVE_INFINITY;
    private int size = 0;

    /**
     * Constructor de una matriz vacia
     */
    Matriz(){
        data = new ArrayList<ArrayList<Float>>();
    }

    /**
     * contructor de una matriz con dimension size
     * @param size dimension
     */
    Matriz(int size){
        this(size, false);
    }

    /**
     * constructo de una matriz con dimension size con posibles ceros
     * @param size dimension matriz
     * @param zero contiene cero o no
     */
    Matriz(int size, boolean zero) {
        this();
        for (int i = 0; i < size; i++) {
            ArrayList<Float> arr = new ArrayList<Float>();
            for (int j = 0; j < size; j++) {
                if (zero) {
                    arr.add(0f);
                }
                else {
                    arr.add(Infinity);
                }
            }
            data.add(arr);
        }
        this.size = size;
    }

    /**
     * Metodo para aumentar la matriz proporcionalmente
     */
    public void AumentarMatriz() {
        size = size + 1;
        for (ArrayList<Float> arr : data) {
            arr.add(Infinity);
        }
        ArrayList<Float> array = new ArrayList<Float>();
        for (int i = 0; i < size; i++) {
            array.add(Infinity);
        }
        data.add(array);
    }

    /**
     * Metodo para establecer valores de la matriz
     * @param i posicion
     * @param j posicion
     * @param e valor
     */
    public void setData(int i, int j, float e) {
        i--;
        j--;
        ArrayList<Float> array = data.get(i);
        array.set(j, e);
        data.set(i, array);
    }

    /**
     * metodo para obtener valores en diferentes posiciones de la matriz
     * @param i posicion
     * @param j posicion
     * @return valor en las posiciones
     */
    public Float get(int i, int j) {
        i--;
        j--;
        return data.get(i).get(j);
    }

    /**
     * Metodo para generar arreglo con valores maximos por columna
     * @return arreglo
     */
    private ArrayList<Float> MaxArray() {
        ArrayList<Float> MaxArr = new ArrayList<Float>();
        for (int i=0; i<size; i++) {
            float max = NegativeInfinity;
            for (ArrayList<Float> arr : data) {
                if (max < arr.get(i)) {
                    max = arr.get(i);
                }
            }
            MaxArr.add(max);
        }
        return MaxArr;

    }

    /**
     * Metodo que gerena el minimo indice del arreglo
     * @return indice minimo
     */
    public int LowestIndex() {
        ArrayList<Float> maxArr = MaxArray();
        float min = Infinity;
        int lowestindex = 0;
        for (int i=0; i<maxArr.size(); i++) {
            if (maxArr.get(i) < min) {
                min = maxArr.get(i);
                lowestindex = i + 1;
            }
        }
        return lowestindex;
    }

    /**
     * metodo para generar una copia de la matriz
     * @return matriz
     */
    public Matriz GenerateCopy() {
        Matriz matriz = new Matriz(size, false);
        for (int i=1; i<=size; i++) {
            for (int j=1; j<=size; j++) {
                matriz.setData(i,  j, get(i, j));
            }
        }
        return matriz;
    }

    /**
     * Metodo para representar la matriz con cadenas
     * @return matriz en cadena
     */
    @Override
    public String toString() {
        String matriz_string = "";
        for (ArrayList<Float> arr : data) {
            matriz_string += "[";
            for (Float f : arr) {
                if (f == Infinity) {
                    matriz_string += "INF,\t";
                } else {
                    matriz_string += f.toString() + ",\t";
                }
            }
            matriz_string = matriz_string.substring(0, matriz_string.length() - 2);
            matriz_string += "]\n";
        }
        return matriz_string;
    }
}