package com.sportello.sportello.service;

import java.util.List;
import java.util.Optional;

import com.sportello.sportello.model.Prenotazione;

public interface ServicePrenotazione {
	public List<Prenotazione> getAllPrenotazione();

	public Optional<Prenotazione> getPrenotazione(Long id);

	public void addPrenotazione(Prenotazione prenotazione);

	public void updatePrenotazione(Long id, Prenotazione prenotazione);

	public void removePrenotazione(Long id);

	List<Prenotazione> selActiveSurname(String cognome);

	public String selActiveNumber(int nOrdine);

	public void prenota(String cognome);

	public List<Prenotazione> estrai(Long id) throws Exception;
	
	public void rinuncia(Long id) throws Exception;

	List<Prenotazione> attesa(Long id) throws Exception;
}
