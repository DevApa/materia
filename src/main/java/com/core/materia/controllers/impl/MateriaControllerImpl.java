package com.core.materia.controllers.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.core.materia.constants.ErrorsConfig;
import com.core.materia.controllers.contract.IMateriaController;
import com.core.materia.controllers.dto.MateriaDTO;
import com.core.materia.service.impl.MateriaService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Materia")
public class MateriaControllerImpl implements IMateriaController{
	@Autowired
    private MateriaService _service;
    private static final Logger LOG = LoggerFactory.getLogger(MateriaControllerImpl.class);
	@Override
	public ResponseEntity<?> getList() {
		try {
        	LOG.info("Incio de consulta de materia");
            List<MateriaDTO> materias = _service.list();
            if (materias.isEmpty()) {
            	LOG.info("No hay registros que mostrar");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);    
            }
            LOG.info("Fin la consulta devolvió " + materias.size() + " de registros");
            return new ResponseEntity<>(materias, HttpStatus.OK);
        } catch (Exception e) {
        	LOG.info("La consulta falló");
            return new ResponseEntity<String>(ErrorsConfig.ERROR_INTERN, HttpStatus.INTERNAL_SERVER_ERROR);  
        }
	}

	@Override
	public ResponseEntity<?> create(@Valid MateriaDTO MateriaDTO) {
		try {
        	LOG.info("Incio de creación de materia");
            MateriaDTO materia = _service.create(MateriaDTO);
            if (materia.equals(null)) {
            	LOG.info("Fallo al intentar crear el registro");
                return new ResponseEntity<String>(ErrorsConfig.ERROR_RESOURCE, HttpStatus.CONFLICT);   
            }     
            LOG.info("Fin registro creado");
            return new ResponseEntity<String>("RECURSO CREADO",HttpStatus.CREATED);   
        } catch (Exception e) {
        	LOG.info("Error no se pudo crear área ");
        	return new ResponseEntity<String>(ErrorsConfig.ERROR_NO_RECOURSE, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

	@Override
	public ResponseEntity<?> update(MateriaDTO MateriaDTO) {
		try {
        	if (!_service.exist(MateriaDTO.getId())) {
        		LOG.info("No éxiste una institución para este id");
        		return new ResponseEntity<String>(ErrorsConfig.ERROR_NO_RECOURSE,HttpStatus.NOT_FOUND);
			}
        	MateriaDTO materia = _service.update(MateriaDTO);
        	if (materia == null) {
				LOG.error("Error al intentar actualizar el recurso");
				return new ResponseEntity<String>(ErrorsConfig.ERROR_RESOURCE, HttpStatus.CONFLICT);				
			}
        	return ResponseEntity.ok("Recurso Actualizado...!");
		} catch (Exception e) {
			LOG.error("Excepción al intentar actualizar recurso: ",e.getMessage());
			return new ResponseEntity<String>(ErrorsConfig.ERROR_INTERN, HttpStatus.INTERNAL_SERVER_ERROR);					
		}
	}

	@Override
	public ResponseEntity<?> delete(int id) {
		try {
			LOG.info("Inicia eliminar");
			if (!_service.exist(id)) {		
				LOG.info("Error recurso no encontrado");
				return new ResponseEntity<String>(ErrorsConfig.ERROR_NO_RECOURSE,HttpStatus.NOT_FOUND);
			}
			LOG.info("Fin eliminar");
			
			_service.delete(id);
			
			return ResponseEntity.ok("Recurso Eliminado correctamente...!");
		} catch (Exception e) {
			LOG.error("Excepción al intentar eliminar recurso: ", e.getMessage());
			return new ResponseEntity<String>(ErrorsConfig.ERROR_INTERN, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
