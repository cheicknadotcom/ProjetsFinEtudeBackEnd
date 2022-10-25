package com.plateformeweb.orientation.etudiant.ml.Contolleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateformeweb.orientation.etudiant.ml.Services.EtudiantServices;
import com.plateformeweb.orientation.etudiant.ml.Services.OrientationServices;

@RestController
@CrossOrigin("**")
@RequestMapping("/studentCompany")
public class EtudiantControlleur {
	@Autowired
	EtudiantServices etudiantService;
	@Autowired
	OrientationServices orientationService;}
