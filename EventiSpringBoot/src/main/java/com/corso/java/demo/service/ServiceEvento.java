package com.corso.java.demo.service;

import java.util.List;
import java.util.Optional;

import com.corso.java.demo.model.Evento;

public interface ServiceEvento {
	public List<Evento> getAllEvento();

	public Optional<Evento> getEvento(Long id);

	public void addEvento(Evento evento);

	public void updateEvento(Long id, Evento evento);

	public void removeEvento(Long id);

	public List<Evento> selActiveName(String nome);

	public List<Evento> selActiveDays(int giorni);
}
