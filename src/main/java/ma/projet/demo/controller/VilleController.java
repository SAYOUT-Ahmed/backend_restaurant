package ma.projet.demo.controller;

import java.util.List;

import ma.projet.demo.Exceptions.RestaurantNotFoundException;
import ma.projet.demo.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.projet.demo.entities.Restaurant;
import ma.projet.demo.entities.Ville;
import ma.projet.demo.entities.Zone;
import ma.projet.demo.service.VilleService;

@RestController
@CrossOrigin
@RequestMapping("/api/villes")
public class VilleController {
    @Autowired
    private VilleService villeService;

    @Autowired
    VilleRepository villeRepository;

    @PostMapping("/save")
    public void save(@RequestBody Ville ville) {
        villeService.save(ville);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable (required = true) String id){
        Ville r = villeService.findById(Integer.parseInt(id));
        villeService.delete(r);
    }

    @PutMapping("/update/{id}")
    Ville updateVille(@RequestBody Ville ville,@PathVariable Integer id){
        return villeRepository.findById(id)
                .map(item -> {
                    item.setNom(ville.getNom());


                    return villeRepository.save(item);
                }).orElseThrow( ()-> new RestaurantNotFoundException(id) );
    }

    @GetMapping("/all")
    public List<Ville> findAll() {
        return villeService.findAll();
    }

    @GetMapping("/{nom}/zones")
    public List<Zone> findZonesByVille(@PathVariable String nom) {

        return villeService.findZonesByVille(nom);
    }

    @GetMapping("/{nomV}/zones/{nomZ}/restaurants")
    public List<Restaurant> findRestoByZone(@PathVariable String nomV, @PathVariable String nomZ) {
        return villeService.findRestoByZone(nomV, nomZ);
    }

    @GetMapping("/id/{id}")
    public Ville findById(@PathVariable int id) {
        return villeService.findById(id);
    }

}
