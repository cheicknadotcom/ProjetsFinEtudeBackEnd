package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.Etudiant;
import com.plateformeweb.orientation.etudiant.ml.Entity.Users;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.EtudiantRepository;
import com.plateformeweb.orientation.etudiant.ml.Security.SecurityConfig;

@Service
public class EtudiantServices {
	@Autowired
	EtudiantRepository etudiantRepository;
	
	Etudiant etudiant;
	
	Users users; 
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Etudiant addEtudiant(Etudiant etudiant) {
		etudiant.setTypeUsers("Etudiant");
		etudiant.setPasswordUser(SecurityConfig.crypt(etudiant.getPasswordUser()));
		return etudiantRepository.save(etudiant);
	}
	public List<Etudiant> listEtudiantService(){
		return etudiantRepository.findAll();
	}
	public Etudiant updateEtudiant(Etudiant etudiant)
	{
		
		return etudiantRepository.save(etudiant);
	}

	public Etudiant findEtudiantsById(Long id) {
		return etudiantRepository.findEtudiantById(id).orElseThrow(() -> new UserNotFoundException("Cet etudiant d'identifiant" + id +" n'exist pas"))
;
	}
	public void deleteEtudiant(Long id) {
		etudiantRepository.deleteById(id);
	}
}
