package ma.projet.demo.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Restaurant;
import ma.projet.demo.entities.Specialite;
import ma.projet.demo.entities.Ville;
import ma.projet.demo.entities.Zone;

import ma.projet.demo.repository.VilleRepository;



@Service
public class VilleService implements IDao<Ville> {
	@Autowired
	private VilleRepository repository;
	@Autowired
	private ZoneService zoneService;
	@Autowired
	private SpecialiteService specialiteService;
	
	
	@Override
	public Ville save(Ville o) {
		
		return repository.save(o);
	}

	@Override
	public List<Ville> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Ville findById(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public void update(Ville o) {
		repository.save(o);
		
	}

	@Override
	public void delete(Ville o) {
		repository.delete(o);
	}
	public Ville findByNom (String nom) {
		return repository.findByNom(nom);
	}
	public List<Zone> findZonesByVille (String nom){
		Ville v = repository.findByNom(nom);
		return v.getZone();
	}
	public List<Restaurant> findRestoByZone (String nomV, String nomZ){
		Ville ville = repository.findByNom(nomV);
		Zone zone = zoneService.findByNom(nomZ);
		
		List<Zone> zones = ville.getZone();
		
		for(Zone z : zones) {
			if(z.equals(zone)) {
				return z.getRestaurant();
			}
		}
		return null;
	}
	public List<Restaurant> filterRestoByspeciality(String nomV, String nomZ, String nomS){
		Ville ville = repository.findByNom(nomV);
		Zone zone = zoneService.findByNom(nomZ);
		Specialite spec = specialiteService.findByNom(nomS);
		List<Zone> zones = ville.getZone();
		
		List<Restaurant> restaurants = new ArrayList<>();
		for(Zone z : zones) {
			if(z.equals(zone)) {
				List<Restaurant> restos = z.getRestaurant();
				for(Restaurant r: restos) {
					if(r.getSpecialite().contains(spec)) {
						restaurants.add(r);
					}
				}
			}
		}
		return restaurants;
	}
	

}
