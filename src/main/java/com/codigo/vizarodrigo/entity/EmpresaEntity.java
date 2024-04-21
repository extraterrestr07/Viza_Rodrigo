package com.codigo.vizarodrigo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "empresas")
@Getter
@Setter
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razon_social;
    private char tipo_documento ;
    private String numero_documento ;
    private String condicion;
    private String direccion;
    private String distrito ;
    private String provincia ;
    private String departamento ;
    private boolean es_agente_retencion;
    private int estado;
    private String usua_crea;
    private Timestamp date_create;
    private String usua_modif;
    private Timestamp date_modif;
    private String usua_delet;
    private Timestamp date_delet;

}
