package com.tercalivre.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tercalivre.api.entities.Categoria;
import com.tercalivre.api.repositories.CategoriaRepository;
import com.tercalivre.api.services.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria cadastrar(Categoria categoria) {
		return this.categoriaRepository.save(categoria);
	}

	@Override
	public Page<Categoria> getAll(PageRequest pageRequest) {
		return this.categoriaRepository.findAll(pageRequest);
	}
}
