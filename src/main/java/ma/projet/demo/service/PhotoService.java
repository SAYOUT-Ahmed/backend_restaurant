package ma.projet.demo.service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Photo;
import ma.projet.demo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    public <S extends Photo> S save(S entity) {
        return photoRepository.save(entity);
    }

    public Optional<Photo> findById(Integer integer) {
        return photoRepository.findById(integer);
    }

    public void deleteById(Integer integer) {
        photoRepository.deleteById(integer);
    }
}
