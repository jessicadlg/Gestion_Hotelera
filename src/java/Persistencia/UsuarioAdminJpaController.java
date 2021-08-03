/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.UsuarioAdmin;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 003578613
 */
public class UsuarioAdminJpaController implements Serializable {

    public UsuarioAdminJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

     public UsuarioAdminJpaController() {
        emf = Persistence.createEntityManagerFactory("tpIntegradorFinalPU");
    }
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioAdmin usuarioAdmin) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioAdmin);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarioAdmin(usuarioAdmin.getId_usuario()) != null) {
                throw new PreexistingEntityException("UsuarioAdmin " + usuarioAdmin + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioAdmin usuarioAdmin) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioAdmin = em.merge(usuarioAdmin);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuarioAdmin.getId_usuario();
                if (findUsuarioAdmin(id) == null) {
                    throw new NonexistentEntityException("The usuarioAdmin with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UsuarioAdmin usuarioAdmin;
            try {
                usuarioAdmin = em.getReference(UsuarioAdmin.class, id);
                usuarioAdmin.getId_usuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioAdmin with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioAdmin);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioAdmin> findUsuarioAdminEntities() {
        return findUsuarioAdminEntities(true, -1, -1);
    }

    public List<UsuarioAdmin> findUsuarioAdminEntities(int maxResults, int firstResult) {
        return findUsuarioAdminEntities(false, maxResults, firstResult);
    }

    private List<UsuarioAdmin> findUsuarioAdminEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioAdmin.class));
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

    public UsuarioAdmin findUsuarioAdmin(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioAdmin.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioAdminCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioAdmin> rt = cq.from(UsuarioAdmin.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
