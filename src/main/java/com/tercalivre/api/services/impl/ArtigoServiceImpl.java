package com.tercalivre.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tercalivre.api.entities.Artigo;
import com.tercalivre.api.repositories.ArtigoRepository;
import com.tercalivre.api.services.ArtigoService;

@Service
public class ArtigoServiceImpl implements ArtigoService {

	@Autowired
	private ArtigoRepository artigoRepository;

	@Override
	public Artigo cadastrar(Artigo artigo) {
		return this.artigoRepository.save(artigo);
	}

	@Override
	public Page<Artigo> getAll(PageRequest pageRequest) {
		return this.artigoRepository.findAll(pageRequest);
	}
}
