package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_DemandesInscription",uniqueConstraints = {@UniqueConstraint(columnNames = "matricule"),@UniqueConstraint(columnNames = "filieres")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemandeInscription extends Demande implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT")
	private Date dateInscription;
	private String codeClasse;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn (name="demandes_inscription_id")
	private FiliereUniversite filieres;
	@Column(name = "Montant")
	private double montant;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT")
	private Date dateVersement;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "universite_id",referencedColumnName = "id")
	private Universite universite;
	public DemandeInscription(Long id,String typeDemande,Date deteInscription,Etudiant etudiant,FiliereUniversite filiere,Universite universite) {
		super(id,typeDemande,etudiant);
		this.dateInscription = deteInscription;
		this.filieres = filiere;
		this.universite = universite;
	}
}
