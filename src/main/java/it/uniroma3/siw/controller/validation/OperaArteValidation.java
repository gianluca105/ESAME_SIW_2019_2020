package it.uniroma3.siw.controller.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.OperaArte;

import it.uniroma3.siw.service.OperaArteService;



@Component
public class OperaArteValidation implements Validator{

	final Integer MAX_NAME_LENGTH = 100;
	final Integer MIN_NAME_LENGTH = 2;

	@Autowired
	OperaArteService operaArteService;

	@Override
	public boolean supports(Class<?> clazz) {
		return OperaArte.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		OperaArte opera = (OperaArte) o;
		String tecnica = opera.getTecnica().trim();
		String titolo = opera.getTitolo().trim();
		


		if (tecnica==null || tecnica.isEmpty())
			errors.rejectValue("tecnica", "required");
		else if (tecnica.length() < MIN_NAME_LENGTH || tecnica.length() > MAX_NAME_LENGTH)
			errors.rejectValue("tecnica", "size");
		

		if (titolo==null || titolo.isEmpty())
			errors.rejectValue("titolo", "required");
		else if (titolo.length() < MIN_NAME_LENGTH || titolo.length() > MAX_NAME_LENGTH)
			errors.rejectValue("titolo", "size");
		
		
		if(ricercaDoppione(opera))
			errors.rejectValue("titolo", "duplicate");

	}
	private boolean ricercaDoppione(OperaArte o) {
		List<OperaArte> opereArte = operaArteService.getOperaArte(o.getTitolo());
		for(OperaArte opera : opereArte) {
			if(opera.equals(o))
				return true;
		}
		
		return false;
	}

}
