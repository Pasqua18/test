package com.corso.java.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.corso.java.demo.model.Partecipante;

@Repository
public interface PartecipanteRepository extends JpaRepository<Partecipante, Long> {
	@Query(nativeQuery = true, value = "SELECT * FROM partecipanti WHERE nome=?1")
	List<Partecipante> selActiveName(String nome);

	@Query(nativeQuery = true, value = "SELECT * FROM `partecipanti` WHERE `partecipanti`.`metodo_pagamento`=?1")
	List<Partecipante> selActivePagamento(String metodoPagamento);

	@Query(nativeQuery = true, value = "SELECT * FROM `partecipanti`,eventi WHERE partecipanti.importo_versato<eventi.quota_iscrizione and partecipanti.fk_evento=eventi.id_evento")
	List<Partecipante> selQuotaVersata();

	@Query(nativeQuery = true, value = "SELECT eventi.nome,eventi.costo_totale,SUM(partecipanti.importo_versato) as somma FROM eventi,partecipanti WHERE partecipanti.fk_evento=eventi.id_evento GROUP by id_evento HAVING eventi.costo_totale>SUM(partecipanti.importo_versato)")
	List<String> selSomma();
}
