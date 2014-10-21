package com.conexia.webflows.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by pbastidas on 21/10/14.
 */
@Entity
public @Data class Afiliado {
    @Id
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
