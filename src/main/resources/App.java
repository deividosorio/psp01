package mundo;

/*
 * Clase que representa la aplicación 
 */


import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author deividosorio
 */
public class App {

    /**
     * Clase principan main del aplicativo, este carga los valores y los 
     * muestra en la consola
     * @param args 
     */
    public static void main(String args[]) {

        LinkedList list;

        Calculador calcula = new Calculador();
        
        list = new LinkedList();
        list.add((double)(160));
        list.add((double)(591));
        list.add((double)(114));
        list.add((double)(229));
        list.add((double)(230));
        list.add((double)(270));
        list.add((double)(128));
        list.add((double)(1657));
        list.add((double)(624));
        list.add((double)(1503));
        
        DecimalFormat f = new DecimalFormat("##.00");
        
        System.out.println("Tarea No.1 Conceptos Avanzados de Software");
        System.out.println("Tabla de valores n.1:\n");
        for (Iterator i = list.iterator(); i.hasNext();){
            System.out.println((double)i.next());
        }
        System.out.println("\n");
        
        System.out.println("La media de los valores ingresados es:/n");
        System.out.println(f.format(calcula.obtenerMedia(list)) + "\n");
        
        System.out.println("La desviación estándar de los valores ingresados es:/n");
        System.out.println(f.format(calcula.obtenerDesvStdr(list)) + "\n");

        
        LinkedList list1 = new LinkedList();
        list1.add((double)(15.0));
        list1.add((double)(69.9));
        list1.add((double)(6.5));
        list1.add((double)(22.4));
        list1.add((double)(28.4));
        list1.add((double)(65.9));
        list1.add((double)(19.4));
        list1.add((double)(198.7));
        list1.add((double)(38.8));
        list1.add(((double)138.2));
        
        System.out.println("\n");
        
        System.out.println("\n Tabla de valores n.2");
        for (Iterator i = list1.iterator(); i.hasNext();){
            System.out.println((double)i.next());
        }
        
        System.out.println("\n");
        System.out.println("La media de los valores ingresados es:/n");
        System.out.println(f.format(calcula.obtenerMedia(list1)) + "\n");
        
        System.out.println("La desviación estándar de los valores ingresados es:/n");
        System.out.println(f.format(calcula.obtenerDesvStdr(list1)) + "\n");

        
    }
}
