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

import com.tercalivre.api.dtos.CategoriaDto;
import com.tercalivre.api.entities.Categoria;
import com.tercalivre.api.response.TercaLivreResponse;
import com.tercalivre.api.services.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin(origins = "*")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public CategoriaController() {

	}

	@GetMapping(value = "/")
	public ResponseEntity<TercaLivreResponse<Page<CategoriaDto>>> buscarTodasCategorias(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "ord", defaultValue = "id") String ord,
			@RequestParam(value = "dir", defaultValue = "DESC") String dir) {
		
		TercaLivreResponse<Page<CategoriaDto>> response = new TercaLivreResponse<Page<CategoriaDto>>();
		PageRequest pageRequest = PageRequest.of(page, this.qtdPorPagina, Direction.valueOf(dir), ord);
		Page<Categoria> categorias = this.categoriaService.getAll(pageRequest);
		Page<CategoriaDto> categoriasDto = categorias.map(categoria -> this.converterCategoriaDto(categoria));
		
		response.setData(categoriasDto);
		return ResponseEntity.ok(response);
	}

	private CategoriaDto converterCategoriaDto(Categoria categoria) {
		CategoriaDto categoriaDto = new CategoriaDto();
		categoriaDto.setId(categoria.getId());
		categoriaDto.setDescricao(categoria.getDescricao());
		return categoriaDto;
	}

	private Categoria converterDtoParaCategoria(CategoriaDto categoriaDto) {
		Categoria categoria = new Categoria();
		categoria.setId(categoriaDto.getId());
		categoria.setDescricao(categoriaDto.getDescricao());
		return categoria;
	}

}
