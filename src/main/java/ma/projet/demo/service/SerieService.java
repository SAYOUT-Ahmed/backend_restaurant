package ma.projet.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.demo.dao.IDao;
import ma.projet.demo.entities.Serie;
import ma.projet.demo.repository.SerieRepository;

@Service
public class SerieService implements IDao<Serie> {
	@Autowired
	SerieRepository serieRepository;
	@Override
	public Serie save(Serie o) {

		return serieRepository.save(o);
	}

	@Override
	public List<Serie> findAll() {

		return serieRepository.findAll();
	}

	@Override
	public Serie findById(int id) {

		return serieRepository.findById(id);
	}

	@Override
	public void update(Serie o) {

		serieRepository.save(o);
	}

	@Override
	public void delete(Serie o) {

		serieRepository.delete(o);
	}
	public Serie findByNom(String nom) {
		return serieRepository.findByNom(nom);
	}

	public void deleteById(Integer integer) {
		serieRepository.deleteById(integer);
	}
}
