package br.com.global.donatefoodv2.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.global.donatefoodv2.model.Usuario;
import br.com.global.donatefoodv2.repository.UsuarioRepository;

@Service
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> usuario = repository.findByEmail(username);
		if (usuario.isEmpty())
			throw new UsernameNotFoundException("User not found");
		return usuario.get();
	}

}
