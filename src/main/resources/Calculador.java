package mundo;

/*
 * Esta clase pertenece al mundo del aplicativo que se encarga de hacer las
 * operaciones de calcular desviación y media
 */


import java.util.LinkedList;
import java.util.Iterator;

/**
 *
 * @author deividosorio
 */
public class Calculador {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    private double sumatoria;
    private double media;
    private int cantidadLista;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    public Calculador() {
        
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    // Método que calcula la desviación estándar 
    //
    public double obtenerDesvStdr(LinkedList list) {
        cantidadLista = list.size();
        media = obtenerMedia(list);
        sumatoria = 0;

        for (Iterator i = list.iterator(); i.hasNext();) {
            sumatoria += Math.pow(((double) i.next() - media),2);
        }
         
        return Math.sqrt(sumatoria / (cantidadLista - 1));
    }

 
    // Método que calcula la media de un listado de números
    public double obtenerMedia(LinkedList list) {
        cantidadLista = list.size();
        sumatoria = 0;

        for (Iterator i = list.iterator(); i.hasNext();) {
            sumatoria += (double) i.next();
        }

        return ((sumatoria) / (cantidadLista));
    }

}
