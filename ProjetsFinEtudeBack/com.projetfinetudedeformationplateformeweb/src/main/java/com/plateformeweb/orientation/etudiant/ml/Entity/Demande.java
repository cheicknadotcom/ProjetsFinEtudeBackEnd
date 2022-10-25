package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Demande implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private TypeDemande typeDemande;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT")
	private Date dateDepot;
	@JoinColumn (name="demande_id")
	Etudiant etudiant;
	public Demande(Long id,String type,Etudiant etudiant) {
		this.id = id;
		this.typeDemande = TypeDemande.valueOf(type);
		this.etudiant = etudiant;
	}
	public Demande(Long id,TypeDemande type,Date depot) {
		this.id = id;
		this.typeDemande = type;
		this.dateDepot = depot;
	}
}
