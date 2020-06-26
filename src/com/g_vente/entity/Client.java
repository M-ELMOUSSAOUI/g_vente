package com.g_vente.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2158421968135843920L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codeClt;
	
	@Column
	private String nomClt;
	
	@OneToMany(mappedBy = "client",fetch = FetchType.EAGER)
	private List<Commande> commandes = new ArrayList<Commande>();

	public Client() {
		super();
	}
	
	public int getCodeClt() {
		return codeClt;
	}

	public void setCodeClt(int codeClt) {
		this.codeClt = codeClt;
	}

	public String getNomClt() {
		return nomClt;
	}

	public void setNomClt(String nomClt) {
		this.nomClt = nomClt;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	@Override
	public String toString() {
		return "Client [codeClt=" + codeClt + ", nomClt=" + nomClt + ", commandes=" + commandes + "]";
	}

	
	
}
