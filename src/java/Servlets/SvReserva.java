package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        long idHuesped = Long.parseLong(request.getParameter("idHuesped"));
        int cantP = Integer.parseInt(request.getParameter("cantP"));
        long dni_empleado = Long.parseLong(request.getParameter("dni_empleado"));
        int idHab = Integer.parseInt(request.getParameter("idHab"));

        //pruebo traer p mostrar solo ese id
        /*Habitacion hab = control.buscarHabitacion(idHab);
        
          HttpSession misession = request.getSession();
          misession.setAttribute("habitacion", hab);
         */
 /*traiga la session y asignar los atributos p abrir en cualquier JSP */
        request.getSession().setAttribute("fecha_entrada", fechaNueva);
        request.getSession().setAttribute("fecha_salida", fechaNuevaC);
        request.getSession().setAttribute("fecha_reserva", fechaNuevaR);
        request.getSession().setAttribute("idHuesped", idHuesped);
        request.getSession().setAttribute("cantP", cantP);
        request.getSession().setAttribute("dni_empleado", dni_empleado);
        request.getSession().setAttribute("idHab", idHab);
/*recorro p conseguir el monto segun habitacion*/
        Controladora control = new Controladora();
        List<Habitacion> listaHabitaciones = control.traerHabitaciones();
        double precio = 0;
        for (Habitacion habitacion : listaHabitaciones) {
            if (habitacion.getId_numHab() == (idHab)) {
                precio = habitacion.getPrecio();
            }
        }
        double montoTotal = dias * precio;
        request.getSession().setAttribute("resultado", montoTotal);
        /*System.out.println("T" + montoTotal);
        System.out.println("Iddddddddd" + idHab);
                  System.out.println("pRECIO" + precio);   
        System.out.println("T" + montoTotal);
        System.out.println("MIRAR todas las fechas" + fechaNueva + "-" + fechaNuevaC + "-" + fechaNuevaR);*/
 /*metodo para verificar reserva*/
        Boolean autorizado = control.comprobarReserva(fechaInicio, fechaSalida, idHab);

        if (autorizado == true) {
            control.crearAltaReserva(fechaInicio, fechaSalida, fechaReserva, cantP, idHab, idHuesped, dni_empleado, montoTotal);
            response.sendRedirect("ticketReserva.jsp");

        } else {
            response.sendRedirect("errorReserva.jsp");

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
