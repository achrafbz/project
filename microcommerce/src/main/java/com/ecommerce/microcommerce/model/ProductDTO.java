package com.ecommerce.microcommerce.model;

public class ProductDTO {

	private Integer idDTO;
	private String nomDTO;
	private int prixDTO;
	private int prixAchatDTO;

	public ProductDTO() {

	}

	public Integer getIdDTO() {
		return idDTO;
	}

	public void setIdDTO(Integer idDTO) {
		this.idDTO = idDTO;
	}

	public String getNomDTO() {
		return nomDTO;
	}

	public void setNomDTO(String nomDTO) {
		this.nomDTO = nomDTO;
	}

	public int getPrixDTO() {
		return prixDTO;
	}

	public void setPrixDTO(int prixDTO) {
		this.prixDTO = prixDTO;
	}

	public int getPrixAchatDTO() {
		return prixAchatDTO;
	}

	public void setPrixAchatDTO(int prixAchatDTO) {
		this.prixAchatDTO = prixAchatDTO;
	}

}
