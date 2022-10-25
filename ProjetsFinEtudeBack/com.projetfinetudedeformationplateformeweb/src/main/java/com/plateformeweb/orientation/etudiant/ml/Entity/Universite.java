package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_Universite",uniqueConstraints = {@UniqueConstraint(columnNames = "descriptionUniversite"),@UniqueConstraint(columnNames = "Siret")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Universite extends Users {
	@Column(name = "descriptionUniversite")
	private String descriptionuniversite;
	@Column(name = "siteUniversite")
	private String siteUniversite;
	@Column(name = "Siret")
	private String siret;
	@JsonIgnore
	@OneToMany(mappedBy = "universite")
	private Set<FiliereUniversite> filieres = new HashSet<>();
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Orientation_etudiant_id",referencedColumnName = "id")
	private OrientationEtudiant orientation;
	@JsonIgnore
	@OneToMany(mappedBy = "universite")
	private Set<DemandeInscription> demandeInscription = new HashSet<>();
	public Universite(Long id,String name,String type,String addresse,String tel,String email,String password,String description) {
		super(id,name,type,addresse,tel,email,password);
		this.descriptionuniversite = description;
	}
	public Universite(String addresseEmail,String password,String siret) {
		super(addresseEmail,password);
		this.siret = siret;
	}
	public Universite(String addresseEmail,String password,String tel,String siret) {
		super(addresseEmail,password,tel);
		this.siret = siret;
	}
}