package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Persona;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-08-03T16:13:35", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile ListAttribute<Rol, Persona> listaPersona;
    public static volatile SingularAttribute<Rol, Long> id_rol;
    public static volatile SingularAttribute<Rol, String> nombre_rol;

}