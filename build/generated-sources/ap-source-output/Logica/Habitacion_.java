package Logica;

import Logica.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-09T16:10:03")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, String> piso;
    public static volatile SingularAttribute<Habitacion, Double> precio;
    public static volatile SingularAttribute<Habitacion, String> tematica;
    public static volatile ListAttribute<Habitacion, Reserva> listaReservas;
    public static volatile SingularAttribute<Habitacion, Integer> id_numHab;
    public static volatile SingularAttribute<Habitacion, String> tipoHabitacion;

}