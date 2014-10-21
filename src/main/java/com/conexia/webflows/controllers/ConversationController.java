package com.conexia.webflows.controllers;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import javax.enterprise.context.Conversation;

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

    public ConversationController() {
    }

    public void init(){
        if (!FacesContext.getCurrentInstance().isPostback()&& conversation.isTransient()) {
             conversation.begin();
        }
    }

    public String end(){
        if (!conversation.isTransient()) {
             conversation.end();
        }

        return "/index?faces-redirect=true";
    }
}
