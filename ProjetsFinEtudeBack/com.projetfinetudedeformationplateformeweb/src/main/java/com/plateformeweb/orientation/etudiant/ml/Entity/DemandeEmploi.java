package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_DemandesEmploi",uniqueConstraints = {@UniqueConstraint(columnNames = "code"+""),@UniqueConstraint(columnNames = "libelle")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemandeEmploi extends Demande implements Serializable {
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn (name="demande_emploi_id")
	EtudiantCv etudiantcv;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn (name="demande_emploi_lettreDeMotivation")
	LettreDeMotivation lettreDeMotivation;
	@JoinColumn (name="demande_emploi_entreprise")
	Entreprise entreprise;
	@SuppressWarnings("static-access")
	public DemandeEmploi(Long id,TypeDemande type,Date date,Etudiant etudiant,EtudiantCv etudiantcv,LettreDeMotivation lettreDeMotivation,Entreprise entreprise) {
		super(id,type.EMPLOI,date,etudiant);
		this.etudiantcv = etudiantcv;
		this.lettreDeMotivation = lettreDeMotivation;
		this.entreprise = entreprise;
	}
	
}
