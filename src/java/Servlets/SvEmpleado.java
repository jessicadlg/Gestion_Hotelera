package Servlets;

import Logica.Controladora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

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
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String cargo = request.getParameter("cargo");
        String[] fechaNac = request.getParameter("fechaNac").split("-");

        String dia = fechaNac[1];
        String mes = fechaNac[2];
        String anno = fechaNac[0];

        String fechaNueva = dia + "/" + mes + "/" + anno;


        /*traiga la session y asignar los atributos p abrir en cualquier JSP */
        request.getSession().setAttribute("dni", dni);
        request.getSession().setAttribute("nombre", nombre);
        request.getSession().setAttribute("apellido", apellido);
        request.getSession().setAttribute("direccion", direccion);
        request.getSession().setAttribute("cargo", cargo);
        request.getSession().setAttribute("fechaNac", fechaNac);

        /*conecto cn la logica */
        Controladora control = new Controladora();
        
           control.crearAltaEmpleado(dni, nombre, apellido, direccion, cargo,fechaNueva);

        System.out.println("nueva FECHAA:  " + fechaNueva);/*armar la respuesta */
        response.sendRedirect("altaCorrecta.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
