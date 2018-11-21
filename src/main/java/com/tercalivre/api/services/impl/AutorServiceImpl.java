package com.tercalivre.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tercalivre.api.entities.Autor;
import com.tercalivre.api.repositories.AutorRepository;
import com.tercalivre.api.services.AutorService;

@Service
public class AutorServiceImpl implements AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public Autor cadastrar(Autor autor) {
		return this.autorRepository.save(autor);
	}

	@Override
	public Page<Autor> getAll(PageRequest pageRequest) {
		return this.autorRepository.findAll(pageRequest);
	}
}
