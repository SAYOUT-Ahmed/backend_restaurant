package ma.projet.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Restaurant;
import ma.projet.demo.entities.Serie;
import ma.projet.demo.entities.Specialite;
import ma.projet.demo.entities.Ville;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.repository.RestaurantRepository;




@Service
public class RestaurantService implements IDao<Restaurant>{
	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private VilleService villeService;
	@Autowired
	private ZoneService zoneService;
	@Autowired
	private SpecialiteService specialiteRepository;
	@Autowired
	private SerieService serieService;
	@Override
	public Restaurant save(Restaurant o) {

		return restaurantRepository.save(o);
	}
	@Override
	public List<Restaurant> findAll() {

		return restaurantRepository.findAll();
	}
	@Override
	public Restaurant findById(int id) {

		return restaurantRepository.findById(id);
	}
	@Override
	public void update(Restaurant o) {

		restaurantRepository.save(o);
	}
	@Override
	public void delete(Restaurant o) {
		restaurantRepository.delete(o);
	}

	public void deleteById(Integer integer) {
		restaurantRepository.deleteById(integer);
	}

	public List<Restaurant> filterRestoByspeciality(String nomV, String nomZ, String nomS){
		Ville ville = villeService.findByNom(nomV);
		Zone zone = zoneService.findByNom(nomZ);
		Specialite spec = specialiteRepository.findByNom(nomS);
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
	public List<Restaurant> filterRestoBySerie(String nomV, String nomZ, String nomSerie){
		Ville ville = villeService.findByNom(nomV);
		Zone zone = zoneService.findByNom(nomZ);
		Serie serie = serieService.findByNom(nomSerie);
		List<Zone> zones = ville.getZone();
		
		List<Restaurant> restaurants = new ArrayList<>();
		for(Zone z : zones) {
			if(z.equals(zone)) {
				List<Restaurant> restos = z.getRestaurant();
				for(Restaurant r: restos) {
					if(r.getSerie().equals(serie)) {
						restaurants.add(r);
					}
				}
			}
		}
		return restaurants;
	}


}
