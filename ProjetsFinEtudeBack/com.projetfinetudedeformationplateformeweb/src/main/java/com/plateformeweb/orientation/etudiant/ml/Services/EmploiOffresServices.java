package com.plateformeweb.orientation.etudiant.ml.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.EmploiOffres;
import com.plateformeweb.orientation.etudiant.ml.Repository.EmploiOffresRepository;

@Service
public class EmploiOffresServices {
	@Autowired
	EmploiOffresRepository emploiOffresRepository;
	
	public EmploiOffres ajouterEmploiOffres(EmploiOffres emploiOffres) {
		return emploiOffresRepository.save(emploiOffres);
	}
	public EmploiOffres updateEmploiOffres(EmploiOffres emploiOffres) {
		return emploiOffresRepository.save(emploiOffres);
	}
	public void deleteEmploiOffres(Long id) {
		emploiOffresRepository.deleteById(id);
	}
}
