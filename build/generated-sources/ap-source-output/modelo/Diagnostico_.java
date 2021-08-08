package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Consulta;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-08-08T06:11:09", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Diagnostico.class)
public class Diagnostico_ { 

    public static volatile SingularAttribute<Diagnostico, String> enfermedad;
    public static volatile SingularAttribute<Diagnostico, Long> id_diagnostico;
    public static volatile SingularAttribute<Diagnostico, String> motivo_consulta;
    public static volatile SingularAttribute<Diagnostico, Long> id_medico;
    public static volatile SingularAttribute<Diagnostico, Long> id_paciente;
    public static volatile SingularAttribute<Diagnostico, Consulta> consulta;
    public static volatile SingularAttribute<Diagnostico, String> observacion;

}