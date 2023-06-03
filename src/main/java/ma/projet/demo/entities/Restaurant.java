package ma.projet.demo.entities;

import java.sql.Time;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@JsonIgnoreProperties("specialite")
@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String adresse;
	private String lattitude;
	private String longitude;
	private String week;
	private int rank;
	private Time open_hour;
	private Time close_hour;
	

	
	@ManyToOne
	private Serie serie;
	
	@ManyToMany(mappedBy="restaurant")
	private Set<Specialite> specialite = new HashSet<Specialite>();
	
	
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
	private List<Photo> photo;
	
	@ManyToOne
	private Zone zone;
	
	@ManyToOne
	private User user;
	
	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Set<Specialite> getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Set<Specialite> specialite) {
		this.specialite = specialite;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getLattitude() {
		return lattitude;
	}

	public void setLattitude(String lattitude) {
		this.lattitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public Time getOpen_hour() {
		return open_hour;
	}

	public void setOpen_hour(Time open_hour) {
		this.open_hour = open_hour;
	}

	public Time getClose_hour() {
		return close_hour;
	}

	public void setClose_hour(Time close_hour) {
		this.close_hour = close_hour;
	}
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public List<Photo> getPhoto() {
		return photo;
	}

	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
