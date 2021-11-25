package com.core.materia.service.contract;

import java.util.List;

import com.core.materia.controllers.dto.MateriaDTO;

public interface IMateriaService {
	List<MateriaDTO> list();
	MateriaDTO create(MateriaDTO materiaDto);
	MateriaDTO update(MateriaDTO materiaDto);
	void delete(int id);
	boolean exist(int id);
}
