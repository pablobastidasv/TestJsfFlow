package com.conexia.webflows.controllers;

import com.conexia.webflows.Log;
import com.conexia.webflows.boundary.AfiliadoBoundary;
import com.conexia.webflows.entities.Afiliado;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by pbastidas on 21/10/14.
 */
@Named
@ConversationScoped
public class ConversationController implements Serializable {
    @Getter @Setter
    private String valor;
    @Inject
    private Conversation conversation;
    @EJB
    private AfiliadoBoundary afiliadoBoundary;
    @Getter @Setter
    private List<Afiliado> afiliados;
    @Getter @Setter
    private Afiliado afiliado;
    @Inject
    private Log logger;

    public ConversationController() {
    }

    public void init(){
        if (!FacesContext.getCurrentInstance().isPostback()&& conversation.isTransient()) {
             conversation.begin();
        }
    }

    public void buscarAfiliados(){
        afiliados = afiliadoBoundary.buscar(valor);
    }

    public String end(){
        if (!conversation.isTransient()) {
             conversation.end();
        }

        return "/index?faces-redirect=true";
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
