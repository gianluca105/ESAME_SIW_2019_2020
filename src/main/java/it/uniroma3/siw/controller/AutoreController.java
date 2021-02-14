package it.uniroma3.siw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.model.*;
import it.uniroma3.siw.model.Autore;
import it.uniroma3.siw.service.AutoreService;
import it.uniroma3.siw.service.OperaArteService;

@Controller
public class AutoreController {
	
	@Autowired
	AutoreService autoreService;
	@Autowired
	OperaArteService operaArteService;
	
	//Reindirizza alla pagina che mostra le opere di un determinato autore
		@RequestMapping(value = "/opereAutore/{id}", method = RequestMethod.GET)
		public String opereByAutore(@PathVariable long id,
							Model model) {
			Autore autore = autoreService.findById(id);
			List<OperaArte> opere = operaArteService.getOperaArte(autore);
			
			model.addAttribute("autore", autore);
			model.addAttribute("opereAutore", opere);
			return "opereByAutore";
		}
		
		@RequestMapping(value = "/ricercaArtista", method = RequestMethod.GET)
		public String getAutori(Model model) {
			List<Autore> autori = autoreService.findAll();
			model.addAttribute("autori", autori);
			return "autori";
		}
		
		

}
