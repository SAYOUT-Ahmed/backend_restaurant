package ma.projet.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ma.projet.demo.entities.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	Restaurant findById(int id);

}
