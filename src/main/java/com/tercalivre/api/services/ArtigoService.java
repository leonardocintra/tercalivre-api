package com.tercalivre.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.tercalivre.api.entities.Artigo;

public interface ArtigoService {

	Artigo cadastrar(Artigo artigo);

	Page<Artigo> getAll(PageRequest pageRequest);

}
