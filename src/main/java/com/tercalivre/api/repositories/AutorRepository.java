package com.tercalivre.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tercalivre.api.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
