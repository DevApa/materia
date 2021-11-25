package com.core.materia.service.impl;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.materia.controllers.dto.MateriaDTO;
import com.core.materia.repository.contract.IMateriaRepository;
import com.core.materia.repository.models.Materia;
import com.core.materia.service.contract.IMateriaService;
import com.core.materia.utils.ModelMap;


@Service
public class MateriaService implements IMateriaService{
	
	@Autowired
	IMateriaRepository repository;
	
	@Override
	public List<MateriaDTO> list() {
		return ModelMap.listMapModelToListDto(repository.findAll());
	}

	@Override
	public MateriaDTO create(MateriaDTO materiaDto) {
		Materia materia = ModelMap.dtoToModel(materiaDto);	
		materia.setId(null);
		return ModelMap.modelToDto(repository.save(materia));
	}

	@Override
	public MateriaDTO update(MateriaDTO materiaDto) {
		Materia materia = ModelMap.dtoToModel(materiaDto);		
		return ModelMap.modelToDto(repository.save(materia));
	}

	@Override
	public void delete(int id) {
		repository.deleteById(BigInteger.valueOf(id));		
	}

	@Override
	public boolean exist(int id) {		
		return repository.existsById(BigInteger.valueOf(id));
	}

}
