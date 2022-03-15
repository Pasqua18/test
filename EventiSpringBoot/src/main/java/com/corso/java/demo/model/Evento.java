package com.corso.java.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "eventi")
public class Evento implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evento")
	private Long idEvento;
	@Column(name = "nome")
	private String nome;
	@Column(name = "num_partecipanti")
	private int numPartecipanti;
	@Column(name = "quota_iscrizione")
	private double quotaIscrizione;
	@Column(name = "giorni")
	private int giorni;
	@Column(name = "luogo")
	private String luogo;
	@Column(name = " costo_totale")
	private double costoTotale;

	public Evento(Long idEvento, String nome, int numPartecipanti, double quotaIscrizione, int giorni, String luogo,
			double costoTotale) {
		super();
		this.idEvento = idEvento;
		this.nome = nome;
		this.numPartecipanti = numPartecipanti;
		this.quotaIscrizione = quotaIscrizione;
		this.giorni = giorni;
		this.luogo = luogo;
		this.costoTotale = costoTotale;
	}

	public Evento(String nome, int numPartecipanti, double quotaIscrizione, int giorni, String luogo,
			double costoTotale) {
		super();
		this.nome = nome;
		this.numPartecipanti = numPartecipanti;
		this.quotaIscrizione = quotaIscrizione;
		this.giorni = giorni;
		this.luogo = luogo;
		this.costoTotale = costoTotale;
	}

	public Evento() {
		super();
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumPartecipanti() {
		return numPartecipanti;
	}

	public void setNumPartecipanti(int numPartecipanti) {
		this.numPartecipanti = numPartecipanti;
	}

	public double getQuotaIscrizione() {
		return quotaIscrizione;
	}

	public void setQuotaIscrizione(double quotaIscrizione) {
		this.quotaIscrizione = quotaIscrizione;
	}

	public int getGiorni() {
		return giorni;
	}

	public void setGiorni(int giorni) {
		this.giorni = giorni;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public double getCostoTotale() {
		return costoTotale;
	}

	public void setCostoTotale(double costoTotale) {
		this.costoTotale = costoTotale;
	}

}
