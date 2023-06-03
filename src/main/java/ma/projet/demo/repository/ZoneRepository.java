package ma.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import ma.projet.demo.entities.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Integer>{
	Zone findById(int id);
	Zone findByNom (String nom);
}
