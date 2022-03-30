package com.sportello.sportello.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sportello.sportello.model.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
	// dato il cognome della persona, restituisce il numero d'ordine;
	@Query(nativeQuery = true, value = "select * from prenotazioni INNER JOIN persone on prenotazioni.fk_persona=persone.id where cognome=?1")
	List<Prenotazione> selActiveSurname(String cognome);

	// dato il numero di prenotazione, restituisce il cognome della persona
	@Query(nativeQuery = true, value = "select persone.cognome from prenotazioni INNER JOIN persone on prenotazioni.fk_persona=persone.id where prenotazioni.id=?1")
	String selActiveNumber(int nOrdine);

	//PRENOTAZIONE
	///////////////////////////////////////////////////////////////////
	// per prenotare tramite cognome devo ottenere la chiave primaria della persona
	// in questione
	@Query(nativeQuery = true, value = "select id from persone where persone.cognome=?1")
	Long findByCognome(String cognome);

	// inserisco una nuova prenotazione con la foreign key appena ottenuta
	@Transactional
	@Modifying
	@Query(value = "insert into prenotazioni (id, fk_persona) VALUES (NULL, ?1)", nativeQuery = true)
	void insertInto(long id);
	
	///////////////////////////////////////////////////////////////////
	//ESTRAI
	@Query(nativeQuery = true, value = "SELECT * FROM prenotazioni WHERE id>?1 LIMIT 1")
	List<Prenotazione> estrai(Long id);
	///////////////////////////////////////////////////////////////////
	//TEMPO ATTESA
	@Query(nativeQuery = true, value = "SELECT * FROM `prenotazioni` WHERE prenotazioni.id<?1")
	List<Prenotazione> attesa(Long id);
}
