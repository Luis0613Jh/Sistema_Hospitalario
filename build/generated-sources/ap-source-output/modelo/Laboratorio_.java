package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Examen;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-08-08T06:11:09", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Laboratorio.class)
public class Laboratorio_ { 

    public static volatile SingularAttribute<Laboratorio, Long> id_laboratorio;
    public static volatile SingularAttribute<Laboratorio, String> estado;
    public static volatile SingularAttribute<Laboratorio, String> nombre_lab;
    public static volatile SingularAttribute<Laboratorio, Long> id_encargado;
    public static volatile SingularAttribute<Laboratorio, String> descripcion_lab;
    public static volatile SingularAttribute<Laboratorio, Examen> examen;

}