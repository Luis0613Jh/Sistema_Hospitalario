/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Consulta;
import modelo.Examen;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Pedido;

/**
 *
 * @author RICARDO
 */
public class PedidoJpaController implements Serializable {

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) throws IllegalOrphanException {
        if (pedido.getListaExamen() == null) {
            pedido.setListaExamen(new ArrayList<Examen>());
        }
        List<String> illegalOrphanMessages = null;
        Consulta consultaOrphanCheck = pedido.getConsulta();
        if (consultaOrphanCheck != null) {
            Pedido oldPedidoOfConsulta = consultaOrphanCheck.getPedido();
            if (oldPedidoOfConsulta != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Consulta " + consultaOrphanCheck + " already has an item of type Pedido whose consulta column cannot be null. Please make another selection for the consulta field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consulta consulta = pedido.getConsulta();
            if (consulta != null) {
                consulta = em.getReference(consulta.getClass(), consulta.getId_consulta());
                pedido.setConsulta(consulta);
            }
            List<Examen> attachedListaExamen = new ArrayList<Examen>();
            for (Examen listaExamenExamenToAttach : pedido.getListaExamen()) {
                listaExamenExamenToAttach = em.getReference(listaExamenExamenToAttach.getClass(), listaExamenExamenToAttach.getId_examen());
                attachedListaExamen.add(listaExamenExamenToAttach);
            }
            pedido.setListaExamen(attachedListaExamen);
            em.persist(pedido);
            if (consulta != null) {
                consulta.setPedido(pedido);
                consulta = em.merge(consulta);
            }
            for (Examen listaExamenExamen : pedido.getListaExamen()) {
                Pedido oldPedidoOfListaExamenExamen = listaExamenExamen.getPedido();
                listaExamenExamen.setPedido(pedido);
                listaExamenExamen = em.merge(listaExamenExamen);
                if (oldPedidoOfListaExamenExamen != null) {
                    oldPedidoOfListaExamenExamen.getListaExamen().remove(listaExamenExamen);
                    oldPedidoOfListaExamenExamen = em.merge(oldPedidoOfListaExamenExamen);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getId_pedido());
            Consulta consultaOld = persistentPedido.getConsulta();
            Consulta consultaNew = pedido.getConsulta();
            List<Examen> listaExamenOld = persistentPedido.getListaExamen();
            List<Examen> listaExamenNew = pedido.getListaExamen();
            List<String> illegalOrphanMessages = null;
            if (consultaNew != null && !consultaNew.equals(consultaOld)) {
                Pedido oldPedidoOfConsulta = consultaNew.getPedido();
                if (oldPedidoOfConsulta != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Consulta " + consultaNew + " already has an item of type Pedido whose consulta column cannot be null. Please make another selection for the consulta field.");
                }
            }
            for (Examen listaExamenOldExamen : listaExamenOld) {
                if (!listaExamenNew.contains(listaExamenOldExamen)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Examen " + listaExamenOldExamen + " since its pedido field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (consultaNew != null) {
                consultaNew = em.getReference(consultaNew.getClass(), consultaNew.getId_consulta());
                pedido.setConsulta(consultaNew);
            }
            List<Examen> attachedListaExamenNew = new ArrayList<Examen>();
            for (Examen listaExamenNewExamenToAttach : listaExamenNew) {
                listaExamenNewExamenToAttach = em.getReference(listaExamenNewExamenToAttach.getClass(), listaExamenNewExamenToAttach.getId_examen());
                attachedListaExamenNew.add(listaExamenNewExamenToAttach);
            }
            listaExamenNew = attachedListaExamenNew;
            pedido.setListaExamen(listaExamenNew);
            pedido = em.merge(pedido);
            if (consultaOld != null && !consultaOld.equals(consultaNew)) {
                consultaOld.setPedido(null);
                consultaOld = em.merge(consultaOld);
            }
            if (consultaNew != null && !consultaNew.equals(consultaOld)) {
                consultaNew.setPedido(pedido);
                consultaNew = em.merge(consultaNew);
            }
            for (Examen listaExamenNewExamen : listaExamenNew) {
                if (!listaExamenOld.contains(listaExamenNewExamen)) {
                    Pedido oldPedidoOfListaExamenNewExamen = listaExamenNewExamen.getPedido();
                    listaExamenNewExamen.setPedido(pedido);
                    listaExamenNewExamen = em.merge(listaExamenNewExamen);
                    if (oldPedidoOfListaExamenNewExamen != null && !oldPedidoOfListaExamenNewExamen.equals(pedido)) {
                        oldPedidoOfListaExamenNewExamen.getListaExamen().remove(listaExamenNewExamen);
                        oldPedidoOfListaExamenNewExamen = em.merge(oldPedidoOfListaExamenNewExamen);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pedido.getId_pedido();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getId_pedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Examen> listaExamenOrphanCheck = pedido.getListaExamen();
            for (Examen listaExamenOrphanCheckExamen : listaExamenOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedido (" + pedido + ") cannot be destroyed since the Examen " + listaExamenOrphanCheckExamen + " in its listaExamen field has a non-nullable pedido field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Consulta consulta = pedido.getConsulta();
            if (consulta != null) {
                consulta.setPedido(null);
                consulta = em.merge(consulta);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pedido findPedido(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
