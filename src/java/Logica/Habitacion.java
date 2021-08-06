package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int id_numHab;
    String piso;
    String tematica;
    double precio;
    String tipoHabitacion;

    public Habitacion() {
    }

    public Habitacion(int id_numHab, String piso, String tematica, double precio, String tipoHabitacion) {
        this.id_numHab = id_numHab;
        this.piso = piso;
        this.tematica = tematica;
        this.precio = precio;
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getId_numHab() {
        return id_numHab;
    }

    public void setId_numHab(int id_numHab) {
        this.id_numHab = id_numHab;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

   

}
