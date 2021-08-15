package controlador.DAO;
import controlador.PersonaJpaController;
import java.util.ArrayList;
import java.util.List;
import modelo.Persona;
public class PersonaDAO {
    private PersonaJpaController PersonaJpa = new PersonaJpaController();
    private Persona persona;

    public Persona getPersona() {
        if (persona == null) {
            persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona buscarPersona(Persona persona) {
        Persona aux = new Persona();
        try {
            aux = PersonaJpa.findPersona(persona.getId_persona());
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }
    
    public Persona buscarPersonaPorId(Long id) {
        Persona aux = new Persona();
        try {    
            aux = PersonaJpa.findPersona(id);
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }

    public boolean agregarPersona(Persona persona) {
        try {
            PersonaJpa.create(persona);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    public List listarPersonas() {
        List<Persona> listaPersona = new ArrayList<Persona>();
        try {
            listaPersona = PersonaJpa.findPersonaEntities();
            return listaPersona;
        } catch (Exception e) {
            return listaPersona;
        }
    }

    /**
     * Método que devuelve una lista con todos los personas que cumplan con el estado indicado.
     * @param estado Estado por el cual se van a filtar los personas, es de tipo String.
     * @return Retorna una lista de tipo List.
     */
    public List<Persona> getPersonasPorEstado(String estado) {
        return PersonaJpa.getPersonasPorEstado(estado);
    }
    
    public boolean editarPersona(Persona persona) {
        try {
            PersonaJpa.edit(persona);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }
}
