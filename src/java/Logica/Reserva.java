
package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Reserva implements Serializable {
    @Id
    int id_reserva;
    @Temporal(TemporalType.DATE)
    Date checkIn;
    @Temporal(TemporalType.DATE)
    Date checkOut;
     @Temporal(TemporalType.DATE)
    Date fechaDeCarga;
    boolean estaReservada;
    int cantidadPersonas;
    @OneToMany
    List<Habitacion>listaHabitaciones;
    @OneToMany
    List<Huesped>listaHuesped;
     @OneToMany
    List<UsuarioAdmin>listaUsuarios;
    
    

    public Reserva() {
    }

    public Reserva(int id_reserva, Date checkIn, Date checkOut, Date fechaDeCarga, boolean estaReservada, int cantidadPersonas, List<Habitacion> listaHabitaciones, List<Huesped> listaHuesped, List<UsuarioAdmin> listaUsuarios) {
        this.id_reserva = id_reserva;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.fechaDeCarga = fechaDeCarga;
        this.estaReservada = estaReservada;
        this.cantidadPersonas = cantidadPersonas;
        this.listaHabitaciones = listaHabitaciones;
        this.listaHuesped = listaHuesped;
        this.listaUsuarios = listaUsuarios;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getFechaDeCarga() {
        return fechaDeCarga;
    }

    public void setFechaDeCarga(Date fechaDeCarga) {
        this.fechaDeCarga = fechaDeCarga;
    }

    public boolean isEstaReservada() {
        return estaReservada;
    }

    public void setEstaReservada(boolean estaReservada) {
        this.estaReservada = estaReservada;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public List<Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    public void setListaHabitaciones(List<Habitacion> listaHabitaciones) {
        this.listaHabitaciones = listaHabitaciones;
    }

    public List<Huesped> getListaHuesped() {
        return listaHuesped;
    }

    public void setListaHuesped(List<Huesped> listaHuesped) {
        this.listaHuesped = listaHuesped;
    }

    public List<UsuarioAdmin> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<UsuarioAdmin> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

   
    
    
}
