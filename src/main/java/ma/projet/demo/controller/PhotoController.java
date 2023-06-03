package ma.projet.demo.controller;

import ma.projet.demo.entities.Photo;
import ma.projet.demo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/photos")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping("/all")
    public List<Photo> findAll() {
        return photoService.findAll();
    }

    @PostMapping("/save")
    public Photo save(@RequestBody Photo entity) {
        return photoService.save(entity);
    }

    @GetMapping("/id/{id}")
    public Optional<Photo> findById(Integer integer) {
        return photoService.findById(integer);
    }

    @DeleteMapping("delete/{id}")
    public void deleteById(Integer integer) {
        photoService.deleteById(integer);
    }
}
