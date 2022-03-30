package com.sportello.sportello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportello.sportello.model.Persona;
import com.sportello.sportello.repository.PersonaRepository;

@Service
public class ServicePersonaImpl implements ServicePersona {

	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public List<Persona> getAllPersona() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	public Optional<Persona> getPersona(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id);
	}

	@Override
	public void addPersona(Persona persona) {
		// TODO Auto-generated method stub
		personaRepository.save(persona);
	}

	@Override
	public void updatePersona(Long id, Persona persona) {
		// TODO Auto-generated method stub
		persona.setId(id);
		personaRepository.save(persona);
	}

	@Override
	public void removePersona(Long id) {
		// TODO Auto-generated method stub
		personaRepository.deleteById(id);
	}

}
