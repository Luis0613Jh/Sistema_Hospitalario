
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "laboratorio")
public class Laboratorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_laboratorio;
    private String nombre_lab;
    private String descripcion_lab;
    private String id_encargado;

   @ManyToMany(mappedBy = "listaLab",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Examen>listaExamen = new ArrayList<Examen>();

    public List<Examen> getListaExamen() {
        return listaExamen;
    }

    public void setListaExamen(List<Examen> listaExamen) {
        this.listaExamen = listaExamen;
    }
    
    
    public String getNombre_lab() {
        return nombre_lab;
    }

    public void setNombre_lab(String nombre_lab) {
        this.nombre_lab = nombre_lab;
    }

    public String getDescripcion_lab() {
        return descripcion_lab;
    }

    public void setDescripcion_lab(String descripcion_lab) {
        this.descripcion_lab = descripcion_lab;
    }

    public String getId_encargado() {
        return id_encargado;
    }

    public void setId_encargado(String id_encargado) {
        this.id_encargado = id_encargado;
    }

    public Long getId_laboratorio() {
        return id_laboratorio;
    }

    public void setId_laboratorio(Long id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_laboratorio != null ? id_laboratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_laboratorio fields are not set
        if (!(object instanceof Laboratorio)) {
            return false;
        }
        Laboratorio other = (Laboratorio) object;
        if ((this.id_laboratorio == null && other.id_laboratorio != null) || (this.id_laboratorio != null && !this.id_laboratorio.equals(other.id_laboratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Laboratorio[ id=" + id_laboratorio + " ]";
    }
    
}