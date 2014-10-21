package com.conexia.webflows.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by pbastidas on 21/10/14.
 */
@Entity
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
}
