package com.g_vente.bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.g_vente.entity.Commande;
import com.g_vente.entity.ProduitP;
import com.g_vente.service.CommandeService;
import com.g_vente.service.ProduitPService;

@ManagedBean(name="cmdBean")
@SessionScoped
public class CommandeBean {
		
	@ManagedProperty("#{commandeService}")
	CommandeService cmdService;
	
	@ManagedProperty(value="#{produitPService}")
	ProduitPService produitPService;

	private Commande commande = new Commande();
	
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public CommandeService getCmdService() {
		return cmdService;
	}

	public void setCmdService(CommandeService cmdService) {
		this.cmdService = cmdService;
	}

	public Commande getCommande() {
		return commande;
	}

	public ProduitPService getProduitPService() {
		return produitPService;
	}

	public void setProduitPService(ProduitPService produitPService) {
		this.produitPService = produitPService;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	public void add(int id) {
			FacesContext ctx = FacesContext.getCurrentInstance();
			 Map<String,String> params=ctx.getExternalContext().getRequestParameterMap();
			data = params.get("id_pdt");
			 
			System.out.println(id);
			ProduitP produitP =produitPService.findById(id);
			System.out.println("products searched is :"+produitP.toString());
			LocalDate dateNow = LocalDate.now();
			ZoneId defaultZoneId = ZoneId.systemDefault();
			Date d = Date.from(dateNow.atStartOfDay(defaultZoneId).toInstant());
		
			commande.setProduitP(produitP);
			commande.setDateCmd(d);
			commande.setQteCmd(15);
		cmdService.addCommand(commande);
	}
	
}
