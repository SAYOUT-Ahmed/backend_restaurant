package ma.projet.demo.controller;

import ma.projet.demo.entities.Zone;
import ma.projet.demo.service.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/zones")
public class ZoneController {
    @Autowired
    private ZoneService zoneService;

    @PostMapping("/save")
    public Zone save(Zone o) {
        return zoneService.save(o);
    }

    @GetMapping("/all")
    public List<Zone> findAll() {
        return zoneService.findAll();
    }

    @GetMapping("/zone/{id}")
    public Zone findById(int id) {
        return zoneService.findById(id);
    }

    @PutMapping("/update")
    public void update(Zone o) {
        zoneService.update(o);
    }

    @GetMapping("/nom/{nom}")
    public Zone findByNom(String nom) {
        return zoneService.findByNom(nom);
    }


    @DeleteMapping("/delete/id/{id}")
    public void deleteById(Integer id) {
        zoneService.deleteById(id);
    }
}
