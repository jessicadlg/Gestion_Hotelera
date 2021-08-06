package Servlets;

import Logica.Controladora;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvHabitacion", urlPatterns = {"/SvHabitacion"})
public class SvHabitacion extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*traiga los datos del JSP */
        String tematica = request.getParameter("tematica");
        String piso = request.getParameter("piso");
        String tipoHabitacion = request.getParameter("tipo");
        double precio = Double.parseDouble(request.getParameter("precio"));


        /*traiga la session y asignar los atributos p abrir en cualquier JSP */
        request.getSession().setAttribute("tematica", tematica);
        request.getSession().setAttribute("piso", piso);
        request.getSession().setAttribute("tipo", tipoHabitacion);
        request.getSession().setAttribute("precio", precio);

        /*conecto cn la logica */
        Controladora control = new Controladora();
        
        try {
            control.crearAltaHabitacion(tematica,piso,tipoHabitacion,precio);
        } catch (Exception ex) {
            Logger.getLogger(SvHabitacion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        /*armar la respuesta */
        response.sendRedirect("altaCorrecta.jsp");

   }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
