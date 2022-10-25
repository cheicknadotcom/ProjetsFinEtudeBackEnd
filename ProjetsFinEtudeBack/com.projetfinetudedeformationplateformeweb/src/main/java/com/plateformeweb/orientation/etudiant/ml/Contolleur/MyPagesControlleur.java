package com.plateformeweb.orientation.etudiant.ml.Contolleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateformeweb.orientation.etudiant.ml.Entity.Entreprise;
import com.plateformeweb.orientation.etudiant.ml.Entity.Etudiant;
import com.plateformeweb.orientation.etudiant.ml.Entity.Universite;
import com.plateformeweb.orientation.etudiant.ml.Entity.Users;
import com.plateformeweb.orientation.etudiant.ml.Repository.EntrepriseRepository;
import com.plateformeweb.orientation.etudiant.ml.Repository.EtudiantRepository;
import com.plateformeweb.orientation.etudiant.ml.Repository.UniversiteRepository;
import com.plateformeweb.orientation.etudiant.ml.Repository.UsersRepository;
import com.plateformeweb.orientation.etudiant.ml.Services.EntrepriseServices;
import com.plateformeweb.orientation.etudiant.ml.Services.EtudiantServices;
import com.plateformeweb.orientation.etudiant.ml.Services.UniversiteServices;
import com.plateformeweb.orientation.etudiant.ml.Services.UsersService;
//@Controller
@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/studentCompany")
public class MyPagesControlleur {
	
	@Autowired
	UsersRepository usersRepository;
	@Autowired
	UsersService usersService;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	EtudiantServices etudiantServices;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	EntrepriseServices entrepriseServices;
	@Autowired
	UniversiteRepository universiteRepository;
	@Autowired
	UniversiteServices universiteServices;
	
	Users users;
	
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion des etudiants du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	@PostMapping("/Etudiant/Etudiantsave")
	public ResponseEntity<Etudiant> ajouterEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<Etudiant>(etudiantServices.addEtudiant(etudiant), HttpStatus.CREATED);
	}
	@PutMapping("/Etudiant/Etudiantupdate")
	public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<Etudiant>(etudiantServices.updateEtudiant(etudiant),HttpStatus.CREATED);
	}
	@GetMapping("/")
	public ResponseEntity<List<Etudiant>> listeEtudiantControlleur(){
		return new ResponseEntity<List<Etudiant>>(etudiantServices.listEtudiantService(),HttpStatus.OK);
	}
	@GetMapping("/Etudiant/getEtudiant/{id}")
	public ResponseEntity<Etudiant> listeEtudiantByIdControlleur(@PathVariable("id") Long id){
		return new ResponseEntity<Etudiant>(etudiantServices.findEtudiantsById(id), HttpStatus.OK);
	}
	@DeleteMapping("/Etudiant/deleteEtudiant/{id}")
	public ResponseEntity<HttpStatus> deleteEtudiant(@PathVariable("id") Long id){
		etudiantServices.deleteEtudiant(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion des entreprises du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	@GetMapping("/Entreprise/getEntrepriseById/{id}")
	public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable("id") Long id){
		return new ResponseEntity<Entreprise>(entrepriseServices.getEntreprisesById(id),HttpStatus.OK);
	}
	@GetMapping("/Entreprise/getAllEntreprise")
	public ResponseEntity<List<Entreprise>> getAllEntreprise(){
		return new ResponseEntity<List<Entreprise>>(entrepriseServices.getEntreprises(),HttpStatus.OK);
	}
	@PostMapping("/Entreprise/addEntreprise")
	public ResponseEntity<Entreprise> ajouterEntreprise(@RequestBody Entreprise entreprise) {
		return new ResponseEntity<Entreprise>(entrepriseServices.ajouterEntreprise(entreprise),HttpStatus.CREATED);
	}
	@PutMapping("/Entreprise/updateEntreprise")
	public ResponseEntity<Entreprise> updateEntreprise(@RequestBody Entreprise entreprise){
		return new ResponseEntity<Entreprise>(entrepriseServices.updateEntreprises(entreprise), HttpStatus.CREATED);
	}
	@DeleteMapping("/Entreprise/deleteEntreprise/{id}")
	public ResponseEntity<HttpStatus> deleteEntrepriseById(@PathVariable("id") Long id){
		entrepriseServices.deleteEntrepriseById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion pour l'administrateur du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	
	
	
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion des Universites du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	@PostMapping("/Universite/addUniversite")
	public ResponseEntity<Universite> ajouterUniversite(@RequestBody Universite universite){
		return new ResponseEntity<Universite>(universiteServices.addUniversite(universite),HttpStatus.CREATED);
	}
	@PutMapping("/Universite/updateUniversite")
	public ResponseEntity<Universite> updateUniversite(@RequestBody Universite universite){
		return new ResponseEntity<Universite>( universiteServices.updateUniversite(universite),HttpStatus.CREATED);
	}
	@GetMapping("/Universite/getAllUniversite")
	public ResponseEntity<List<Universite>> getAllUniversite(){	
		return new ResponseEntity<List<Universite>>(universiteServices.getUniversite(),HttpStatus.OK);
	}
	@GetMapping("/Universite/getUniversite/{id}")
	public ResponseEntity<Universite> getUniversiteById(@PathVariable("id") Long id){
		return new ResponseEntity<Universite>(universiteServices.getUniversitesById(id),HttpStatus.OK);
	}
	@GetMapping("/Universite/getUniversite/{email}")
	public ResponseEntity<Universite> getUniversiteByAdresseEmail(@PathVariable("email") String email){
		return new ResponseEntity<Universite>(universiteServices.getUniversiteByEmail(email),HttpStatus.OK);
	}
	@DeleteMapping("/deleteUniversite/{id}")
	public ResponseEntity<HttpStatus> deleteUniversiteById(@PathVariable("id") Long id){
		universiteServices.deleteUniversite(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion d'authentification du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	@GetMapping(value="/Users/getUserByEmailAndPassword/{email}&{password}")
	public ResponseEntity<Users> getUsersByEmailAndPassword(@PathVariable("email") String email,@PathVariable("Password") String password){
		return new ResponseEntity<Users>(usersService.getUserByEmailAndPassword(email, password),HttpStatus.OK);
	}
	@GetMapping("/Users/getUsersById/{id}")
	public ResponseEntity<Users> getUsersById(@PathVariable("id") Long id){
		return new ResponseEntity<Users>(usersService.getUsersById(id),HttpStatus.OK);
	}
	@GetMapping("/Users/getUsersByEmail/{email}")
	public ResponseEntity<Users> getUsersByEmail(@PathVariable("email") String email){
		return new ResponseEntity<Users>(usersService.getUsersByEmails(email),HttpStatus.OK);
	}
	@PostMapping("/Users/adduser")
	public ResponseEntity<Users> ajouterUser(@RequestBody Users users){
		return new ResponseEntity<Users>(usersService.addUser(users),HttpStatus.OK);
	}
	@PutMapping("/Users/updateUser")
	public ResponseEntity<Users> updateUser(@RequestBody Users users){
		return new ResponseEntity<Users>(usersService.updateUsers(users),HttpStatus.OK);
	}
	@DeleteMapping("/Users/deleteUser/{id}")
	public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") Long id){
		usersService.deleteUsers(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@GetMapping("/Users/getAllUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		return new ResponseEntity<List<Users>>(usersService.getAllUsers(),HttpStatus.OK);
	}
	//*******************************************************************************************************
}
