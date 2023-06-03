package ma.projet.demo.controller;

import java.util.List;

import ma.projet.demo.Exceptions.RestaurantNotFoundException;
import ma.projet.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import ma.projet.demo.entities.Restaurant;

import ma.projet.demo.service.RestaurantService;


@RestController
@CrossOrigin
@RequestMapping("/api/restaurants")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping("/save")
    public void save(@RequestBody Restaurant restaurant) {
        restaurantService.save(restaurant);
    }


    @GetMapping("/all")
    public List<Restaurant> findAll() {
        return restaurantService.findAll();
    }

    @GetMapping("/{nomV}/zones/{nomZ}/restaurants/specialite/{nomS}")
    public List<Restaurant> filterRestoByspeciality(@PathVariable String nomV, @PathVariable String nomZ, @PathVariable String nomS) {
        return restaurantService.filterRestoByspeciality(nomV, nomZ, nomS);
    }

    @GetMapping("/{nomV}/zones/{nomZ}/restaurants/serie/{nomSerie}")
    public List<Restaurant> filterRestoBySerie(@PathVariable String nomV, @PathVariable String nomZ, @PathVariable String nomSerie) {
        return restaurantService.filterRestoBySerie(nomV, nomZ, nomSerie);
    }

    @GetMapping("/{id}")
    public Restaurant findRestaurantById(@PathVariable int id) {
        return restaurantService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        Restaurant r = restaurantService.findById(id);
        restaurantService.delete(r);
    }



    @PutMapping("/update/{id}")
    Restaurant updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable Integer id) {
        return restaurantRepository.findById(id)
                .map(item -> {
                    item.setNom(restaurant.getNom());
                    item.setAdresse(restaurant.getAdresse());
                    item.setLattitude(restaurant.getLattitude());
                    item.setLongitude(restaurant.getLongitude());
                    item.setRank(restaurant.getRank());
                    item.setClose_hour(restaurant.getClose_hour());
                    item.setOpen_hour(restaurant.getOpen_hour());

                    return restaurantRepository.save(item);
                }).orElseThrow(() -> new RestaurantNotFoundException(id));
    }
}
