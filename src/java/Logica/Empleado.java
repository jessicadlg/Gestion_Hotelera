
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
    Usuario user;
   @OneToMany
    List<Reserva>listaReservas;


    public Empleado() {
    }

    public Empleado(String cargo, double bonificacionesPorDia, Usuario user, List<Reserva> listaReservas, long id_numero, String DNI, String nombre, String apellido, String direccion, Date fechaNac) {
        super(id_numero, DNI, nombre, apellido, direccion, fechaNac);
        this.cargo = cargo;
        this.bonificacionesPorDia = bonificacionesPorDia;
        this.user = user;
        this.listaReservas = listaReservas;
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

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public List<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(List<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public long getId_numero() {
        return id_numero;
    }

    public void setId_numero(long id_numero) {
        this.id_numero = id_numero;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

  }
