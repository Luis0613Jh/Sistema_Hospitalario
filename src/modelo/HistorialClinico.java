/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author CNH
 */
@Entity
@Table(name = "historial_clinico")
public class HistorialClinico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_historial_clinico;
    private Long id_paciente;
    private String[] enfermedad;
    private String[] enfermedad_hereditaria;
    private String observacion;
    @OneToMany(mappedBy="historial_clinico",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Consulta>ListarConsulta=new ArrayList<Consulta>();

    public List<Consulta> getListarConsulta() {
        return ListarConsulta;
    }

    public void setListarConsulta(List<Consulta> ListarConsulta) {
        this.ListarConsulta = ListarConsulta;
    }
    
    public Long getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Long id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String[] getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String[] enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String[] getEnfermedad_hereditaria() {
        return enfermedad_hereditaria;
    }

    public void setEnfermedad_hereditaria(String[] enfermedad_hereditaria) {
        this.enfermedad_hereditaria = enfermedad_hereditaria;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getId_historial_clinico() {
        return id_historial_clinico;
    }

    public void setId_historial_clinico(Long id_historial_clinico) {
        this.id_historial_clinico = id_historial_clinico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_historial_clinico != null ? id_historial_clinico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_historial_clinico fields are not set
        if (!(object instanceof HistorialClinico)) {
            return false;
        }
        HistorialClinico other = (HistorialClinico) object;
        if ((this.id_historial_clinico == null && other.id_historial_clinico != null) || (this.id_historial_clinico != null && !this.id_historial_clinico.equals(other.id_historial_clinico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.HistorialClinico[ id=" + id_historial_clinico + " ]";
    }

}
