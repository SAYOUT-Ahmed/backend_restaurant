package ma.projet.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ma.projet.demo.entities.Serie;
import ma.projet.demo.service.SerieService;

@RestController
@RequestMapping("/api/series")
public class SerieController {
	@Autowired
	SerieService serieService;
	@PostMapping("/save")
    public void save(@RequestBody Serie serie){
		serieService.save(serie);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable (required = true) String id){
    	Serie s = serieService.findById(Integer.parseInt(id));
    	serieService.delete(s);
    }
    @GetMapping("/all")
    public List<Serie> findAll(){
        return serieService.findAll();
    }
}
