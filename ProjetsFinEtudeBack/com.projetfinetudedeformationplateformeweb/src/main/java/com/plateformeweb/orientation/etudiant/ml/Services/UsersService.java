package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.Users;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.UsersRepository;
import com.plateformeweb.orientation.etudiant.ml.Security.SecurityConfig;


@Service
public class UsersService{
	@Autowired
	UsersRepository usersRepository;
	
	public Users getUserByEmailAndPassword(String email,String password) {
		Users user = usersRepository.findUsersByAdresseEmailUserAndPasswordUser(email,password)
				.orElseThrow (() -> new UserNotFoundException("User d'addresse Email : " + email+" Password"+password+ "not found"));
		return user;
	}
	public String getTypeUserByEmailAndPassword(String email,String password) {
		Users user = usersRepository.findUsersByAdresseEmailUserAndPasswordUser(email,password)
				.orElseThrow (() -> new UserNotFoundException("User d'addresse Email : " + email+" Password"+password+ "not found"));
		if(user.getTypeUsers().compareTo("Etudiant") == 0)
			return "EspaceEtudiant";
		else if(user.getTypeUsers().compareTo("Entreprise") == 0)
			return "EspaceEntreprise";
		else if(user.getTypeUsers().compareTo("Administrateur") == 0)
			return "EspaceEntreprise";
		else if(user.getTypeUsers().compareTo("Universite") == 0)
			return "EspaceUniversite";
		else 
			return "home";
	}
//	@Override
//	public UserDetails loadUserByUsername(String AdresseEmail) throws UsernameNotFoundException {
//		Objects.requireNonNull(AdresseEmail);
//        Users user = usersRepository.findUserWithAddresseEmail(AdresseEmail)
//                .orElseThrow (() -> new UserNotFoundException("User d'address : " + AdresseEmail+ "not found"));
//        return user;
//	}
	public Users addUser(Users users) {
		users.setPasswordUser(SecurityConfig.crypt(users.getPasswordUser()));
		return usersRepository.save(users);
	}
	public String passwordUserCrypt(Users users) {
		return SecurityConfig.crypt(users.getPasswordUser()); 
	}
	public Users updateUsers(Users users) {
		return usersRepository.save(users);
	}

	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	public Users getUsersById(Long id) {
		return usersRepository.findUsersById(id)
				.orElseThrow(() ->new UserNotFoundException("Cet User d'identifiant : " + id + "n'existe pas sorry"));
	}
	public Users getUsersByEmails(String email) {
		Users users = usersRepository.findUsersByAdresseEmailUser(email)
				.orElseThrow(() -> new UserNotFoundException("L'utilisateur d'addresse email :" + email + "n'existe pas sorry"));
		return users;
	}
	public void deleteUsers(Long id) {
		usersRepository.deleteById(id);
	}
}
