package com.corso.java.demo.service;

import java.util.List;
import java.util.Optional;

import com.corso.java.demo.model.Partecipante;

public interface ServicePartecipante {

	public List<Partecipante> getAllPartecipante();

	public Optional<Partecipante> getPartecipante(Long id);

	public void addPartecipante(Partecipante partecipante);

	public void updatePartecipante(Long id, Partecipante partecipante);

	public void removePartecipante(Long id);

	public List<Partecipante> selActiveName(String nome);

	public List<Partecipante> selActivePagamento(String metodoPagamento);

	List<Partecipante> selQuotaVersata();

	List<String> selSomma();
}
