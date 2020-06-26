package com.g_vente.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.g_vente.entity.Client;
import com.g_vente.service.ClientService;

@ManagedBean
@SessionScoped
public class ClientBean {

	@ManagedProperty(value = "#{clientService}")
	ClientService clientService;

	private Client client = new Client();
	private List<Client> allClient;
	
	
	public List<Client> getAllClient() {
		allClient = clientService.findAll();
		return allClient;
	}

	public void setAllClient(List<Client> allClient) {
		this.allClient = allClient;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addClient() {
		
		clientService.add(client);
	}
}
