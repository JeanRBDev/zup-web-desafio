package com.jrodrigues.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jrodrigues.model.Usuario;
import com.jrodrigues.repository.UsuarioRepository;

@Controller
@RestController // FUNCIONAMENTO DA API REST
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value="/cadastrar-usuario", method=RequestMethod.GET)
	public String form() {
		return "usuario/FormUsuario";
	}

	@RequestMapping(value="/cadastrar-usuario", method=RequestMethod.POST)
	public String form(Usuario usuario) {
		
		usuarioRepository.save(usuario);
		
		return "redirect:/cadastrar-usuario";
	}
	
	// !!! ISSO É APENAS UM TESTE, PARA MELHOR ORGANIZAÇÃO SERIA TERIA QUE CRIAR UM CONTROLLER PRA API !!!
	@RequestMapping(value="/api/usuarios/listar", method=RequestMethod.GET)
	public List<Usuario> getAllUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	@RequestMapping("/usuarios")
	public ModelAndView listaUsuario() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Usuario> usuarios = usuarioRepository.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}
}
