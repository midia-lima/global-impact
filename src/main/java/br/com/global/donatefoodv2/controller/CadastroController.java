package br.com.global.donatefoodv2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.global.donatefoodv2.model.Usuario;
import br.com.global.donatefoodv2.repository.UsuarioRepository;

@Controller
public class CadastroController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/cadastro")
	public String index(Usuario usuario) {
		return "cadastro";
	}

	@PostMapping("/cadastro")
	public String save(@Valid Usuario usuario, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors())
			return "cadastro";
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		repository.save(usuario);
		return "redirect:/";
	}

	@GetMapping("/registeredusers")
	public ModelAndView buscaUsuarios() {
		ModelAndView modelAndView = new ModelAndView("registered-users");
		List<Usuario> users = repository.findAll();
		modelAndView.addObject("users", users);
		return modelAndView;
	}
	
	

}
