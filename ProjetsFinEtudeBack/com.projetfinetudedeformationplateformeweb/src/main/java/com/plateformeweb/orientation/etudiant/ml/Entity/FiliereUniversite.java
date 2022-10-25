package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_filieres",uniqueConstraints = {@UniqueConstraint(columnNames = "Description")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class FiliereUniversite implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFiliere;
	@Column(name = "NomFiliere",nullable = false)
	private String nameFiliere;
	@Column(name = "Description")
	private String descriptionFilieres;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "universite_id",referencedColumnName = "id")
	private Universite universite;

}
