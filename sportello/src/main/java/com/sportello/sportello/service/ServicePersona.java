package com.sportello.sportello.service;

import java.util.List;
import java.util.Optional;

import com.sportello.sportello.model.Persona;

public interface ServicePersona {
	public List<Persona> getAllPersona();

	public Optional<Persona> getPersona(Long id);

	public void addPersona(Persona persona);

	public void updatePersona(Long id, Persona persona);

	public void removePersona(Long id);
}
