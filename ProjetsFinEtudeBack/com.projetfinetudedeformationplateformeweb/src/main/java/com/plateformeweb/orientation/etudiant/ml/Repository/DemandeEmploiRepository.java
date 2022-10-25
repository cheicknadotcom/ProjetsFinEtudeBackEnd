package com.plateformeweb.orientation.etudiant.ml.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.DemandeEmploi;

public interface DemandeEmploiRepository extends JpaRepository<DemandeEmploi, Long> {

	//List<DemandeEmploi> findAllDemandeEmploiByDate(Date date);

	List<DemandeEmploi> findAllDemandeEmploiByTypeDemande(String concat);

}
