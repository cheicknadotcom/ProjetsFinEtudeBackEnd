package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "TableEtudiantcv")
@Data @AllArgsConstructor @NoArgsConstructor
public class EtudiantCv implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String diplome;
	@Column
	private String specialite;
	@Column
	private String experience;
	@Column
	private String connaissance;
	@Lob
	private byte[] fichier;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn (name="etudiant_cv_id")
	private Etudiant etudiant;
	public EtudiantCv(Long id,String diplome,String specialite,String experience,String connaissance,byte[] file) {
		this.id = id;
		this.diplome = diplome;
		this.specialite = specialite;
		this.experience = experience;
		this.connaissance = connaissance;
		this.fichier = file;
	}
}
