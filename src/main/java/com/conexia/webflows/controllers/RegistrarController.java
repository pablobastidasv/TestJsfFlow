package com.conexia.webflows.controllers;

import com.conexia.webflows.Log;
import com.conexia.webflows.boundary.AfiliadoBoundary;
import com.conexia.webflows.entities.Afiliado;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by pbastidas on 21/10/14.
 */
@Named
@FlowScoped("crearAfiliado")
public class RegistrarController {

    @Inject
    private Log logger;
    @Getter @Setter
    private Afiliado afiliado;
    @EJB
    private AfiliadoBoundary afiliadoBoundary;

    public RegistrarController() {
    }

    public void init(){
        afiliado = new Afiliado();
    }

    public void guardar(){
        afiliadoBoundary.crearAfiliado(afiliado);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Afiliado creado correctamente (id:"+afiliado.getId()+")"));

        afiliado = new Afiliado();
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("PostConstruct de FacesScoped Bean");
    }
    @PreDestroy
    public void preDestroy(){
        logger.info("PreDestroy de FacesScoped Bean");
    }
}
