
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_consulta;
    @Column(length = 10, unique=true)
    private Long id_paciente;
    private Long id_medico;
    private String hora_cita;
    private String fecha_cita;
    @ManyToOne(cascade = CascadeType.REFRESH , fetch = FetchType.LAZY)
    @JoinColumn(name = "id_historial_clinico", nullable=false,referencedColumnName="id_historial_clinico")
    private HistorialClinico historial_clinico;
    
    @OneToOne(mappedBy="consulta",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Receta receta;
    
    

    public Receta getRecera() {
        return receta;
    }

    public void setRecera(Receta recera) {
        this.receta = recera;
    }
    
    
    
    public HistorialClinico getHistorial_clinico() {
        return historial_clinico;
    }

    public void setHistorial_clinico(HistorialClinico historial_clinico) {
        this.historial_clinico = historial_clinico;
    }

    
    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Long getId_medico() {
        return id_medico;
    }

    public void setId_medico(Long id_medico) {
        this.id_medico = id_medico;
    }

    public String getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(String hora_cita) {
        this.hora_cita = hora_cita;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }
    
    

    public Long getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(Long id_consulta) {
        this.id_consulta = id_consulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_consulta != null ? id_consulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_consulta fields are not set
        if (!(object instanceof Consulta)) {
            return false;
        }
        Consulta other = (Consulta) object;
        if ((this.id_consulta == null && other.id_consulta != null) || (this.id_consulta != null && !this.id_consulta.equals(other.id_consulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Consulta[ id=" + id_consulta + " ]";
    }
    
}
