package com.tercalivre.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tercalivre.api.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
