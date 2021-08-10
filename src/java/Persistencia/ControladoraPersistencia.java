
package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    PersonaJpaController pacJpa = new PersonaJpaController();
    HabitacionJpaController habJpa = new HabitacionJpaController();
    HuespedJpaController hueJpa = new HuespedJpaController();
    EmpleadoJpaController empJpa = new EmpleadoJpaController();
    ReservaJpaController reserJpa = new ReservaJpaController();
    UsuarioAdminJpaController usuJpa = new UsuarioAdminJpaController();
    
     public List<Usuario> traerUsuarios() {
        return usuJpa.findUsuarioAdminEntities();
    }
       
    public void crearAltaHabitacion(Habitacion hab) {
        try {
            habJpa.create(hab);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Habitacion> traerHabitaciones() {
        return habJpa.findHabitacionEntities();
    }
    public void eliminarHabitacion(int id) {
        try {
           habJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public Habitacion buscarHabitacion(int id) {
        return habJpa.findHabitacion(id);
    }
     public void modificarHabitacion(Habitacion hab){
        try {
            habJpa.edit(hab);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void crearAltaEmpleado(Empleado emp) {
        empJpa.create(emp);
    }
       public List<Empleado> traerEmpleados() {
        return empJpa.findEmpleadoEntities();
    }
       public void eliminarEmpleado(long id_numero) {
        try {
            empJpa.destroy(id_numero);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Empleado buscarEmpleado(long id_numero) {
        return empJpa.findEmpleado(id_numero);
    }
    public void modificarEmpleado(Empleado emp) {
        try {
            empJpa.edit(emp);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void crearAltaHuesped(Huesped hues) {
        hueJpa.create(hues);
    }
    public List<Huesped> traerHuespedes() {
        return hueJpa.findHuespedEntities();
    }
       public void eliminarHuesped(long id_numero) {
        try {
            hueJpa.destroy(id_numero);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Huesped buscarHuesped(long id_numero) {
        return hueJpa.findHuesped(id_numero);
    }
    public void modificarHuesped(Huesped hues) {
        try {
            hueJpa.edit(hues);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearAltaUsuario(Usuario usu) {
        try {
            usuJpa.create(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void crearAltaReserva(Reserva re) {
        try {
            reserJpa.create(re);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public List<Reserva> traerReservas() {
        return reserJpa.findReservaEntities();
    }
   
}
