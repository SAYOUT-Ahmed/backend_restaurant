package ma.projet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findById(int id);
}
