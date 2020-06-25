package com.g_vente.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import com.g_vente.entity.ProduitS;
import com.g_vente.service.ProduitSService;

@ManagedBean(name="stockBean")
@SessionScoped
@Component
public class ProduitStockBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -243226071452829737L;

	@ManagedProperty(value = "#{stockService}")
	ProduitSService stockService;
	
	private int codePdt;
	private String nomPdt;
	private String descPdt;
	private int prixPdt;
	private int qtePdt;
	
	private ProduitS produitS = new ProduitS();
	
	public ProduitS getProduitS() {
		return produitS;
	}

	public void setProduitS(ProduitS produitS) {
		this.produitS = produitS;
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

	

	public ProduitSService getStockService() {
		return stockService;
	}

	public void setStockService(ProduitSService stockService) {
		this.stockService = stockService;
	}


	public List<ProduitS> getAll() {
		return stockService.findAll();
	}
	
}
