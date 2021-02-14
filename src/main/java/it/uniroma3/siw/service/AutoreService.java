package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.OperaArte;
import it.uniroma3.siw.repository.AutoreRepository;

@Service
public class AutoreService {
	
	@Autowired
	AutoreRepository autoreRepository;
	
	@Transactional
	public Autore findById(Long id) {
		Optional<Autore> result = autoreRepository.findById(id);
		return result.orElse(null);
	}
	
	@Transactional
	public List<Autore> findByNome(String nome) {
		Optional<List<Autore>> result = autoreRepository.findByNome(nome);
		return result.orElse(null);
	}
	
	@Transactional
	public List<Autore> findAll(){
		List<Autore> result = new ArrayList<>();
		Iterable<Autore> iterable = this.autoreRepository.findAll();
		for(Autore autore : iterable)
			result.add(autore);
		return result;
		
	}
	@Transactional
    public Autore saveAutore(Autore autore) {
        return this.autoreRepository.save(autore);
    }
	@Transactional
	   public void delete(long id){
	     this.autoreRepository.deleteById(id);
	    }

}
