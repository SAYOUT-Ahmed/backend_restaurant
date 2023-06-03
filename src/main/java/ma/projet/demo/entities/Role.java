package ma.projet.demo.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String libelle;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="user_role",
	 joinColumns = { @JoinColumn(name="role_id") },
	 inverseJoinColumns = { @JoinColumn(name="user_id") })
	private Set<User> user = new HashSet<User>();
	public Role() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
