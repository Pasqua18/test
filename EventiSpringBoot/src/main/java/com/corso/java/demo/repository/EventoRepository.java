package com.corso.java.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.corso.java.demo.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
	@Query(nativeQuery = true, value = "SELECT * FROM eventi WHERE nome=?1")
	List<Evento> selActiveName(String nome);

	@Query(nativeQuery = true, value = "SELECT * FROM eventi WHERE giorni>?1")
	List<Evento> selActiveDays(int giorni);
}
