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

    
    public boolean editarMedico(Medico medico){
        try {
            medicoJpa.edit(medico);
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
    }
}
