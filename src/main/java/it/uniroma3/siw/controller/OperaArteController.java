package it.uniroma3.siw.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.controller.session.SessionData;
import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.model.OperaArte;
import it.uniroma3.siw.model.Utente;
import it.uniroma3.siw.service.OperaArteService;

@Controller
public class OperaArteController {

	@Autowired
	SessionData sessionData;
	
	@Autowired
	OperaArteService operaArteService;


	@RequestMapping(value = { "/cercaOpera" }, method = RequestMethod.GET)
	public String home(Model model) {
		Utente loggedUser = sessionData.getLoggedUser();
		model.addAttribute("user", loggedUser);
		return "ricerca";
	}
	
	@RequestMapping(value = "/ricercaAnno", method = RequestMethod.GET)
	public String getAnni(Model model) {
		Set<Integer> anni = operaArteService.selectAnni();
		model.addAttribute("anni", anni);
		return "anni";
	}
	@RequestMapping(value = "/opereAnni/{anno}", method = RequestMethod.GET)
	public String opereByAutore(@PathVariable int anno,
						Model model) {
		
		List<OperaArte> opere = operaArteService.getOperaArte(anno);
		model.addAttribute("opereAnni", opere);
		model.addAttribute("anno",anno);
		return "opereByAnni";
	}
	
	@RequestMapping(value = "/ricercaOpera", method = RequestMethod.GET)
	public String getOpere(Model model) {
		List<OperaArte> opere = operaArteService.getAllOpere();
		model.addAttribute("opere", opere);
		return "opere";
	}
	@RequestMapping(value = "/opere/{id}", method = RequestMethod.GET)
	public String opereByAutore(@PathVariable long id,
						Model model) {
		
		OperaArte opera = operaArteService.getOperaArte(id);
		model.addAttribute("opera", opera);
		return "opera";
	}

}
