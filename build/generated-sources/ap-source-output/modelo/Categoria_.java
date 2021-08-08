package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Examen;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-08-03T16:13:36", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> nombre_cat;
    public static volatile SingularAttribute<Categoria, Long> id_categoria;
    public static volatile SingularAttribute<Categoria, String> descripcion_cat;
    public static volatile ListAttribute<Categoria, Examen> listaExamen;

}