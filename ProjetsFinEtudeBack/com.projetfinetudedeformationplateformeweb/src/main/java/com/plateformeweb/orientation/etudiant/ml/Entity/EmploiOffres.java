
package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.EqualsAndHashCode;
import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "TableEmploiOffres",uniqueConstraints = {@UniqueConstraint(columnNames = "titre"),@UniqueConstraint(columnNames = "description")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmploiOffres implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String titre;
	@Column
	private String description;
	@Column
	private String diplome;
	@Column
	private String connaissanceTechnique;
	@Column
	private String region;
	@Column
	private Double salaire;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateoffre;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "entreprise_id",referencedColumnName = "id")
	private Entreprise entreprise;
	
	
}
