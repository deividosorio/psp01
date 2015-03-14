package edu.uniandes.ecos.controlador;

import edu.uniandes.ecos.vista.mainView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;

/**
 * Clase vista de visualización que se encarga que hacer 
 * la orquestación entre el mundo y la vista
 */
public class App extends HttpServlet {

    public static void main(String[] args) {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new App()), "/*");
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método doGet para llamar la vista con la dirección donde está el 
     * archivo y los archivos del código fuente a contar
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        try{
            mainView.home(req, resp, "./src/main/resources/");
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            mainView.home(req, resp, "resources/");
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
