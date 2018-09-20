package com.g3softwares.sipe.api.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.g3softwares.sipe.api.model.Usuario;
import com.g3softwares.sipe.api.repository.UsuarioRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<Usuario> usuarioOtional = usuarioRepository.findByEmail(email);
		Usuario usuario = usuarioOtional
				.orElseThrow(() -> new UsernameNotFoundException("Usuário e/ou senha incorretos."));
		return new User(email, usuario.getSenha(), gerPermissoes(usuario));
	}

	private Collection<? extends GrantedAuthority> gerPermissoes(Usuario usuario) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		usuario.getPermissoes()
				.forEach((p) -> authorities.add(new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));
		return authorities;
	}

}
