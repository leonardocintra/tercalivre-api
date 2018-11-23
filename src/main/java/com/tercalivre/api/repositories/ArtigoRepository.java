package com.tercalivre.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tercalivre.api.entities.Artigo;

public interface ArtigoRepository extends JpaRepository<Artigo, Long> {
}
