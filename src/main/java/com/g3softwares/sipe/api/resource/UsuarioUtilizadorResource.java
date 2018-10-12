package com.g3softwares.sipe.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.g3softwares.sipe.api.event.RecursoCriadoEvent;
import com.g3softwares.sipe.api.model.UsuarioUtilizador;
import com.g3softwares.sipe.api.repository.UsuarioUtilizadorRepository;
import com.g3softwares.sipe.api.service.UsuarioUtilizadorService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioUtilizadorResource {

	@Autowired
	private UsuarioUtilizadorRepository usuarioUtilizadorRepository;

	@Autowired
	private UsuarioUtilizadorService usuarioUtilizadorService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<UsuarioUtilizador> listar() {
		return this.usuarioUtilizadorRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UsuarioUtilizador> criar(@Valid @RequestBody UsuarioUtilizador usuarioUtilizador,
			HttpServletResponse response) {

		UsuarioUtilizador usuarioUtilizadorSalvo = usuarioUtilizadorRepository.save(usuarioUtilizador);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioUtilizadorSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioUtilizadorSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<UsuarioUtilizador> buscarPorCodigo(@PathVariable Long codigo) {
		UsuarioUtilizador usuarioUtilizador = usuarioUtilizadorRepository.findOne(codigo);
		return usuarioUtilizador != null ? ResponseEntity.ok(usuarioUtilizador) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		usuarioUtilizadorRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<UsuarioUtilizador> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody UsuarioUtilizador usuarioUtilizador) {
		UsuarioUtilizador usuarioUtilizadorSalvo = usuarioUtilizadorService.atualizar(codigo, usuarioUtilizador);
		return ResponseEntity.ok(usuarioUtilizadorSalvo);
	}

}
