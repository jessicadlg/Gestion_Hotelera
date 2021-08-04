package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

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

    public void crearAltaEmpleado(String dni, String nombre, String apellido, Date fecha, String direccion, String cargo) {
        Empleado emp = new Empleado();

        emp.setDNI(dni);
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setFechaNac(new Date());
        emp.setDireccion(direccion);
        emp.setCargo(cargo);

        controlPersis.crearAltaEmpleado(emp);
    }

    public void crearAltaHuesped(String dni, String nombre, String apellido, Date fecha, String direccion, String profesion) {
        Huesped hues = new Huesped();

        hues.setDNI(dni);
        hues.setNombre(nombre);
        hues.setApellido(apellido);
        hues.setFechaNac(new Date());
        hues.setDireccion(direccion);
        hues.setProfesion(profesion);

        controlPersis.crearAltaHuesped(hues);
    }

    public void crearAltaHabitacion(String tematica, String piso, String tipoHabitacion, double precio) {
        Habitacion hab = new Habitacion();
        hab.setTemática(tematica);
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

    //Convierte un String a un tipo DATE en formato dd-MM-yyyy
    //@return Retorna la fecha en formato Date
    public static synchronized java.util.Date deStringToDate(String fecha) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); //formato guión
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
