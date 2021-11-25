package com.core.materia.controllers.dto;

import java.sql.Date;

import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;


public class MateriaDTO {	
	
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String description;
	@NonNull
	private Integer idArea;
	@NonNull
	private Integer idUsuario;
	
	private Date create_at;
	
	private Date update_at;
	
	public MateriaDTO() {}

	public MateriaDTO(int id, String name, String description, int idArea, int idUsuario, Date create_at, Date update_at) {	
		this.id = id;
		this.name = name;
		this.description = description;
		this.idArea = idArea;
		this.idUsuario = idUsuario;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {this.id = id;}

	public String getName() {return name;}

	public void setName(String name) {this.name = name;}

	public String getDescription() {return description;}

	public void setDescription(String description) {this.description = description;}
	
	public int getIdArea() {return idArea;}

	public void setIdArea(int idArea) {this.idArea = idArea;}

	public int getIdUsuario() {return idUsuario;}

	public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}	

	public Date getCreate_at() {return create_at;}

	public void setCreate_at(Date create_at) {this.create_at = create_at;}

	public Date getUpdate_at() {return update_at;}

	public void setUpdate_at(Date update_at) {this.update_at = update_at;}		
}
