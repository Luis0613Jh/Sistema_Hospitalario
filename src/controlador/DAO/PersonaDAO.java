package controlador.DAO;

import controlador.PersonaJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Persona;

public class PersonaDAO {
    private PersonaJpaController PersonaJpa = new PersonaJpaController();
    private Persona persona; 

    public Persona getPersona() {
        if(persona == null){
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public Persona buscarPersona(Persona persona){
        Persona aux = new Persona();
        try {
            aux = PersonaJpa.findPersona(persona.getId_persona());
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }
    
    public Persona buscarPersonaPorId(Long id){
        Persona aux = new Persona();
        try {
            aux = PersonaJpa.findPersona(id);
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }
    
    public List<Persona> filtro(Long idRol, String estado){
        List<Persona> lista = new ArrayList<Persona>();
        try {
            lista = PersonaJpa.getPersonasPorRol(idRol, estado);
            System.out.println("Si vale");
            return lista;
        } catch (Exception e) {
            System.out.println("Valio VRG: "+e);
            return lista;
        }
    }
    
    public boolean agregarPersona(Persona persona){
        try {
            PersonaJpa.create(persona);
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
    }
    
    public List listarPersonas(){
        List<Persona> listaPersona = new ArrayList<Persona>();
        try {
            listaPersona = PersonaJpa.findPersonaEntities();
            return listaPersona;
        } catch (Exception e) {
            return listaPersona;
        }
    }

    
    public boolean editarPersona(Persona persona){
        try {
            PersonaJpa.edit(persona);
            return true;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return false;
        }
    }
}
