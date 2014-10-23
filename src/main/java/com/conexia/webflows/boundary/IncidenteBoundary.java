package com.conexia.webflows.boundary;

import com.conexia.webflows.entities.Incidencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

/**
 * Created by pbastidas on 23/10/14.
 */
@Stateless
public class IncidenteBoundary {

    @PersistenceContext(unitName = "webflow-pu")
    private EntityManager em;

    public void crearIncidencia(Incidencia incidencia){
        em.persist(incidencia);
    }
}
