package com.g_vente.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.g_vente.entity.ProduitP;
import com.g_vente.entity.ProduitS;
import com.g_vente.service.ProduitPService;
import com.g_vente.service.ProduitSService;
import com.g_vente.utils.ListProduitP;

@ManagedBean
@SessionScoped
public class ProduitBean {

	@ManagedProperty(value = "#{produitPService}")
	ProduitPService produitPService;

	@ManagedProperty(value = "#{stockService}")
	ProduitSService produitSService;

	private int codePdt;
	private String nomPdt;
	private String descPdt;
	private int prixPdt;

	private ProduitP produitP = new ProduitP();
	private ProduitS produitS = new ProduitS();

	private List<ListProduitP> products;

	private List<ProduitP> produiPrixList;
	private List<ProduitS> produitStockList;

	public List<ListProduitP> getProducts() {
		
		if (!produitPService.findAll().isEmpty()) {
			
			produiPrixList = produitPService.findAll();
			produitStockList = produitSService.findAll();
			products = new ArrayList<ListProduitP>();
			for (ProduitP pp : produiPrixList) {
				for (ProduitS ps : produitStockList) {
					if (ps.getNomPdt().equals(pp.getNomPdt())) {
						ListProduitP p = new ListProduitP();
						if (ps.getQtePdt() > 0) {
							p.setCodePdt(pp.getCodePdt());
							p.setNomPdt(pp.getNomPdt());
							p.setPrixPdt(pp.getPrixPdt());
							p.setQtePdt(ps.getQtePdt());
							products.add(p);
						}
					} else {
						continue;
					}
				}
			}
			
		}
		return products;
	}

	public void setProducts(List<ListProduitP> products) {
		this.products = products;
	}

	public List<ProduitS> getProduitStockList() {
		return produitStockList;
	}

	public void setProduitStockList(List<ProduitS> produitStockList) {
		this.produitStockList = produitStockList;
	}

	public ProduitS getProduitS() {
		return produitS;
	}

	public void setProduitS(ProduitS produitS) {
		this.produitS = produitS;
	}

	public ProduitP getProduitP() {
		return produitP;
	}

	public void setProduitP(ProduitP produitP) {
		this.produitP = produitP;
	}

	public ProduitSService getProduitSService() {
		return produitSService;
	}

	public void setProduitSService(ProduitSService produitSService) {
		this.produitSService = produitSService;
	}

	public ProduitPService getProduitPService() {
		return produitPService;
	}

	public void setProduitPService(ProduitPService produitPService) {
		this.produitPService = produitPService;
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

	public List<ProduitP> getProduiPrixList() {
		return produiPrixList;
	}

	public void setProduiPrixList(List<ProduitP> produiPrixList) {
		this.produiPrixList = produiPrixList;
	}

	public int getPrixPdt() {
		return prixPdt;
	}

	public void setPrixPdt(int prixPdt) {
		this.prixPdt = prixPdt;
	}

	public void save() {

		ProduitS ps = produitSService.findByName(nomPdt);
		ProduitP pp = new ProduitP();
		pp.setCodePdt(ps.getCodePdt());
		pp.setNomPdt(ps.getNomPdt());
		pp.setDescPdt(ps.getDescPdt());
		pp.setPrixPdt(prixPdt);
		produitPService.save(pp);
	}

	public void remove(ProduitP p) {
		produitPService.delete(p);
	}
	
	public void edit() {
		int id = produitSService.findByName(nomPdt).getCodePdt();
		ProduitP pp = produitPService.findById(id);
			pp.setPrixPdt(prixPdt);
		produitPService.update(pp);
	}
}
