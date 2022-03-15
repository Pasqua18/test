package com.corso.java.demo.model;

//import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partecipanti")
public class Partecipante {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_partecipante")
	private Long idPartecipante;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	@Column(name = "affiliazione")
	private String affiliazione;
	@Column(name = "metodo_pagamento")
	private String metodoPagamento;
	@Column(name = "importo_versato")
	private String importoVersato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_evento", referencedColumnName = "id_evento")
	private Evento evento;

	public Partecipante(Long idPartecipante, String nome, String cognome, String affiliazione, String metodoPagamento,
			String importoVersato, Evento evento) {
		super();
		this.idPartecipante = idPartecipante;
		this.nome = nome;
		this.cognome = cognome;
		this.affiliazione = affiliazione;
		this.metodoPagamento = metodoPagamento;
		this.importoVersato = importoVersato;
		this.evento = evento;
	}

	public Partecipante(String nome, String cognome, String affiliazione, String metodoPagamento, String importoVersato,
			Evento evento) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.affiliazione = affiliazione;
		this.metodoPagamento = metodoPagamento;
		this.importoVersato = importoVersato;
		this.evento = evento;
	}

	public Partecipante() {
		super();
	}

	public Long getIdPartecipante() {
		return idPartecipante;
	}

	public void setIdPartecipante(Long idPartecipante) {
		this.idPartecipante = idPartecipante;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getAffiliazione() {
		return affiliazione;
	}

	public void setAffiliazione(String affiliazione) {
		this.affiliazione = affiliazione;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getImportoVersato() {
		return importoVersato;
	}

	public void setImportoVersato(String importoVersato) {
		this.importoVersato = importoVersato;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
