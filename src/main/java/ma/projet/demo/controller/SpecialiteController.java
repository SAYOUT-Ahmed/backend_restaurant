package ma.projet.demo.controller;

import ma.projet.demo.entities.Specialite;
import ma.projet.demo.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/specialites")
public class SpecialiteController {
    @Autowired
    private SpecialiteService specialiteService;

    @PostMapping("/save")
    public Specialite save(@RequestBody Specialite o) {
        return specialiteService.save(o);
    }

    @GetMapping("/all")
    public List<Specialite> findAll() {
        return specialiteService.findAll();
    }

    @GetMapping("/sp/{id}")
    public Specialite findById(@PathVariable int id) {
        return specialiteService.findById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Specialite o) {
        specialiteService.update(o);
    }


    @GetMapping("/nom/{nom}")
    public Specialite findByNom(@PathVariable String nom) {
        return specialiteService.findByNom(nom);
    }
}
