package it.uniroma3.siw.controller.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.OperaArte;
import it.uniroma3.siw.service.AutoreService;
import it.uniroma3.siw.service.OperaArteService;



@Component
public class AutoreValidation implements Validator{
	
	final Integer MAX_NAME_LENGTH = 100;
	final Integer MIN_NAME_LENGTH = 2;

	@Autowired
	AutoreService autoreService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Autore.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Autore autore = (Autore) o;
		String nome = autore.getNome().trim();
		String cognome = autore.getCognome().trim();
		String nazionalita = autore.getNazionalita().trim();
		


		if (nome.isBlank())
			errors.rejectValue("nome", "required");
		else if (nome.length() < MIN_NAME_LENGTH || nome.length() > MAX_NAME_LENGTH)
			errors.rejectValue("nome", "size");
		

		if (cognome.isBlank())
			errors.rejectValue("cognome", "required");
		else if (cognome.length() < MIN_NAME_LENGTH || cognome.length() > MAX_NAME_LENGTH)
			errors.rejectValue("cognome", "size");
		
		if (nazionalita.isBlank())
			errors.rejectValue("nazionalita", "required");
		else if (nazionalita.length() < MIN_NAME_LENGTH || nazionalita.length() > MAX_NAME_LENGTH)
			errors.rejectValue("nazionalita", "size");
		
		if(ricercaDoppione(autore))
			errors.rejectValue("nome", "duplicate");

	}
	private boolean ricercaDoppione(Autore o) {
		List<Autore> autori = autoreService.findByNome(o.getNome());
		for(Autore autore : autori) {
			if(autore.equals(o))
				return true;
		}
		
		return false;
	}


}
