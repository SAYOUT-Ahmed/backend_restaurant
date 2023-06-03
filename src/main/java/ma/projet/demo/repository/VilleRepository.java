package ma.projet.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ma.projet.demo.entities.Ville;
@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer>{
	Ville findById(int id);
	Ville findByNom(String nom);
	
}
