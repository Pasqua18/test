package com.sportello.sportello.controller;

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

import com.sportello.sportello.model.Persona;
import com.sportello.sportello.service.ServicePersonaImpl;

@RestController
@RequestMapping("/persone")
public class IndexControllerPersona {

	@Autowired
	private ServicePersonaImpl servicePersonaImpl;

	@GetMapping("/all")
	public List<Persona> getAllPersona() {

		return servicePersonaImpl.getAllPersona();
	}

	@GetMapping(value = "/cerca/{id}")
	public Optional<Persona> getPersona(@PathVariable Long id) {
		return servicePersonaImpl.getPersona(id);
	}

	@PostMapping(value = "/add")
	public void addPersona(@RequestBody Persona persona) {
		servicePersonaImpl.addPersona(persona);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updateEvento(@PathVariable Long id, @RequestBody Persona persona) {
		servicePersonaImpl.updatePersona(id, persona);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteEvento(@PathVariable Long id) {
		servicePersonaImpl.removePersona(id);
	}

}
