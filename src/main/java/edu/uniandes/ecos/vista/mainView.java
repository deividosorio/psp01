/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.vista;

import edu.uniandes.ecos.modelo.counterLOC;
import edu.uniandes.ecos.modelo.counterLOCFile;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author deividosorio
 */
public class mainView {

    public static void home(HttpServletRequest req, HttpServletResponse resp, String path)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        counterLOC cLF = new counterLOC(path);
        ArrayList<counterLOCFile> cLOCf = new ArrayList<counterLOCFile>();
        counterLOCFile method;

        pw.write("<html>");
        pw.println("<h1>PSP0.1 Programa de conteo de líneas de código</h1>");
        pw.write("Por defecto se lee del directorio resources de esta solución");

        pw.println("<b>SUMMARY </b>");
        pw.println("<b>Número de archivos en directorio:: </b> " + cLF.getNumTotFiles() + "<br>");
        pw.println("<b>Número total de líneas de código: </b> " + cLF.getNumTotLOC() + "<br>");
        pw.println("<b>Número total de líneas de comentario: </b> " + cLF.getNumTotLComment() + "<br> ");
        pw.println("<b>Número total de líneas en blanco: </b> " + cLF.getNumTotLEmpty() + "<br> ");
        pw.println("<b>Número total de métodos: </b> " + cLF.getNumTotMethods() + "<br> ");

        pw.write("<br>");
        pw.write("METHODS");

        for (int i = 0; i < cLOCf.size(); i++) {
            method = cLOCf.get(i);
            pw.println("\n");
            pw.println("<b>Nombre de Archivo:</b> " + method.getNameFile() + "");
            pw.println("<b>Número de Méthodos del archivo:</b> " + method.getNumMethods() + "");
            pw.println("<b>Número de LOC del archivo:</b> " + method.getNumLOC() + "");
            pw.println("<b>Número de Comentarios del archivo:</b> " + method.getNumCommet() + "");
            pw.println("<b>Número de Líneas vacías del archivo:</b> " + method.getNumEmpty() + "");
        }

        pw.write("</html>");
    }

}
