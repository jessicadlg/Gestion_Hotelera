package Logica;

import Logica.Habitacion;
import Logica.Huesped;
import Logica.UsuarioAdmin;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-06T14:03:54")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile ListAttribute<Reserva, UsuarioAdmin> listaUsuarios;
    public static volatile SingularAttribute<Reserva, Boolean> estado;
    public static volatile SingularAttribute<Reserva, Date> checkIn;
    public static volatile ListAttribute<Reserva, Habitacion> listaHabitaciones;
    public static volatile SingularAttribute<Reserva, Date> fechaDeCarga;
    public static volatile SingularAttribute<Reserva, Integer> cantidadPersonas;
    public static volatile SingularAttribute<Reserva, Integer> id_reserva;
    public static volatile SingularAttribute<Reserva, Date> checkOut;
    public static volatile ListAttribute<Reserva, Huesped> listaHuesped;

}