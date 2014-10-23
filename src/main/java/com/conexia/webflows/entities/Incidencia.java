package com.conexia.webflows.entities;

import com.conexia.webflows.constantes.CategoriaIncidenciaEnum;
import com.conexia.webflows.constantes.EstadoIncidenciaEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by pbastidas on 23/10/14.
 */
@Entity
public @Data class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fechaRegistro;
    private Date fechaFinalizacion;
    private String resumen;
    private String descripcion;
    private String ubicacion;
    @ManyToOne(targetEntity = Afiliado.class)
    private Afiliado afiliado;
    @Enumerated
    private EstadoIncidenciaEnum estado;
    @Enumerated
    private CategoriaIncidenciaEnum categoria;
}
