package com.conexia.webflows.controllers;

import com.conexia.webflows.boundary.AfiliadoBoundary;
import com.conexia.webflows.entities.Afiliado;
import lombok.Getter;
import lombok.Setter;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Created by pbastidas on 21/10/14.
 */
@Model
public class RegistrarController {

    @Inject @Getter @Setter
    private Afiliado afiliado;
    @EJB
    private AfiliadoBoundary afiliadoBoundary;

    public RegistrarController() {
    }

    public void guardar(){
        afiliadoBoundary.crearAfiliado(afiliado);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Afiliado creado correctamente (id:"+afiliado.getId()+")"));

        afiliado = new Afiliado();
    }
}
