package com.corso.java.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.corso.java.demo.model.Evento;
import com.corso.java.demo.service.ServiceEventoImpl;

@RestController
@RequestMapping("/eventi")
public class IndexControllerEventi {

	@Autowired
	private ServiceEventoImpl serviceEventoImpl;

	@GetMapping("/all")
	public List<Evento> getAllEvento() {

		return serviceEventoImpl.getAllEvento();
	}

	@GetMapping(value = "/cerca/{id}")
	public Optional<Evento> getEvento(@PathVariable Long id) {
		return serviceEventoImpl.getEvento(id);
	}

	@GetMapping(value = "/filtro/{nome}")
	public List<Evento> getEventoFiltroNome(@PathVariable String nome) {
		return serviceEventoImpl.selActiveName(nome);
	}

	@GetMapping(value = "/filtroG/{giorni}")
	public List<Evento> getEventoFiltroGiorni(@PathVariable int giorni) {
		return serviceEventoImpl.selActiveDays(giorni);
	}

	@PostMapping(value = "/add")
	public void addEvento(@RequestBody Evento evento) {
		serviceEventoImpl.addEvento(evento);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateEvento(@PathVariable Long id, @RequestBody Evento evento) {
		serviceEventoImpl.updateEvento(id, evento);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteEvento(@PathVariable Long id) {
		serviceEventoImpl.removeEvento(id);
	}

}
