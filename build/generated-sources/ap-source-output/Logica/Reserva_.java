package Logica;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-09T16:10:03")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Huesped> huesped;
    public static volatile SingularAttribute<Reserva, Date> checkIn;
    public static volatile SingularAttribute<Reserva, Empleado> empleado;
    public static volatile SingularAttribute<Reserva, Date> fechaDeCarga;
    public static volatile SingularAttribute<Reserva, Integer> cantidadPersonas;
    public static volatile SingularAttribute<Reserva, Integer> id_reserva;
    public static volatile SingularAttribute<Reserva, Date> checkOut;
    public static volatile SingularAttribute<Reserva, Habitacion> habitacion;

}