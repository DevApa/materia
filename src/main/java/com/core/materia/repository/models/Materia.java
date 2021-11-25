package com.core.materia.repository.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.type.TrueFalseType;


@Entity
@Table(name = "materia")
public class Materia implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private BigInteger id;
	
	@Column(name = "nombre",length = 100, nullable = false)
	private String name;
	
	@Column(name = "descripcion")
	private String description;
	
	@Column(name = "id_area")
	private Integer idArea;
	
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@Column(name = "creado_en")
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_at;
	
	@Column(name = "editado_en")
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_at;
	
	public Materia() {}

	public Materia(BigInteger id, String name, String description, int idArea, int idUsuario, Date create_at, Date update_at) {	
		this.id = id;
		this.name = name;
		this.description = description;
		this.idArea = idArea;
		this.idUsuario = idUsuario;
		this.create_at = create_at;
		this.update_at = update_at;
	}

	public BigInteger getId() {return id;}

	public void setId(BigInteger id) {this.id = id;}

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
