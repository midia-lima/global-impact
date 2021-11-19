package br.com.global.donatefoodv2.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.global.donatefoodv2.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNameLike(String name);
	
	Optional<Usuario> findByEmail(String username);

}
