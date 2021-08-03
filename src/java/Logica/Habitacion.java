package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Habitacion implements Serializable {

    @Id
    String id_numero;
    String piso;
    String temática;
    double precio;
    String tipoHabitacion;

    public Habitacion() {
    }

    public Habitacion(String id_numero, String piso, String temática, double precio, String tipoHabitacion) {
        this.id_numero = id_numero;
        this.piso = piso;
        this.temática = temática;
        this.precio = precio;
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getId_numero() {
        return id_numero;
    }

    public void setId_numero(String id_numero) {
        this.id_numero = id_numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getTemática() {
        return temática;
    }

    public void setTemática(String temática) {
        this.temática = temática;
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
