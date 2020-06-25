package com.g_vente.utils;

public class ListProduitP {

	private int codePdt;

	private String nomPdt;

	private int qtePdt;
	private int prixPdt;
	
	private boolean editable;

	public boolean isEditable() {
		return editable;
	}

	@Override
	public String toString() {
		return "ListProduitP [codePdt=" + codePdt + ", nomPdt=" + nomPdt + ", qtePdt=" + qtePdt + ", prixPdt=" + prixPdt
				+ "]";
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public ListProduitP() {
		super();
	}

	public ListProduitP(int codePdt, String nomPdt, int qtePdt, int prixPdt) {
		this.codePdt = codePdt;
		this.nomPdt = nomPdt;
		this.qtePdt = qtePdt;
		this.prixPdt = prixPdt;
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

	public int getQtePdt() {
		return qtePdt;
	}

	public void setQtePdt(int qtePdt) {
		this.qtePdt = qtePdt;
	}

	public int getPrixPdt() {
		return prixPdt;
	}

	public void setPrixPdt(int prixPdt) {
		this.prixPdt = prixPdt;
	}
}
