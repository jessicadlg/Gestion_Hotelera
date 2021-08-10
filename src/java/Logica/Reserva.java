package Logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id_reserva;
    @Temporal(TemporalType.DATE)
    Date checkIn;
    @Temporal(TemporalType.DATE)
    Date checkOut;
    @Temporal(TemporalType.DATE)
    Date fechaDeCarga;
    int cantidadPersonas;
    @ManyToOne
    Habitacion habitacion;
    @ManyToOne
    Huesped huesped;
    @ManyToOne
   Empleado empleado;

    public Reserva() {
    }

    public Reserva(int id_reserva, Date checkIn, Date checkOut, Date fechaDeCarga, int cantidadPersonas, Habitacion habitacion, Huesped huesped, Usuario usuario) {
        this.id_reserva = id_reserva;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.fechaDeCarga = fechaDeCarga;
        this.cantidadPersonas = cantidadPersonas;
        this.habitacion = habitacion;
        this.huesped = huesped;
       // this.usuario = usuario;
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

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    

    

   
}
