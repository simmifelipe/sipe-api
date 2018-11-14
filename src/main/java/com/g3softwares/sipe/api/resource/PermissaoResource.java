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
import com.g3softwares.sipe.api.model.Permissao;
import com.g3softwares.sipe.api.repository.PermissaoRepository;
import com.g3softwares.sipe.api.service.PermissaoService;

@RestController
@RequestMapping("/permissoes")
public class PermissaoResource {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@Autowired
	private PermissaoService permissaoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Permissao> listar() {
		return this.permissaoRepository.findAll();
	}

	@PostMapping()
	public ResponseEntity<Permissao> criar(@Valid @RequestBody Permissao permissao, HttpServletResponse response) {

		Permissao permissaoSalva = this.permissaoRepository.save(permissao);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, permissaoSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(permissaoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Permissao> buscarPorCodigo(@PathVariable Long codigo) {

		Permissao permissao = this.permissaoRepository.findOne(codigo);
		return permissao != null ? ResponseEntity.ok(permissao) : ResponseEntity.notFound().build();
	}

	@GetMapping("/{modulo}/{nivel}")
	public List<Permissao> buscarPorModuloENivel(@PathVariable Long modulo, @PathVariable Integer nivel) {
		return this.permissaoRepository.findPermissoesByModuloAndNivel(modulo, nivel);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		this.permissaoRepository.delete(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Permissao> atualizar(@PathVariable Long codigo, @Valid @RequestBody Permissao permissao) {

		Permissao permissaoSalva = this.permissaoService.atualizar(codigo, permissao);
		return ResponseEntity.ok(permissaoSalva);
	}

}
