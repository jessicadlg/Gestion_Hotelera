package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Habitacion;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_numero = Integer.parseInt(request.getParameter("id_numero"));
        String tematica = request.getParameter("tematica");
        String piso = request.getParameter("piso");
        String tipoHabitacion = request.getParameter("tipo");
        double precio = Double.parseDouble(request.getParameter("precio"));


        Controladora control = new Controladora();
        Habitacion hab = control.buscarHabitacion(id_numero);
        hab.setTemática(tematica);
        hab.setPiso(piso);
        hab.setTipoHabitacion(tipoHabitacion);
        hab.setPrecio(precio);
       
        control.modificarHabitacion(hab);
        request.getSession().setAttribute("listaHabitaciones",control.traerHabitaciones());
        response.sendRedirect("verHabitaciones.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_numero = Integer.parseInt(request.getParameter("id_numero"));

        Controladora control = new Controladora();
        Habitacion hab = control.buscarHabitacion(id_numero);

        //seteo
        HttpSession misession = request.getSession();

        misession.setAttribute("habitacion", hab);
        response.sendRedirect("modificarHabitacion.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
