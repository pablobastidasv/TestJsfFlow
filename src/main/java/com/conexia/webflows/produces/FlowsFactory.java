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

        // Inicializador para el flujo de crear Incidencia
        flowBuilder.initializer("#{crearIncidenciaController.init}");

        // Nodo para el envio del flujo hacia crear afiliado
        flowBuilder.flowCallNode("call-crearAfiliado")
                .flowReference("", "crearAfiliado")
                .outboundParameter("afiliado", "#{crearIncidenciaController.incidencia.afiliado}")
                .outboundParameter("origin", flowId);

        return flowBuilder.getFlow();
    }

    @Produces
    @FlowDefinition
    public Flow defineFlowCrearAfiliado(@FlowBuilderParameter FlowBuilder flowBuilder) {
        String flowId = "crearAfiliado"; // id del flujo
        flowBuilder.id("", flowId); // set del id del flujo

        // Seteo el valor del origen sobre un atributo propio del flujo
        flowBuilder.inboundParameter("origin", "#{flowScope.origin}");
        flowBuilder.inboundParameter("afiliado", "#{registrarController.afiliado}");

        // Se crea el nodo inicial del flujo
        flowBuilder.viewNode(flowId, "/" + flowId + "/registrar.xhtml").markAsStartNode();

        // Se crea nodo de salida
        flowBuilder.returnNode(flowId+"-exit").fromOutcome("/index");

        // Nodo de salida hacia crear Incidente
        flowBuilder.returnNode(flowId+"-exitTo-crearInc").fromOutcome("crearInc");

        // Inicializador del flujo de registrar Afiliado
        flowBuilder.initializer("#{registrarController.init}");

        return flowBuilder.getFlow();
    }

}
