package com.tercalivre.api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artigo")
public class Artigo implements Serializable {

	private static final long serialVersionUID = -2048064333427095294L;

	@Id
	private Long id;

	private String titulo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
