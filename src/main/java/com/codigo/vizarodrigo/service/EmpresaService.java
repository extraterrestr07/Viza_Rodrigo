package com.codigo.vizarodrigo.service;

import com.codigo.vizarodrigo.entity.EmpresaEntity;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {
    EmpresaEntity crear(EmpresaEntity empresa);
    Optional<EmpresaEntity> buscarxId(Long id);
    List<EmpresaEntity> buscarAll();
    EmpresaEntity actualizar(Long id,EmpresaEntity empresa);
    //borrar es un borrado logico
    EmpresaEntity borrar(Long id);
}
