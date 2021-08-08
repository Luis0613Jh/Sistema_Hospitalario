/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.DAO;
import controlador.PersonaJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import modelo.Persona;
/**
 *
 * @author CNH
 */
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
    
    public Persona buscarPersona(long id){
        Persona aux = new Persona();
        try {
            aux = PersonaJpa.findPersona(id);
            return aux;
        } catch (Exception e) {
            return aux;
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
