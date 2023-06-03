package ma.projet.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@JsonIgnoreProperties("zone")
@Entity
public class Ville {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany(mappedBy = "ville", fetch = FetchType.EAGER)
	private List<Zone> zone;
	public Ville() {
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
	public List<Zone> getZone() {
		return zone;
	}
	public void setZone(List<Zone> zone) {
		this.zone = zone;
	}
	
	
}
