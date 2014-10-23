package com.conexia.webflows.controllers;

import com.conexia.webflows.Log;
import com.conexia.webflows.boundary.AfiliadoBoundary;
import com.conexia.webflows.boundary.IncidenteBoundary;
import com.conexia.webflows.entities.Afiliado;
import com.conexia.webflows.entities.Incidencia;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by pbastidas on 23/10/14.
 */
@Named
@FlowScoped("crearInc")
public class CrearIncidenciaController {

    @Inject
    private Log logger;

    @Getter @Setter
    private Incidencia incidencia;

    @EJB
    private IncidenteBoundary incidenteBoundary;
    @EJB
    private AfiliadoBoundary afiliadoBoundary;

    public void buscarAfiliado(){
        Afiliado afiliado = afiliadoBoundary.buscarPorNumDoc(incidencia.getAfiliado().getNumeroDocumento());

        if(afiliado == null){
            final FacesMessage msg = new FacesMessage("No se encontro el afiliado");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage("txtAfiliado", msg);
        }else {
            final FacesMessage msg = new FacesMessage(afiliado.getNombreCompleto());
            msg.setSeverity(FacesMessage.SEVERITY_INFO);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            incidencia.setAfiliado(afiliado);
        }
    }

    public String crearIncidencia(){
        incidenteBoundary.crearIncidencia(incidencia);

        return "crearInc-resumen";
    }

    /**
     * Metodo que es llamado al inicializar el contexto del faces flow
     */
    public void init(){
        logger.info("Inicializador del flujo");

        incidencia = new Incidencia();
        incidencia.setAfiliado(new Afiliado());
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
