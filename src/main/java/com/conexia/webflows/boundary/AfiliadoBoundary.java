package com.conexia.webflows.boundary;

import com.conexia.webflows.entities.Afiliado;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by pbastidas on 21/10/14.
 */
@Stateless
public class AfiliadoBoundary {
    @PersistenceContext(unitName = "webflow-pu")
    private EntityManager em;

    public AfiliadoBoundary() {
    }

    public void crearAfiliado(Afiliado afiliado){
        em.persist(afiliado);
    }
}
