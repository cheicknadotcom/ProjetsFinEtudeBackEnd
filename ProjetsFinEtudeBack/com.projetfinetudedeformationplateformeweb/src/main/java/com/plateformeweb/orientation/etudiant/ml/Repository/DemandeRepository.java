package com.plateformeweb.orientation.etudiant.ml.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.Demande;

public interface DemandeRepository extends JpaRepository<Demande,Long> {

}
