package com.codigo.vizarodrigo.controller;

import com.codigo.vizarodrigo.entity.EmpresaEntity;
import com.codigo.vizarodrigo.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/examen/v3/empresa")
@AllArgsConstructor
@Tag(
        name = "API DE MANTENIMIENTO EMPRESAS",
        description = "Esta api contiene todos los end points para realizar el mantenimiento de empresas"
)
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(summary = "Crear una nueva Empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa Creada exitosamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    public ResponseEntity<EmpresaEntity> crear(@RequestBody EmpresaEntity empresaEntity){
        return ResponseEntity.ok(empresaService.crear(empresaEntity));
    }

    @Operation(summary = "Buscar Una Empresa Por ID")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresa Encontrada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<Optional<EmpresaEntity>> buscarxId(@PathVariable Long id){
        return ResponseEntity.ok(empresaService.buscarxId(id));
    }

    @Operation(summary = "Obteniendo los datos de todas las empresas")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresas encontradas",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @GetMapping("/todos")
    public ResponseEntity<List<EmpresaEntity>> buscarAll(){
        return ResponseEntity.ok(empresaService.buscarAll());
    }

    @Operation(summary = "Actualizar una Empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresas actualizada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EmpresaEntity> actualizar(@PathVariable Long id, @RequestBody EmpresaEntity empresaEntity){
        return ResponseEntity.ok(empresaService.actualizar(id,empresaEntity));
    }

    @Operation(summary = "Eliminacion logica de una Empresa")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "Empresas eliminada",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EmpresaEntity.class))})
    })
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<EmpresaEntity> eliminar(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.borrar(id));
    }
}
