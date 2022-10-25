package com.plateformeweb.orientation.etudiant.ml.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_Etudiant",uniqueConstraints = {@UniqueConstraint(columnNames = "matricule"),@UniqueConstraint(columnNames = "codeNationalite")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Etudiant extends Users {
	@Column(name = "matricule")
	private String matricule;
	@Column(name = "prenomEtudiant")
	private String prenomEtudiant;
	@Column(name = "codePostal")
	private String codePostal;
	@Column(name = "ville")
	private String villeEtudiant;
	@Column(name = "lieuNaissance")
	private String lieuDeNaissance;
	@Column(name = "TypeEtudiant")
	private TypeEtudiant typeEtudiant;
	@Column(name = "nomPere")
	private String nomPere;
	@Column(name = "profPere")
	private String profPere;
	@Column(name = "nomMere")
	private String nomMere;
	@Column(name = "profMere")
	private String profMere;
	@Column(name = "tuteur")
	private String tuteur;
	@Column(name = "profTuteur")
	private String profTuteur;
	@Column(name = "quartier")
	private String quartier;
	@Column(name = "carre")
	private String carre;
	@Column(name = "concession")
	private String concession;
	@Column(name = "codeClasse")
	private String codeClasse;
	@Column(name = "codeEtablissmente")
	private String codeEtablissement;
	@Column(name = "etablissement")
	private String etablissement;
	@Column(name = "classe")
	private String classe;
	@Column(name = "cintuteur")
	private String cintuteur;
	@Column(name = "Genre")
	private Genre genre;
	@Column(name = "codeNationalite")
	private String codeNationalite;
	@Column(name = "telTuteur")
	private String telTuteur;
	@Column(name = "anneeEntreEtudiant")
	private int anneeEntreEtudiant;
	
}
