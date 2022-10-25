package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_Entreprise",uniqueConstraints = {@UniqueConstraint(columnNames = "descriptionEntreprise"),@UniqueConstraint(columnNames = "Siren")})
@Data  @NoArgsConstructor  @AllArgsConstructor
public class Entreprise extends Users {
	@Column(name = "descriptionEntreprise")
	private String descriptionEntreprise;
	@Column(name = "siteEntreprise")
	private String sitesEntreprise;
	@Column(name = "slogantEntreprise")
	private String slogantEntreprise;
	@Column(name = "Siren")
	private String siren;
	@JsonIgnore
	@OneToMany(mappedBy = "entreprise")
	private Set<EmploiOffres> offres = new HashSet<>();
	public String getDescriptionEntreprise() {
		return descriptionEntreprise;
	}

	public void setDescriptionEntreprise(String descriptionEntreprise) {
		this.descriptionEntreprise = descriptionEntreprise;
	}

	public Entreprise(Long id,String nom,String type,String address,String tel,String email,String password, String description ) {
		super(id,nom,type,address,tel,email,password);
		this.descriptionEntreprise = description;
	}
	public Entreprise(String addresseEmail,String password,String tel,String siren) {
		super(addresseEmail,password,tel);
		this.siren = siren;
	}
	public Entreprise(String addresseEmail,String password,String tel,String site,String description) {
		super(addresseEmail,password,tel);
		this.sitesEntreprise =site;
		this.descriptionEntreprise = description;
	}
	public Entreprise(String addresseEmail,String password,String tel,String site,String description,String slogan) {
		this(addresseEmail,password,tel,site,description);
		this.slogantEntreprise = slogan;
	
	}
}
