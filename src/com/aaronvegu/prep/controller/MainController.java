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
import com.aaronvegu.prep.dao.ResultadoDAO;
import com.aaronvegu.prep.dao.UsuarioDAO;
import com.aaronvegu.prep.dao.VotoDAO;
import com.aaronvegu.prep.model.Candidatura;
import com.aaronvegu.prep.model.Casilla;
import com.aaronvegu.prep.model.Resultado;
import com.aaronvegu.prep.model.Usuario;
import com.aaronvegu.prep.model.Voto;

@Controller
public class MainController {

	@Autowired
	private CasillaDAO casillaDAO;
	
	@Autowired
	private CandidaturaDAO candidaturaDAO;
	
	@Autowired
	private VotoDAO votoDAO;
	
	@Autowired 
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private ResultadoDAO resultadoDAO;
	
	@RequestMapping(value = "/")
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message = "Usuario incorrecto o no aprobado";
		
		Usuario u = usuarioDAO.getByMail(username);
		
		if(u == null)
			return new ModelAndView("errorPage", "message", message);
		
		Integer result = usuarioDAO.checkUser(username, password);
		
		if(result != 0 && password != null && !password.equals("") && 
				password.equals(u.getPassword())) {
			return new ModelAndView("redirect:/inicio");
		} else {
			return new ModelAndView("errorPage", "message", message);
		}
				
	}
	
	@RequestMapping(value = "/inicio")
	public ModelAndView inicio(ModelAndView model) {
		model.setViewName("inicio");
		
		return model;
	}
	
	@RequestMapping(value = "/registro")
	public ModelAndView registro(ModelAndView model) {
		Usuario u = new Usuario();
		model.addObject("usuario", u);
		model.setViewName("registro");
		
		return model;
	}
	
	@RequestMapping(value = "/registrar-usuario", method = RequestMethod.POST)
	public ModelAndView registUsuario(@ModelAttribute Usuario usuario) {
		if(usuario.getId() == null)
			usuarioDAO.save(usuario);
		else
			usuarioDAO.update(usuario);
		
		return new ModelAndView("usuario-registrado");
	}
	
	@RequestMapping(value = "/usuario-registrado")
	public ModelAndView usuarioRegistrado(ModelAndView model) {
		model.setViewName("usuario-registrado");
		
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
	
	@RequestMapping(value = "/login-usuarios")
	public String loginUsuarios() {
		return "login-usuarios";
	}
	
	@RequestMapping(value = "/usuarios")
	public ModelAndView votos(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message = "Usuario incorrecto o sin permisos de administrador";
		
		if(username != null && username.equals("admin") && password != null && 
				password.equals("admin")) {
			return new ModelAndView("redirect:/lista-usuarios");
		} else {
			return new ModelAndView("error-page", "message", message);
		}
				
	}
	
	@RequestMapping(value = "/lista-usuarios")
	public ModelAndView listUsuario(ModelAndView model) {
		List<Usuario> listUsuario = usuarioDAO.list();
		model.addObject("listUsuario", listUsuario);
		model.setViewName("lista-usuarios");
		
		return model;
	}
	
	@RequestMapping(value = "/agregar-usuario", method = RequestMethod.GET)
	public ModelAndView addUsuario(ModelAndView model) {
		Usuario addUsuario = new Usuario();
		model.addObject("usuario", addUsuario);
		model.setViewName("agregar-usuario");
		
		return model;
	}
	
	@RequestMapping(value = "/guardar-usuario", method = RequestMethod.POST)
	public ModelAndView saveUsuario(@ModelAttribute Usuario usuario) {
		if(usuario.getId() == null)
			usuarioDAO.save(usuario);
		else
			usuarioDAO.update(usuario);
		
		return new ModelAndView("redirect:/lista-usuarios");
	}
	
	@RequestMapping(value = "/editar-usuario", method = RequestMethod.GET)
	public ModelAndView editUsuario(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuario = usuarioDAO.get(id);
		
		ModelAndView model = new ModelAndView("agregar-usuario");
		
		model.addObject("usuario", usuario);
		
		return model;
	}
	
	@RequestMapping(value = "/eliminar-usuario", method = RequestMethod.GET)
	public ModelAndView deleteUsuario(@RequestParam Integer id) {
		usuarioDAO.delete(id);
		
		return new ModelAndView("redirect:/lista-usuarios");
	}
	
	@RequestMapping(value = "/resultados")
	public ModelAndView listResultado(ModelAndView model) {
		List<Resultado> listResultado = resultadoDAO.list();
		model.addObject("listResultado", listResultado);
		model.setViewName("resultados");
		
		return model;
	}	
	
	@RequestMapping(value = "/votos-partido")
	public ModelAndView listVotosPorPartido(ModelAndView model) {
		List<Resultado> listResultado = resultadoDAO.getResultsByParty();
		model.addObject("listResultado", listResultado);
		model.setViewName("votos-partido");
		
		return model;
	}
	
	@RequestMapping(value = "/viewPDF", method = RequestMethod.POST)
	public ModelAndView verPDF(@ModelAttribute Resultado resultados) {
		List<Resultado> listResultado = resultadoDAO.list();
		
		return new ModelAndView("viewPDF", "listResultado", listResultado);
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
