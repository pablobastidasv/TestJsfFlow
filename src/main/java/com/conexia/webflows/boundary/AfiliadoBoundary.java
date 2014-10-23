package com.conexia.webflows.boundary;

import com.conexia.webflows.entities.Afiliado;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    public List<Afiliado> buscar(String key){
        return em.createNamedQuery("Afiliado.findByKey", Afiliado.class)
                .setParameter("llave", "%"+key+"%")
                .getResultList();
    }

    public Afiliado buscarPorNumDoc(String numDoc){
        try {
            return em.createNamedQuery("Afiliado.findByNumeroDoc", Afiliado.class)
                    .setParameter("numDoc", numDoc)
                    .getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
}
