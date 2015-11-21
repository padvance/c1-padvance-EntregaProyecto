/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ucentral.controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ucentral.modelo.PreguntaRespuesta;

/**
 *
 * @author rm-rf
 */
@Stateless
public class PreguntaRespuestaFacade extends AbstractFacade<PreguntaRespuesta> {
    @PersistenceContext(unitName = "generaCuestionarioWEBPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreguntaRespuestaFacade() {
        super(PreguntaRespuesta.class);
    }
    
}
