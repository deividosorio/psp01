/*
 * Clase que representa la consola
 */
package edu.uniandes.ecos.vista;

import edu.uniandes.ecos.modelo.counterLOC;
import edu.uniandes.ecos.modelo.counterLOCFile;
import java.util.ArrayList;

/**
 *
 * @author deividosorio
 */
public class appConsola {

    public static void main(String[] args) {

        try {
            counterLOC cLF = new counterLOC("./src/main/resources/");
            ArrayList<counterLOCFile> cLOCf = new ArrayList<counterLOCFile>();
            counterLOCFile method;
            
            System.out.println("SUMMARY");
            System.out.println("Número de archivos: " + cLF.getNumTotFiles());
            System.out.println("Número de líneas de código: " + cLF.getNumTotLOC());
            System.out.println("Número de líneas de comentario: " + cLF.getNumTotLComment());
            System.out.println("Número de líneas en blanco: " + cLF.getNumTotLEmpty());
            System.out.println("Número de métodos: " + cLF.getNumTotMethods());

            System.out.println("METHODS");
            cLOCf = cLF.getFiles();
            
            for (int i = 0; i < cLOCf.size(); i++){
                method =  cLOCf.get(i);
                System.out.println("Nombre de método: " + method.getNameMethod() + "");
                System.out.println("LOC del metodo: " + method.getNumLOC() + "");
                System.out.println("Comentarios del metodo: " + method.getNumCommet()+ "");
            }
                        
        } catch (Exception e) {
            System.out.println("Error de null " + e.getMessage());
        }

    }

}
