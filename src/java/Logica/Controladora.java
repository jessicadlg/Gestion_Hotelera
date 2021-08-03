package Logica;

import Persistencia.ControladoraPersistencia;
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

    public Date deStringToDate(String fechaNac) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
       
    

   
    

}
