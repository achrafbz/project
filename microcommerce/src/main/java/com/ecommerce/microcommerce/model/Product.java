package com.ecommerce.microcommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@JsonFilter("monFiltreDynamique")
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	private String nom;
	private int prix;
	private int prix_achat;

	public Product(int id, String nom, int prix, int prix_achat) {
		super();
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.prix_achat = prix_achat;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getPrix_achat() {
		return prix_achat;
	}

	public void setPrix_achat(int prix_achat) {
		this.prix_achat = prix_achat;
	}

}
