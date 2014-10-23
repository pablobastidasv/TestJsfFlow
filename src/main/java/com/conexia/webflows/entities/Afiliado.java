package com.conexia.webflows.entities;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by pbastidas on 21/10/14.
 */
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "Afiliado.findByKey", query = "SELECT a FROM Afiliado a  " +
                "WHERE a.primerNombre LIKE :llave " +
                "OR a.primerApellido LIKE :llave " +
                "OR a.segundoApellido LIKE :llave " +
                "OR a.numeroDocumento LIKE :llave " +
                "OR a.segundoNombre LIKE :llave "
        ),
        @NamedQuery(name = "Afiliado.findByNumeroDoc", query = "SELECT a FROM Afiliado a WHERE a.numeroDocumento = :numDoc")
})
public @Data class Afiliado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String numeroDocumento;
    private String genero;
    private String plan;
    private String telefono;
    private String celular;
    private String email;

    public String getNombreCompleto(){
        return primerNombre + " "
                + segundoNombre + " "
                + primerApellido + " "
                + segundoApellido + " ";
    }
}
