package com.tercalivre.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tercalivre.api.dtos.AutorDto;
import com.tercalivre.api.entities.Autor;
import com.tercalivre.api.response.TercaLivreResponse;
import com.tercalivre.api.services.AutorService;

@RestController
@RequestMapping("/v1/autor")
@CrossOrigin(origins = "*")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public AutorController() {

	}

	@GetMapping(value = "/")
	public ResponseEntity<TercaLivreResponse<Page<AutorDto>>> buscarTodosAutores(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "ord", defaultValue = "id") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir) {
		
		TercaLivreResponse<Page<AutorDto>> response = new TercaLivreResponse<Page<AutorDto>>();
		PageRequest pageRequest = PageRequest.of(page, this.qtdPorPagina, Direction.valueOf(dir), ord);
		Page<Autor> autores = this.autorService.getAll(pageRequest);
		Page<AutorDto> autoresDto = autores.map(autor -> this.converterAutorDto(autor));
		
		response.setData(autoresDto);
		return ResponseEntity.ok(response);
	}

	private AutorDto converterAutorDto(Autor autor) {
		AutorDto autorDto = new AutorDto();
		autorDto.setId(autor.getId());
		autorDto.setNome(autor.getNome());
		return autorDto;
	}

	private Autor converterDtoParaAutor(AutorDto autorDto) {
		Autor autor = new Autor();
		autor.setId(autorDto.getId());
		autor.setNome(autorDto.getNome());
		return autor;
	}

}
