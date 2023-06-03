package ma.projet.demo.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;

@Entity
public class Specialite {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="restaurant_specialite",
	 joinColumns = { @JoinColumn(name="specialite_id") },
	 inverseJoinColumns = { @JoinColumn(name="restaurant_id") })


	private Set<Restaurant> restaurant = new HashSet<Restaurant>();
	
	
	public Specialite() {
		super();
	}
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
	public Set<Restaurant> getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Set<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}
	
	
}
