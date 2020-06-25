package com.g_vente.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="commandes")
public class Commande {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codeCmd;
	
	@Column
	private int qteCmd;
	
	@ManyToOne
	@JoinColumn(name="codePdt")
	private ProduitP produitP;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="client",referencedColumnName = "nomClt")
	private Client client;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column
	@Temporal(TemporalType.DATE)
	private Date dateCmd;

	public Commande() {
		super();
	}

	public int getCodeCmd() {
		return codeCmd;
	}

	public void setCodeCmd(int codeCmd) {
		this.codeCmd = codeCmd;
	}

	public int getQteCmd() {
		return qteCmd;
	}

	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}

	public ProduitP getProduitP() {
		return produitP;
	}

	public void setProduitP(ProduitP produitP) {
		this.produitP = produitP;
	}

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	
}
