
package Logica;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity 
public class Huesped extends Persona{
    @Basic
    String profesion;
    @OneToMany
    List<Reserva>listaReservas;
    
    public Huesped() {
    }

    public Huesped(String profesion, List<Reserva> listaReservas, long id_numero, String DNI, String nombre, String apellido, String direccion, Date fechaNac) {
        super(id_numero, DNI, nombre, apellido, direccion, fechaNac);
        this.profesion = profesion;
        this.listaReservas = listaReservas;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

   

}
