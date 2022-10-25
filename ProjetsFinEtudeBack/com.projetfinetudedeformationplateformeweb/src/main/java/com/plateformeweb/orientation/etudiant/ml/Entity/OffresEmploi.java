package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "TableOffresEmploi",uniqueConstraints = {@UniqueConstraint(columnNames = "typeoffres")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OffresEmploi extends EmploiOffres implements Serializable{
	@Column(name = "typeoffres")
	private TypeOffres typeoffres;
	@SuppressWarnings("static-access")
	public OffresEmploi(Long id,String titre,String description,String diplome,String connaissance,
			String region,Double salaire,Date date,Entreprise entreprise,TypeOffres type) {
		super(id,titre,description,diplome,connaissance,region,salaire,date,entreprise);
		this.typeoffres = type.EMPLOI;
	}
}
