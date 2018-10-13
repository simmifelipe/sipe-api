package com.g3softwares.sipe.api.security.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword {

	private BCryptPasswordEncoder encoder;

	public EncodePassword() {
		encoder = new BCryptPasswordEncoder();
	}

	public String encode(String senha) {
		return this.encoder.encode(senha);
	}
}
