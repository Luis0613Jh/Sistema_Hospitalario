package controlador.DAO;

import controlador.MedicoJpaController;
import java.util.ArrayList;
import java.util.List;
import modelo.Medico;

public class MedicoDAO {
    private MedicoJpaController medicoJpa = new MedicoJpaController();
    private Medico medico;

    public Medico getMedico() {
        if(this.medico == null){
            this.medico = new Medico();
        }
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public Medico buscarMedico(Medico medico){
        Medico aux = new Medico();
        try {
            aux = medicoJpa.findMedico(medico.getId_persona());
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }
    
     public Medico buscarMedicoid(long id) {
        Medico aux = new Medico();
        try {
            aux = medicoJpa.findMedico(id);
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }
    
    public boolean agregarMedico(Medico medico){
        try {
            medicoJpa.create(medico);
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
    }
    
     public List listarMedicos(){
        List<Medico> listaMedico = new ArrayList<Medico>();
        try {
            listaMedico = medicoJpa.findMedicoEntities();
            return listaMedico;
        } catch (Exception e) {
            return listaMedico;
        }
    }

    public List<Medico> filtrarPor_EstadoDiponibilidad_IdRol(Long idRol, String estadoDisponibilidad) {
        List<Medico> listaMedicos = getMedicosPorEstado("activo");
        List<Medico> listaMedicosPorEstadoDisponibilidad = new ArrayList<Medico>();

        for (Medico medico : listaMedicos) {
            if (medico.getEstado_disponibilidad().equalsIgnoreCase(estadoDisponibilidad) && medico.getRol().getId_rol() == idRol) {
                listaMedicosPorEstadoDisponibilidad.add(medico);
            }
        }
        return listaMedicosPorEstadoDisponibilidad;
    }

    /**
     * Método que devuelve una lista con todos los medicos que cumplan con el
     * estado indicado.
     *
     * @param estado Estado por el cual se van a filtar los medicos, es de tipo String.
     * @return Retorna una lista de tipo List.
     */
    public List<Medico> getMedicosPorEstado(String estado) {
        List<Medico> listaMedicos = listarMedicos();
        List<Medico> listaMedicosPorEstado = new ArrayList<Medico>();
        for (Medico medico : listaMedicos) {
            if(medico.getEstado().equalsIgnoreCase(estado)) {
                listaMedicosPorEstado.add(medico);
            }
        }
        return listaMedicosPorEstado;
    }

    public boolean editarMedico(Medico medico) {
        try {
            medicoJpa.edit(medico);
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
    }
}
