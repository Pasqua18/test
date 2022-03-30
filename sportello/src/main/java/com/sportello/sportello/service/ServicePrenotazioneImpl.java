package com.sportello.sportello.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportello.sportello.model.Prenotazione;
import com.sportello.sportello.repository.PrenotazioneRepository;

@Service
public class ServicePrenotazioneImpl implements ServicePrenotazione {

	@Autowired
	private PrenotazioneRepository prenotazioneRepository;

	@Override
	public List<Prenotazione> getAllPrenotazione() {
		// TODO Auto-generated method stub
		return prenotazioneRepository.findAll();
	}

	@Override
	public Optional<Prenotazione> getPrenotazione(Long id) {
		// TODO Auto-generated method stub
		return prenotazioneRepository.findById(id);
	}

	@Override
	public void addPrenotazione(Prenotazione prenotazione) {
		// TODO Auto-generated method stub
		prenotazioneRepository.save(prenotazione);
	}

	@Override
	public void updatePrenotazione(Long id, Prenotazione prenotazione) {
		// TODO Auto-generated method stub
		prenotazione.setId(id);
		prenotazioneRepository.save(prenotazione);
	}

	@Override
	public void removePrenotazione(Long id) {
		// TODO Auto-generated method stub
		prenotazioneRepository.deleteById(id);
	}

	@Override
	public List<Prenotazione> selActiveSurname(String cognome) {
		// TODO Auto-generated method stub
		return prenotazioneRepository.selActiveSurname(cognome);
	}

	@Override
	public String selActiveNumber(int nOrdine) {
		// TODO Auto-generated method stub
		return prenotazioneRepository.selActiveNumber(nOrdine);
	}

	@Override
	public void prenota(String cognome) {
		// TODO Auto-generated method stub
		Long id = prenotazioneRepository.findByCognome(cognome);
		System.out.println("ID:" + id);
		// se il cognome non esiste,allora non viene inviata la query di inserimento
		if (id != null) {
			prenotazioneRepository.insertInto(id);
		}

	}

	@Override
	public List<Prenotazione> estrai(Long id) throws Exception {
		// TODO Auto-generated method stub
		if (!getPrenotazione(id).isEmpty()) {
			return prenotazioneRepository.estrai(id);
		} else {
			throw new Exception("ID non esistente!");
		}

	}

	@Override
	public void rinuncia(Long id) throws Exception {
		// TODO Auto-generated method stub
		if (!getPrenotazione(id).isEmpty()) {
			prenotazioneRepository.deleteById(id);
		} else {
			throw new Exception("ID non esistente!");
		}
	}

	@Override
	public List<Prenotazione> attesa(Long id) throws Exception {
		// TODO Auto-generated method stub
		if (!getPrenotazione(id).isEmpty()) {
			return prenotazioneRepository.attesa(id);
		} else {
			throw new Exception("ID non esistente!");
		}

	}

}
