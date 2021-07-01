package com.aaronvegu.prep.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aaronvegu.prep.dao.CandidaturaDAO;
import com.aaronvegu.prep.dao.CasillaDAO;
import com.aaronvegu.prep.dao.VotoDAO;
import com.aaronvegu.prep.model.Candidatura;
import com.aaronvegu.prep.model.Casilla;
import com.aaronvegu.prep.model.Voto;

@Controller
public class MainController {

	@Autowired
	private CasillaDAO casillaDAO;
	
	@Autowired
	private CandidaturaDAO candidaturaDAO;
	
	@Autowired
	private VotoDAO votoDAO;
	
	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message;
		
		if(username != null && !username.equals("") && username.equals("admin@gmail.com")
				&& password != null && !password.equals("") && password.equals("admin")) {
			return new ModelAndView("redirect:/inicio");
		} else {
			message = "Usuario incorrecto o no aprobado";
			return new ModelAndView("errorPage", "message", message);
		}
				
	}
	
	@RequestMapping(value = "/inicio")
	public ModelAndView inicio(ModelAndView model) {
		model.setViewName("inicio");
		
		return model;
	}
	
	@RequestMapping(value = "/casillas")
	public ModelAndView listCasilla(ModelAndView model) {
		List<Casilla> listCasilla = casillaDAO.list();
		model.addObject("listCasilla", listCasilla);
		model.setViewName("casillas");
		
		return model;
	}
	
	@RequestMapping(value = "/agregar-casilla", method = RequestMethod.GET)
	public ModelAndView addCasilla(ModelAndView model) {
		Casilla addCasilla = new Casilla();
		model.addObject("casilla", addCasilla);
		model.setViewName("agregar-casilla");
		
		return model;
	}
	
	@RequestMapping(value = "/guardar-casilla", method = RequestMethod.POST)
	public ModelAndView saveCasilla(@ModelAttribute Casilla casilla) {
		if(casilla.getId() == null)
			casillaDAO.save(casilla);
		else
			casillaDAO.update(casilla);
		
		return new ModelAndView("redirect:/casillas");
	}
	
	@RequestMapping(value = "/editar-casilla", method = RequestMethod.GET)
	public ModelAndView editCasilla(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Casilla casilla = casillaDAO.get(id);
		
		ModelAndView model = new ModelAndView("agregar-casilla");
		
		model.addObject("casilla", casilla);
		
		return model;
	}
	
	@RequestMapping(value = "/eliminar-casilla", method = RequestMethod.GET)
	public ModelAndView deleteCasilla(@RequestParam Integer id) {
		casillaDAO.delete(id);
		
		return new ModelAndView("redirect:/casillas");
	}
	
	@RequestMapping(value = "/candidaturas")
	public ModelAndView listCandidaturas(ModelAndView model) {
		
		List<Candidatura> listCandidatura = candidaturaDAO.list();
		model.addObject("listCandidatura", listCandidatura);
		model.setViewName("candidaturas");
		
		return model;
	}
	
	@RequestMapping(value = "/agregar-candidatura", method = RequestMethod.GET)
	public ModelAndView addCandidatura(ModelAndView model) {
		Candidatura addCandidatura = new Candidatura();
		model.addObject("candidatura", addCandidatura);
		model.setViewName("agregar-candidatura");
		
		return model;
	}
	
	@RequestMapping(value = "/guardar-candidatura", method = RequestMethod.POST)
	public ModelAndView saveCandidatura(@ModelAttribute Candidatura candidatura) {
		if(candidatura.getId() == null)
			candidaturaDAO.save(candidatura);
		else
			candidaturaDAO.update(candidatura);
		
		return new ModelAndView("redirect:/candidaturas");
	}
	
	@RequestMapping(value = "/editar-candidatura", method = RequestMethod.GET)
	public ModelAndView editCandidatura(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Candidatura candidatura = candidaturaDAO.get(id);
		
		ModelAndView model = new ModelAndView("agregar-candidatura");
		
		model.addObject("candidatura", candidatura);
		
		return model;
	}
	
	@RequestMapping(value = "/eliminar-candidatura", method = RequestMethod.GET)
	public ModelAndView deleteCandidatura(@RequestParam Integer id) {
		candidaturaDAO.delete(id);
		
		return new ModelAndView("redirect:/candidaturas");
	}
	
	@RequestMapping(value = "/votos")
	public ModelAndView getTotalVotos(ModelAndView model) {
		Integer totalVotos = votoDAO.getTotalVotos();
		
		model.addObject("totalVotos", totalVotos);
		model.setViewName("votos");
		
		return model;
	}
	
	@RequestMapping(value = "/lista-casillas")
	public ModelAndView listarCasillas(ModelAndView model) {
		List<Casilla> listarCasillas = casillaDAO.list();
		model.addObject("listarCasillas", listarCasillas);
		model.setViewName("lista-casillas");
		
		return model;
	}
	
	@RequestMapping(value = "/registrar-voto", method = RequestMethod.GET)
	public ModelAndView registrarVoto(HttpServletRequest request) {
		Map<String, Object> modelos = new HashMap<String, Object>();
		
		Integer idCasilla = Integer.parseInt(request.getParameter("id"));
		Casilla casilla = casillaDAO.get(idCasilla);
		
		List<Candidatura> listCandidatura = candidaturaDAO.list();
		
		modelos.put("casilla", casilla);
		modelos.put("listCandidatura", listCandidatura);
		
		ModelAndView model = new ModelAndView("registrar-voto");
		model.addObject("modelos", modelos);
		
		return model;
	}

	@RequestMapping(value = "/confirmar-voto", method = RequestMethod.GET)
	public ModelAndView confirmarVoto(HttpServletRequest request) {
		Integer idCasilla = Integer.parseInt(request.getParameter("idCasilla"));
		Integer idCandidatura = Integer.parseInt(request.getParameter("idCandidatura"));
		
		Voto voto = new Voto(idCasilla, idCandidatura, 0);
		
		ModelAndView model = new ModelAndView("confirmar-voto", "voto", voto);
		
		return model;
	}
	
	@RequestMapping(value = "/guardar-voto", method = RequestMethod.POST)
	public ModelAndView saveVoto(@ModelAttribute Voto voto) {
			votoDAO.save(voto);
		
		return new ModelAndView("redirect:/votos");
	}
	/*
	@RequestMapping(value = "/agregar-votos")
	public ModelAndView listVotos(ModelAndView model) {
		
		List<Casilla> listCasilla = casillaDAO.list();
		List<Candidatura> listCandidatura = candidaturaDAO.list();
		
		Map<String, Object> datos = new HashMap<String, Object>();
		
		datos.put("listCasilla", listCasilla);
		datos.put("listCandidatura", listCandidatura);
		
		model.addObject("datos", datos);
		model.setViewName("agregar-votos");
		
		return model;
	}
	*/
	
}
