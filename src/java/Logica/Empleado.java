
package Logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Empleado extends Persona{
    
    @Basic
    String cargo;
    double bonificacionesPorDia;
    @OneToOne
    UsuarioAdmin user;


    public Empleado() {
    }

    public Empleado(String cargo, double bonificacionesPorDia, UsuarioAdmin user, long id_numero, String DNI, String nombre, String apellido, String direccion, Date fechaNac) {
        super(id_numero, DNI, nombre, apellido, direccion, fechaNac);
        this.cargo = cargo;
        this.bonificacionesPorDia = bonificacionesPorDia;
        this.user = user;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getBonificacionesPorDia() {
        return bonificacionesPorDia;
    }

    public void setBonificacionesPorDia(double bonificacionesPorDia) {
        this.bonificacionesPorDia = bonificacionesPorDia;
    }

    public UsuarioAdmin getUser() {
        return user;
    }

    public void setUser(UsuarioAdmin user) {
        this.user = user;
    }

    

}
