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

import com.sportello.sportello.model.Prenotazione;
import com.sportello.sportello.service.ServicePrenotazioneImpl;

@RestController
@RequestMapping("/prenotazioni")
public class IndexControllerPrenotazione {

	@Autowired
	private ServicePrenotazioneImpl servicePrenotazioneImpl;

	@GetMapping("/all")
	public List<Prenotazione> getAllPrenotazione() {

		return servicePrenotazioneImpl.getAllPrenotazione();
	}

	@GetMapping(value = "/cerca/{id}")
	public Optional<Prenotazione> getPrenotazione(@PathVariable Long id) {
		return servicePrenotazioneImpl.getPrenotazione(id);
	}

	@GetMapping(value = "/cognome/{cognome}")
	public List<Prenotazione> selActiveSurname(@PathVariable String cognome) {
		return servicePrenotazioneImpl.selActiveSurname(cognome);
	}

	@GetMapping(value = "/ordine/{numero}")
	public String selActiveSurname(@PathVariable int numero) {
		return servicePrenotazioneImpl.selActiveNumber(numero);
	}

	@GetMapping(value = "/prenota/{cognome}")
	public void prenota(@PathVariable String cognome) {
		servicePrenotazioneImpl.prenota(cognome);
	}

	@GetMapping(value = "/estrai/{id}")
	public List<Prenotazione> estrazione(@PathVariable Long id) throws Exception {
		return servicePrenotazioneImpl.estrai(id);
	}

	@RequestMapping(value = "/rinuncia/{id}", method = RequestMethod.DELETE)
	public void rinuncia(@PathVariable Long id) throws Exception {
		servicePrenotazioneImpl.rinuncia(id);
	}

	@GetMapping(value = "/attesa/{id}")
	public List<Prenotazione> attesa(@PathVariable Long id) throws Exception {
		return servicePrenotazioneImpl.attesa(id);
	}

	@PostMapping(value = "/add")
	public void addPrenotazione(@RequestBody Prenotazione prenotazione) {
		servicePrenotazioneImpl.addPrenotazione(prenotazione);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public void updatePrenotazione(@PathVariable Long id, @RequestBody Prenotazione prenotazione) {
		servicePrenotazioneImpl.updatePrenotazione(id, prenotazione);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deletePrenotazione(@PathVariable Long id) {
		servicePrenotazioneImpl.removePrenotazione(id);
	}
}
