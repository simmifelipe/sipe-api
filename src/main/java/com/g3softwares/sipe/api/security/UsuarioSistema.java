package com.g3softwares.sipe.api.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.g3softwares.sipe.api.model.UsuarioUtilizador;

public class UsuarioSistema extends User {

	private static final long serialVersionUID = 1L;

	private UsuarioUtilizador usuario;

	public UsuarioSistema(UsuarioUtilizador usuario, Collection<? extends GrantedAuthority> authorities) {
		super(usuario.getEmail(), usuario.getSenha(), authorities);
		this.usuario = usuario;
	}

	public UsuarioUtilizador getUsuario() {
		return usuario;
	}

}