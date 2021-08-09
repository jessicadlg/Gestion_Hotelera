package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

    public boolean comprobarIngreso(String usuario, String contra) {
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();

        if (listaUsuarios != null) {
            for (Usuario usu : listaUsuarios) {
                if (usu.getUser().equals(usuario) && usu.getPassword().equals(contra)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void crearAltaHabitacion(String tematica, String piso, String tipoHabitacion, double precio) {
        Habitacion hab = new Habitacion();
        hab.setTematica(tematica);
        hab.setPiso(piso);
        hab.setTipoHabitacion(tipoHabitacion);
        hab.setPrecio(precio);

        controlPersis.crearAltaHabitacion(hab);
    }

    public List<Habitacion> traerHabitaciones() {
        return controlPersis.traerHabitaciones();
    }

    public void eliminarHabitacion(int id) {
        controlPersis.eliminarHabitacion(id);
    }

    public Habitacion buscarHabitacion(int id) {
        return controlPersis.buscarHabitacion(id);
    }

    public void modificarHabitacion(Habitacion hab) {
        controlPersis.modificarHabitacion(hab);
    }

    public void crearAltaEmpleado(String dni, String nombre, String apellido, String direccion, String cargo, String fechaNueva) {
        Empleado emp = new Empleado();

        emp.setDNI(dni);
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        //LO PASO DE STRING A DATE P MANDARLO A LA BD
        Date fechaDate = new Date(fechaNueva);
        emp.setFechaNac(fechaDate);
        emp.setDireccion(direccion);
        emp.setCargo(cargo);
        emp.setBonificacionesPorDia(0);
        emp.setUser(null);
        controlPersis.crearAltaEmpleado(emp);
    }

    public void crearAltaHuesped(String dni, String nombre, String apellido, String direccion, String profesion, String fechaNueva) {
        Huesped hues = new Huesped();

        hues.setDNI(dni);
        hues.setNombre(nombre);
        hues.setApellido(apellido);
        Date fechaDate = new Date(fechaNueva);
        hues.setFechaNac(fechaDate);
        hues.setDireccion(direccion);
        hues.setProfesion(profesion);

        controlPersis.crearAltaHuesped(hues);
    }

    public void crearAltaUsuario(String usuario, String contra) {
        Usuario usu = new Usuario();
        usu.setUser(usuario);
        usu.setPassword(contra);
        controlPersis.crearAltaUsuario(usu);

    }

    public List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }

    public List<Empleado> traerEmpleados() {
        return controlPersis.traerEmpleados();
    }

    public void eliminarEmpleado(long id_numero) {
        controlPersis.eliminarEmpleado(id_numero);
    }

    public Empleado buscarEmleado(long id_numero) {
        return controlPersis.buscarEmpleado(id_numero);
    }

    public void modificarEmpleado(Empleado emp) {
        controlPersis.modificarEmpleado(emp);
    }

    public List<Huesped> traerHuespedes() {
        return controlPersis.traerHuespedes();
    }

    public void eliminarHuesped(long id_numero) {
        controlPersis.eliminarEmpleado(id_numero);
    }

    public Empleado buscarHuesped(long id_numero) {
        return controlPersis.buscarEmpleado(id_numero);
    }

    public void modificarHuesped(Huesped hues) {
        controlPersis.modificarHuesped(hues);
    }

    public Boolean comprobarReserva(Date fechaInicio, Date fechaSalida, int idHab) {
        Reserva nuevaReserva = new Reserva();
        List<Reserva> listaReservas = controlPersis.traerReservas();
        List<Habitacion> listaHabitaciones = controlPersis.traerHabitaciones();
        for (Habitacion habi : listaHabitaciones) {
            if (habi.getId_numHab() == (idHab)) {
                listaReservas = habi.getListaReservas();
                System.out.println("listadoR" + listaReservas);
                return true;
            } else {
                System.out.println("NO ENTRO A A HABITACION");
            }
                        /*
        //if (listaReservas != null) {
        for (Reserva re : listaReservas) {
            if (re.getHabitacion().getId_numHab() == (idHab)) {
                System.out.println("NO SE PUEDE HACER LA RESERVA");

                return false;
            } else {
                System.out.println("si RESERVA");
                re.setCheckIn(fechaInicio);
                re.setCheckOut(fechaSalida);
                              //  re.setHabitacion(idHab);
            }
        }
            return true;
        }*/
        }
        return false;
    }
        //mi metodo:
         public void crearAltaReserva(Date fechaInicio, Date fechaSalida, Date fechaReserva, int cantP, int idHab, long idHuesped, long dni_empleado,double montoTotal) {
             Reserva re = new Reserva();
             List<Habitacion> listaHabitaciones = controlPersis.traerHabitaciones();
            
         }

        ///////////////////////////////////ADAPTANDO A MARCE
    /*public Boolean crearReserva(Date fechaInicio, Date fechaSalida, Date fechaReserva, int dias, int cantP,
            int idHab, long idHuesped, long id_empleado) {
        List<Habitacion> listaHabitaciones = controlPersis.traerHabitaciones();
        //=!     Empleado emple = traerEmpleados(id_empleado);
        //=!   Huesped hue = traerHuesped(id_Huesped);
        //=!
        Habitacion habi = buscarHabitacion(idHab);

        //falta id_reserva
        // Reserva reser = new Reserva(fechaInicio,fechasal,dias,cant_personas,id_habitacion,id_Huesped,id_empleado);
        List<Reserva> listaReservas = traerReservas();

        for (Reserva reser : listaReservas) {
            if (habi.getId_numHab() == idHab && fechaInicio == reser.getCheckOut() && fechaSalida == reser.getCheckOut()) {

                System.out.println("NO SE PUEDE HACER LA RESERVA");
                return false;
            } else {
                reser.setCheckIn(fechaInicio);
                reser.setCheckOut(fechaSalida);
                reser.setFechaDeCarga(fechaReserva);
                reser.setCantidadPersonas(cantP);

                controlPersis.crearReserva(reser);
                return true;
            }
        }
    }
*/
//fin
    public List<Reserva> traerReservas() {
        return controlPersis.traerReservas();
    }
//final ult llave
}

//public boolean crear(Date checkin, Date checkout, Date fechaDeReserva, int cantDias,int id_numHab , int cantPersonas,int id_reserva) {}
/* int id_reserva = retornarUltIdReserva();
    Huesped hues = verHuesped(id_numero);
    Habitacion hab = verHabitacion(id_numHab);
    Reserva nuevaRes = new Reserva(id_reserva, checkin, checkout, cantDias, tematica, cantPersonas, id_usuario, id_numero);
    List<Reserva> listadoReservas = cp.traerReservas();
    List<Habitacion> listadoHabitaciones = cp.traerHabitaciones();
        for(Reserva res: listadoReservas){
            if(res.get?algdehabitacion().getId_numHab() == tematica.getId_numHab()){
              if(nuevaRes.getCheckIn().after(res.getCheckIn()) && nuevaRes.getCheckIn().before(res.getCheckOut())){
                  System.out.println("esta mal:la nueva reserva esta dentro del rango de fechas de una reserva existente");
                  return true;
              }
              ?
            }
}*/
///////////////////////4 metodos para abm
/* public void crearAltaHabitacion(String tematica, String piso, String tipoHabitacion, double precio) {
        Habitacion hab = new Habitacion();
        hab.setTematica(tematica);
        hab.setPiso(piso);
        hab.setTipoHabitacion(tipoHabitacion);
        hab.setPrecio(precio);

        controlPersis.crearAltaHabitacion(hab);
    }

   

    public void eliminarHabitacion(int id_numero) {
        controlPersis.eliminarHabitacion(id_numero);
    }

    public Habitacion buscarReserva(int id_numero) {
        return controlPersis.buscarReserva(id_numero);
    }

    public void modificarHabitacion(Habitacion hab) {
        controlPersis.modificarHabitacion(hab);
    }

 */
