package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    private static UsuarioAdmin usu;
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

    public boolean comprobarIngreso(String usuario, String contra) {
        List<UsuarioAdmin> listaUsuarios = controlPersis.traerUsuarios();

        if (listaUsuarios != null) {
            for (UsuarioAdmin usu : listaUsuarios) {
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

    public void eliminarHabitacion(int id_numero) {
        controlPersis.eliminarHabitacion(id_numero);
    }

    public Habitacion buscarHabitacion(int id_numero) {
        return controlPersis.buscarHabitacion(id_numero);
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
    public void crearAltaUsuario(String usuario, String contra) {
        UsuarioAdmin usu = new UsuarioAdmin();
        usu.setUser(usuario);
        usu.setPassword(contra);
        controlPersis.crearAltaUsuario(usu);

    }

    public List<UsuarioAdmin> traerUsuarios() {
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

    //apartado metodos para reservas
   

    public void crearAltaReserva(String fechaNueva, String fechaNuevaC, String fechaNuevaR, String idHuesped, String cantPersonas, String dni_empleado, String tipoHab) {

       //Habitacion habi = verHabitacion(id_numHab);
        //Huesped hues = verHuesped(id_numero);

        Reserva re = new Reserva();
      //  List<Reserva> listaReservas = controlPersis.traerReservas();
        //List<Habitacion> listaHabitaciones = controlPersis.traerHabitaciones();
           // if(usu!= null){
            //    for (Habitacion listaHabitacione : listaHabitaciones) {
                    
             //   }
           // }
            
        //LO PASO DE STRING A DATE P MANDARLO A LA BD
        Date fechaDateCheckin = new Date(fechaNueva);
        re.setCheckIn(fechaDateCheckin);
        Date fechaDateCheckout = new Date(fechaNuevaC);
        re.setCheckOut(fechaDateCheckout);
        Date fechaDate = new Date(fechaNuevaR);
        re.setFechaDeCarga(fechaDate);

        re.setListaHuesped(null);
        re.setCantidadPersonas(0);
        re.setListaUsuarios(null);
        re.setListaHabitaciones(null);

        controlPersis.crearAltaReserva(re);
    }
/* public void crearAltaHabitacion(String tematica, String piso, String tipoHabitacion, double precio) {
        Habitacion hab = new Habitacion();
        hab.setTematica(tematica);
        hab.setPiso(piso);
        hab.setTipoHabitacion(tipoHabitacion);
        hab.setPrecio(precio);

        controlPersis.crearAltaHabitacion(hab);
    }

    public List<Reserva> traerReservas() {
        return controlPersis.traerReservas();
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

}
