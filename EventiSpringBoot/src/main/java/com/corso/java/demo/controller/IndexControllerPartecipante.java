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

import com.corso.java.demo.model.Partecipante;
import com.corso.java.demo.service.ServicePartecipanteImpl;

@RestController
@RequestMapping("/partecipanti")
public class IndexControllerPartecipante {
	@Autowired
	private ServicePartecipanteImpl servicePartecipanteImpl;

	@GetMapping("/all")
	public List<Partecipante> getAllPartecipante() {

		return servicePartecipanteImpl.getAllPartecipante();
	}

	@GetMapping(value = "/cerca/{id}")
	public Optional<Partecipante> getPartecipante(@PathVariable Long id) {
		return servicePartecipanteImpl.getPartecipante(id);
	}

	@GetMapping(value = "/filtro/{nome}")
	public List<Partecipante> getPartecipanteFiltroNome(@PathVariable String nome) {
		return servicePartecipanteImpl.selActiveName(nome);
	}

	@GetMapping(value = "/filtroP/{pagamento}")
	public List<Partecipante> getPartecipanteFiltroPagamento(@PathVariable String pagamento) {
		return servicePartecipanteImpl.selActivePagamento(pagamento);
	}

	@GetMapping(value = "/filtroQ")
	public List<Partecipante> getPartecipanteFiltroQuota() {
		return servicePartecipanteImpl.selQuotaVersata();
	}

	@GetMapping(value = "/filtroS")
	public List<String> getPartecipanteFiltroSomma() {
		return servicePartecipanteImpl.selSomma();
	}

	@PostMapping(value = "/add")
	public void addPartecipante(@RequestBody Partecipante partecipante) {
		servicePartecipanteImpl.addPartecipante(partecipante);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updatePartecipante(@PathVariable Long id, @RequestBody Partecipante partecipante) {
		servicePartecipanteImpl.updatePartecipante(id, partecipante);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deletePartecipante(@PathVariable Long id) {
		servicePartecipanteImpl.removePartecipante(id);
	}
}
