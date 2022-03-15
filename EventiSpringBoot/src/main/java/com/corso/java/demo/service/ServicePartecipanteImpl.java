package com.corso.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.java.demo.model.Partecipante;
import com.corso.java.demo.repository.PartecipanteRepository;

@Service
public class ServicePartecipanteImpl implements ServicePartecipante {

	@Autowired
	private PartecipanteRepository partecipanteRepository;

	@Override
	public List<Partecipante> getAllPartecipante() {
		// TODO Auto-generated method stub
		return partecipanteRepository.findAll();
	}

	@Override
	public Optional<Partecipante> getPartecipante(Long id) {
		// TODO Auto-generated method stub
		return partecipanteRepository.findById(id);
	}

	@Override
	public void addPartecipante(Partecipante partecipante) {
		// TODO Auto-generated method stub
		partecipanteRepository.save(partecipante);
	}

	@Override
	public void updatePartecipante(Long id, Partecipante partecipante) {
		// TODO Auto-generated method stub
		partecipante.setIdPartecipante(id);
		partecipanteRepository.save(partecipante);
	}

	@Override
	public void removePartecipante(Long id) {
		// TODO Auto-generated method stub
		partecipanteRepository.deleteById(id);
	}

	@Override
	public List<Partecipante> selActiveName(String nome) {
		// TODO Auto-generated method stub
		return partecipanteRepository.selActiveName(nome);
	}

	@Override
	public List<Partecipante> selActivePagamento(String metodoPagamento) {
		// TODO Auto-generated method stub
		return partecipanteRepository.selActivePagamento(metodoPagamento);
	}

	@Override
	public List<Partecipante> selQuotaVersata() {
		// TODO Auto-generated method stub
		return partecipanteRepository.selQuotaVersata();
	}

	@Override
	public List<String> selSomma() {
		// TODO Auto-generated method stub
		return partecipanteRepository.selSomma();
	}

}
