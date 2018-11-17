package com.tercalivre.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.tercalivre.api.entities.Categoria;

public interface CategoriaService {

	Categoria cadastrar(Categoria categoria);

	Page<Categoria> getAll(PageRequest pageRequest);

}
