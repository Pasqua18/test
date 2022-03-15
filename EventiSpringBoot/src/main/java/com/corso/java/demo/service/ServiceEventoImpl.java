package com.corso.java.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corso.java.demo.model.Evento;
import com.corso.java.demo.repository.EventoRepository;

@Service
public class ServiceEventoImpl implements ServiceEvento {
	@Autowired
	private EventoRepository eventoRepository;

	@Override
	public List<Evento> getAllEvento() {
		// TODO Auto-generated method stub
		return eventoRepository.findAll();
	}

	@Override
	public Optional<Evento> getEvento(Long id) {
		// TODO Auto-generated method stub
		return eventoRepository.findById(id);
	}

	@Override
	public void addEvento(Evento evento) {
		// TODO Auto-generated method stub
		eventoRepository.save(evento);
	}

	@Override
	public void updateEvento(Long id, Evento evento) {
		// TODO Auto-generated method stub
		evento.setIdEvento(id);
		eventoRepository.save(evento);
	}

	@Override
	public void removeEvento(Long id) {
		// TODO Auto-generated method stub
		eventoRepository.deleteById(id);
	}

	public List<Evento> selActiveName(String nome) {
		// TODO Auto-generated method stub
		return eventoRepository.selActiveName(nome);
	}

	public List<Evento> selActiveDays(int giorni) {
		// TODO Auto-generated method stub
		return eventoRepository.selActiveDays(giorni);
	}

}
