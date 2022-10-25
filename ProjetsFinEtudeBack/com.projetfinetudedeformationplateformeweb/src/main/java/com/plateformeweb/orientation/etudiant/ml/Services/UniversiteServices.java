package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.Universite;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.UniversiteRepository;
import com.plateformeweb.orientation.etudiant.ml.Security.SecurityConfig;

@Service
public class UniversiteServices {
	@Autowired
	private UniversiteRepository universiteRepository;
	
	public Universite getUniversitesById(Long id) {
		return universiteRepository.findUniversiteById(id).orElseThrow(() ->new UserNotFoundException("Cette universite d'identifiant :" + id+ "n'existe pas sorry..."));
	}
	public List<Universite> getUniversite() {
		return universiteRepository.findAll();
	}
	public Universite addUniversite(Universite universite) {
		universite.setTypeUsers("Universite");
		universite.setPasswordUser(SecurityConfig.crypt(universite.getPasswordUser()));
		return universiteRepository.save(universite);
	}
	public Universite updateUniversite(Universite universite) {
		return universiteRepository.save(universite);
	}
	public Universite getUniversiteByEmail(String email) {
		return universiteRepository.findUniversiteByAdresseEmailUser(email).orElseThrow(() -> new UserNotFoundException("Cette universite d'emeil :"+ email+ "n'existe pas sorry"));
	}
	public void deleteUniversite(Long id) {
		universiteRepository.deleteById(id);
	}
}
