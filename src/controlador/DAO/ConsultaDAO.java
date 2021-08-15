package controlador.DAO;

import controlador.ConsultaJpaController;
import controlador.exceptions.IllegalOrphanException;
import java.util.ArrayList;
import java.util.List;
import modelo.Consulta;

public class ConsultaDAO {

    private ConsultaJpaController ConsultaJpa = new ConsultaJpaController();
    private Consulta consulta;

    public Consulta getConsulta() {
        if (consulta == null) {
            consulta = new Consulta();
        }
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    /**
     * Permite agregar nuevas consultas a la BD sin preocuparnos por errores en
     * el sistema.
     *
     * @param consulta
     * @return
     */
    public boolean agregarConsulta(Consulta consulta) {
        try {
            ConsultaJpa.create(consulta);
            return true;
        } catch (IllegalOrphanException e) {
            return false;
        }
    }

    /**
     * Devuelveen una lista todos las consultas guardadas en la BD.
     *
     * @return
     */
    public List listarConsultas() {
        List<Consulta> listaPersona = new ArrayList<Consulta>();
        try {
            listaPersona = ConsultaJpa.findConsultaEntities();
            return listaPersona;
        } catch (Exception e) {
            return listaPersona;
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
            return ConsultaJpa.findConsulta(id);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Devuelve una lista de consultas filtrando por el estado deseado.
     *
     * @param estado
     * @return
     */
    public List<Consulta> getConsultasPorEstado(String estado) {
        return ConsultaJpa.getConsultasPorEstado(estado);
    }

    /**
     * Devuelve una lista de consultas filtrando por el estado que no se desea
     * mostrar.
     *
     * @param estado
     * @return
     */
    public List<Consulta> getPedidosPorTodosMenosUnEstado(String estado) {
        return ConsultaJpa.getPedidosPorTodosMenosUnEstado(estado);
    }

    /**
     * Permite editar una consulta en la BD.
     *
     * @param consulta
     * @return
     */
    public boolean editarConsulta(Consulta consulta) {
        try {
            ConsultaJpa.edit(consulta);
            return true;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return false;
        }
    }

}
