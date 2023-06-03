package ma.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import ma.projet.demo.entities.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
	Serie findById(int id);
	Serie findByNom(String nomSerie);

}
