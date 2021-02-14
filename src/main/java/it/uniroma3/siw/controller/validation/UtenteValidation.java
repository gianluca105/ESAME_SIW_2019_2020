package it.uniroma3.siw.controller.validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.UtenteService;
@Component
public class UtenteValidation implements Validator {

    final Integer MAX_NAME_LENGTH = 100;
    final Integer MIN_NAME_LENGTH = 2;

    @Autowired
    UtenteService userService;

    @Override
    public void validate(Object o, Errors errors) {
        Utente user = (Utente) o;
        String firstName = user.getNome().trim();
        String lastName = user.getCognome().trim();

        if (firstName.isBlank())
            errors.rejectValue("nome", "required");
        else if (firstName.length() < MIN_NAME_LENGTH || firstName.length() > MAX_NAME_LENGTH)
            errors.rejectValue("nome", "size");

        if (lastName.isBlank())
            errors.rejectValue("cognome", "required");
        else if (lastName.length() < MIN_NAME_LENGTH || lastName.length() > MAX_NAME_LENGTH)
            errors.rejectValue("cognome", "size");
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Utente.class.equals(clazz);
    }

}