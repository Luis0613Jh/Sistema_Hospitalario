package controlador.DAO;

import controlador.ConsultaJpaController;
import controlador.RecetaJpaController;
import modelo.Consulta;
import modelo.Receta;

public class RecetaDAO {

    private long idConsulta;
    private RecetaJpaController recetajpa = new RecetaJpaController();
    private ConsultaJpaController jpaconsulta = new ConsultaJpaController();
    private Consulta consulta = new Consulta();
    private Receta receta = new Receta();

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public RecetaJpaController getRecetajpa() {
        return recetajpa;
    }

    public void setRecetajpa(RecetaJpaController recetajpa) {
        this.recetajpa = recetajpa;
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public ConsultaJpaController getJpaconsulta() {
        return jpaconsulta;
    }

    public void setJpaconsulta(ConsultaJpaController jpaconsulta) {
        this.jpaconsulta = jpaconsulta;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    /**
     * Permite editar una receta de la BD controlando las posibles excepciones.
     *
     * @param receta
     * @return
     */
    public boolean editarReceta(Receta receta) {
        try {
            recetajpa.edit(receta);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

    /**
     * ¨Permite encontrar una consulta en la BD, mediante un ID.
     *
     * @param id
     * @return
     */
    public Consulta encontrarConsulta(Long id) {
        try {
            return jpaconsulta.findConsulta(idConsulta);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * ¨Permite encontrar una Receta en la BD, mediante un ID.
     *
     * @param id
     * @return
     */
    public Receta buscarReceta(long id) {
        Receta aux = new Receta();
        try {
            aux = recetajpa.findReceta(id);
            return aux;
        } catch (Exception e) {
            return aux;
        }
    }

    /**
     * Permite cargar una consulta dentro del objeto de RecetaDAO
     */
    public void CargarConsulta() {
        this.setConsulta(jpaconsulta.findConsulta(idConsulta));
    }

}
