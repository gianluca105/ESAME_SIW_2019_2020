package it.uniroma3.siw.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.siw.controller.session.SessionData;
import it.uniroma3.siw.controller.validation.AutoreValidation;
import it.uniroma3.siw.controller.validation.OperaArteValidation;
import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.OperaArte;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.AutoreService;
import it.uniroma3.siw.service.OperaArteService;

@Controller
public class AdminController {

	@Autowired
	SessionData sessionData;
	@Autowired
	OperaArteService operaArteService;
	@Autowired
	AutoreService autoreService;
	@Autowired
	AutoreValidation autoreValidation;
	@Autowired
	OperaArteValidation operaArteValidation;

	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String admin(Model model) {
		Utente loggedUser = sessionData.getLoggedUser();
		model.addAttribute("user", loggedUser);
		return "admin";
	}

	@RequestMapping(value = "/admin/opere", method = RequestMethod.GET)
	public String getOpere(Model model) {
		List<OperaArte> opere = operaArteService.getAllOpere();
		model.addAttribute("opere", opere);
		return "opere";
	}
	@RequestMapping(value = "/admin/opere/{id}/rimuovi", method = RequestMethod.POST)
    public String deleteOpere(@PathVariable long id,
    		Model model) {
	
     operaArteService.delete(id);
      return "redirect:/admin/opere";
    }
	@RequestMapping(value = "/admin/autori", method = RequestMethod.GET)
	public String getAutori(Model model) {
		List<Autore> autori = autoreService.findAll();
		model.addAttribute("autori", autori);
		return "deleteAutori";
	}
	@RequestMapping(value = "/admin/autori/{id}/rimuovi", method = RequestMethod.POST)
    public String deleteAutori(@PathVariable long id,
    		Model model) {
	
     autoreService.delete(id);
      return "redirect:/admin/autori";
    }
	@RequestMapping(value = "/admin/addOpera", method = RequestMethod.GET)
	public String addOpera(Model model) {
		Utente loggedUser = sessionData.getLoggedUser();
		List<Autore> autori = autoreService.findAll();
		model.addAttribute("utente", loggedUser);
		model.addAttribute("operaArte",new OperaArte());
		model.addAttribute("autori",autori);
		return "addOpera";
	}
	@RequestMapping( value = "/admin/addOpera", method = RequestMethod.POST)
    public String addOpera(@Valid @ModelAttribute("operaArte") OperaArte operaArte, 
                      BindingResult operaBindingResult, Model model) {
      
		this.operaArteValidation.validate(operaArte, operaBindingResult);
		
        if (operaBindingResult.hasErrors()) {
        	List<Autore> autori = autoreService.findAll();
        	model.addAttribute("autori",autori);
            return "addOpera";
        }
        else {
          model.addAttribute(operaArte);
          operaArteService.saveOperaArte(operaArte);
        }
        return "redirect:/admin/addOpera";
    }
	@RequestMapping(value = "/admin/addAutore", method = RequestMethod.GET)
	public String addAutore(Model model) {
		Utente loggedUser = sessionData.getLoggedUser();
		model.addAttribute("utente", loggedUser);
		model.addAttribute("autore",new Autore());
		
		return "addAutore";
	}
	@RequestMapping( value = "/admin/addAutore", method = RequestMethod.POST)
    public String addAutore(@Valid @ModelAttribute("autore") Autore autore, 
                      BindingResult autoreBindingResult, Model model) {
      
		this.autoreValidation.validate(autore, autoreBindingResult);
		
        if (autoreBindingResult.hasErrors()) {
       
            return "addAutore";
        }
        else {
          model.addAttribute(autore);
          autoreService.saveAutore(autore);
        }
       
        return "redirect:/admin/addAutore";
    }



	}
