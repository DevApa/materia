package com.core.materia.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.core.materia.controllers.dto.MateriaDTO;
import com.core.materia.repository.models.Materia;

public class ModelMap {
	public static final MateriaDTO modelToDto(Materia area) {
        return new ModelMapper().map(area, MateriaDTO.class);
    }

    public static final Materia dtoToModel(MateriaDTO materiaDTO) {
        return new ModelMapper().map(materiaDTO, Materia.class);
    }

    public static final List<MateriaDTO> listMapModelToListDto(List<Materia> areas) {
        return areas.stream().map(ModelMap::modelToDto).collect(Collectors.toList());
    }

    public static final List<Materia> listMapDtoToListModel(List<MateriaDTO> areasDto) {
        return areasDto.stream().map(ModelMap::dtoToModel).collect(Collectors.toList());
    }
}
