package com.plateformeweb.orientation.etudiant.ml.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Repository.LettreDeMotivationRepository;

@Service
public class LettreDeMotivationServices {
	@Autowired
	LettreDeMotivationRepository lettreDeMotivationRepository;
}
