
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

    public Reserva(int id_reserva, Date checkIn, Date checkOut, boolean estaReservada, int cantidadPersonas) {
        this.id_reserva = id_reserva;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.estaReservada = estaReservada;
        this.cantidadPersonas = cantidadPersonas;
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
    
    
}
