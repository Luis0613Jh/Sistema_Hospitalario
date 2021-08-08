package controlador.DAO;

import controlador.LaboratorioJpaController;
import java.util.List;
import modelo.Laboratorio;

public class LaboratorioDAO {

    private LaboratorioJpaController jpaControlador = new LaboratorioJpaController();
    private Laboratorio laboratorio;

    public Laboratorio getLaboratorio() {
        if (laboratorio == null) {
            laboratorio = new Laboratorio();
        }
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public boolean agregar(Laboratorio laboratorio) {
        try {
            jpaControlador.create(laboratorio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editar(Laboratorio laboratorio) {
        try {
            jpaControlador.edit(laboratorio);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Laboratorio> listar() {
        return jpaControlador.findLaboratorioEntities();
    }
    
    public List<Laboratorio> laboratoriosPorEstado(String estado) {
        return jpaControlador.getLaboratoriosPorEstado(estado);
    }
}
