package br.com.global.donatefoodv2.api;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.global.donatefoodv2.model.Usuario;
import br.com.global.donatefoodv2.repository.UsuarioRepository;



@RestController
public class ApiUsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/usuario/listar")
	public List<Usuario> index(@RequestParam(required = false) String name) {
		if (name == null) {
			return repository.findAll();
		}
		return repository.findByNameLike("%" + name + "%");

	}

	@PostMapping("/usuario/cadastrar")
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario, UriComponentsBuilder uriBuilder) {
		repository.save(usuario);
		URI uri = uriBuilder.path("/usuario/cadastrar/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);

	}

	@GetMapping("/usuario/listar/{id}")
	public ResponseEntity<Usuario> show(@PathVariable Long id) {
		return ResponseEntity.of(repository.findById(id));
	}

	@DeleteMapping("usuario/apagar/{id}")
	public ResponseEntity<Usuario> destroy(@PathVariable Long id) {
		Optional<Usuario> usuarios = repository.findById(id);
		if (usuarios.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}

}
