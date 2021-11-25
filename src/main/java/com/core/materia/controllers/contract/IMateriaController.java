package com.core.materia.controllers.contract;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.core.materia.controllers.dto.MateriaDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface IMateriaController {
	@GetMapping(value = "api/es/secoed/materia/list", produces = "application/json")
	@Operation(description = "Listado de Materia de Conocimiento disponibles")
	@ApiResponses(value = {
            @ApiResponse(responseCode =  "200", description =  "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MateriaDTO.class)))),
            @ApiResponse(responseCode =  "204", description =  "No Hay Contenido"),
            @ApiResponse(responseCode =  "500", description =  "Error Interno", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
    })
    @Parameters(value = {
            @Parameter(name =  "sim parametros" )
    })
	ResponseEntity<?> getList();
	
	@PostMapping(value = "api/es/secoed/materia/create", produces = "application/json")
	@Operation(description = "Creación de Materia")
	@ApiResponses(value = {
            @ApiResponse(responseCode =  "200", description =  "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MateriaDTO.class)))),
            @ApiResponse(responseCode =  "204", description =  "No Hay Contenido"),
            @ApiResponse(responseCode =  "500", description =  "Error Interno", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
    })
    @Parameters(value = {
            @Parameter(name =  "name", description = "Permite añadir un nombre de Materia", example = "Matemtáticas" ),
            @Parameter(name =  "description", description = "Permite agregar una breve descripción", example = "Materia creada en 1985" ),
            @Parameter(name =  "area", description = "id del area de conocimiento de la materia", example = "1" ),
            @Parameter(name =  "usuario", description = "id de usuario", example = "1" )
    })
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Estructa de datos de una Materia", content = @Content(schema = @Schema(implementation = MateriaDTO.class)))
	ResponseEntity<?> create(@RequestBody @Valid MateriaDTO MateriaDTO);
	
	@PutMapping(value = "api/es/secoed/materia/update", produces = "application/json")
	@Operation(description = "Actualización de Materia")
	@ApiResponses(value = {
            @ApiResponse(responseCode =  "200", description =  "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MateriaDTO.class)))),
            @ApiResponse(responseCode =  "204", description =  "No Hay Contenido"),
            @ApiResponse(responseCode =  "500", description =  "Error Interno", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
    })
    @Parameters(value = {
            @Parameter(name =  "name", description = "Permite añadir un nombre de Materia", example = "Matemáticas I" ),
            @Parameter(name =  "description", description = "Permite agregar una breve descripción", example = "Materia creada en 1985" ),
            @Parameter(name =  "area", description = "id del area de conocimiento de la materia", example = "1" ),
            @Parameter(name =  "usuario", description = "id de usuario", example = "1" )
    })
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Estructa de datos de una Materia", content = @Content(schema = @Schema(implementation = MateriaDTO.class)))
	ResponseEntity<?> update(@RequestBody MateriaDTO MateriaDTO);
	
	@DeleteMapping(value = "api/es/secoed/materia/delete/{id}", produces = "application/json")
    @Operation(description =  "Eliminación de una Materia existente" )
    @ApiResponses(value = {
            @ApiResponse(responseCode =  "200", description =  "OK", content = @Content(array = @ArraySchema(schema = @Schema(implementation = MateriaDTO.class)))),
            @ApiResponse(responseCode =  "204", description =  "No Hay Contenido"),
            @ApiResponse(responseCode =  "500", description =  "Error Interno", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))),
    })
    @Parameter(name =  "id", description =  "Primary Key del registro a eliminar", example =  "1")
	ResponseEntity<?> delete(@PathVariable int id);
}
