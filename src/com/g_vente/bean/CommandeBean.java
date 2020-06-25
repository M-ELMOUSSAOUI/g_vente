package com.g_vente.bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.g_vente.entity.Client;
import com.g_vente.entity.Commande;
import com.g_vente.entity.ProduitP;
import com.g_vente.entity.ProduitS;
import com.g_vente.service.ClientService;
import com.g_vente.service.CommandeService;
import com.g_vente.service.ProduitPService;
import com.g_vente.service.ProduitSService;

@ManagedBean(name="cmdBean")
@SessionScoped
public class CommandeBean {
		
	@ManagedProperty("#{commandeService}")
	CommandeService cmdService;
	
	@ManagedProperty(value="#{produitPService}")
	ProduitPService produitPService;
	
	@ManagedProperty(value="#{stockService}")
	ProduitSService produitSService;
	
	@ManagedProperty(value="#{clientService}")
	ClientService clientService;
	
	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public ProduitSService getProduitSService() {
		return produitSService;
	}

	public void setProduitSService(ProduitSService produitSService) {
		this.produitSService = produitSService;
	}

	private Commande commande = new Commande();
	private Client clt = new Client();
	
	public Client getClt() {
		return clt;
	}

	public void setClt(Client clt) {
		this.clt = clt;
	}

	private int data;

	public int getData() {
		return data;
	}

	public void setData(int data) {
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
	
	public String addCommande() {
			ProduitP produitP =produitPService.findById(data);
			ProduitS produitS = new ProduitS();
			produitS = produitSService.findByName(produitP.getNomPdt());
			
			Client c = clientService.findByName(clt.getNomClt());
			
			LocalDate dateNow = LocalDate.now();
			ZoneId defaultZoneId = ZoneId.systemDefault();
			Date d = Date.from(dateNow.atStartOfDay(defaultZoneId).toInstant());
			
			if(commande.getQteCmd()<=produitS.getQtePdt()) {
				commande.setProduitP(produitP);
				commande.setDateCmd(d);
				commande.setClient(c);
				
				cmdService.addCommand(commande);
				
				int newQte = produitS.getQtePdt()-commande.getQteCmd();
					produitS.setQtePdt(newQte);
					produitSService.update(produitS);
					return "view/index";
			}
			return null;
	}
	
	public String goTo() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		data = Integer.parseInt(ctx.getExternalContext().getRequestParameterMap().get("id")) ;
		
		return "/accueil";
		
	}
}
