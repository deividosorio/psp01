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
            System.out.println("Número de archivos en directorio: " + cLF.getNumTotFiles());
            System.out.println("Número de líneas de código: " + cLF.getNumTotLOC());
            System.out.println("Número de líneas de comentario: " + cLF.getNumTotLComment());
            System.out.println("Número de líneas en blanco: " + cLF.getNumTotLEmpty());
            System.out.println("Número de métodos: " + cLF.getNumTotMethods());
            System.out.println("\n");
            System.out.println("METHODS");
            cLOCf = cLF.getFiles();

            for (int i = 0; i < cLOCf.size(); i++) {
                method = cLOCf.get(i);
                System.out.println("\n");
                System.out.println("Nombre de Archivo: " + method.getNameFile() + "");
                System.out.println("Número de Méthodos del archivo: " + method.getNumMethods()+ "");
                System.out.println("Número de LOC del archivo: " + method.getNumLOC() + "");
                System.out.println("Número de Comentarios del archivo: " + method.getNumCommet() + "");
                System.out.println("Número de Líneas vacías del archivo: " + method.getNumEmpty() + "");
            }

        } catch (Exception e) {
            System.out.println("Error de null " + e.getMessage());
        }

    }

}
