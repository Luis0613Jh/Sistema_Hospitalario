package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Consulta;
import modelo.Persona;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-08-08T06:11:09", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(HistorialClinico.class)
public class HistorialClinico_ { 

    public static volatile ListAttribute<HistorialClinico, Consulta> ListarConsulta;
    public static volatile SingularAttribute<HistorialClinico, Long> id_historial_clinico;
    public static volatile SingularAttribute<HistorialClinico, String> enfermedad_hereditaria;
    public static volatile SingularAttribute<HistorialClinico, Persona> persona;
    public static volatile SingularAttribute<HistorialClinico, String> habitos;
    public static volatile SingularAttribute<HistorialClinico, String> tipo_sangre;

}