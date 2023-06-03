package ma.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	Photo findById(int id);
}
