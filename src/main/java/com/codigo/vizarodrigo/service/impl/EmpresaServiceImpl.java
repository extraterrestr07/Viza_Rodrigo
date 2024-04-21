package com.codigo.vizarodrigo.service.impl;

import com.codigo.vizarodrigo.dao.EmpresaRepository;
import com.codigo.vizarodrigo.entity.EmpresaEntity;
import com.codigo.vizarodrigo.service.EmpresaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    @Value(("${usuario.nombre}"))
    private String nombreUsuario;


    @Override
    public EmpresaEntity crear(EmpresaEntity empresa) {
        empresa.setDate_create(tiempoActual());
        empresa.setUsua_crea(nombreUsuario);
        return empresaRepository.save(empresa);
    }

    @Override
    public Optional<EmpresaEntity> buscarxId(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<EmpresaEntity> buscarAll() {
        return empresaRepository.findAll();
    }

    @Override
    public EmpresaEntity actualizar(Long id, EmpresaEntity empresa) {
        if (empresaRepository.findById(id).isPresent()) {
            EmpresaEntity empresaActualizar = empresaRepository.findById(id).get();

            empresaActualizar.setRazon_social(empresa.getRazon_social());
            empresaActualizar.setTipo_documento(empresa.getTipo_documento());
            empresaActualizar.setNumero_documento(empresa.getNumero_documento());
            empresaActualizar.setCondicion(empresa.getCondicion());
            empresaActualizar.setDireccion(empresa.getDireccion());
            empresaActualizar.setDistrito(empresa.getDistrito());
            empresaActualizar.setProvincia(empresa.getProvincia());
            empresaActualizar.setDepartamento(empresa.getDepartamento());
            empresaActualizar.setEs_agente_retencion(empresa.isEs_agente_retencion());
            empresaActualizar.setDate_modif(tiempoActual());
            empresaActualizar.setUsua_modif(nombreUsuario);

            return empresaRepository.save(empresaActualizar);
        }
        return null;
    }

    @Override
    public EmpresaEntity borrar(Long id) {
        Optional<EmpresaEntity> empresaBuscada = empresaRepository.findById(id);
        if (empresaBuscada.isPresent()){
            empresaBuscada.get().setEstado(0);
            empresaBuscada.get().setDate_delet(tiempoActual());
            empresaBuscada.get().setUsua_delet(nombreUsuario);
            return empresaRepository.save(empresaBuscada.get());
        }
        return null;
    }

    private Timestamp tiempoActual() {
        // Obtain the current date and time in the system default time zone
        LocalDateTime now = LocalDateTime.now();
        // Convert the LocalDateTime to a java.sql.Timestamp using ZoneId.systemDefault()
        return Timestamp.valueOf(String.valueOf(now.atZone(ZoneId.systemDefault()).toInstant()));    }
}
