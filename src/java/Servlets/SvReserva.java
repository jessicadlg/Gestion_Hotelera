package Servlets;

import Logica.Controladora;
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


@WebServlet(name = "SvReserva", urlPatterns = {"/SvReserva"})
public class SvReserva extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*traiga los datos del JSP */
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String[] checkinJSP = request.getParameter("fecha_entrada").split("-");
        String dia = checkinJSP[2];
        String mes = checkinJSP[1];
        String anno = checkinJSP[0];
        String fechaNueva = dia + "/" + mes + "/" + anno;
//
        Date fechaInicio = new Date();
        try {
            fechaInicio = formato.parse(fechaNueva);
        } catch (ParseException ex) {
            Logger.getLogger(SvReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String[] checkoutJSP = request.getParameter("fecha_salida").split("-");
        String diaC = checkoutJSP[2];
        String mesC = checkoutJSP[1];
        String annoC = checkoutJSP[0];
        String fechaNuevaC = diaC + "/" + mesC + "/" + annoC;
        System.out.println("mIRARRRRR: " + fechaNuevaC);

        Date fechaSalida = new Date();
        try {
            fechaSalida = formato.parse(fechaNuevaC);
        } catch (ParseException ex) {
            Logger.getLogger(SvReserva.class.getName()).log(Level.SEVERE, null, ex);
        }

        int milisecondsByDay = 86400000;
        int dias = (int) ((fechaSalida.getTime() - fechaInicio.getTime()) / milisecondsByDay);

        System.out.println("varible mIRARRRRR: " + dias);

        String[] fecha_reserva = request.getParameter("fecha_reserva").split("-");
        String diaR = fecha_reserva[2];
        String mesR = fecha_reserva[1];
        String annoR = fecha_reserva[0];
        String fechaNuevaR = diaR + "/" + mesR + "/" + annoR;
        
        Date fechaReserva = new Date();
        try {
             fechaReserva = formato.parse(fechaNuevaR);
        } catch (ParseException ex) {
            Logger.getLogger(SvReserva.class.getName()).log(Level.SEVERE, null, ex);
        }

        String idHuesped = request.getParameter("idHuesped");
        String cantPersonas = request.getParameter("cantPersonas");
        String dni_empleado = request.getParameter("dni_empleado");
        String tipoHab = request.getParameter("tipoHab");

        /*traiga la session y asignar los atributos p abrir en cualquier JSP */
        request.getSession().setAttribute("fecha_entrada", checkinJSP);
        request.getSession().setAttribute("fecha_salida", checkoutJSP);
        request.getSession().setAttribute("fecha_reserva", fecha_reserva);
        request.getSession().setAttribute("idHuesped", idHuesped);
        request.getSession().setAttribute("cantPersonas", cantPersonas);
        request.getSession().setAttribute("dni_empleado", dni_empleado);
        request.getSession().setAttribute("tipoHab", tipoHab);

        /*conecto cn la logica */
        Controladora control = new Controladora();
        control.crearAltaReserva(fechaNueva, fechaNuevaC, fechaNuevaR, idHuesped, cantPersonas, dni_empleado, tipoHab);
        System.out.println("MIRAR" +fechaNueva  + "-" + fechaNuevaC + "-" + fechaNuevaR);
        /*armar la respuesta */
        response.sendRedirect("altaCorrecta.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
