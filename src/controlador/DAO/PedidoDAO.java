
package controlador.DAO;

import controlador.ConsultaJpaController;
import controlador.PedidoJpaController;
import java.util.ArrayList;
import java.util.List;
import modelo.Consulta;
import modelo.Examen;
import modelo.Pedido;

public class PedidoDAO {

    private long idConsulta;
    private PedidoJpaController jpaControlador = new PedidoJpaController();
    private Pedido pedido = new Pedido();
    private ConsultaJpaController jpaconsulta = new ConsultaJpaController();
    private Consulta consulta = new Consulta();
    private ExamenDAO examendao = new ExamenDAO();
    private Examen examen = new Examen();
    private List<Examen> listaExamen = new ArrayList<Examen>();

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public PedidoJpaController getJpaControlador() {
        return jpaControlador;
    }

    public void setJpaControlador(PedidoJpaController jpaControlador) {
        this.jpaControlador = jpaControlador;
    }

    public ConsultaJpaController getJpaconsulta() {
        return jpaconsulta;
    }

    public List<Examen> getListaExamen() {
        return listaExamen;
    }

    public void setListaExamen(List<Examen> listaExamen) {
        this.listaExamen = listaExamen;
    }

    public void setJpaconsulta(ConsultaJpaController jpaconsulta) {
        this.jpaconsulta = jpaconsulta;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public ExamenDAO getExamendao() {
        return examendao;
    }

    public void setExamendao(ExamenDAO examendao) {
        this.examendao = examendao;
    }

    public Examen getExamen() {
        return examen;
    }

    public long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public boolean agregar(Pedido pedido) {
        try {
            jpaControlador.create(pedido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editar(Pedido pedido) {
        try {
            jpaControlador.edit(pedido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Pedido> listar() {
        return jpaControlador.findPedidoEntities();
    }

    public List<Pedido> getPedidosPorEstado(String estado) {
        return jpaControlador.getPedidosPorEstado(estado);
    }

    public Consulta encontrarConsulta(Long id) {
        try {
            return jpaconsulta.findConsulta(idConsulta);
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Pedido> getPedidosPorTodosMenosUnEstado(String estado) {
        return jpaControlador.getPedidosPorTodosMenosUnEstado(estado);
    }

}
