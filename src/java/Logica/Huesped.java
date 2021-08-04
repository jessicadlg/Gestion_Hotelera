
package Logica;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;

@Entity 
public class Huesped extends Persona{
    @Basic
    String profesion;
   
    public Huesped() {
    }

    public Huesped(String profesion, long id_numero, String DNI, String nombre, String apellido, String direccion, Date fechaNac) {
        super(id_numero, DNI, nombre, apellido, direccion, fechaNac);
        this.profesion = profesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
   
}
