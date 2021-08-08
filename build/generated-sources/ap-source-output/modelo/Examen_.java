package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Categoria;
import modelo.Laboratorio;
import modelo.Pedido;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-08-03T16:13:36", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Examen.class)
public class Examen_ { 

    public static volatile ListAttribute<Examen, Laboratorio> listaLab;
    public static volatile SingularAttribute<Examen, String> unidad_medida;
    public static volatile SingularAttribute<Examen, Long> id_examen;
    public static volatile SingularAttribute<Examen, Categoria> categoria;
    public static volatile SingularAttribute<Examen, Pedido> pedido;
    public static volatile SingularAttribute<Examen, String[]> valor_referencia;
    public static volatile SingularAttribute<Examen, String> nombre;

}