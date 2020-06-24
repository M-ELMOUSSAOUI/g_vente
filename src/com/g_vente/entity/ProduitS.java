package com.g_vente.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produitStock")
public class ProduitS implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4927182034070768561L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codePdt;
	
	@Column
	private String nomPdt;
	
	@Column
	private String descPdt;
	
	@Column
	private int prixPdt;
	
	@Column
	private int qtePdt;
	
	public ProduitS() {
		
	}

	public int getCodePdt() {
		return codePdt;
	}

	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
	}

	public String getNomPdt() {
		return nomPdt;
	}

	public void setNomPdt(String nomPdt) {
		this.nomPdt = nomPdt;
	}

	public String getDescPdt() {
		return descPdt;
	}

	public void setDescPdt(String descPdt) {
		this.descPdt = descPdt;
	}

	public int getPrixPdt() {
		return prixPdt;
	}

	public void setPrixPdt(int prixPdt) {
		this.prixPdt = prixPdt;
	}

	public int getQtePdt() {
		return qtePdt;
	}

	public void setQtePdt(int qtePdt) {
		this.qtePdt = qtePdt;
	}

	@Override
	public String toString() {
		return "ProduitS [codePdt=" + codePdt + ", nomPdt=" + nomPdt + ", descPdt=" + descPdt + ", prixPdt=" + prixPdt
				+ ", qtePdt=" + qtePdt + "]";
	}

	
	
	
}
