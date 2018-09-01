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
import com.g3softwares.sipe.api.model.Utilizador;
import com.g3softwares.sipe.api.repository.UtilizadorRepository;
import com.g3softwares.sipe.api.service.UtilizadorService;

@RestController
@RequestMapping("/utilizadores")
public class UtilizadorResource {

	@Autowired
	private UtilizadorRepository utilizadorRepository;

	@Autowired
	private UtilizadorService utilizadorService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Utilizador> listar() {
		return this.utilizadorRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Utilizador> criar(@Valid @RequestBody Utilizador utilizador, HttpServletResponse response) {

		Utilizador utilizadorSalvo = utilizadorRepository.save(utilizador);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, utilizadorSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(utilizadorSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Utilizador> buscarPorCodigo(@PathVariable Long codigo) {
		Utilizador utilizador = utilizadorRepository.findOne(codigo);
		return utilizador != null ? ResponseEntity.ok(utilizador) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		utilizadorRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Utilizador> atualizar(@PathVariable Long codigo, @Valid @RequestBody Utilizador utilizador) {
		Utilizador utilizadorSalvo = utilizadorService.atualizar(codigo, utilizador);
		return ResponseEntity.ok(utilizadorSalvo);
	}

	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		utilizadorService.atualizarPropriedadeAtivo(codigo, ativo);
	}

}
