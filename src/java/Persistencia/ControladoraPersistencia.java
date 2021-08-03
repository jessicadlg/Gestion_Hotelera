
package Persistencia;

import Logica.Empleado;
import Logica.UsuarioAdmin;
import java.util.List;


public class ControladoraPersistencia {
    
    PersonaJpaController pacJpa = new PersonaJpaController();
    HabitacionJpaController habJpa = new HabitacionJpaController();
    HuespedJpaController hueJpa = new HuespedJpaController();
    EmpleadoJpaController empJpa = new EmpleadoJpaController();
    ReservaJpaController reserJpa = new ReservaJpaController();
    UsuarioAdminJpaController usuJpa = new UsuarioAdminJpaController();
    
     public List<UsuarioAdmin> traerUsuarios() {
        return usuJpa.findUsuarioAdminEntities();
    }
     
    public void crearAltaEmpleado(Empleado emp) {
        empJpa.create(emp);
    }
}
