package com.plateformeweb.orientation.etudiant.ml.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_postulations")
public class PostulationOffres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
}
