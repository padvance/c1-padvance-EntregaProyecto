/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucentral.controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ucentral.modelo.Examen;
import ucentral.modelo.PreguntaExamen;

/**
 *
 * @author rm-rf
 */
@Stateless
public class PreguntaExamenFacade extends AbstractFacade<PreguntaExamen> {
    @PersistenceContext(unitName = "generaCuestionarioWEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntaExamenFacade() {
        super(PreguntaExamen.class);
    }

    public List<PreguntaExamen> findByExamen(Examen examen) {
        Query query = em.createQuery("SELECT c FROM PreguntaExamen c WHERE c.examenIdexamen.idexamen =:idexamen");
        query.setParameter("idexamen", examen.getIdexamen());
        return query.getResultList();
    }
    
}
