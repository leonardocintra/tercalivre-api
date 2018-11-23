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

import com.tercalivre.api.dtos.ArtigoDto;
import com.tercalivre.api.entities.Artigo;
import com.tercalivre.api.response.TercaLivreResponse;
import com.tercalivre.api.services.ArtigoService;

@RestController
@RequestMapping("/v1/artigo")
@CrossOrigin(origins = "*")
public class ArtigoController {

	@Autowired
	private ArtigoService artigoService;

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public ArtigoController() {

	}

	@GetMapping(value = "/")
	public ResponseEntity<TercaLivreResponse<Page<ArtigoDto>>> buscarTodosArtigoes(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "ord", defaultValue = "id") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir) {
		
		TercaLivreResponse<Page<ArtigoDto>> response = new TercaLivreResponse<Page<ArtigoDto>>();
		PageRequest pageRequest = PageRequest.of(page, this.qtdPorPagina, Direction.valueOf(dir), ord);
		Page<Artigo> artigoes = this.artigoService.getAll(pageRequest);
		Page<ArtigoDto> artigoesDto = artigoes.map(artigo -> this.converterArtigoDto(artigo));
		
		response.setData(artigoesDto);
		return ResponseEntity.ok(response);
	}

	private ArtigoDto converterArtigoDto(Artigo artigo) {
		ArtigoDto artigoDto = new ArtigoDto();
		artigoDto.setId(artigo.getId());
		artigoDto.setTitulo(artigo.getTitulo());
		return artigoDto;
	}

	private Artigo converterDtoParaArtigo(ArtigoDto artigoDto) {
		Artigo artigo = new Artigo();
		artigo.setId(artigoDto.getId());
		artigo.setTitulo(artigoDto.getTitulo());
		return artigo;
	}

}
