package com.tercalivre.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.tercalivre.api.entities.Autor;

public interface AutorService {

	Autor cadastrar(Autor categoria);

	Page<Autor> getAll(PageRequest pageRequest);

}
