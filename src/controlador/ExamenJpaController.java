/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Categoria;
import modelo.Pedido;
import modelo.Laboratorio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Examen;


public class ExamenJpaController implements Serializable {

    private EntityManagerFactory emf;
    
    public ExamenJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ExamenJpaController() {
        emf = Persistence.createEntityManagerFactory("SistemaHospitalarioPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Examen examen) {
        if (examen.getListaLab() == null) {
            examen.setListaLab(new ArrayList<Laboratorio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria categoria = examen.getCategoria();
            if (categoria != null) {
                categoria = em.getReference(categoria.getClass(), categoria.getId_categoria());
                examen.setCategoria(categoria);
            }
            Pedido pedido = examen.getPedido();
            if (pedido != null) {
                pedido = em.getReference(pedido.getClass(), pedido.getId_pedido());
                examen.setPedido(pedido);
            }
            List<Laboratorio> attachedListaLab = new ArrayList<Laboratorio>();
            for (Laboratorio listaLabLaboratorioToAttach : examen.getListaLab()) {
                listaLabLaboratorioToAttach = em.getReference(listaLabLaboratorioToAttach.getClass(), listaLabLaboratorioToAttach.getId_laboratorio());
                attachedListaLab.add(listaLabLaboratorioToAttach);
            }
            examen.setListaLab(attachedListaLab);
            em.persist(examen);
            if (categoria != null) {
                categoria.getListaExamen().add(examen);
                categoria = em.merge(categoria);
            }
            if (pedido != null) {
                pedido.getListaExamen().add(examen);
                pedido = em.merge(pedido);
            }
            for (Laboratorio listaLabLaboratorio : examen.getListaLab()) {
                listaLabLaboratorio.getListaExamen().add(examen);
                listaLabLaboratorio = em.merge(listaLabLaboratorio);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Examen examen) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Examen persistentExamen = em.find(Examen.class, examen.getId_examen());
            Categoria categoriaOld = persistentExamen.getCategoria();
            Categoria categoriaNew = examen.getCategoria();
            Pedido pedidoOld = persistentExamen.getPedido();
            Pedido pedidoNew = examen.getPedido();
            List<Laboratorio> listaLabOld = persistentExamen.getListaLab();
            List<Laboratorio> listaLabNew = examen.getListaLab();
            if (categoriaNew != null) {
                categoriaNew = em.getReference(categoriaNew.getClass(), categoriaNew.getId_categoria());
                examen.setCategoria(categoriaNew);
            }
            if (pedidoNew != null) {
                pedidoNew = em.getReference(pedidoNew.getClass(), pedidoNew.getId_pedido());
                examen.setPedido(pedidoNew);
            }
            List<Laboratorio> attachedListaLabNew = new ArrayList<Laboratorio>();
            for (Laboratorio listaLabNewLaboratorioToAttach : listaLabNew) {
                listaLabNewLaboratorioToAttach = em.getReference(listaLabNewLaboratorioToAttach.getClass(), listaLabNewLaboratorioToAttach.getId_laboratorio());
                attachedListaLabNew.add(listaLabNewLaboratorioToAttach);
            }
            listaLabNew = attachedListaLabNew;
            examen.setListaLab(listaLabNew);
            examen = em.merge(examen);
            if (categoriaOld != null && !categoriaOld.equals(categoriaNew)) {
                categoriaOld.getListaExamen().remove(examen);
                categoriaOld = em.merge(categoriaOld);
            }
            if (categoriaNew != null && !categoriaNew.equals(categoriaOld)) {
                categoriaNew.getListaExamen().add(examen);
                categoriaNew = em.merge(categoriaNew);
            }
            if (pedidoOld != null && !pedidoOld.equals(pedidoNew)) {
                pedidoOld.getListaExamen().remove(examen);
                pedidoOld = em.merge(pedidoOld);
            }
            if (pedidoNew != null && !pedidoNew.equals(pedidoOld)) {
                pedidoNew.getListaExamen().add(examen);
                pedidoNew = em.merge(pedidoNew);
            }
            for (Laboratorio listaLabOldLaboratorio : listaLabOld) {
                if (!listaLabNew.contains(listaLabOldLaboratorio)) {
                    listaLabOldLaboratorio.getListaExamen().remove(examen);
                    listaLabOldLaboratorio = em.merge(listaLabOldLaboratorio);
                }
            }
            for (Laboratorio listaLabNewLaboratorio : listaLabNew) {
                if (!listaLabOld.contains(listaLabNewLaboratorio)) {
                    listaLabNewLaboratorio.getListaExamen().add(examen);
                    listaLabNewLaboratorio = em.merge(listaLabNewLaboratorio);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = examen.getId_examen();
                if (findExamen(id) == null) {
                    throw new NonexistentEntityException("The examen with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Examen examen;
            try {
                examen = em.getReference(Examen.class, id);
                examen.getId_examen();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The examen with id " + id + " no longer exists.", enfe);
            }
            Categoria categoria = examen.getCategoria();
            if (categoria != null) {
                categoria.getListaExamen().remove(examen);
                categoria = em.merge(categoria);
            }
            Pedido pedido = examen.getPedido();
            if (pedido != null) {
                pedido.getListaExamen().remove(examen);
                pedido = em.merge(pedido);
            }
            List<Laboratorio> listaLab = examen.getListaLab();
            for (Laboratorio listaLabLaboratorio : listaLab) {
                listaLabLaboratorio.getListaExamen().remove(examen);
                listaLabLaboratorio = em.merge(listaLabLaboratorio);
            }
            em.remove(examen);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Examen> findExamenEntities() {
        return findExamenEntities(true, -1, -1);
    }

    public List<Examen> findExamenEntities(int maxResults, int firstResult) {
        return findExamenEntities(false, maxResults, firstResult);
    }

    private List<Examen> findExamenEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Examen.class));
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

    public Examen findExamen(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Examen.class, id);
        } finally {
            em.close();
        }
    }

    public int getExamenCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Examen> rt = cq.from(Examen.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
