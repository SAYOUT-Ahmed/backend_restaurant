package ma.projet.demo.entities;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Serie {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String nom;
	public Serie() {
		super();
	}
	
	@OneToMany(mappedBy = "serie", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Restaurant> restaurant;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Restaurant> getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
