package controlador.DAO;

import controlador.PedidoJpaController;
import java.util.List;
import modelo.Pedido;

public class PedidoDAO {

    private PedidoJpaController jpaControlador = new PedidoJpaController();
    private Pedido pedido;

    public Pedido getPedido() {
        if (pedido == null) {
            pedido = new Pedido();
        }
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

}
