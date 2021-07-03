
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "examen")
public class Examen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_examen;
    private String nombre;
    private String unidad_medida;
    private String[] valor_referencia;

    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY)
    @JoinColumn(name ="id_categoria",nullable = false, referencedColumnName = "id_categoria" )
    private Categoria categoria;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "laboratorio_examen",
            joinColumns = @JoinColumn(name = "id_examen" , nullable = false, referencedColumnName = "id_examen"),
            inverseJoinColumns = @JoinColumn(name = "id_laboratorio",nullable = false, referencedColumnName = "id_laboratorio")      
    )
    private List<Laboratorio>listaLab = new ArrayList<Laboratorio>();
     
     
    public List<Laboratorio> getListaExamen() {
        return listaLab;
    }

    public void setListaExamen(List<Laboratorio> listaExamen) {
        this.listaLab = listaExamen;
    }
    
    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String[] getValor_referencia() {
        return valor_referencia;
    }

    public void setValor_referencia(String[] valor_referencia) {
        this.valor_referencia = valor_referencia;
    }

    public Long getId_examen() {
        return id_examen;
    }

    public void setId_examen(Long id_examen) {
        this.id_examen = id_examen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_examen != null ? id_examen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id_examen fields are not set
        if (!(object instanceof Examen)) {
            return false;
        }
        Examen other = (Examen) object;
        if ((this.id_examen == null && other.id_examen != null) || (this.id_examen != null && !this.id_examen.equals(other.id_examen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Examen[ id=" + id_examen + " ]";
    }
    
}
