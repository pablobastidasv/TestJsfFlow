package com.conexia.webflows.produces;

import javax.enterprise.inject.Produces;
import javax.faces.flow.Flow;
import javax.faces.flow.builder.FlowBuilder;
import javax.faces.flow.builder.FlowBuilderParameter;
import javax.faces.flow.builder.FlowDefinition;
import java.io.Serializable;

/**
 * Created by pbastidas on 22/10/14.
 */
public class FlowsFactory implements Serializable {

    @Produces
    @FlowDefinition
    public Flow defineFlowCrearIncidente(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "crearInc"; // id del flujo
        flowBuilder.id("", flowId); // set del id del flujo

        // Se crea el nodo inicial del flujo
        flowBuilder.viewNode(flowId, "/" + flowId + "/" + flowId + ".xhtml").markAsStartNode();

        // Se crea el nodo que muestra el resumen del incidente creado
        flowBuilder.viewNode(flowId+"-resumen", "/" + flowId + "/resumenInc.xhtml");

        // Se crea nodo de salida
        flowBuilder.returnNode(flowId+"-exit").fromOutcome("/index");

        flowBuilder.initializer("#{crearIncidenciaController.init}");

        return flowBuilder.getFlow();
    }

}
