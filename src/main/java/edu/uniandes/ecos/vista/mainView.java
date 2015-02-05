/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.vista;

import edu.uniandes.ecos.modelo.counterLOC;
import java.io.IOException;
import java.io.PrintWriter;
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
        pw.write("<html>");
        pw.println("<h1>PSP0.1 Programa de conteo de líneas de código</h1>");
        pw.write("Por defecto se lee del directorio resources de esta solución");
        counterLOC cLF = new counterLOC(path);

        pw.println("<b>Número de archivos: </b> " + cLF.getNumTotFiles() + "<br>");
        pw.println("<b>Número de líneas de código: </b> " + cLF.getNumTotLOC() + "<br>");
        pw.println("<b>Número de líneas de comentario: </b> " + cLF.getNumTotLComment() + "<br> ");
        pw.println("<b>Número de líneas en blanco: </b> " + cLF.getNumTotLEmpty() + "<br> ");
        
        pw.write("</html>");
    }

}
