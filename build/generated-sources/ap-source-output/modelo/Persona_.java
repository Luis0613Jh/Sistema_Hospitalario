package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cuenta;
import modelo.HistorialClinico;
import modelo.Rol;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-08-03T16:13:36", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> estado;
    public static volatile SingularAttribute<Persona, String> cedula;
    public static volatile SingularAttribute<Persona, HistorialClinico> historial_clinico;
    public static volatile SingularAttribute<Persona, String> fecha_nacimiento;
    public static volatile SingularAttribute<Persona, String> direccion;
    public static volatile SingularAttribute<Persona, String> estado_civil;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, Rol> rol;
    public static volatile SingularAttribute<Persona, Long> id_persona;
    public static volatile SingularAttribute<Persona, String> apellido;
    public static volatile SingularAttribute<Persona, String> genero;
    public static volatile SingularAttribute<Persona, String> correo;
    public static volatile SingularAttribute<Persona, Cuenta> cuenta;
    public static volatile SingularAttribute<Persona, String> celular;
    public static volatile SingularAttribute<Persona, String> contacto_auxiliar;

}