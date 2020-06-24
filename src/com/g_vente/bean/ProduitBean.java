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
import com.test.utils.ListProduitP;

@ManagedBean
@SessionScoped
public class ProduitBean {
	
	@ManagedProperty(value="#{produitPService}")
	ProduitPService produitPService;
	
	@ManagedProperty(value="#{stockService}")
	ProduitSService produitSService;
	
	private int codePdt;
	private String nomPdt;
	private String descPdt;
	private int prixPdt;
	
	private ProduitP produitP =  new ProduitP();
	private ProduitS produitS = new ProduitS();
	
	private List<ListProduitP> products;
	
	public List<ListProduitP> getProducts() {
		products = new ArrayList<ListProduitP>();
			for (ProduitP pp : produiPrixList) {
				for (ProduitS ps : produitStockList) {
					if (ps.getNomPdt().equals(pp.getNomPdt())) {
						ListProduitP p = new ListProduitP();
						if(ps.getQtePdt()>0) {
						p.setCodePdt(pp.getCodePdt());
						p.setNomPdt(pp.getNomPdt());
						p.setPrixPdt(pp.getPrixPdt());
						p.setQtePdt(ps.getQtePdt());
						products.add(p);
					} }
					else {
						continue;
					}
				}
			}
		return products;
	}
	public void setProducts(List<ListProduitP> products) {
		this.products = products;
	}

	private List<ProduitP> produiPrixList;
	private List<ProduitS> produitStockList;

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

	@PostConstruct
	public void init() {
		//get the products from the stock and push it into magazine
		produitStockList = produitSService.findAll();
		
		if(!produitStockList.isEmpty()) {
			for (ProduitS ps : produitStockList) {
				produitP.setCodePdt(ps.getCodePdt());
				produitP.setNomPdt(ps.getNomPdt());
				produitP.setDescPdt(ps.getDescPdt());
				produitP.setPrixPdt(0);
				 produitPService.save(produitP);
			}}
		produiPrixList=produitPService.findAll();
		
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
		produitPService.save(produitP);
	}
	
	
	public void remove(ProduitP p) {
		produitPService.delete(p);
	}

	
}
