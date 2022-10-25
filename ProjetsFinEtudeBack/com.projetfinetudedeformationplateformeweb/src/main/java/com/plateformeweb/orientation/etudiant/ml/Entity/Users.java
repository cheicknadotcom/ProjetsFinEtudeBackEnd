package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity

@Table(name = "T_utilisateurs",uniqueConstraints = {@UniqueConstraint(columnNames = "AdresseEmail")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Nom")
	private String nameUsers;
	@Column(name = "Type")
	private String typeUsers;
	@Column(name = "Adresse")
	private String adresseUsers;
	@Column(name = "Telephone")
	private String telUsers;
	@Column(name = "AdresseEmail")
	private String adresseEmailUser;
	@Column(name = "Password")
	private String passwordUser;
	@JsonIgnore
	@ManyToMany(mappedBy = "rolesUsers")
	private Set<RolesUsers> roles = new HashSet<>();
	
	public Users(String adresseEmailUser, String passwordUser) {
		this.adresseEmailUser = adresseEmailUser;
		this.passwordUser = passwordUser;
	}
	public Users(Long id, String adresseEmailUser, String passwordUser) {
		this(adresseEmailUser,passwordUser);
		this.id = id;
		
	}
	public Users(String adresseEmailUser,String passwordUser,String tel) {
		this(adresseEmailUser,passwordUser);
		this.telUsers = tel;
	}
	public Users(Long id, String nameUsers, String adresseUsers, String telUsers, String adresseEmailUser,
			String passwordUser) {
		this(id,adresseEmailUser,passwordUser);
		this.nameUsers = nameUsers;
		this.adresseUsers = adresseUsers;
		this.telUsers = telUsers;
	}
	public Users(Long id2, String name, String type, String addresse, String tel, String email, String password) {
		this(id2,name,addresse,tel,email,password);
		this.typeUsers= type;
	}
	

	
}
