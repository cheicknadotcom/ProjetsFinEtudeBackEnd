package com.plateformeweb.orientation.etudiant.ml.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.Etudiant;
import com.plateformeweb.orientation.etudiant.ml.Entity.EtudiantCv;
import com.plateformeweb.orientation.etudiant.ml.Repository.EtudiantCvRepository;

@Service
public class EtudiantcvServices {
	@Autowired
	EtudiantCvRepository etudiantcvRepository;
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	Etudiant etudiant;
	public EtudiantCv addEtudiantcv(EtudiantCv etudiantcv) {
		etudiantcv.setEtudiant(getEtudiant());
		return etudiantcvRepository.save(etudiantcv);
	}

}
