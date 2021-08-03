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
import modelo.Examen;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Laboratorio;

/**
 *
 * @author Jean Agreda
 */
public class LaboratorioJpaController implements Serializable {

    public LaboratorioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Laboratorio laboratorio) {
        if (laboratorio.getListaExamen() == null) {
            laboratorio.setListaExamen(new ArrayList<Examen>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Examen> attachedListaExamen = new ArrayList<Examen>();
            for (Examen listaExamenExamenToAttach : laboratorio.getListaExamen()) {
                listaExamenExamenToAttach = em.getReference(listaExamenExamenToAttach.getClass(), listaExamenExamenToAttach.getId_examen());
                attachedListaExamen.add(listaExamenExamenToAttach);
            }
            laboratorio.setListaExamen(attachedListaExamen);
            em.persist(laboratorio);
            for (Examen listaExamenExamen : laboratorio.getListaExamen()) {
                listaExamenExamen.getListaLab().add(laboratorio);
                listaExamenExamen = em.merge(listaExamenExamen);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Laboratorio laboratorio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Laboratorio persistentLaboratorio = em.find(Laboratorio.class, laboratorio.getId_laboratorio());
            List<Examen> listaExamenOld = persistentLaboratorio.getListaExamen();
            List<Examen> listaExamenNew = laboratorio.getListaExamen();
            List<Examen> attachedListaExamenNew = new ArrayList<Examen>();
            for (Examen listaExamenNewExamenToAttach : listaExamenNew) {
                listaExamenNewExamenToAttach = em.getReference(listaExamenNewExamenToAttach.getClass(), listaExamenNewExamenToAttach.getId_examen());
                attachedListaExamenNew.add(listaExamenNewExamenToAttach);
            }
            listaExamenNew = attachedListaExamenNew;
            laboratorio.setListaExamen(listaExamenNew);
            laboratorio = em.merge(laboratorio);
            for (Examen listaExamenOldExamen : listaExamenOld) {
                if (!listaExamenNew.contains(listaExamenOldExamen)) {
                    listaExamenOldExamen.getListaLab().remove(laboratorio);
                    listaExamenOldExamen = em.merge(listaExamenOldExamen);
                }
            }
            for (Examen listaExamenNewExamen : listaExamenNew) {
                if (!listaExamenOld.contains(listaExamenNewExamen)) {
                    listaExamenNewExamen.getListaLab().add(laboratorio);
                    listaExamenNewExamen = em.merge(listaExamenNewExamen);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = laboratorio.getId_laboratorio();
                if (findLaboratorio(id) == null) {
                    throw new NonexistentEntityException("The laboratorio with id " + id + " no longer exists.");
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
            Laboratorio laboratorio;
            try {
                laboratorio = em.getReference(Laboratorio.class, id);
                laboratorio.getId_laboratorio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The laboratorio with id " + id + " no longer exists.", enfe);
            }
            List<Examen> listaExamen = laboratorio.getListaExamen();
            for (Examen listaExamenExamen : listaExamen) {
                listaExamenExamen.getListaLab().remove(laboratorio);
                listaExamenExamen = em.merge(listaExamenExamen);
            }
            em.remove(laboratorio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Laboratorio> findLaboratorioEntities() {
        return findLaboratorioEntities(true, -1, -1);
    }

    public List<Laboratorio> findLaboratorioEntities(int maxResults, int firstResult) {
        return findLaboratorioEntities(false, maxResults, firstResult);
    }

    private List<Laboratorio> findLaboratorioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Laboratorio.class));
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

    public Laboratorio findLaboratorio(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Laboratorio.class, id);
        } finally {
            em.close();
        }
    }

    public int getLaboratorioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Laboratorio> rt = cq.from(Laboratorio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
