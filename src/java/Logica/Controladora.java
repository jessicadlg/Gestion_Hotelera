package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public Empleado buscarEmpleado(long id_numero) {
        return controlPersis.buscarEmpleado(id_numero);
    }

    public void modificarEmpleado(Empleado emp) {
        controlPersis.modificarEmpleado(emp);
    }

    public List<Huesped> traerHuespedes() {
        return controlPersis.traerHuespedes();
    }

    public void eliminarHuesped(long id_numero) {
        controlPersis.eliminarHuesped(id_numero);
    }

    public Huesped buscarHuesped(long id_numero) {
        return controlPersis.buscarHuesped(id_numero);
    }

    public void modificarHuesped(Huesped hues) {
        controlPersis.modificarHuesped(hues);
    }

    /*public String comprobarReserva(Date fechaInicio, Date fechaSalida, int idHab) {
        try {
            List<Reserva> reservas = controlPersis.traerReservas();
            List<Habitacion> habitaciones = controlPersis.traerHabitaciones();
                     if (idHab != 0) {
                for (Habitacion habitacion : habitaciones) {
                    if (habitacion.getId_numHab() == idHab) {
                      habitacion.getId_numHab();
                        System.out.println("valor id hab  N° " + habitacion.getId_numHab());
                        for (Reserva reser : reservas) {
                            if (reser.getHabitacion().getId_numHab() == habitacion.getId_numHab()) {
                                System.out.println("COINCIDEN NHABI DE LA RESERVA C EL DE LA HAB");
                                if (((reser.getCheckIn().after(fechaInicio)) && (reser.getCheckOut().after(fechaSalida))) || ((reser.getCheckIn().before(fechaInicio)) && (reser.getCheckOut().before(fechaSalida)))) {
                                    System.out.println("entramos  a las fechassssssssssss");
                                    return "si";
                                }
                            }
                        }
                    } else {
                        return "No se pudo ";
                    }
                }
            } else {
                return "No se pudo ";
            }
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "No se pudo ";
    }*/
    public Boolean comprobarReserva(Date fechaInicio, Date fechaSalida, int idHab) {
        List<Reserva> listaReservas = controlPersis.traerReservas();
        List<Habitacion> listaHabitaciones = controlPersis.traerHabitaciones();

        for (Habitacion habi : listaHabitaciones) {
            if (habi.getId_numHab() == (idHab)) {
                System.out.println("valor id hab  N° " + idHab);
               /* for (Reserva reser : listaReservas) {
                    if (reser.getHabitacion().getId_numHab() == habi.getId_numHab()) {
                        System.out.println("entra");

                        if (((reser.getCheckIn().after(fechaInicio)) && (reser.getCheckOut().after(fechaSalida)))
                                || ((reser.getCheckIn().before(fechaInicio)) && (reser.getCheckOut().before(fechaSalida)))) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
    }*/ 
                listaReservas = habi.getListaReservas();
                return true;
            } else {
                System.out.println("NO ENTRO A A HABITACION");
            }
            System.out.println("NO ENTRO A A HABITACION");
        }
        return false;
    }


    public void crearAltaReserva(Date fechaInicio, Date fechaSalida, Date fechaReserva, long idHuesped, int cantP, int idHab, long idEmp, double montoTotal) {
        Reserva reser = new Reserva();
        Empleado emp = buscarEmpleado(idEmp);
        Habitacion hab = buscarHabitacion(idHab);
        Huesped hue = buscarHuesped(idHuesped);
        reser.setCheckIn(fechaInicio);
        reser.setCheckOut(fechaSalida);
        reser.setFechaDeCarga(fechaReserva);
        reser.setEmpleado(emp);
        reser.setCantidadPersonas(cantP);
        reser.setHuesped(hue);
        reser.setHabitacion(hab);
    }

    public List<Reserva> traerReservas() {
        return controlPersis.traerReservas();
    }

    

}
