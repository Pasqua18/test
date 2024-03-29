package com.sportello.sportello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.sportello.sportello.model.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
