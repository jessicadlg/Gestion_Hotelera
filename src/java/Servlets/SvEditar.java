package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
 long id = Long.parseLong(request.getParameter("id"));
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String profesion = request.getParameter("profesion");
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String[] fechaNac = request.getParameter("fechaNac").split("-");
        String diaR = fechaNac[2];
        String mesR = fechaNac[1];
        String annoR = fechaNac[0];
        String fechaNueva = diaR + "/" + mesR + "/" + annoR;
        Date fecha= new Date();
       
        try {
            fecha = formato.parse(fechaNueva);
        } catch (ParseException ex) {
            Logger.getLogger(SvEditar.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        Controladora control = new Controladora();
        Huesped hues =control.buscarHuesped(id);

        hues.setDNI(dni);
        hues.setNombre(nombre);
        hues.setApellido(apellido);
        Date fechaDate = new Date(fechaNueva);
        hues.setFechaNac(fechaDate);
        hues.setDireccion(direccion);
        hues.setProfesion(profesion);

        control.modificarHuesped(hues);
        request.getSession().setAttribute("listaHuespedes", control.traerHuespedes());
        response.sendRedirect("verHuespedes.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));

        Controladora control = new Controladora();
        Huesped hue = control.buscarHuesped(id);

        //seteo
        HttpSession misession = request.getSession();

        misession.setAttribute("huesped", hue);
        response.sendRedirect("modificarHuesped.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
