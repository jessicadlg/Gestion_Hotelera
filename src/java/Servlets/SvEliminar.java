
package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEliminar", urlPatterns = {"/SvEliminar"})
public class SvEliminar extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 long id = Long.parseLong(request.getParameter("id"));
        System.out.println("la ID ES "  + id);
        
       Controladora control = new Controladora();
        control.eliminarHuesped(id);
     
        response.sendRedirect("verHuespedes.jsp");
    }

      @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
