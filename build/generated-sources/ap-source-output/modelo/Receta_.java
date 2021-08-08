package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Consulta;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-08-08T06:11:09", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Receta.class)
public class Receta_ { 

    public static volatile SingularAttribute<Receta, String> fecha;
    public static volatile SingularAttribute<Receta, String> indicaciones;
    public static volatile SingularAttribute<Receta, Long> id_receta;
    public static volatile SingularAttribute<Receta, Consulta> consulta;

}