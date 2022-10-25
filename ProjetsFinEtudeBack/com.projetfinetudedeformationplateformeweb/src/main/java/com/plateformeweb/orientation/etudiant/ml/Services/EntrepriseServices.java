package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.Entreprise;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.EntrepriseRepository;
import com.plateformeweb.orientation.etudiant.ml.Security.SecurityConfig;

@Service
public class EntrepriseServices {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	public Entreprise ajouterEntreprise(Entreprise entreprise) {
		entreprise.setTypeUsers("Entreprise");
		entreprise.setPasswordUser(SecurityConfig.crypt(entreprise.getPasswordUser()));
		return entrepriseRepository.save(entreprise);
	}
	public List<Entreprise> getEntreprises()
	{
		return entrepriseRepository.findAll();
	}
	public Entreprise getEntreprisesById(Long id) {
		return entrepriseRepository.findEntrepriseById(id).orElseThrow(() -> new UserNotFoundException("Cette entreprise d'identifiant" + id+ "n'existe pas..."));
	}
	public Entreprise updateEntreprises(Entreprise entreprise) {
		return entrepriseRepository.save(entreprise);
	}
	public void deleteEntrepriseById(Long id) {
		entrepriseRepository.deleteById(id);
	}
}
